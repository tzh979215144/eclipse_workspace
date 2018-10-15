package com.bjsxt.tanpang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Batch
 * 批处理：一次执行大量语句，建议使用Statement
 * 因为PreparedStatement的预编译空间有限，当数据量特别大时，会发生异常
 * @author tzh
 *
 */
public class Demo05 {

	public static void main(String[] args)  {
		Connection conn = null;
		Statement stmt =null;
		try {
			//加载驱动，通过字符串找类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gouwu","root","19961026");
			conn.setAutoCommit(false);//设为手动提交，默认自动提交，connction 关闭时提交
			stmt = conn.createStatement();//事务开始于这
			long start = System.currentTimeMillis();
			for(int i=0;i<20000;i++) {
				stmt.addBatch("insert into vip (username,userpass,phone) values ('gaoq"+i+"','666666','16675831026')");
			}
			
			stmt.executeBatch();
			conn.commit();//提交事务
			
			long end = System.currentTimeMillis();
			System.out.println("执行两万条数据耗时："+(end-start)+"ms");//两秒左右
			
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
