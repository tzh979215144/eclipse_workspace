package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.zhoukan.util.ConnectionPool;

public class DopSP {

	public void save(String sql){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall(sql);
			
			cs.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
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
		
	}
}
