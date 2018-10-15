package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.CL_MYSettlePayBean;
import org.zhoukan.util.ConnectionPool;


public class SettlePay_Search_SP {
	/*
	 * 根据LOAN_NO查找贷款发放信息
	 */
	
	public String save(CL_MYSettlePayBean bean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String mess = null;
		try {
			cs = conn.prepareCall("{call SP_SEARCH_BY_LOAN_NO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1,bean.getLOAN_NO());
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(6, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(7, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(8, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(9, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(10, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(11, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(12, oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(13, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(14, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(15, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(16, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(17, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(18, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			mess = cs.getString(18);
			System.out.println(mess);
			
			bean.setDD_NO(cs.getString(2));
			bean.setLENDER(cs.getString(3));
			bean.setBORROWER(cs.getString(4));
			bean.setBOOK_BRANCH(cs.getString(5));
			bean.setLOAN_MANAGER(cs.getString(6));
			bean.setLOAN_TYPE(cs.getString(7));
			bean.setLOAN_SUB_TYPE(cs.getString(8));
			bean.setACCT_EXEC(cs.getString(9));
			bean.setCCY(cs.getString(10));
			bean.setDD_AMT(cs.getString(11));
			bean.setINT_RATE(cs.getString(12));
			bean.setLOAN_KEY(cs.getString(13));
			bean.setDD_KEY(cs.getString(14));
			bean.setCLIENT_NO(cs.getString(15));
			bean.setBASE_ACCT_NO(cs.getString(16));
			bean.setACCT_TYPE(cs.getString(17));
		} catch (SQLException e) {
			e.printStackTrace();
			return mess;
		} finally {
			try {
				if(cs != null){
					cs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(conn != null){
				ConnectionPool.backOneConn(conn);
			}
		}
		return mess;
	}
	public static void main(String[] args) {
		CL_MYSettlePayBean bean = new CL_MYSettlePayBean();
		bean.setLOAN_NO("222");//贷款号
		String out=new SettlePay_Search_SP().save(bean);
		//String mess = bean.getLENDER();
		System.out.println(bean.getDD_NO());
		System.out.println(bean.getLENDER());
		System.out.println(bean.getLOAN_NO());
		System.out.println(bean.getBORROWER());
		System.out.println(bean.getBOOK_BRANCH());
		System.out.println(bean.getLOAN_MANAGER());
		System.out.println(bean.getLOAN_TYPE());
		System.out.println(bean.getLOAN_SUB_TYPE());
		System.out.println(bean.getDD_AMT());
		System.out.println(bean.getACCT_EXEC());
		System.out.println(bean.getINT_RATE());
		System.out.println(bean.getCCY());
		System.out.println(bean.getLOAN_KEY());
		System.out.println(bean.getDD_KEY());
		//System.out.println(mess);
		System.out.println(out);
	}

}
