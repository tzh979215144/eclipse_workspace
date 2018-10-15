package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.CL_RECEIPT_TBLBean;
import org.zhoukan.bean.Cl_InvoiceBean;
import org.zhoukan.util.ConnectionPool;

public class PaidInvoiceSP {

	public String save(Cl_InvoiceBean bean,CL_RECEIPT_TBLBean cReceiptTBLBean ){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_CL_Paid_invoice(?,?,?,?)}");
			//System.out.println(bean.getDEBIT_NOTE_NO()+"哈哈"+cReceiptTBLBean.getRECEIPT_NO());
			cs.setInt(1, bean.getDEBIT_NOTE_NO());
			cs.setString(2,cReceiptTBLBean.getRECEIPT_NO());
			cs.setInt(3,Integer.parseInt(new GetNOSP().getNO("INTERNAL_KEY11")));
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);

			//cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n=cs.getString(4);
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
	
	public static void main(String[] args) {
		Cl_InvoiceBean clInvoiceBean=new Cl_InvoiceBean();
		CL_RECEIPT_TBLBean clRECEIPTTBLBean=new CL_RECEIPT_TBLBean();
		clInvoiceBean.setDEBIT_NOTE_NO(567);
		clRECEIPTTBLBean.setRECEIPT_NO("201220080639");
		System.out.println(new PaidInvoiceSP().save(clInvoiceBean, clRECEIPTTBLBean));
		System.out.println("ok!");
	}

}
