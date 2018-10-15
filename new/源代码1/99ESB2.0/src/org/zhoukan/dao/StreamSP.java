package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.StreamBean;
import org.zhoukan.util.ConnectionPool;

public class StreamSP {
	public String setStream(StreamBean bean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "no";
		try {
			cs = conn.prepareCall("{call SP_STREAM_TE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, bean.getTRAN_SEQ());
			cs.setString(2, bean.getACCT_ID());
			cs.setString(3, bean.getSUB_ACCT_ID());
			cs.setString(4, bean.getBANK_ID());
			cs.setString(5, bean.getOPER_ID());
			cs.setString(6, bean.getTRAN_CODE());
			cs.setString(7, bean.getTRAN_NAME());
			cs.setString(8, bean.getAMOUNT());
			cs.setString(9, bean.getCCY());
			cs.setString(10, bean.getTRAN_DATE());
			cs.setString(11, bean.getTRAN_STATUS());
			cs.setString(12, bean.getRE_CODE());
			cs.setString(13, bean.getREVERSAL_RS_CODE());
			cs.setString(14, bean.getREVERSAL_DATE());
			cs.setString(15, bean.getPROFIT_CENTER());
			cs.setString(16, bean.getSOURCE_MODULE());
			cs.setString(17, bean.getFRONT_SEQ());
			cs.registerOutParameter(18, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(18);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return n;
		} finally{
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
