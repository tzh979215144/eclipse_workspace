package com.bjsxt.tanpang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * 测试Blob 二进制大对象的使用
 * 包含：将字符串、文件内容插入数据库中的BLOB字段。将BLOB字段值取出来的操作
 */
public class Demo10 {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		PreparedStatement ps=null;
		PreparedStatement ps2=null;
		InputStream is =null;
		OutputStream os = null;
		try {
			//加载驱动，通过字符串找类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gouwu","root","19961026");
			
			String sql = "insert into testsql (name,pass,headImg) values (?,?,?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, "测试Blob大字段二进制");
			ps.setString(2, "123456");
			//流，读取二进制文件内容导入到数据库中,此处照片比较大，Blob类型还不成，用了mediumblob类型
			ps.setBlob(3, new FileInputStream(new File("/home/tzh/Documents/jianli.jpg")));
			
			//ps.executeUpdate();
			//---------------------------------------------------------------------------------
			/////下面是取出来的操作
			
			ps2 = conn.prepareStatement("select * from testsql where name=?");
			
			ps2.setString(1, "测试Blob大字段二进制");
			ResultSet rs = ps2.executeQuery();
			while(rs.next()) {
				Blob b =rs.getBlob("headImg");
				is = b.getBinaryStream();
				os= new FileOutputStream("/home/tzh/桌面/a.jpg");
				//输入流的读取,输出流输出到桌面，流的使用有点生了
				int temp = 0;
				while((temp=is.read())!=-1) {
						os.write(temp);
				}
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
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(is!=null) {
				try {
					//关闭流
					is.close();
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
