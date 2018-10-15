package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.zhoukan.bean.CL_LOANBean;
import org.zhoukan.bean.CL_PAID_INVOICEBEAN;
import org.zhoukan.bean.CL_RECEIPT_TBLBean;
import org.zhoukan.util.ConnectionPool;
import org.zhoukan.util.MyDate;

public class ReceiptSP {
	public String save(CL_RECEIPT_TBLBean bean1,CL_LOANBean bean2,CL_PAID_INVOICEBEAN bean3){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		CallableStatement cs1 = null;
		String n = "-1";
		try {
			
				cs1 = conn.prepareCall("{call SP_RECEIPT_TABLE(?,?,?,?,?,?,?,?)}");
				cs1.setString(1, bean3.getINTERNAL_KEY()); 
				cs1.setString(2, bean3.getLOAN_NO());
				cs1.setString(3, bean3.getDD_NO());
				cs1.setString(4, bean3.getBORROWER());
				cs1.setString(5, bean3.getCCY());
				cs1.setString(6, bean3.getRECEIPT_NO());
				cs1.setString(7, bean3.getPAID_AMT());
				cs1.registerOutParameter(8, oracle.jdbc.OracleTypes.VARCHAR);
				cs1.execute();
			
			cs = conn.prepareCall("{call SP_RECEIPT(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, bean2.getLOAN_NO());
			cs.setString(2, bean1.getCCY());
			cs.setString(3, bean1.getUSER_ID());
			cs.setString(4, bean1.getBANK_SEQ_NO());
			cs.setString(5, bean1.getRECEIPT_KEY());
			cs.setString(6, bean1.getRECEIPT_NO());
			cs.setString(7, bean1.getRECEIPT());
			cs.setString(8, bean1.getRECEIPT_DATE());
			cs.setString(9, bean1.getPAYER());
			cs.setString(10, bean1.getNARRATIVE());
			cs.setString(11, bean1.getRECEIPT_AMT());
			//cs.setString(12, bean2.getREVOLVE_YN());
			cs.registerOutParameter(12, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n=cs.getString(12);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	//根据回收表对象插入一条回收表记录
	public String save(CL_RECEIPT_TBLBean Bean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_RECEIPT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, Bean.getRECEIPT_KEY());
			cs.setString(2, Bean.getRECEIPT_NO());
			cs.setString(3, Bean.getLOAN_KEY());
			cs.setString(4, Bean.getPAYER());
			cs.setString(5, Bean.getRECEIPT());
			cs.setString(6, Bean.getCCY());
			cs.setString(7, Bean.getRECEIPT_DATE());
			cs.setString(8, Bean.getTRAN_DATE());
			cs.setString(9, Bean.getRECEIPT_AMT());
			cs.setString(10, Bean.getNARRATIVE());
			cs.setString(11, Bean.getCLEARED());
			cs.setString(12, Bean.getPRINT_YN());
			cs.setString(13, Bean.getADVICE_SENT());
			cs.setString(14, Bean.getGL_POSTED());
			cs.setString(15, Bean.getUSER_ID());
			cs.setString(16, Bean.getLAST_CHANGE_DATE());
			cs.setString(17, Bean.getVERIFY());
			cs.setString(18, Bean.getSETTLED());
			cs.setString(19, Bean.getRECEIPT_CEN_CODE());
			cs.setString(20, Bean.getREV_REC());
			cs.setString(21, MyDate.getTime());
			cs.setString(22, Bean.getBANK_SEQ_NO());
			cs.setString(23, Bean.getVERIFY_USER_ID());
			cs.setString(24, Bean.getSETTLED_USER_ID());
			cs.setString(25, Bean.getREASON_DESC());
			//cs.setString(12, bean2.getREVOLVE_YN());
			cs.registerOutParameter(26, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n=cs.getString(26);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
//		CL_RECEIPT_TBLBean bean1 = new CL_RECEIPT_TBLBean();
//		CL_LOANBean bean2=new CL_LOANBean();
//		CL_PAID_INVOICEBEAN bean3=new CL_PAID_INVOICEBEAN();
//		//List<ReceiptTableBean> ReceiptTableList=new ArrayList<ReceiptTableBean>();
//		ReceiptSP ReceiptSP = new ReceiptSP();
//		bean3.setLOAN_NO("2080000026");
//		bean3.setDD_NO("20111205064");
//		bean3.setINTERNAL_KEY("1");
//		bean3.setBORROWER("123");
//		bean3.setCCY("RMB");
//		bean3.setRECEIPT_NO("123");
//		bean3.setPAID_AMT("11111111");
//		bean2.setLOAN_NO("2080000026");
//		bean1.setCCY("RMB");
//		bean1.setUSER_ID("20880001");
//		bean1.setBANK_SEQ_NO("20110000001");
//		bean1.setRECEIPT_KEY("111");
//		bean1.setRECEIPT_NO("123");
//		bean1.setRECEIPT("AB");
//		bean1.setRECEIPT_DATE(MyDate.getTime());
//		bean1.setPAYER("132");
//		bean1.setNARRATIVE("aaaaaaaa");
//		bean1.setRECEIPT_AMT("1000");
////		System.out.println(MyDate.getTime());
//		String ss = ReceiptSP.save(bean1, bean2,bean3);
//		System.out.println(ss);
		CL_RECEIPT_TBLBean cReceiptTBLBean=new CL_RECEIPT_TBLBean();
		String rECEIPT_KEY = new GetNOSP().getNO("RECEIPT_KEY");
		cReceiptTBLBean.setRECEIPT_KEY(rECEIPT_KEY);
		String rECEIPT_NO= new GetNOSP().getNO("RECEIPT_NO");
		cReceiptTBLBean.setRECEIPT_NO(rECEIPT_NO);
		cReceiptTBLBean.setRECEIPT_DATE(MyDate.getTime());
		cReceiptTBLBean.setTRAN_DATE(MyDate.getTime());
		cReceiptTBLBean.setREV_REC("1");
		System.out.println(new ReceiptSP().save(cReceiptTBLBean));
	}
}
