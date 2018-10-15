package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.zhoukan.util.ConnectionPool;

public class StartSP {

	public void go(){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall("{call GET_PROCESS(?)}");
			cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			ResultSet rsDD = (ResultSet)cs.getObject(1);
//			System.out.println(rsDD.next());
			while(rsDD.next()){
				String pro_name=rsDD.getString("PROCESS_NAME");
				new DopSP().save("{call "+pro_name+"}");
				System.out.println("{call "+pro_name+"}");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
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
