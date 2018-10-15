package com.bjsxt.tanpang;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * 测试CLOB  文本大对象的使用
 * 包含：将字符串、文件内容插入数据库中的CLOB（text）字段。将CLOB字段值取出来的操作
 */
public class Demo09 {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		PreparedStatement ps=null;
		PreparedStatement ps2=null;
		Reader r =null;
		try {
			//加载驱动，通过字符串找类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gouwu","root","19961026");
			
			String sql = "insert into testsql (name,pass,myinfo) values (?,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, "测试Clob大字段文本");
			ps.setString(2, "123456");
			//流，读取文本文件内容导入到数据库中
			ps.setClob(3, new FileReader(new File("/home/tzh/Documents/a.txt")));
			
			//将程序中的字符串以流的方式读进去,绕来绕去，麻烦
			//ps.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaaabbb".getBytes()))));
			
			//ps.executeUpdate();
			/////下面是取出来的操作
			ps2 = conn.prepareStatement("select * from testsql where myinfo=?");
			
			ps2.setClob(1,new FileReader(new File("/home/tzh/Documents/a.txt")) );
			ResultSet rs = ps2.executeQuery();
			while(rs.next()) {
				Clob c =rs.getClob("myinfo");
				r = c.getCharacterStream();
				//输入流的读取
				int temp = 0;
				while((temp=r.read())!=-1) {
					System.out.print((char)temp);
				}
				//System.out.println(rs.getString(1)+"---"+rs.getClob(5));
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(r!=null) {
				try {
					//关闭流
					r.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				if(ps!=null)
				ps.close();
			} catch (Exception e) {
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
