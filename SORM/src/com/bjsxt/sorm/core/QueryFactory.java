package com.bjsxt.sorm.core;
/**
 * 创建Query对象的工厂类
 * @author tzh
 *
 */
@SuppressWarnings("rawtypes")
public class QueryFactory {

	private static Query prototypeObj;	//原型对象，不然每次都反射，效率低一点
	static {
		try {
			Class c =Class.forName(DBManager.getConf().getQueryClass());	////加载指定的Query类
			prototypeObj = (Query) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private QueryFactory() {	//私有构造器
	}
	
	
	public static Query createQuery() {
//		return new MySqlQuery();
		//克隆模式
		try {
			return (Query) prototypeObj.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}

	}
}
