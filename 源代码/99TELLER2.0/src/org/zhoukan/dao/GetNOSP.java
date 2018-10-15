package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.util.ConnectionPool;

public class GetNOSP {
	
	public String getNO(String name){
		Connection conn = ConnectionPool.getOneConn();
		System.out.println(conn);
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_GET_NO(?,?)}");
			cs.setString(1, name);
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.NUMBER);
			cs.execute();
			n = cs.getString(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return n;
		} finally {
			try {
				if(cs != null){
					cs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(conn != null){
				ConnectionPool.backOneConn(conn);
			}
		}
		return n;
	}
	public static void main(String[] args) {
		GetNOSP getNO = new GetNOSP();
		String n = getNO.getNO("login_no");
		System.out.println(n);
	}
}
