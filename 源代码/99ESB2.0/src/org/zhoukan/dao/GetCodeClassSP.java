package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.ESBServiceBean;
import org.zhoukan.util.ConnectionPool;

public class GetCodeClassSP {

	public ESBServiceBean getCodeClass(ESBServiceBean serviceBean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall("{call SP_GET_CLASS_SYMCODE(?,?,?)}");
			cs.setString(1, serviceBean.getTELLER_TRAN_NO());
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			serviceBean.setSYMBOLS_TRAN_NO(cs.getString(2));
			serviceBean.setSUB_SERVICE_CLASS(cs.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return serviceBean;
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
		
		return serviceBean;
	}
	
	public static void main(String[] args) {
		ESBServiceBean bean = new ESBServiceBean();
		bean.setTELLER_TRAN_NO("MESSWORKDAY1WORKDAY2");
		bean = new GetCodeClassSP().getCodeClass(bean);
		System.out.println(bean.getSUB_SERVICE_CLASS()+" | "+bean.getSYMBOLS_TRAN_NO());
	}
}
