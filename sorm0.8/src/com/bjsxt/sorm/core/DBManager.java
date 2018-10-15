package com.bjsxt.sorm.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.bjsxt.sorm.bean.Configuration;

import som.bjsxt.sorm.pool.DBConnPool;

/**
 * 根据配置信息，维持连接对象的管理（增加连接池功能）
 * @author tzh
 *
 */
public class DBManager {
		private static Configuration conf;
		private static DBConnPool pool ;
		
		static {//only run when the DBManager is being load
			Properties pros = new Properties();
			try {
				pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}

			conf = new Configuration(pros.getProperty("driver"),pros.getProperty("url"),pros.getProperty("user"),
					pros.getProperty("pwd"),pros.getProperty("usingDB"),pros.getProperty("srcPath"),pros.getProperty("poPackage"),
					pros.getProperty("queryClass"),
					Integer.parseInt(pros.getProperty("poolMinSize")),Integer.parseInt(pros.getProperty("poolMaxSize")));
			
			//加载TableContext，让类和表信息加载了（也就是加载了TableContext类的static块
			System.out.println(TableContext.class);
			
		}
		
		/**
		 * 返回一个MySQL连接
		 * @return
		 */
			public static Connection getConn() {
				if(pool==null) {
					pool= new DBConnPool();
				}
				return pool.getConnection();
			}
			/**
			 * 创建一个MySQL连接
			 * @return
			 */
				public static Connection createConn() {
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
					try {
						if(rs!=null) {
						rs.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
				}
					
						/*if(conn!=null) {
						conn.close();
						}*/
						pool.close(conn);
				if(ps!=null) {
					try {
						ps.close();
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
