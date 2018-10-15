package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.RepayBean;
import org.zhoukan.util.ConnectionPool;


public class Repay_SearchSP {
	/*
	 * 根据LOAN_NO查找贷款发放信息
	 */
	public String save(RepayBean bean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String mess = null;
		
		try {
			cs = conn.prepareCall("{call SP_REPAY_SEARCH(?,?,?,?,?,?,?)}");
			cs.setString(1,bean.getLOAN_NO());
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(6, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(7, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			
			//bean.setDD_KEY(cs.getString(2));
			bean.setCCY(cs.getString(3));
			bean.setDD_DATE(cs.getString(4));
			bean.setINT_RATE(cs.getString(6));
			bean.setDD_AMT(cs.getString(5));
			mess = cs.getString(7);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return mess;
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
		return mess;
	}
	
	public static void main(String[] args){
		RepayBean bean = new RepayBean();
		bean.setLOAN_NO("222");
		String out = new Repay_SearchSP().save(bean);
		System.out.println(bean.getCCY());
		System.out.println(bean.getDD_AMT());
		//System.out.println(bean.getDD_KEY());
		System.out.println(bean.getDD_DATE());
		System.out.println(bean.getINT_RATE());
	}
}
