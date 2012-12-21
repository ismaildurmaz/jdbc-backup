package com.intenum.jdbc.backup;

public class Column {
	private String name;
	private String typeName;

	public String getName() {
		return name;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public Column(String name, String typeName) {
		super();
		this.name = name;
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "Column [name=" + name + ", typeName=" + typeName + "]";
	}
	
	
	
}
