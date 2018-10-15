package com.bjsxt.sorm.util;

import java.lang.reflect.Method;

/**
 * 封装了反射常用的操作
 * @author tzh
 *
 */
public class ReflectUtils {
		/**
		 * 调用obj对象对应属性fieldName的get方法
		 * @param fieldName
		 * @param obj
		 * @return
		 */
	@SuppressWarnings("all")
	public static Object invokeGet(String fieldName,Object obj) {
		try {
			Class c = obj.getClass();
			Method m = c.getMethod("get"+StringUtils.firstChar2UpperCase(fieldName), null);
			return m.invoke(obj, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 表---->obj
	 * @param obj	和数据库的表名对应着
	 * @param columnName 数据库中表的列名
	 * @param columnValue 数据库中表的某列的一个值
	 */
	@SuppressWarnings("all")
	public static void invokeSet(Object obj,String columnName,Object columnValue) {
		try {
			Class c = obj.getClass();
			Method m = c.getMethod("set"+StringUtils.firstChar2UpperCase(columnName), 
					columnValue.getClass());//这里传的是参数的类型
			m.invoke(obj, columnValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
