package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.zhoukan.util.ConnectionPool;

public class GetFrontInvoiceSP {
	public Map<String, String> getFrontInvoice(String Loan_no,String dd_no,String invoice_Type){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			cs = conn.prepareCall("{call SP_Get_Front_Invoice(?,?,?,?,?,?,?)}");
			cs.setString(1, Loan_no);
			cs.setString(2, dd_no);
			cs.setString(3, invoice_Type);
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.FLOAT);
			cs.registerOutParameter(5, oracle.jdbc.OracleTypes.INTEGER);
			cs.registerOutParameter(6, oracle.jdbc.OracleTypes.DATE);
			cs.registerOutParameter(7, oracle.jdbc.OracleTypes.DATE);
			cs.execute();
			map.put("INT_RATE", String.valueOf(cs.getFloat(4)));
			System.out.println(map.get("INT_RATE"));
			map.put("BILLED_AMT", String.valueOf(cs.getInt(5)));
			System.out.println(map.get("BILLED_AMT"));
			map.put("INT_FROM", cs.getString(6));
			System.out.println(map.get("INT_FROM"));
			map.put("DUE_DATE", cs.getString(7));
			System.out.println(map.get("DUE_DATE"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		Map<String, String> map = new GetFrontInvoiceSP().getFrontInvoice("2080000008","20110000001","NT");
		System.out.println(map.get("INT_RATE"));
		System.out.println(map.get("INT_FROM"));
	}

}
