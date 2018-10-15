package com.bjsxt.test;

import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

import com.bjsxt.po.Emp;
import com.bjsxt.sorm.core.Query;
import com.bjsxt.sorm.core.QueryFactory;
import com.bjsxt.vo.EmpVo;

import som.bjsxt.sorm.pool.DBConnPool;

/**
 * 客户端调用的测试类
 * @author tanpang
 *
 */
public class test {
	
	public static void main(String[] args) {
		testPoolConnection();
		//不加连接池的耗时：12578----->增加连接池之后：2293
	}
	
	public static void testPoolConnection() {
		long a = System.currentTimeMillis();
		for(int i = 0;i<1000;i++) {
			Query q = QueryFactory.createQuery();
			testHardQuery(q);
		}
		
		long b = System.currentTimeMillis();
		System.out.println(b-a);
	}
	
	
	/**
	 * 测试DML语句
	 * @param q
	 */
	public  static void testDML(Query q) {
		Emp e =new Emp();
		e.setId(3);
		e.setEmpname("liu");
		e.setAge(18);
//		new MySqlQuery().delete(e);
//		new MySqlQuery().insert(e);
		q.update(e, new String[] {"empname","age"});
	}
	
	/**
	 * 测试查多行多列
	 * @param q
	 * @return 返回List
	 */
	@SuppressWarnings("unchecked")
	public static List<Object> testRows(Query q) {
		String sql ="select * from emp where id>? and age>?";
		Object[] params = {0,18};
		return q.queryRows(sql, Emp.class, params);
	}
	/**
	 * 测试复杂的联合主键查询
	 * @param q
	 */
	@SuppressWarnings("unchecked")
	public static void testHardQuery(Query q) {
		String sql ="select e.id,e.empname,salary+bonus 'xinshui',age,"
				+ "d.dname 'deptName',d.address 'deptAddr' from emp e join dept d on e.deptId=d.Id";
		List<EmpVo> list = q.queryRows(sql, EmpVo.class, null);
		
		for(EmpVo e:list) {
			System.out.println(e.getEmpname()+"---"+e.getDeptAddr()+"---"+e.getXinshui());
		}
	}
	
	/**
	 * 测试查询结果为Object类的方法
	 * @param q
	 * @return Object类
	 */
	public static Object testQueryValue(Query q){
		String sql ="select * from emp where id>? and age>?";
		return q.queryValue(sql,new Object[] {0,10});
	}
	
}
