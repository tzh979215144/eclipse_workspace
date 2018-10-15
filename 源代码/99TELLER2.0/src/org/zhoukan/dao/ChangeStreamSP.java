package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.StreamBean;
import org.zhoukan.util.ConnectionPool;

public class ChangeStreamSP {

	public String change(StreamBean bean){
			Connection conn = ConnectionPool.getOneConn();
			CallableStatement cs = null;
			String n = "-1";
			try {
				cs = conn.prepareCall("{call SP_CHANGE_STREAM(?,?,?,?)}");
				cs.setString(1, bean.getFRONT_SEQ());
				cs.setString(2, bean.getRE_CODE());
				cs.setString(3, bean.getREFERENCE());
				cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
				cs.execute();
				n = cs.getString(4);
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
