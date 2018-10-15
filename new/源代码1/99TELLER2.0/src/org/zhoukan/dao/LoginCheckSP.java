package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.util.ConnectionPool;

public class LoginCheckSP {

	public int getCheck(String orgID, String netID, String name, String pwd){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		int n = -1;
		try {
			cs = conn.prepareCall("{call sp_logincheck(?,?,?,?,?)}");
			cs.setString(1, orgID);
			cs.setString(2, netID);
			cs.setString(3, name);
			cs.setString(4, pwd);
			
			System.out.println("222222 orgID=["+ orgID +"]" + "netID=["+ netID +"]" +"name=["+ name +"]" +"pwd=["+ pwd +"]"  );
			
			cs.registerOutParameter(5, oracle.jdbc.OracleTypes.INTEGER);
			cs.execute();
			n = cs.getInt(5);
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
	public static void main(String[] args) {
		LoginCheckSP checkSP = new LoginCheckSP();
		int n = checkSP.getCheck("1410","2080","zhangwenjia", "zwj");
		System.out.println(n);
	}
}
