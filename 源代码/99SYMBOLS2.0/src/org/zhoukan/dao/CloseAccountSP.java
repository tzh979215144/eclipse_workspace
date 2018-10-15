package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.zhoukan.bean.Fm_acctBean;
import org.zhoukan.util.ConnectionPool;

public class CloseAccountSP {
	public String update(Fm_acctBean bean) {
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_CloseAccount(?,?,?,?,?,?,?)}");
			cs.setString(1, bean.getBASE_ACCT_NO());
			cs.setString(2, bean.getGLOBAL_ID());
			cs.setString(3, bean.getCLIENT_SHORT());
			cs.setInt(4, bean.getLEDGER_BAL());
			cs.setString(5, bean.getACCT_CLOSE_REASON());
			cs.setString(6, bean.getACCT_CLOSE_DAYE());
			cs.registerOutParameter(7, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(7);
		} catch (SQLException e) {
			e.printStackTrace();
			return n;
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (conn != null) {
				ConnectionPool.backOneConn(conn);
			}
		}
		return n;
	}
	// public static void main(String[] args) {
	// Fm_acctBean bean = new Fm_acctBean();
	// CloseAccountSP closeAccountSP = new CloseAccountSP();
	// bean.setBASE_ACCT_NO("");
	// bean.setGLOBAL_ID("");
	// bean.setCLIENT_SHORT("");
	// bean.setLEDGER_BAL(30020);
	// bean.setACCT_CLOSE_REASON("销户");
	// bean.setACCT_CLOSE_DAYE("销户");
	// String out = closeAccountSP.update(bean);
	// System.out.println("INFO | 返回码为："+out);
	// }
}
