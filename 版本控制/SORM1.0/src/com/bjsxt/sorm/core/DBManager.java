package com.bjsxt.sorm.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.bjsxt.sorm.bean.Configuration;

/**
 * 根据配置信息，维持连接对象的管理（增加连接池功能）
 * @author tzh
 *
 */
public class DBManager {
		private static Configuration conf;
		
		static {//only run when the DBManager is being load
			Properties pros = new Properties();
			try {
				pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}

			conf = new Configuration(pros.getProperty("driver"),pros.getProperty("url"),pros.getProperty("user"),
					pros.getProperty("pwd"),pros.getProperty("usingDB"),pros.getProperty("srcPath"),pros.getProperty("poPackage"));
			
			
		}
		
		/**
		 * 返回一个MySQL连接
		 * @return
		 */
			public static Connection getConn() {
				try {
					Class.forName(conf.getDriver());
					//Class.forName("com.mysql.jdbc.Driver");
					return DriverManager.getConnection(conf.getUrl(), conf.getUser(),
							conf.getPwd());//直接建立连接，后期增加连接池，提高效率
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
			
			/**
			 * 获得Configuration对象
			 * @return
			 */
			public static Configuration getConf() {
				return conf;
			}
}
