package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.Fm_acctBean;
import org.zhoukan.bean.Rate_ReferenceBean;
import org.zhoukan.util.ConnectionPool;

public class DepositSP {

	public String save(Fm_acctBean bean,Rate_ReferenceBean bean1){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_DEPOSIT(?,?,?,?)}");
			cs.setString(1, bean.getBASE_ACCT_NO());
			cs.setString(2, bean1.getSAVEING_ID());
			cs.setString(3, bean.getSAVE_AMT());
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(4);
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
		Rate_ReferenceBean rate_ReferenceBean = new Rate_ReferenceBean();
		DepositSP depositSP= new DepositSP();
		fm_acctBean.setBASE_ACCT_NO("141020801033");
		rate_ReferenceBean.setSAVEING_ID("5Y");
		fm_acctBean.setSAVE_AMT("1000");
		String out = depositSP.save(fm_acctBean, rate_ReferenceBean);
		System.out.println("INFO | 返回码："+out);
	}
}
