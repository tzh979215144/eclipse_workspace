/*
 * 功能:从客户号获得证件号 、客户简称、帐户类型、证件类型
 */
package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.zhoukan.util.ConnectionPool;

public class FindClientMessSP {

	public Map<String, String> findById(String client_no){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			cs = conn.prepareCall("{call SP_FIND_CLIENT(?,?,?,?)}");
			cs.setString(1, client_no);
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			map.put("GLOBAL_ID", cs.getString(2));
			map.put("CLIENT_SHORT", cs.getString(3));
			map.put("GLOBAL_ID_TYPE", cs.getString(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return map;
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
		return map;
	}
	public static void main(String[] args) {
		Map<String, String> map = new FindClientMessSP().findById("999900000013");
		System.out.println(map.get("CH_CLIENT_NAME"));
	}
}
