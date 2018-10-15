package com.dcfs.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	
	public Connection getCon() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","scott", "scott");
		System.out.println(con);
		return con;
	}
	
	public void closeCon(Connection con) throws Exception {
		if(con!=null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			System.out.println("yes"+dbUtil.getCon());
			dbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("no");
			e.printStackTrace();
		}
	}
}
