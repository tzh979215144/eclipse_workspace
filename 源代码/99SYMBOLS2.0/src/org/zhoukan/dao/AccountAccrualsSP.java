package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.zhoukan.bean.Fm_acctBean;
import org.zhoukan.util.ConnectionPool;
public class AccountAccrualsSP {

	public String update(Fm_acctBean bean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_ACCOUNTACC(?,?,?)}");
			cs.setString(1, bean.getBASE_ACCT_NO());
			cs.setString(2, bean.getACC_INT());
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(3);
		} catch (SQLException e) {
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
	public static void main(String[] args) {
		Fm_acctBean fm_acctBean=new Fm_acctBean();
		AccountAccrualsSP accountAccrualsSP= new AccountAccrualsSP();
		fm_acctBean.setBASE_ACCT_NO("141020801033");
		fm_acctBean.setACC_INT("30");
		String out = accountAccrualsSP.update(fm_acctBean);
		System.out.println("INFO | 返回码："+out);
	}
}
