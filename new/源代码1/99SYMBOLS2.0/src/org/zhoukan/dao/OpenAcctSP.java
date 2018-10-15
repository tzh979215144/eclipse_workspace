package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.Fm_acctBean;
import org.zhoukan.util.ConnectionPool;

public class OpenAcctSP {
	
	public String save(Fm_acctBean bean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_OPEN_ACCT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setInt(1, bean.getINTERNAL_KEY());
			cs.setString(2, bean.getBRANCH());
			//cs.setString(3, bean.getCCY());
			cs.setString(3, "CNY");
			cs.setString(4, bean.getCLIENT_NO());
			cs.setString(5, bean.getGLOBAL_ID_TYPE());
			cs.setString(6, bean.getGLOBAL_ID());
			cs.setString(7, bean.getCERTIFICATE_NO());
			cs.setString(8, bean.getCLIENT_SHORT());
			cs.setString(9, bean.getPROFIT_CENTRE());
			cs.setString(10, bean.getACCT_OPEN_DATE());
			cs.setString(11, bean.getOPEN_TRAN_DATE());
			cs.setString(12, bean.getACCT_STATUS());
			cs.setString(13, bean.getACCT_TYPE());
			cs.setString(14, bean.getACCT_DECS());
			cs.setString(15, bean.getDEPOSIT_TYPE());
			cs.setString(16, bean.getACTUAL_OR_LEDGER_BAL());
			cs.setString(17, bean.getSTMT_PBK());
			cs.setString(18, bean.getDEL_FLAG());
			cs.setString(19, bean.getRESTRAINT_PRESENT());
			cs.setInt(20, bean.getLEDGER_BAL());
			cs.setInt(21, bean.getACUAL_BAL());
			cs.setInt(22, bean.getPREV_DAY_LEDGER_BAL());
			cs.setInt(23, bean.getPREV_DAY_ACUAL_BAL());
			cs.setInt(24, bean.getTOLERANCE_AMT());
			cs.setInt(25, bean.getTOTAL_AUTH_OD());
			cs.setString(26, bean.getUSER_ID());
			cs.setString(27, bean.getOFFICER_ID());
			cs.setString(28, bean.getLAST_CHANGE_OFFICER());
			cs.setString(29, bean.getTRAN_DATE());
			cs.setString(30, bean.getLAST_TRAN_DATE());
			cs.setString(31, bean.getACCT_CLOSE_DAYE());
			cs.setString(32, bean.getACCT_CLOSE_REASON());
			cs.setString(33, bean.getCATEGORY_TYPE());
			cs.setString(34, bean.getCLIENT_TYPE());
			cs.setString(35, bean.getACCT_CLOSE_OFFICE());
			cs.setString(36, bean.getLAST_ATT_STATUS());
			cs.setString(37, bean.getTRAN_ALLOWED());
			cs.setInt(38, bean.getAGG_BAL());
			cs.setInt(39, bean.getPREV_DAY_AGG_BAL());
			cs.setString(40, bean.getBASE_ACCT_NO());
			cs.setString(41, bean.getBASE_INTERNAL_KEY());
			cs.setString(42, bean.getCH_ACCT_NAME());
			cs.setString(43, bean.getALT_ACCT_NAME());
			cs.setString(44, bean.getACCT_NATURE());
			cs.setString(45, bean.getISLOCKED());
			cs.registerOutParameter(46, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(46);
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
	Fm_acctBean bean = new Fm_acctBean();
	String n = new OpenAcctSP().save(bean);
	System.out.println(n);
}
}
