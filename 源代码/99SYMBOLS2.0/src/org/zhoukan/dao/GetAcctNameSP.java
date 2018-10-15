package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.util.ConnectionPool;

public class GetAcctNameSP {
	public String getName(String acctNo){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = null;
		try {
			cs = conn.prepareCall("{call SP_GET_ACCTM(?,?)}");
			cs.setString(1, acctNo);
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
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
		GetAcctNameSP nameSP = new GetAcctNameSP();
		String name = nameSP.getName("141020801023");
		System.out.println(name);
	}
}
