package com.intenum.util.db;


public class Row {
	private Object[] data;
	private DataTable dataTable;
	
	public Row(DataTable dataTable, Object[] data){
		this.dataTable = dataTable;
		this.data = data;
	}
	
	public Object get(String columnLabel){
		return get(dataTable.getColumns().indexByLabel(columnLabel));
	}
	
	public Object get(int index){
		return data[index];
	}
	
	public String getString(int index){
		return String.valueOf(get(index));
	}
	
	public String getString(String label){
		return String.valueOf(get(label));
	}
	
	public Boolean getBoolean(int index){
		return Boolean.parseBoolean(getString(index));
	}
	
	
	
	@Override
	public String toString() {
		if(data == null || data.length == 0){
			return "{}";
		}
		String s = "{" + String.valueOf(data[0]);
		for(int i = 1; i < data.length; i++){
			s += ", " + String.valueOf(data[i]);
		}
		s += "}";
		return s;
	}
}
