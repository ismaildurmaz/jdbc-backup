package com.intenum.jdbc.backup;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.intenum.util.db.DataTable;
import com.intenum.util.db.Row;

public class Backup {
	private Connection connection;
	private TableCollection tables;
	private boolean addEmptyTable;

	public Backup(Connection connection) {
		this.addEmptyTable = true;
		this.connection = connection;
	}

	public boolean isAddEmptyTable() {
		return addEmptyTable;
	}

	/**
	 * add or not <code>delete * from table</code>
	 * 
	 * @param addEmptyTable
	 */
	public void setAddEmptyTable(boolean addEmptyTable) {
		this.addEmptyTable = addEmptyTable;
	}

	public TableCollection getTables() {
		return tables;
	}

	public void execute(PrintStream stream) throws SQLException {
		DatabaseMetaData metaData = connection.getMetaData();
		String quote = metaData.getIdentifierQuoteString();

		DataTable dataTable = null;

		// get tables
		tables = new TableCollection();
		dataTable = DataTable.parse(metaData.getTables(null, null, null, null));
		for (Row row : dataTable) {
			tables.add(new Table(row.getString("TABLE_NAME")));
		}

		// get columns
		for (Table table : tables) {
			dataTable = DataTable.parse(metaData.getColumns(null, null,
					table.getName(), null));
			for (Row row : dataTable) {
				table.getColumns().add(
						new Column(row.getString("COLUMN_NAME"), row
								.getString("TYPE_NAME")));
			}
		}

		// get constraints
		for (int i = 0; i < tables.size(); i++) {
			for (int j = 0; j < tables.size(); j++) {
				if (i != j) {
					dataTable = DataTable.parse(metaData.getCrossReference(
							null, null, tables.get(i).getName(), null, null,
							tables.get(j).getName()));
					if (dataTable.size() > 0) {
						Table src = tables.get(j);
						for (Row row : dataTable) {
							src.getConstraints()
									.add(new FK(row.getString("FKCOLUMN_NAME"),
											tables.get(i), row
													.getString("PKCOLUMN_NAME")));
						}
					}
				}
			}
		}

		tables.sort();

		for (Table table : tables) {
			dataTable = DataTable.execute(connection, "select * from " + quote
					+ table.getName() + quote);
			if (dataTable.size() > 0) {
				stream.println("---------------------------------------------");
				stream.println("-- " + table.getName());
				stream.println("---------------------------------------------");

				if (addEmptyTable) {
					stream.println("delete * from " + quote + table.getName()
							+ quote);
					stream.println();
				}

				String str = "insert into " + quote + table.getName() + quote
						+ "(" + quote + table.getColumns().get(0).getName()
						+ quote;
				for (int i = 1; i < table.getColumns().size(); i++) {
					str += ", " + quote + table.getColumns().get(i).getName()
							+ quote;
				}
				str += ") values ";
				stream.println(str);
				for (int k = 0; k < dataTable.size(); k++) {
					Row row = dataTable.get(k);
					str = "(" + getSQLValue(table, row, 0);
					for (int i = 1; i < dataTable.getColumns().size(); i++) {
						str += ", " + getSQLValue(table, row, i);
					}
					str += ")";
					if (k < dataTable.size() - 1) {
						str += ",";
					} else {
						str += ";";
					}
					stream.println(str);
				}
				stream.println();
				stream.println();
				stream.println();
			}
		}
	}

	public String getSQLValue(Table table, Row row, int index) {
		com.intenum.jdbc.backup.Column column = table.getColumns().get(index);
		if (row.get(index) == null) {
			return "null";
		} else {
			if (column.getTypeName().contains("CHAR")) {
				return "\"" + row.getString(index) + "\"";
			} else {
				return row.getString(index);
			}
		}
	}
}
