package com.bjsxt.tanpang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*
 * 数据库操作-事务原子性的实现
 */
public class Demo06 {

	public static void main(String[] args)  {
		Connection conn = null;
		PreparedStatement ps1 =null;
		PreparedStatement ps2 =null;
		try {
			//加载驱动，通过字符串找类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gouwu","root","19961026");
			
			conn.setAutoCommit(false);//设为手动提交，默认自动提交，connction 关闭时提交
			ps1 = conn.prepareStatement("insert into vip (username,userpass,phone) value (?,?,?)");//事务开始于这
			ps1.setString(1, "高琪shiwu");
			ps1.setString(2, "123465");
			ps1.setString(3, "16675831026");
			ps1.execute();
			System.out.println("插入一个用户，高琪");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//暂停三秒
			
			ps2 = conn.prepareStatement("insert into vip (username,userpass,phone) value (?,?,?)");
			ps2.setString(1, "马士兵");
			ps2.setString(2, "123465");
		//此处有意漏写一个参数，会跳到catch(SQLException e)里
			ps2.execute();
			System.out.println("插入一个用户，高琪");			
			
			conn.commit();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}//只要有一条sql执行错误就会到这来执行回滚
		}finally {
				try {
					if(ps1!=null)
					ps1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if(ps2!=null)
					ps2.close();
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
