package com.bjsxt.tanpang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * 查询返回的结果集 : ResultSet
 * 这里测试ResultSet的基本用法
 * 记得关闭connection和Statement/preparedStatement
 */
public class Demo04 {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//加载驱动，通过字符串找类
			Class.forName("com.mysql.jdbc.Driver");
			long start =System.currentTimeMillis();
			//建立连接(连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时，这是Connection对象管理的一个要点！)
			//真正开发中，为了提高效率，都会使用连接池来管理连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gouwu","root","19961026");
			long end = System.currentTimeMillis();
			System.out.println(conn);//得到结果com.mysql.jdbc.JDBC4Connection@531d72ca，实现类是在MySQL-connection包里的
			System.out.println("建立连接耗时："+(end-start)+"ms毫秒");//建立连接是比较耗时的，423ms
			
			
			String sql = "select * from new_table where age >? ";
			ps=conn.prepareStatement(sql);			
			ps.setObject(1,12);//选出id大于20的
			
			//返回结果集，ResultSet也是个接口，与conn密切相关，连接断了就没了，是个迭代器
			ResultSet set = ps.executeQuery();
			System.out.println(" ID "+"----"+" username "+"----"+" Date ");
			while(set.next()) {//返回布尔值，是否还有下一条
				//取出第一列：id,第二列username，第三列日期
				System.out.println(set.getInt(1)+"----"+set.getString(2));//括号内为索引，列索引

			}
			
			//ps.execute()执行语句，返回boolean类型，是否有结果集
			//下面常用
			//ps.executeUpdate(),执行增删改语句，返回更新的行数
			//ps.executeQuery(),执行selete语句，返回Resultset结果集
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}{
			try {
				if(ps!=null)
				ps.close();
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
