package com.bjsxt.sorm.core;
/**
 * 负责java数据类型和数据库数据类型的互相转化
 * @author tzh
 *
 */
public interface TypeConvertor {

	/**
	 * 将数据库数据类型转化为ｊａｖａ的数据类型
	 * @param columnType	数据库数据类型
	 * @return Ｊａｖａ的数据类型
	 */
	public String databaseType2JavaType(String columnType);
	
	/**
	 * 将ｊａｖａ的数据类型转化为数据库数据类型
	 * @param columnType	ｊａｖａ的数据类型
	 * @return 数据库数据类型
	 */
	public String javaType2DatabaseType(String javaDataType);
}
