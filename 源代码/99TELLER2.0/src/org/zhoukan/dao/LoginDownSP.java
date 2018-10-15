package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.util.ConnectionPool;
import org.zhoukan.util.MyDate;

public class LoginDownSP {

	public String down(String userName){
		String mess = "";
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall("{call SP_LOGIN_DOWN(?,?,?,?)}");
			
			cs.setString(1, MyDate.getTime());
			cs.setString(2, userName);
			cs.setString(3, MyDate.getDate());
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			mess = cs.getString(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return mess;
		}finally{
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
		return mess;
	}
}
