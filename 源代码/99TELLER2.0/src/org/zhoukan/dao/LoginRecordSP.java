package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.LoginBean;
import org.zhoukan.util.ConnectionPool;
import org.zhoukan.util.MyDate;

public class LoginRecordSP {
	
	public String log(LoginBean loginBean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String mess = "";
		try {
			cs = conn.prepareCall("{call SP_LOGIN_RECORD(?,?,?,?,?,?,?)}");
			cs.setString(1, loginBean.getLOGIN_ID());//loginBean.getLOGIN_ID()
			cs.setString(2, loginBean.getLOGIN_UPTIME());//loginBean.getLOGIN_UPTIME()
			cs.setString(3, loginBean.getLOGIN_IP());//loginBean.getLOGIN_IP())
			cs.setString(4, loginBean.getUSER_NAME());//loginBean.getUSER_NAME()
			cs.setString(5, loginBean.getNET_ID());//loginBean.getNET_ID()
			cs.setString(6, loginBean.getWORKDAY());
			cs.registerOutParameter(7, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			mess = cs.getString(7);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return mess;
		}finally{
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
		return mess;
	}
	public static void main(String[] args) {
		LoginBean loginBean = new LoginBean();
		loginBean.setLOGIN_ID("3");
		loginBean.setLOGIN_UPTIME("2011-12-01");
		loginBean.setLOGIN_IP("127.0.0.1");
		loginBean.setNET_ID("2080");
		loginBean.setUSER_NAME("zhangwenjia");
		loginBean.setWORKDAY("2011-12-01");
		LoginRecordSP recordSP = new  LoginRecordSP();
		String n = recordSP.log(loginBean);
		System.out.println(n);
		System.out.println(MyDate.getDate());
	}
}
