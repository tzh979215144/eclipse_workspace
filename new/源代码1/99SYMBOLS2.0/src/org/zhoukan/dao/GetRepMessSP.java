package org.zhoukan.dao;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.zhoukan.util.ConnectionPool;

public class GetRepMessSP {

	public Map<String, String> getMess(String dd_no){
		System.out.println(dd_no);
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			cs = conn.prepareCall("{call SP_REPAY_SEARCH(?,?,?,?,?)}");
			cs.setString(1, dd_no);
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			map.put("LOAN_NO", ""+cs.getString(2));
			map.put("DD_DATE", ""+cs.getString(3));
			map.put("DD_AMT", ""+cs.getString(4));
			map.put("INT_RATE", ""+cs.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
			return map;
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
		return map;
	} 
	public static void main(String[] args) {
		Map<String, String> map = new GetRepMessSP().getMess("2080000010");
		System.out.println(map.get("USE_AMT"));
		System.out.println(map.get("LOAN_AMT"));
	}
}
