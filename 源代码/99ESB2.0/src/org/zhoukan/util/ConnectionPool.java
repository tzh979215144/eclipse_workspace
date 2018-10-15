package org.zhoukan.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
	
	private static CreatePool createPool = null;
	private static LinkedList<Connection> connList = new LinkedList<Connection>();
	private static Lock myLock = new ReentrantLock();
	private static Lock lock = new ReentrantLock();
	private ConnectionPool(){}
	
	static {
		//System.out.println("静态块调用了");
		if(createPool == null){
			myLock.lock();
			try {
				if(createPool == null){
					createPool = new ConnectionPool().new CreatePool();
				}
			} finally{
				myLock.unlock();
			}
		}
	}
	
	public static Connection getOneConn(){
		lock.lock();
		try{
			if(connList.size() > 0){
				return connList.removeFirst();
			}
		}finally{
			lock.unlock();
		}
		
		return null;
	}
	public static synchronized void backOneConn(Connection conn){
		connList.add(conn);
	}
	
	public static void initConnection(){
		System.out.println("INFO | 数据库连接初始化");
	}
	
	private class CreatePool {
		
		public CreatePool(){
			this.create();
		}
		
		private void create(){
			Properties properties = new Properties();
			try {
				properties.load(ConnectionPool.CreatePool.class.getResourceAsStream("/database.properties"));
				String driverClass = properties.getProperty("driverClass");
				String url = properties.getProperty("url");
				String database = properties.getProperty("database");
				String user = properties.getProperty("user");
				String password = properties.getProperty("password");
				String maxLength = properties.getProperty("maxLength");
				int m = Integer.valueOf(maxLength);
				Class.forName(driverClass);
				for(int i = 0; i < m; i++){
					Connection conn = DriverManager.getConnection(url+database, user, password);
					connList.add(conn);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
