package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.RepayBean;
import org.zhoukan.util.ConnectionPool;

public class RepaySP {
	
	public String save(RepayBean bean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs1 = null;
		String mess = null;
		try {
			//查询
			cs1 = conn.prepareCall("{call SP_REPAY(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs1.setString(1,bean.getDD_NO());
			cs1.setString(2,"CNY");
			cs1.setString(3,bean.getPRI_REPAY_FREQ());
			cs1.setString(4,bean.getPRI_REPAY_DAY());
			cs1.setString(5,bean.getREPAY_DATE());
			cs1.setString(6,bean.getEND_DATE());
			cs1.setString(7,bean.getTRAN_DATE());
			cs1.setInt(8,Integer.parseInt(bean.getDD_AMT()));
			cs1.setString(9,bean.getTRAN_DATE());//上一结息日期
			cs1.setString(10,"110");//最后修改交易用户ID
			cs1.setString(11,bean.getTRAN_DATE());
			cs1.setInt(12,Integer.parseInt(new GetNOSP().getNO("REPAY_NO")));
			cs1.setString(13,bean.getLOAN_NO());
			cs1.registerOutParameter(14, oracle.jdbc.OracleTypes.VARCHAR);
			cs1.execute();
			mess = cs1.getString(14);
//			
//			//插入
//			cs = conn.prepareCall("{call SP_REPAY(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
//			cs.setString(1, bean.getDD_KEY());
//			cs.setString(2, bean.getCCY());
//			cs.setString(3, bean.getPRI_REPAY_FREQ());
//			cs.setString(4, bean.getPRI_REPAY_DAY());
//			cs.setString(5, bean.getREPAY_DATE());
//			cs.setString(6, bean.getEND_DATE());
//			cs.setString(7, bean.getTRAN_DATE());
//			cs.setString(8, bean.getDD_AMT());
//			cs.setString(9, bean.getLAST_DN_DUE());
//			cs.setString(10, bean.getUSER_ID());
//			cs.setString(11, bean.getLAST_CHANGE_DATE());
//			cs.setString(12, bean.getSCH_NO());
//			cs.setString(13, bean.getLOAN_KEY());
//			cs.registerOutParameter(14, oracle.jdbc.OracleTypes.VARCHAR);
//			cs.execute();
//			mess = cs.getString(14);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return mess ;
		} finally {
			try {
				if(cs1 != null){
					cs1.close();
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
public static void main(String[] args) {
	RepayBean bean = new RepayBean();
	String n = new RepaySP().save(bean);
	System.out.println(n);
}
}
