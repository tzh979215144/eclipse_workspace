package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.zhoukan.bean.Day_FinishBean;
import org.zhoukan.util.ConnectionPool;
import org.zhoukan.util.MyDate;

public class DayFinishSP {
	public String saveDayFinish(Day_FinishBean bean1){
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		String n = "-1";
		try {
			System.out.println("INFO | DAYFINISH_WORKDAY："+bean1.getDAYFINISH_WORKDAY());
			System.out.println("INFO | DAYFINISH_PEOPLE："+bean1.getDAYFINISH_PEOPLE());
			System.out.println("INFO | DAYFINISH_REMARK："+bean1.getDAYFINISH_REMARK());
			cs = conn.prepareCall("{call sp_dayfinish(?,?,?,?)}");
			cs.setString(1, bean1.getDAYFINISH_WORKDAY());
			cs.setString(2, bean1.getDAYFINISH_PEOPLE());
			cs.setString(3, bean1.getDAYFINISH_REMARK());
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			n = cs.getString(4);
		} catch (SQLException e) {
			e.printStackTrace();
			return n;
		} finally {
			try {
				if(cs != null){
					cs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(conn != null){
				ConnectionPool.backOneConn(conn);
			}
		}
		return n;
		
	}
	public static void main(String[] args) {
		Day_FinishBean bean1= new Day_FinishBean();
		DayFinishSP dayFinishSP = new DayFinishSP();
		bean1.setDAYFINISH_WORKDAY(MyDate.getTime());
		bean1.setDAYFINISH_PEOPLE("tom");
		bean1.setDAYFINISH_REMARK("REMARK");
		System.out.println("INFO | MyDate:" + MyDate.getTime());
		String ss = dayFinishSP.saveDayFinish(bean1);
		System.out.println("INFO | RECODE:"+ss);
	}
}
