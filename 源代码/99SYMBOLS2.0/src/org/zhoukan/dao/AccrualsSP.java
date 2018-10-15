package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.CL_AccrualsBean;
import org.zhoukan.bean.Cl_drawDrowBean;
import org.zhoukan.util.ConnectionPool;

public class AccrualsSP {
	public String update(CL_AccrualsBean bean, Cl_drawDrowBean drawdrowbean) {
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_Accruals(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println(bean.getLOAN_NO());
			System.out.println(drawdrowbean.getDD_NO());
			cs.setString(1, bean.getLOAN_NO());
			cs.setString(2, drawdrowbean.getDD_NO());
			cs.setInt(3, bean.getINTEREST_AMT());
			cs.setInt(4, bean.getPENALTY_AMT_PRI());
			cs.setInt(5, bean.getPENALTY_AMT_INT());
			cs.setInt(6, drawdrowbean.getINT_OUTSTANDING());
			cs.setInt(7, drawdrowbean.getDOP_OUTSTANDING());
			cs.setInt(8, drawdrowbean.getODI_OUTSTANDING());
			cs.setFloat(9,bean.getINT_RATE());
			cs.setFloat(10,bean.getINT_BASISRATE());
			cs.setFloat(11,bean.getPRI_PLTI_RATE());
			cs.setFloat(12,bean.getPRI_PLTY_ABS());
			cs.setFloat(13,bean.getINT_PITY_RATE());
			cs.setFloat(14,bean.getINT_PITY_ABS());
			cs.registerOutParameter(15, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(15);
		} catch (SQLException e) {
			e.printStackTrace();
			return n;
		} finally {
			try {
				if (cs != null) {
					cs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (conn != null) {
				ConnectionPool.backOneConn(conn);
			}
		}
		return n;
	}

	public static void main(String[] args) {
		CL_AccrualsBean bean = new CL_AccrualsBean();
		Cl_drawDrowBean drawDrowBean = new Cl_drawDrowBean();
		AccrualsSP accrualsSP = new AccrualsSP();
		bean.setLOAN_NO("2080000011");
		drawDrowBean.setDD_NO("20111205048");
		bean.setINTEREST_AMT(235);
		bean.setPENALTY_AMT_PRI(241);
		bean.setPENALTY_AMT_INT(241);
		drawDrowBean.setINT_OUTSTANDING(6);
		drawDrowBean.setDOP_OUTSTANDING(6);
		drawDrowBean.setODI_OUTSTANDING(666);
		String out = accrualsSP.update(bean, drawDrowBean);
		System.out.println(out);
	}
}
