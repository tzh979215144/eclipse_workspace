package com.bjsxt.sorm.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.bjsxt.sorm.bean.ColumnInfo;
import com.bjsxt.sorm.bean.TableInfo;
import com.bjsxt.sorm.util.JavaFileUtils;
import com.bjsxt.sorm.util.StringUtils;

/**
 * 负责获取管理数据库所有表结构和类结构的关系，并可以根据表结构生成类结构。
 * @author tzh
 *
 */
public class TableContext {
	
		/**
		 * 表名为key，表信息对象为value
		 */
		public static Map<String ,TableInfo> tables = new HashMap<String ,TableInfo>();
		
		/**
		 * 将po的class对象和表信息对象关联起来，便于重用！
		 */
		@SuppressWarnings("rawtypes")
		public static Map<Class,TableInfo> poClassTableMap = new HashMap<Class,TableInfo>();
		
		
		private TableContext() {}
		
		static {
			try {
				Connection con = DBManager.getConn();
				DatabaseMetaData dbmd = con.getMetaData();
				
				ResultSet tableRet = dbmd.getTables(null, "%", "%", new String[] {"TABLE"});
				
				while(tableRet.next()) {//此处两条为：emp，dept
					String tableName = (String) tableRet.getObject("TABLE_NAME");					
					TableInfo ti = new TableInfo(tableName,new ArrayList<ColumnInfo>(),new HashMap<String,ColumnInfo>());
					tables.put(tableName, ti);//插入表格式信息
					
					ResultSet set = dbmd.getColumns(null, "%", tableName, "%");//查询表中所有字段
					while(set.next()) {
						ColumnInfo ci =  new ColumnInfo(set.getString("COLUMN_NAME"),set.getString("TYPE_NAME"),0);
						ti.getColumns().put(set.getString("COLUMN_NAME"), ci);//将列信息存入tables(TableInfo类)的Columns（map）里
					}
					
					ResultSet set2 = dbmd.getPrimaryKeys(null, "%", tableName);//查询特定表中的主键
					while(set2.next()) {
						ColumnInfo ci2 = (ColumnInfo) ti.getColumns().get(set2.getObject("COLUMN_NAME"));//获取主键列名
						ci2.setKeyType(1);//在Class类里映射主键类型：1
						ti.getPriKeys().add(ci2);//添加到联合主键List里
					}
					if(ti.getPriKeys().size()>0) {//取唯一主键 方便使用。如果是联合主键，则为空！
							ti.setOnlyPriKey(ti.getPriKeys().get(0));
					}
					/*if(ti.getPriKeys().size()==1) {//我觉得这样才能达到目的：如果是联合主键，则为空！
						ti.setOnlyPriKey(ti.getPriKeys().get(0));
					}*/					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//每次启动更新类结构
			updateJavaPOFile() ;
			
			//加载po包下所有的类，便于重用
			loadPOTables();
		}
		
		/**
		 * 根据表结构，更新配置的po包下面的java类
		 */
		public static void updateJavaPOFile() {
			Map<String,TableInfo> map = TableContext.tables;
			for(TableInfo t:map.values()) {
				JavaFileUtils.createJavaPOFile(t,new MySqlTypeConvertor());
				}
		}
		public static Map<String,TableInfo> getTableInfos(){
			return tables;
		}
		
		
		/**
		 * 加载po包下的类
		 * @param args
		 */
		@SuppressWarnings("rawtypes")
		public static void loadPOTables() {
			
			for(TableInfo tableInfo:tables.values()) {
				Class c;
				try {
					c = Class.forName(DBManager.getConf().getPoPackage()+
							"."+StringUtils.firstChar2UpperCase(tableInfo.getTname()));
					poClassTableMap.put(c, tableInfo);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		
		public static void main(String[] args){
			Map<String,TableInfo> tables = getTableInfos();
			System.out.println(tables);
		}
		
}
