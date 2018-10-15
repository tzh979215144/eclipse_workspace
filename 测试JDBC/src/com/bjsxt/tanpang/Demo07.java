package com.bjsxt.tanpang;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;


/*
 * java.util.Date
	- 子类：java.sql.Date					表示年月日
	- 子类：java.sql.Time					表示时分秒
	- 子类：java.sql.Timestamp 		表示年月日时分秒
	日期DATE和时间戳
	实现随机时间插入
 */
public class Demo07 {

	public static void main(String[] args)  {
		Connection conn = null;
		PreparedStatement ps1 =null;
		try {
			//加载驱动，通过字符串找类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gouwu","root","19961026");
			conn.setAutoCommit(false);
			
			for(int i =0;i<1000;i++) {
				
			//Time对应的是sql的time 类型
			//timeStamp对应的是Sql的timeStamp类型
			ps1 = conn.prepareStatement("insert into testSql (name,pass,time,timeStamp) value (?,?,?,?)");
			ps1.setString(1, "高琪随机"+i);
			ps1.setString(2, "123465");
			
			int rand = 100000000+new Random().nextInt(100000000);
			//年月日
			//时间戳，年月日时分秒
			//Timestamp stamp1 = new Timestamp(2018,8,22,14,59,20,150000);//这是不建议使用的
			//要插入指定日期，可以使用Calendar类，DateFormat类
			
			Date date=new java.sql.Date(System.currentTimeMillis()-rand);
			Timestamp stamp = new Timestamp(System.currentTimeMillis()-rand);
			
			ps1.setDate(3, date);
			ps1.setTimestamp(4, stamp);
			
			ps1.execute();

			}
			conn.commit();
			System.out.println("插入一个用户，高琪");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	//只要有一条sql执行错误就会到这来执行回滚
		}finally {
				try {
					if(ps1!=null)
					ps1.close();
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
