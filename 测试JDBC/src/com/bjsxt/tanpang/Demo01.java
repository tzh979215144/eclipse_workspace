package com.bjsxt.tanpang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*
 * 测试数据库建立连接
 * connection 需要关闭
 */
public class Demo01 {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
			//加载驱动，通过字符串找类
			Class.forName("com.mysql.jdbc.Driver");
			long start =System.currentTimeMillis();
			//建立连接(连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时，这是Connection对象管理的一个要点！)
			//真正开发中，为了提高效率，都会使用连接池来管理连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gouwu","root","19961026");
			long end = System.currentTimeMillis();
			System.out.println(conn);//得到结果com.mysql.jdbc.JDBC4Connection@531d72ca，实现类是在MySQL-connection包里的
			System.out.println("建立连接耗时："+(end-start)+"ms毫秒");//建立连接是比较耗时的，423ms
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//要记得关闭连接
			if(conn!=null)
				conn.close();
		}
	}
}
