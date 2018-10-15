package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.Auto_cl_settleSECBean;
import org.zhoukan.util.ConnectionPool;

public class Auto_receptSP {

	public String save(Auto_cl_settleSECBean bean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_AUTO_RCACCT_NO(?,?,?,?,?,?,?,?,?,?)}");
			cs.setInt(1, bean.getINTERNAL_KEY());
			cs.setString(2, bean.getLOAN_NO());
			cs.setString(3, bean.getDD_NO());
			cs.setString(4, bean.getBASE_ACCT_NO());
			cs.setString(5, bean.getCLIENT_NO());
			cs.setString(6, bean.getFREEZE());
			cs.setString(7, bean.getSETTLE_TYPE());
			cs.setString(8, bean.getCLIENT_NAME());
			cs.setString(9, bean.getTRAN_DATE());
			cs.registerOutParameter(10, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(10);
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
