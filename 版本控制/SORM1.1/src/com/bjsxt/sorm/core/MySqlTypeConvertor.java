package com.bjsxt.sorm.core;


/*
 * 
 * mysql 数据库和java数据类型的转换
 */
public class MySqlTypeConvertor implements TypeConvertor{

	@Override
	public String databaseType2JavaType(String columnType) {
		
		//varchar-->String
		if(("varchar".equalsIgnoreCase(columnType))||"char".equalsIgnoreCase(columnType)) {
			return "String";
		}else if(("int".equalsIgnoreCase(columnType))
				||("tinyint".equalsIgnoreCase(columnType))
				||("smallint".equalsIgnoreCase(columnType))
				||("integer".equalsIgnoreCase(columnType))
				) {
			return "Integer";
		}else if("bigint".equalsIgnoreCase(columnType)) {
			return "Long";
		}else if("double".equalsIgnoreCase(columnType)) {
			return "Double";
		}else if("clob".equalsIgnoreCase(columnType)) {
			return "java.sql.CLob";
		}else if("blob".equalsIgnoreCase(columnType)) {
			return "java.sql.BLob";
		}else if("date".equalsIgnoreCase(columnType)) {
			return "java.sql.Date";
		}else if("time".equalsIgnoreCase(columnType)) {
			return "java.sql.Timestamp";
		}else if("TIMESTAMP".equalsIgnoreCase(columnType)) {
			return "java.sql.Timestamp";
		}
		//有需要自己的类型，自己添加对应
		return null;
	}

	@Override
	public String javaType2DatabaseType(String javaDataType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
