package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.zhoukan.bean.CL_LOANBean;
import org.zhoukan.bean.CL_RECEIPT_TBLBean;
import org.zhoukan.bean.Cl_Settle_RecBean;
import org.zhoukan.bean.SettleRecBean;
import org.zhoukan.util.ConnectionPool;

public class SettleRecSP {
	public String save(SettleRecBean bean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_SETTLE_REC_ADD(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setInt(1, Integer.parseInt(new GetNOSP().getNO("INTERNAL_KEY22")));
			cs.setInt(2, Integer.parseInt(new GetNOSP().getNO("REC_SEQ")));
			cs.setInt(3, Integer.parseInt(bean.getBILLED_AMT()));
			cs.setInt(4, Integer.parseInt(bean.getOUTSTANDING()));
			cs.setString(5, bean.getINVOICE_TYPE());
			cs.setInt(6, bean.getMONEY());
			cs.setInt(7, bean.getOTH_MONEY());
			cs.setString(8, bean.getLOAN_NO());
			cs.setString(9, bean.getORIG_BORRPWER());
			cs.setString(10, bean.getLENDER());
			cs.setString(11, bean.getACCT_NO());
			cs.setString(12, bean.getOTH_ACCT_NO());
			cs.setString(13, bean.getDEBIT_NOTE_NO());
	
			cs.registerOutParameter(14, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(14);
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
		SettleRecSP g = new SettleRecSP();
		SettleRecBean bean = new SettleRecBean();
		bean.setBILLED_AMT("800");
		bean.setOUTSTANDING("100");
		bean.setINVOICE_TYPE("PRL");
		bean.setMONEY(0);
		bean.setOTH_MONEY(800);
		bean.setLOAN_NO("2080000044");//
		bean.setORIG_BORRPWER("999900000071");
		bean.setLENDER("李查德");
		bean.setACCT_NO("11111");
		bean.setOTH_ACCT_NO("1111112");
		bean.setDEBIT_NOTE_NO("12345678");//
		System.out.println("完成!"+g.save(bean));
//		settleRecBean.setBASE_ACCT_NO("a11");
//		settleRecBean.setSETTLE_METHOD("a22");
//		settleRecBean.setBASE_ACCT_NO("11111111");
//		settleRecBean.setCLIENT_NAME("qqqqqq");
//		settleRecBean.setREC_AMT(666666);
		
//		Receipt_tblBean.setRECEIPT_NO("2011120539");
//		Receipt_tblBean.setRECEIPT_AMT("1000");
//		g.save(bean, Receipt_tblBean, clRecBean,SettleRecList);
//		System.out.println("DRAWN_AMT:"+Receipt_tblBean.getRECEIPT_AMT());
		
	}
}
