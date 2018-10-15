package com.bjsxt.tanpang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * 测试数据库建立连接
 * Statement类基本用法
 * Statement也需要关闭，后开先关
 */
public class Demo02 {

	public static void main(String[] args)  {
		Connection conn = null;
		Statement stmt =null;
		try {
			//加载驱动，通过字符串找类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gouwu","root","19961026");
			
			//sql语句,返回结果
			stmt = conn.createStatement();
			String name="xiaotan";
					//拼字符串，麻烦，不能防止sql注入
			String sql = "insert into new_table (username,userpass,phone) values ('"+name+"',123456,16675831026)";
			stmt.execute(sql);
		
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(stmt!=null)
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
