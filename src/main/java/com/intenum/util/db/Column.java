package com.intenum.util.db;

public class Column {
	private String catalogName;
	private String schemaName;
	private String tableName;
	private String name;
	private String label;
	private int type;
	private String typeName;
	private String columnClassName;
	private int displaySize;
	private int precision;
	private int scale;

	public String getCatalogName() {
		return catalogName;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public String getTableName() {
		return tableName;
	}

	public String getName() {
		return name;
	}

	public String getLabel() {
		return label;
	}

	public int getType() {
		return type;
	}

	public String getTypeName() {
		return typeName;
	}

	public String getColumnClassName() {
		return columnClassName;
	}

	public int getDisplaySize() {
		return displaySize;
	}

	public int getPrecision() {
		return precision;
	}

	public int getScale() {
		return scale;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setColumnClassName(String columnClassName) {
		this.columnClassName = columnClassName;
	}

	public void setDisplaySize(int displaySize) {
		this.displaySize = displaySize;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	@Override
	public String toString() {
		return "Column [catalogName=" + catalogName + ", schemaName="
				+ schemaName + ", tableName=" + tableName + ", name=" + name
				+ ", label=" + label + ", type=" + type + ", typeName="
				+ typeName + ", columnClassName=" + columnClassName
				+ ", displaySize=" + displaySize + ", precision=" + precision
				+ ", scale=" + scale + "]";
	}

	
}
