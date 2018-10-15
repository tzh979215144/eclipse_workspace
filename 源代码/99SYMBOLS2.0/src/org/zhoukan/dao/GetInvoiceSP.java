package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.zhoukan.bean.Cl_InvoiceBean;
import org.zhoukan.util.ConnectionPool;

public class GetInvoiceSP {

	public Map<String, Object> getInvoice(String Loan_no,String dd_no){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			cs = conn.prepareCall("{call SP_Get_Invoice(?,?,?)}");
			cs.setString(1, Loan_no);
			cs.setString(2, dd_no);
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			ResultSet rsDD = (ResultSet)cs.getObject(3);

			List<Cl_InvoiceBean> list1 = new ArrayList<Cl_InvoiceBean>();
//			System.out.println(rsDD.next());
			while(rsDD.next()){
				Cl_InvoiceBean bean1 = new Cl_InvoiceBean();
				bean1.setDEBIT_NOTE_NO(rsDD.getInt("DEBIT_NOTE_NO"));	
				bean1.setINVOICE_TYPE(rsDD.getString("INVOICE_TYPE"));				
				bean1.setINT_FROM(rsDD.getString("INT_FROM"));			
				bean1.setDUE_DATE(rsDD.getString("DUE_DATE"));				 
				bean1.setINT_RATE(rsDD.getFloat("INT_RATE"));				
				bean1.setCCY(rsDD.getString("CCY"));				
				bean1.setBILLED_AMT(rsDD.getInt("BILLED_AMT"));
				list1.add(bean1);
			}
			map.put("invoice", list1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
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
		GetInvoiceSP getInvoiceSP =new GetInvoiceSP();
		Map<String, Object> map=getInvoiceSP.getInvoice("2080000026", "20111205064");
		List<?> list = (List<?>)map.get("invoice");
		for(int i = 0; i < list.size();	i++){
			System.out.println(((Cl_InvoiceBean)list.get(i)).getINVOICE_TYPE());
		}
	}
}
