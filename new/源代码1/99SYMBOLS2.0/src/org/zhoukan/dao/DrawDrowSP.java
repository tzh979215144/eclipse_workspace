package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.zhoukan.bean.Cl_drawDrowBean;
import org.zhoukan.util.ConnectionPool;

public class DrawDrowSP {

	public String save(Cl_drawDrowBean bean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_drawDrow(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)}");
			cs.setInt(1, bean.getOD_PRI_POSTED());
			System.out.println(bean.getOD_PRI_POSTED());
			
			cs.setInt(2, bean.getDD_KEY());
			System.out.println(bean.getDD_KEY());
			
			cs.setString(3, bean.getDD_NO());
			
			System.out.println(bean.getDD_NO());
			
			cs.setString(4, bean.getTRAN_NO());
			cs.setString(5, bean.getLENDER());
			
			cs.setString(6, bean.getSUB_PROJECT_NO());
			cs.setString(7, bean.getTRAN_DATE());
			cs.setString(8, bean.getDD_DATE());
	
			cs.setString(9, bean.getMATURITY());
			cs.setString(10, bean.getCCY());
			cs.setInt(11, bean.getDD_AMT());
			cs.setInt(12, bean.getOUTSTANDING());
			cs.setInt(13, bean.getOS_LESS_PAST_DUE());
			cs.setString(14, bean.getMONTH_BASIS_PEN());
			cs.setString(15, bean.getMONTH_BASIS_INT());
			cs.setInt(16, bean.getYEAR_BASIS_PEN());
			cs.setInt(17, bean.getYEAR_BASIS_INT());
			cs.setString(18, bean.getINT_BASIS());
			cs.setFloat(19, bean.getINT_BASIS_RATE());
			cs.setFloat(20, bean.getINT_RATE());
			cs.setFloat(21, bean.getINT_PLTY_RATE());
			cs.setString(22, bean.getPRI_PLTY_BASIS());
			cs.setFloat(23, bean.getPRI_PLTY_SPREAD());
			cs.setFloat(24, bean.getPRI_PLTY_ABS());
			cs.setFloat(25, bean.getPENALTY_ODI_RATE_TYPE());
			cs.setString(26, bean.getROLL_DATE());
			cs.setString(27, bean.getLAST_INT_REP_DATE());
			cs.setString(28, bean.getNEXT_INT_REP_DATE());
			cs.setString(29, bean.getINT_REPAY_FREQ());
			cs.setInt(30, bean.getINT_REPAY_DAY());
			cs.setInt(31, bean.getINT_CALCULATED());
			cs.setInt(32, bean.getOD_INT_CALCULATED());
			cs.setInt(33, bean.getOD_PRI_CALCULATED());
			cs.setInt(34, bean.getINT_POSTED());
			cs.setInt(35, bean.getOD_INT_POSTED());
			cs.setInt(36, bean.getINT_ADJ_NOT_POSTED() );
			cs.setInt(37, bean.getINT_ADJ_POSTED());
			cs.setInt(38, bean.getOD_INT_ADJ_NOT_POSTED());
			cs.setInt(39, bean.getOD_PRI_ADJ_NOT_POSTEN());
			cs.setInt(40, bean.getOD_INT_ADJ_POSTED());
			cs.setInt(41, bean.getOD_PRI_ADJ_POSTED());
			cs.setInt(42, bean.getPRI_RECD_RECBLE());
			cs.setInt(43, bean.getPRI_OUTSTANDING());
			cs.setInt(44, bean.getINT_OUTSTANDING());
			cs.setInt(45, bean.getODI_OUTSTANDING());
			cs.setInt(46, bean.getDOP_OUTSTANDING());
			cs.setInt(47, bean.getPRI_PAST_DUE());
			cs.setInt(48, bean.getINT_PAST_DUE());
			cs.setInt(49, bean.getODI_PAST_DUE());
			cs.setInt(50, bean.getODP_PAST_DUE());
			cs.setString(51, bean.getGL_POSTED());
			cs.setString(52, bean.getADVICE_SENT());
			cs.setString(53, bean.getREVERSED_MATURED());
			cs.setString(54, bean.getLOAN_NO());
			System.out.println(bean.getLOAN_NO());
			cs.setString(55, bean.getUSER_ID());
			cs.setString(56, bean.getLAST_CHANGE_DATE());
			cs.setString(57, bean.getVERIFY());
			cs.setString(58, bean.getPRI_BILLING_DATE());
			cs.setString(59, bean.getINT_BILLING_DATE());
			cs.setString(60, bean.getNEXT_PRI_PEP_DATE());
			cs.setString(61, bean.getLAST_ACCRUAL_DATE());
			cs.setString(62, bean.getFINAL_BILLING_DATE());
			cs.setInt(63, bean.getYEAR_BASIS_PLTY());
			cs.setInt(64, bean.getMONTH_BASIS_PLTY());
			cs.setString(65, bean.getINT_PLTY_BASIS());
			cs.setFloat(66, bean.getINT_PLTY_ABS());
			cs.setFloat(67, bean.getINT_PLTY_SPREAD());
			cs.setFloat(68, bean.getINT_SPREAD());
			cs.setString(69, bean.getLAST_PRI_PEP_DATE());
			cs.setFloat(70, bean.getPRI_PLTY_RATE());
			cs.registerOutParameter(71, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(71);
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
		Cl_drawDrowBean bean = new Cl_drawDrowBean();
		DrawDrowSP drawDrowSP = new DrawDrowSP();
		bean.setDD_KEY(53);
		String ss = drawDrowSP.save(bean);
		System.out.println(ss);
	}
}
