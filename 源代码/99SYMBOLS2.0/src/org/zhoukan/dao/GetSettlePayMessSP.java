package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.zhoukan.util.ConnectionPool;

public class GetSettlePayMessSP {

	public Map<String, String> findByDDNoAndLoan(String LOAN_NO, String DD_NO){
		Map<String, String> map = new HashMap<String, String>();
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall("{call SP_GET_SETTLEPAY(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, LOAN_NO);
			cs.setString(2, DD_NO);
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(6, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(7, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(8, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(9, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(10, oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(11, oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(12, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			map.put("LOAN_NO2", LOAN_NO);
			map.put("DD_NO", DD_NO);
			map.put("CLIENT", cs.getString(3));
			map.put("NAME", cs.getString(4));
			map.put("BRANCH", cs.getString(5));
			System.out.println(cs.getString(5));
			map.put("LOAN_TYPE", cs.getString(6));
			map.put("LOAN_SUB_TYPE", cs.getString(7));
			map.put("USER_ID", cs.getString(8));
			map.put("CCY", cs.getString(9));
			map.put("SETTLE_AMT", cs.getString(10));
			map.put("INT_RATE", cs.getString(11));
			map.put("BASE_ACCT_NO", cs.getString(12));
			System.out.println(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("err", "没有查询结果！");
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
	
}
