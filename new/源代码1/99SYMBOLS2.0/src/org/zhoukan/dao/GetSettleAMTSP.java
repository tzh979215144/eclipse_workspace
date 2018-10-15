package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.Cl_Settle_RecBean;
import org.zhoukan.bean.Day_JournalBean;
import org.zhoukan.util.ConnectionPool;
import org.zhoukan.util.MyDate;

public class GetSettleAMTSP {
	public String getSettleAMT(Cl_Settle_RecBean bean1, Day_JournalBean bean2) {
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			System.out.println("INFO | GetSettleAMTSP  is running  ....");
			System.out.println("INFO | TRAN_DATE:" + bean1.getTRAN_DATE());
			cs = conn.prepareCall("{call SP_check_settle_amt(?,?)}");
			cs.setString(1, bean1.getTRAN_DATE());
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
		Cl_Settle_RecBean bean1 = new Cl_Settle_RecBean();
		Day_JournalBean bean2 = new Day_JournalBean();
		GetSettleAMTSP getSettleAMTSP = new GetSettleAMTSP();
		bean1.setTRAN_DATE(MyDate.getTime());
		System.out.println("INFO | MyDate:" + MyDate.getTime());
		String ss = getSettleAMTSP.getSettleAMT(bean1, bean2);
		System.out.println("INFO | RECODE:" + ss);
	}
}
