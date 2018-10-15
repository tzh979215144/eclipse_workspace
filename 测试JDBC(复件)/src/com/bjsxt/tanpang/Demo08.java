package com.bjsxt.tanpang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/*
 * java.util.Date
	- 子类：java.sql.Date					表示年月日
	- 子类：java.sql.Time					表示时分秒
	- 子类：java.sql.Timestamp 		表示年月日时分秒
	日期DATE和时间戳
	实现随机时间插入
 */
public class Demo08 {

	/**
	 * 将字符串代表的日期转为long数字（格式为：yyyy-MM-dd hh:mm:ss）
	 * @return
	 */
	public static long str2Date(String dateStr) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return format.parse(dateStr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public static void main(String[] args)  {
		Connection conn = null;
		PreparedStatement ps1 =null;
		ResultSet rs = null;
		try {
			//加载驱动，通过字符串找类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gouwu","root","19961026");
			

			ps1 = conn.prepareStatement("select * from testsql where timestamp>? and timestamp<?");
			//若是time的，就没有时分秒，所以最好格式对应
			java.sql.Date start=new java.sql.Date(str2Date("2018-8-20 23:23:46"));
			java.sql.Date end=new java.sql.Date(str2Date("2018-8-21 10:23:46"));
			
			ps1.setObject(1,start);
			ps1.setObject(2, end);
			
			rs = ps1.executeQuery();
			System.out.println("name"+"---------"+"pass"+"---------"+"time");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"---------"+rs.getString(2)+"---------"+rs.getTimestamp(4));
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
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
