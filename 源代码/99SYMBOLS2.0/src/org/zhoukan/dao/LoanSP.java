package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.CL_LOANBean;
import org.zhoukan.util.ConnectionPool;

public class LoanSP {

	public String save(CL_LOANBean bean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_CL_Loan(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, bean.getLOAN_NO());
			cs.setString(2, bean.getSTATUS());
			cs.setString(3, bean.getCONTRACT_NO());
			cs.setString(4, bean.getLOAN_TYPE());
			cs.setString(5, bean.getLOAN_SUB_TYPE());
			cs.setString(6, bean.getBORROWER());
			cs.setString(7, bean.getORIG_BORRPWER());
			cs.setString(8, bean.getBORROWER_TYPE());
			cs.setString(9, bean.getLOAN_MANAGER());
			cs.setString(10, bean.getBOOK_BRANCH());
			cs.setString(11, bean.getORIG_BOOK_BRANCH());
			cs.setString(12, bean.getLENDER());
			//cs.setString(13, bean.getCCY());
			cs.setString(13, "CNY");
			cs.setString(14, bean.getREVOLVE_YN());
			cs.setString(15, bean.getSTART_DATE());
			cs.setString(16, bean.getMATURE_DATE());
			cs.setInt(17, bean.getORIG_LOAN_AMT());
			cs.setInt(18, bean.getLOAN_AMT());
			cs.setInt(19, bean.getDRAWN_AMT());
			cs.setInt(20, bean.getOUTSTANDING());
			cs.setFloat(21, bean.getINT_RATE());
			cs.setFloat(22, bean.getMIN_INT_RATE());
			cs.setFloat(23, bean.getMAX_INT_RATE());
			cs.setString(24, bean.getROCESS_TYPE());
			cs.setInt(25, bean.getPRI_BILLING_DAYS());
			cs.setInt(26, bean.getBILLING_DAYS());
			cs.setString(27, bean.getHUNTING_STATUS());
			cs.setString(28, bean.getMONTH_BASIS());
			cs.setInt(29, bean.getYEAR_BASIS());
			cs.setInt(30, bean.getLOAN_KEY());
			cs.setInt(31,bean.getREC_SEQ());
			cs.setString(32,bean.getPAY_REC_IND());
			cs.setString(33,bean.getACCT_59());
			cs.setString(34,bean.getSETTLE_CCY());
			cs.setString(35,bean.getAMT_TYPE());
			cs.setString(36,bean.getBASE_CCT_NO());
			cs.setString(37,bean.getCLIENT_56());
			cs.setString(38,bean.getNAME_56());
			cs.setString(39,bean.getTRAN_DATE());
			cs.setString(40,bean.getUSER_ID());
			cs.setString(41,bean.getLAST_CHANGE_DATE());
			cs.setInt(42,bean.getPRORITY());
			cs.setString(43,bean.getACCT_NO());
			cs.setString(44,bean.getCLIENT_NO());
			cs.setString(45,bean.getACCT_TYPE());
			cs.setString(46,bean.getINTERNAL_KEY());
			cs.setString(47,bean.getBJ_ACCT_59());
			cs.setString(48,bean.getBJ_LENDER());
			cs.setString(49,bean.getLX_ACCT_59());
			cs.setString(50,bean.getLX_LENDER());
			cs.setString(51,bean.getFX_ACCT_59());
			cs.setString(52,bean.getFX_LENDER());
			cs.setString(53,bean.getFL_ACCT_59());
			cs.setString(54,bean.getFL_LENDER());
			cs.setString(55,bean.getFY_ACCT_59());
			cs.setString(56,bean.getFY_LENDER());
			cs.setString(57,bean.getBY_ACCT_NO());
			cs.setString(58,bean.getBY_LENDER());
			cs.registerOutParameter(59, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(59);
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
