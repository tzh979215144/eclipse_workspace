package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;


import org.zhoukan.bean.CL_LOANBean;
import org.zhoukan.bean.Cl_InvoiceBean;
import org.zhoukan.bean.Cl_drawDrowBean;
import org.zhoukan.util.ConnectionPool;
import org.zhoukan.util.MyDate;

public class InvoiceSP {
	public String save(Cl_InvoiceBean bean1,CL_LOANBean bean2,Cl_drawDrowBean bean3){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_INVOICE(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setInt(1, bean1.getINTERNAL_KEY());
			cs.setString(2, bean2.getLOAN_NO());
			cs.setInt(3, bean1.getDEBIT_NOTE_NO());
			cs.setString(4, bean1.getINVOICE_TRAN_NOO());
			cs.setString(5, bean3.getDD_NO());
			cs.setString(6, bean1.getCCY());
			cs.setString(7, bean1.getINVOICE_TYPE());
			cs.setInt(8, bean1.getBILLED_AMT());
			cs.setString(9, bean1.getDUE_DATE());
			cs.setString(10, bean1.getINT_FROM());
			cs.setFloat(11, bean1.getINT_RATE());
			cs.registerOutParameter(12, oracle.jdbc.OracleTypes.VARCHAR);
			
			cs.execute();
			n = cs.getString(12);
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
		Cl_InvoiceBean bean1 = new Cl_InvoiceBean();
		CL_LOANBean bean2=new CL_LOANBean();
		Cl_drawDrowBean bean3= new Cl_drawDrowBean();
		InvoiceSP InvoiceSP = new InvoiceSP();
		bean1.setINTERNAL_KEY(32);
//		bean1.setDEBIT_NOTE_NO(2011);
//		bean1.setINVOICE_TRAN_NOO("2080");
		bean2.setLOAN_NO("2080000033");
		bean1.setDEBIT_NOTE_NO(2011000041);
		bean1.setINVOICE_TRAN_NOO("20880041");
		bean3.setDD_NO("20111205076");
		bean1.setCCY("RMB");
		bean1.setINVOICE_TYPE("PRL");
		bean1.setUSER_ID("zhoukan");
		bean1.setDUE_DATE(MyDate.getTime());
		System.out.println(MyDate.getTime());
		String ss = InvoiceSP.save(bean1, bean2, bean3);
		System.out.println(ss);
	}
}

