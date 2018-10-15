package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.util.ConnectionPool;

public class ChangeTranDetlSP {

	public String change(String seq, String status){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_CHANGE_TRAN_STA(?,?,?)}");
			cs.setString(1, seq);
			cs.setString(2, status);
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(3);
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
}
