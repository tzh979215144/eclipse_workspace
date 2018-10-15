package com.bjsxt.tanpang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*
 * 测试PreparedStatement的基本用用法
 */
public class Demo03 {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//加载驱动，通过字符串找类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gouwu","root","19961026");
			
			String sql = "insert into vip (username,userpass,phone) values (?,?,?)";//?为占位符，防止注入
			//有预处理，？必须为字符串或数字
			ps = conn.prepareStatement(sql);
			//索引从1开始算，此处传值
			ps.setString(1, "gaoqi");		//还有setInt等
			ps.setString(2, "123456");
			ps.setString(3, "16675831026");
			
			ps.execute();//执行语句，返回boolean类型，是否有结果集
			//下面常用
			//ps.executeUpdate(),执行增删改语句，返回更新的行数
			//ps.executeQuery(),执行selete语句，返回Resultset结果集
			
			
			//ps.setDate(4,new java.sql.Date(System.currentTimeMillis())); 插入系统当前时间，此中有转换
			//都可用setObject(indexof,object x);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
				ps.close();
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
