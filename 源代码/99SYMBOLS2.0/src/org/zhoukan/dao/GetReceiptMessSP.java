package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.zhoukan.bean.Cl_drawDrowBean;
import org.zhoukan.util.ConnectionPool;

//根据贷款号运用Ajax来查询相关信息
public class GetReceiptMessSP {
	// 调用存储过程获得界面的相关信息
	public Map<String, Object> getMess(String Loan_no) {

		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			cs = conn.prepareCall("{call SP_GET_RECEIPTMESS(?,?,?,?,?,?,?,?,?,?)}");
			// 界面输入参数 贷款号
			cs.setString(1, Loan_no);
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(6, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(7, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(8, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(9, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(10, oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			// 开立表的信息
			map.put("STATUS", cs.getString(2));
			map.put("BORROWER", cs.getString(3));
			map.put("BORROWER_NAME", cs.getString(3));
			map.put("BOOK_BRANCH", cs.getString(4));
			map.put("LOAN_MANAGER", cs.getString(5));
			map.put("LOAN_TYPE", cs.getString(6));
			map.put("LOAN_SUB_TYPE", cs.getString(7));
			map.put("REVOLVE_YN", cs.getString(8));
			map.put("OUTSTANDING", cs.getString(9));
			//回收表信息
//			map.put("RECEIPT", cs.getString(11));
//			map.put("RECEIPT_DATE", cs.getString(12));
//			map.put("PAYER", cs.getString(13));
//			map.put("NARRATIVE", cs.getString(14));
//			map.put("RECEIPT_AMT", cs.getString(15));
//			map.put("DCCY", cs.getString(16));
			ResultSet rs = (ResultSet) cs.getObject(10);
			List<Cl_drawDrowBean> RecList = new ArrayList<Cl_drawDrowBean>();
			while(rs.next()){
				Cl_drawDrowBean drawDrowBean = new Cl_drawDrowBean();
				drawDrowBean.setLENDER(rs.getString("LENDER"));
				drawDrowBean.setMATURITY(rs.getString("MATURITY"));
				drawDrowBean.setCCY(rs.getString("CCY"));
				//drawDrowBean.setPRI_RECD_RECBLE((rs.getInt("ODI_OUTSTANDING"))+rs.getInt("INT_OUTSTANDING")+rs.getInt("ODI_OUTSTANDING"));
				drawDrowBean.setDD_AMT((rs.getInt("DD_AMT")));
				drawDrowBean.setDD_NO(rs.getString("DD_NO"));
				drawDrowBean.setINT_RATE(rs.getFloat("INT_RATE"));
				RecList.add(drawDrowBean);
			}
			map.put("RecList", RecList);
			System.out.println("INFO | RecList的大小为："+RecList.size());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("INFO | Receipt查询存储过程SQLException.......");
			return map;
		} finally {       
			try {
				if (cs != null) {
					cs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("INFO | 释放资源出现异常....");
			}
			if (conn != null) {
				// 用完以后放回连接池
				ConnectionPool.backOneConn(conn);
			}
		}
		return map;
	}
	//通过通知单号获取贷款回收信息
	public Map<String, String> getMessById(String DEBIT_NOTE_NO) {

		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			cs = conn.prepareCall("{call SP_GET_RECEIPTMESS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 界面输入参数 贷款号
			cs.setString(1, DEBIT_NOTE_NO);
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(6, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(7, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(8, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(9, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(10, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(11, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(12, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(13, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(14, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(15, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(16, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(17, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(18, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			// 开立表的信息
			map.put("LOAN_KEY", cs.getString(2));
			map.put("DD_KEY", cs.getString(3));
			map.put("BORROWER", cs.getString(4));
//			map.put("STATUS", cs.getString(5));
			map.put("BOOK_BRANCH", cs.getString(6));
			map.put("LENDER", cs.getString(7));
//			map.put("CCY", cs.getString(8));
			map.put("LOAN_MANAGER", cs.getString(9));
//			map.put("BORROWER_TYPE", cs.getString(10));
//			map.put("LOAN_SUB_TYPE", cs.getString(11));
//			map.put("RECEIPT", cs.getString(12));
//			map.put("REVOLVE_VN", cs.getString(13));
//			map.put("PAYER", cs.getString(14));
//			map.put("RECEIPT_DATE", cs.getString(15));
//			map.put("REASON_DESC", cs.getString(16));
			map.put("REPAY_AMT", cs.getString(17));
			map.put("OUTSTANDING", cs.getString(18));
			
		} catch (SQLException e) {
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
//		Map<String, Object> map = new GetReceiptMessSP().getMess("2080000030");
//		// 借款人
//		System.out.println(map.get("STATUS"));
//		System.out.println(map.get("BORROWER"));
//		System.out.println(map.get("BORROWER_NAME"));
//		System.out.println(map.get("BOOK_BRANCH"));
//		System.out.println(map.get("LOAN_MANAGER"));
//		System.out.println(map.get("LOAN_TYPE"));
//		System.out.println(map.get("LOAN_SUB_TYPE"));
//		System.out.println(map.get("REVOLVE_YN"));
//		System.out.println(map.get("OUTSTANDING"));
//		List<?> list = (List<?>)map.get("RecList");
//		for(int i = 0; i < list.size();	i++){
//			System.out.println(((Cl_drawDrowBean)list.get(i)).getLENDER());
//			System.out.println(((Cl_drawDrowBean)list.get(i)).getMATURITY());
//			System.out.println(((Cl_drawDrowBean)list.get(i)).getCCY());
//			System.out.println(((Cl_drawDrowBean)list.get(i)).getODI_OUTSTANDING());
//			System.out.println(((Cl_drawDrowBean)list.get(i)).getDD_AMT());
//			System.out.println(((Cl_drawDrowBean)list.get(i)).getDD_NO());
//			System.out.println(((Cl_drawDrowBean)list.get(i)).getINT_RATE());
//		}
		new GetReceiptMessSP().getMessById("567");
	}
}
