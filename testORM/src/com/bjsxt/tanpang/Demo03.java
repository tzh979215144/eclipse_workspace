package com.bjsxt.tanpang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试使用Map封装一条记录
 * 使用List<Map>存储多条记录
 * @author tzh
 *
 */
public class Demo03 {
		public static void main(String[] args) {
			test02();
		}
		
		
		/**
		 * 测试使用Map封装一条记录
		 */
		public static void test01() {
			Connection conn = JDBCUtil.getMysqlConn();
			PreparedStatement ps = null;
			ResultSet rs =null;
			Emp emp =new Emp();
			try {
				ps = conn.prepareCall("select empname,salary,age from emp where id>=?");
				ps.setInt(1, 1);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					//System.out.println("*直接输出*\n"+rs.getString(1)+"--"+rs.getDouble(2)+"---"+rs.getInt(3));
					emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));	
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(rs, ps, conn);
			}
			System.out.println(emp.getEmpname()+"---"+emp.getSalary()+"--"+emp.getAge());
		}
		/**
		 * javabean加进List中
		 */
	public static void test02() {

		Connection conn = JDBCUtil.getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<Emp> list = new ArrayList<Emp>();
		Emp emp =new Emp();
		try {
			ps = conn.prepareCall("select empname,salary,age from emp where id>=?");
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));	
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		for(Emp emps:list)
		System.out.println(emps.getEmpname()+"---"+emps.getSalary()+"--"+emps.getAge());
	}
		
}
