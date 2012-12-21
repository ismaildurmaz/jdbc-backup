package com.intenum.jdbc.backup;

public class FK {
	private String column;
	private Table referenceTable;
	private String referencePK;

	public String getColumn() {
		return column;
	}

	public String getReferencePK() {
		return referencePK;
	}

	public Table getReferenceTable() {
		return referenceTable;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public void setReferencePK(String referencePK) {
		this.referencePK = referencePK;
	}

	public void setReferenceTable(Table referenceTable) {
		this.referenceTable = referenceTable;
	}

	public FK(String column, Table referenceTable, String referencePK) {
		this.column = column;
		this.referenceTable = referenceTable;
		this.referencePK = referencePK;
	}

	@Override
	public String toString() {
		return "FK [column=" + column + ", referenceTable=" + referenceTable
				+ ", referencePK=" + referencePK + "]";
	}

	
}
