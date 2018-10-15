package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.util.ConnectionPool;

public class GetServerClassSP {

	public String getClassName(String name){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "";
		try {
			cs = conn.prepareCall("{call SP_GET_CLASS(?,?)}");
			cs.setString(1, name);
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(2);  
		} catch (SQLException e) {
			e.printStackTrace();
			return n;
		} finally {
			try {
				if(cs != null){
					cs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(conn != null){
				ConnectionPool.backOneConn(conn);
			}
		}
		return n;
	}
	public static void main(String[] args) {
		String n = new GetServerClassSP().getClassName("WORKDAY1WORKDAY201");
		System.out.println(n);
	}
}
