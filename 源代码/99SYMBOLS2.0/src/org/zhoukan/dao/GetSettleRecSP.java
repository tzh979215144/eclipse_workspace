package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zhoukan.bean.SettleRecBean;
import org.zhoukan.util.ConnectionPool;

public class GetSettleRecSP {
	public Map<String, String> getMess(SettleRecBean settleRecBean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			cs = conn.prepareCall("{call SP_GET_SETTLE_RECMESS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, settleRecBean.getLOAN_NO());
			cs.setString(2, settleRecBean.getDEBIT_NOTE_NO());
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(6, oracle.jdbc.OracleTypes.NUMBER);
			
			cs.registerOutParameter(7, oracle.jdbc.OracleTypes.VARCHAR);
			
			cs.registerOutParameter(8, oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(9, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(10, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(11, oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(12, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(13, oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(14, oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(15, oracle.jdbc.OracleTypes.NUMBER);

			cs.execute();
			map.put("ORIG_BORRPWER", cs.getString(3));
			map.put("LENDER", cs.getString(4));
			map.put("INVOICE_TYPE", cs.getString(5));
			map.put("BILLED_AMT", Integer.toString(cs.getInt(6)));
			map.put("ACCT_NO", cs.getString(7));
			
			map.put("ACCT_AMT", Integer.toString(cs.getInt(8)));
			map.put("CLIENT", cs.getString(9));
			map.put("OTH_ACCT_NO", cs.getString(10));
			map.put("OTH_ACCT_AMT", Integer.toString(cs.getInt(11)));
			map.put("OTH_CLIENT", cs.getString(12));
			map.put("OUTSTANDING", Integer.toString(cs.getInt(13)));
			map.put("MONEY", Integer.toString(cs.getInt(14)));
			map.put("OTH_MONEY", Integer.toString(cs.getInt(15)));
			
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
		System.out.println(map.entrySet());
		return map;
	}
	public static void main(String[] args) {
		SettleRecBean settleRecBean=new SettleRecBean();
		settleRecBean.setLOAN_NO("2080000044");
		settleRecBean.setDEBIT_NOTE_NO("12345678");
		GetSettleRecSP g = new GetSettleRecSP();
		System.out.println(g.getMess(settleRecBean));
		System.out.println("哈哈");
	}

}
