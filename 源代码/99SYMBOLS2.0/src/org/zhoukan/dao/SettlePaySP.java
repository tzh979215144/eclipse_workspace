package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.CL_settlePayBean;
import org.zhoukan.util.ConnectionPool;
import org.zhoukan.util.MyDate;

public class SettlePaySP {

	public String save(CL_settlePayBean bean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_SETTLE_PAY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setInt(1, bean.getINTERNAL_KEY());
			cs.setInt(2, bean.getPAY_SEQ());
			cs.setString(3, bean.getBRANCH());
			cs.setString(4, bean.getSELLET_ACCT_TYPE());
			cs.setString(5, bean.getSELLE_METHOD());
			cs.setString(6, bean.getCLIENT());
			cs.setString(7, bean.getNAME());
			cs.setString(8, bean.getACCT());
			cs.setString(9, bean.getTRAN_DATE());
			cs.setString(10, bean.getUSER_ID());
			cs.setString(11, bean.getRB_SEQ_NO());
			cs.setInt(12, bean.getPAY_AMT());
			cs.setInt(13, bean.getSETTLE_AMT());
			cs.setString(14, bean.getLOAN_NO());
			cs.setString(15, bean.getBASE_ACCT_NO());
			cs.setString(16, bean.getDD_NO());
			cs.setString(17, bean.getLAST_CHANGE_DATE());
			cs.registerOutParameter(18, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(18);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return n;
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
		return n;
	}
	public static void main(String[] args) {
		CL_settlePayBean bean = new CL_settlePayBean();
		bean.setINTERNAL_KEY(5);
		bean.setDD_NO("20111205059");
		bean.setLOAN_NO("2080000026");
		bean.setSETTLE_AMT(11);
		bean.setTRAN_DATE(MyDate.getTime());
		bean.setLAST_CHANGE_DATE(MyDate.getTime());
		String mess = new SettlePaySP().save(bean);
		System.out.println(mess);
	}
}
