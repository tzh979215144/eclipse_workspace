package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zhoukan.bean.Cl_DayFinishiBean;
import org.zhoukan.util.ConnectionPool;

public class LoadingSP {

	public Map<String, Object> load(){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			cs = conn.prepareCall("{call PROCCESS_LOADING(?)}");
			cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			ResultSet rsDD = (ResultSet)cs.getObject(1);

			List<Cl_DayFinishiBean> list1 = new ArrayList<Cl_DayFinishiBean>();
//			System.out.println(rsDD.next());
			while(rsDD.next()){
				Cl_DayFinishiBean bean1 = new Cl_DayFinishiBean();
				bean1.setPROCESS_SEQ_NO(rsDD.getString("PROCESS_SEQ_NO"));	
				bean1.setSTART_TIME(rsDD.getString("START_TIME"));				
				bean1.setEND_TIME(rsDD.getString("END_TIME"));			
				bean1.setRESULT(rsDD.getString("RESULT"));				 
				bean1.setPROCESS_NAME(rsDD.getString("PROCESS_NAME"));				
				list1.add(bean1);
			}
			map.put("Day_finish", list1);
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
}
