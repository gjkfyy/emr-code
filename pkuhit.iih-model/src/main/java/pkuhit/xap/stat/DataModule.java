package pkuhit.xap.stat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataModule {
	
	public List<Column> columnList;
	public List<Row> rowList;
	public HashMap<String, HashMap<String, Object>> data;
	
	public DataModule(){
		this.columnList = new ArrayList<Column>();
		this.rowList = new ArrayList<Row>();
		this.data = new HashMap<String, HashMap<String, Object>>();
	}
	
	public List<Column> getColumnList() {
		return columnList;
	}
	
	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}
	
	public List<Row> getRowList() {
		return rowList;
	}
	
	public void setRowList(List<Row> rowList) {
		this.rowList = rowList;
	}
	
	public Object getData(String columnCode,String rowCode) {
		System.out.println(columnCode);
		if (this.data != null && data.get(columnCode) != null) {
			return this.data.get(columnCode).get(rowCode);
		}else {
			return null;
		}
	}

	public void setData(String columnCode,String rowCode,Object value) {
		if (this.data.get(columnCode) != null) {
			this.data.get(columnCode).put(rowCode,value);
		}else {
			HashMap<String, Object> rowMap = new HashMap<String, Object>();
			rowMap.put(rowCode, value);
			this.data.put(columnCode, rowMap);
		}
	}
	
	public Object getDataRC(String rowCode,String columnCode) {
		if (this.data != null && data.get(rowCode) != null) {
			return this.data.get(rowCode).get(columnCode);
		}else {
			return null;
		}
	}
	
	public void setDataRC(String rowCode,String columnCode,Object value) {
		if (this.data.get(rowCode) != null) {
			this.data.get(rowCode).put(columnCode,value);
		}else {
			HashMap<String, Object> columnMap = new HashMap<String, Object>();
			columnMap.put(columnCode, value);
			this.data.put(rowCode, columnMap);
		}
	}

	public HashMap<String, HashMap<String, Object>> getData() {
		return data;
	}

	public void setData(HashMap<String, HashMap<String, Object>> data) {
		this.data = data;
	}
}
