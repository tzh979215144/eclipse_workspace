package com.bjsxt.test;

import java.util.List;

import com.bjsxt.po.Emp;
import com.bjsxt.sorm.core.Query;
import com.bjsxt.sorm.core.QueryFactory;
import com.bjsxt.vo.EmpVo;

/**
 * 客户端调用的测试类
 * @author tanpang
 *
 */
public class test {
	
	public static void main(String[] args) {
		Query q = QueryFactory.createQuery();
//		testHardQuery(q);
		System.out.println(testQueryValue(q));
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
