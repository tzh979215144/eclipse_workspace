package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.Rb_tranBean;
import org.zhoukan.util.ConnectionPool;

public class TranDetlSP {
	
	public String saveStream(Rb_tranBean bean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "";
		try {
			cs = conn.prepareCall("{call SP_STREAM_SYM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, bean.getSEQ_NO());
			cs.setString(2, bean.getINTERNAL_KEY());
			cs.setString(3, bean.getTRAN_DATE());
			cs.setString(4, bean.getSOURSE_TYPE());
			cs.setString(5, bean.getTERMINAL_ID());
			cs.setString(6, bean.getBRANCH());
			cs.setString(7, bean.getOFFICER_ID());
			cs.setString(8, bean.getTRAN_TYPE());
			cs.setString(9, bean.getEFFECT_DATE());
			cs.setString(10, bean.getREVERSAL_TRAN_TYPE());
			cs.setString(11, bean.getREVERSAL_DATE());
			cs.setString(12, bean.getTRAN_AMT());
			cs.setString(13, bean.getREFERENCE());
			cs.setString(14, bean.getPREVIOUS_BAL_AMT());
			cs.setString(15, bean.getACTUAL_BAL_AMT());
			cs.setString(16, bean.getTFR_INTERNAL_KEY());
			cs.setString(17, bean.getTRF_SEQ_NO());
			cs.setString(18, bean.getTRACE_ID());
			cs.setString(19, bean.getCR_DR_MAINT_IND());
			cs.setString(20, bean.getBASE_ACCT_NO());
			cs.setString(21, bean.getTRAN_DESC());
			cs.setString(22, bean.getTIME_STAMP());
			cs.setString(23, bean.getVALUE_DATE());
			cs.setString(24, bean.getCCY());
			cs.setString(25, bean.getPROFIT_CENTER());
			cs.setString(26, bean.getSOURCE_MODULE());
			cs.setString(27, bean.getBT_OFFICER_ID());
			cs.setString(28, bean.getTRN());
			cs.setString(29, bean.getAPPROVAL_DATE());
			cs.setString(30, bean.getSETTLEMENT_DATE());
			cs.setString(31, bean.getTRAN_DATE_TIME());
			cs.setString(32, bean.getTRAN_ENTRY_DATE());
			cs.setString(33, bean.getRATE_TYPE());
			cs.setString(34, bean.getTRAN_REF_NO());
			cs.setString(35, bean.getBORROWING_LENDING_RATE());
			cs.registerOutParameter(36, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(36);
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
}
