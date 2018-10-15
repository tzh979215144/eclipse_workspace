package com.bjsxt.sorm.core;

import java.util.ArrayList;
import java.util.List;

import com.bjsxt.po.Emp;
import com.bjsxt.vo.EmpVo;

/**
 * 负责针对MySQL数据库的查询（对外提供服务的核心类）
 * @author tanpang
 *
 */
public class MySqlQuery extends Query {

	public  static void testDML() {
		Emp e =new Emp();
		e.setId(3);
		e.setEmpname("liu");
		e.setAge(18);
//		new MySqlQuery().delete(e);
//		new MySqlQuery().insert(e);
		new MySqlQuery().update(e, new String[] {"empname","age"});
	
	}
	
	public static List testRows() {
		String sql ="select * from emp where id>? and age>?";
		Object[] params = {0,18};
		return new MySqlQuery().queryRows(sql, Emp.class, params);
	}
	public static void testHardRows() {
		String sql ="select e.id,e.empname,salary+bonus 'xinshui',age,"
				+ "d.dname 'deptName',d.address 'deptAddr' from emp e join dept d on e.deptId=d.Id";
		List<EmpVo> list = new MySqlQuery().queryRows(sql, EmpVo.class, null);
		
		for(EmpVo e:list) {
			System.out.println(e.getEmpname()+"---"+e.getDeptAddr()+"---"+e.getXinshui());
		}
	}
	public static void main(String[] args) {
/*		List<Emp> list =new ArrayList<Emp>();
		list =testRows();
		System.out.println(list);*/
//		testHardRows();
/*		String sql ="select * from emp where id>? and age>?";
		System.out.println((Number)new MySqlQuery().queryValue(sql,new Object[] {0,10}));*/
		
	}

	@Override
	public Object queryPagenate(int pageNum, int size) {
		// TODO Auto-generated method stub
		return null;
	}
}
