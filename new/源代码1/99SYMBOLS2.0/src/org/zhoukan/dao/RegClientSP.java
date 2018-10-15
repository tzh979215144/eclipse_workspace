package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.Fm_clientBean;
import org.zhoukan.util.ConnectionPool;

public class RegClientSP {

	public String saveClient(Fm_clientBean bean){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			cs = conn.prepareCall("{call SP_CLIENT_REG(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, bean.getCLIENT_NO());
			cs.setString(2, bean.getCLIENT_CITY());
			cs.setString(3, bean.getTAXABLE_IND());
			cs.setString(4, bean.getCH_CLIENT_NAME());
			cs.setString(5, bean.getCLIENT_NAME());
			cs.setString(6, bean.getLOCATION());
			cs.setString(7, bean.getACCT_EXEC());
			cs.setString(8, bean.getCLIENT_TYPE());
			cs.setString(9, bean.getCOUNTRY_LOC());
			cs.setString(10, bean.getREGISTER_DATE());
			cs.setString(11, bean.getMAJOR_CATEGORY());
			cs.setString(12, bean.getCTRL_BRANCH());
			cs.setString(13, bean.getPROFIT_SEGMNT());
			cs.setString(14, bean.getINDUSRTY());
			cs.setString(15, bean.getBUSINESS());
			cs.setString(16, bean.getCR_RAING());
			cs.setString(17, bean.getINTERNAL_IND());
			cs.setString(18, bean.getRB_CLIENT());
			cs.setString(19, bean.getCL_CLIENT());
			cs.setString(20, bean.getCLIENT_STATUS());
			cs.setString(21, bean.getTRAN_STATUS());
			cs.setString(22, bean.getCLOSED_DATA());
			cs.setString(23, bean.getCLIENT_INDICATOR());
			cs.setString(24, bean.getCLIENT_KEY());
			cs.setString(25, bean.getCHANNEL());
			cs.setString(26, bean.getUPDATE_USER());
			cs.setString(27, bean.getUPDATE_DATE());
			cs.setString(28, bean.getRISK_LEVEL());
			cs.setString(29, bean.getTEMP_CLIENT());
			cs.setString(30, bean.getRISK_UPDATE_DATE());
			cs.setString(31, bean.getRISK_UPDATE_REASON());
			cs.setString(32, bean.getCREATION_USER());
			cs.setString(33, bean.getCREATION_DATE());
			cs.setString(34, bean.getCLASS_LEVEL());
			cs.setString(35, bean.getCLASS_LEVEL_DATE());
			cs.setString(36, bean.getCLIENT_SHORT());
			cs.setString(37, bean.getLICENCE_NO());
			cs.setString(38, bean.getGLOBAL_ID_TYPE());
			cs.setString(39, bean.getGLOBAL_ID());
			cs.registerOutParameter(40, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(40);
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
}
