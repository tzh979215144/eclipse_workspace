package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.Cl_drawDrowBean;
import org.zhoukan.bean.Day_JournalBean;
import org.zhoukan.util.ConnectionPool;
import org.zhoukan.util.MyDate;

public class GetDrowDownAMTSP {
	public String getDrowDownAMT(Cl_drawDrowBean bean1, Day_JournalBean bean2) {
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			System.out.println("INFO | GetDrowDownAMTSP  is  running....");
			System.out.println("INFO | DD_DATE:" + bean1.getDD_DATE());
			cs = conn.prepareCall("{call SP_check_drawdown_amt(?,?)}");
			cs.setString(1, bean1.getDD_DATE());
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
		Cl_drawDrowBean bean1 = new Cl_drawDrowBean();
		Day_JournalBean bean2 = new Day_JournalBean();
		GetDrowDownAMTSP getDrowDownAMT = new GetDrowDownAMTSP();
		// bean2.setDAYJOURNAL_ID("10");
		bean1.setDD_DATE(MyDate.getTime());
		System.out.println("INFO | MyDate:" + MyDate.getTime());
		String ss = getDrowDownAMT.getDrowDownAMT(bean1, bean2);
		System.out.println("INFO | RECODE:" + ss);
	}
}
