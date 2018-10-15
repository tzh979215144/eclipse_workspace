package org.zhoukan.dao;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.zhoukan.util.ConnectionPool;

public class GetPltyRateMessSP {

	public Map<String, String> getMess(String INT_PLTY_BASIS){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			cs = conn.prepareCall("{call SP_GET_INTRATEMESS(?,?,?)}");
			cs.setString(1, INT_PLTY_BASIS);
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.FLOAT);//MIN_RATE 
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.FLOAT);//ACTUAL_RATE
			cs.execute();
			map.put("INT_PLTY_ABS", ""+cs.getFloat(2));
			map.put("INT_PLTY_RATE", ""+cs.getFloat(3));
			map.put("INT_PLTY_SPREAD", ""+(cs.getFloat(3)-cs.getFloat(2)));
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
		Map<String, String> map = new GetPltyRateMessSP().getMess("2080000010");
		System.out.println(map.get("USE_AMT"));
		System.out.println(map.get("LOAN_AMT"));
	}
}

