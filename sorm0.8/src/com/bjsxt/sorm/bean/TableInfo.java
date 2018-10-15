package com.bjsxt.sorm.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bjsxt.sorm.bean.ColumnInfo;

/**
 * 存储表结构信息
 * @author tzh
 *
 */
public class TableInfo {
	//表名
	private String tname;
	//所有字段的信息
	private Map<String, ColumnInfo> columns;
	//唯一主键（目前我们只能处理表中有且只有一个主键的情况）
	private ColumnInfo onlyPriKey;
	//如果联合主键，则在这里存储
	private List<ColumnInfo> priKeys;
	
	
	public TableInfo(String tname, List<ColumnInfo> priKeys, HashMap<String, ColumnInfo> columns) {
		super();
		this.tname = tname;
		this.priKeys = priKeys;
		this.columns = columns;
	}
	public TableInfo() {
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}
	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}
	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}
	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}
	public TableInfo(String tname, ColumnInfo onlyPriKey, Map<String, ColumnInfo> columns) {
		super();
		this.tname = tname;
		this.onlyPriKey = onlyPriKey;
		this.columns = columns;
	}
	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}
	public void setPriKey(List<ColumnInfo> priKey) {
		this.priKeys = priKey;
	}
	
	
}
