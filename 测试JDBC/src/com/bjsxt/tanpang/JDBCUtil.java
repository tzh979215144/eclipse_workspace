package com.bjsxt.tanpang;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCUtil {
		
	static Properties pros = null;//可以帮助读取和处理资源文件中的信息
	
	//只会类被的时候执行一次
	static {		//加载JDBCUtil类的时候调用，只需要一次
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("mysqldb.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 返回一个MySQL连接
	 * @return
	 */
		public static Connection getMysqlConn() {
			try {
				Class.forName(pros.getProperty("mysqlDriver"));
				//Class.forName("com.mysql.jdbc.Driver");
				return DriverManager.getConnection(pros.getProperty("mysqlURL"), pros.getProperty("mysqlUser"),
						pros.getProperty("mysqlPwd"));
				//return DriverManager.getConnection("jdbc:mysql://localhost:3306/gouwu", "root", "19961026");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} 
			
		}
		/**
		 * 提供了关闭的方法，可写重载，但我嫌麻烦，不关的填null就好了
		 * @param rs
		 * @param ps
		 * @param conn
		 */
		public static void close(ResultSet rs,Statement ps, Connection conn) {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
