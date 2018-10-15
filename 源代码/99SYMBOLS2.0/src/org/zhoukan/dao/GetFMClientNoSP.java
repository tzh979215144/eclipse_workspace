package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.zhoukan.bean.Day_JournalBean;
import org.zhoukan.bean.Fm_clientBean;
import org.zhoukan.util.ConnectionPool;
import org.zhoukan.util.MyDate;

public class GetFMClientNoSP {

	public String getClientNo(Fm_clientBean bean1, Day_JournalBean bean2) {

		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			System.out.println("INFO | GetFMClientNoSP  is  running ...");

			cs = conn.prepareCall("{call SP_CHECK_FM_CLIENT(?,?)}");
			cs.setString(1, bean1.getREGISTER_DATE());
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(2);
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

	public static void main(String[] args) {
		Fm_clientBean bean1 = new Fm_clientBean();
		Day_JournalBean bean2 = new Day_JournalBean();
		GetFMClientNoSP getFMClientNoSP = new GetFMClientNoSP();
		bean1.setREGISTER_DATE(MyDate.getTime());
		String ss = getFMClientNoSP.getClientNo(bean1, bean2);
		System.out.println("INFO | RECODE:" + ss);
	}
}
