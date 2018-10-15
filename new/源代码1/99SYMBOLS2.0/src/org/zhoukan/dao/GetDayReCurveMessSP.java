package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zhoukan.bean.Day_FinishBean;
import org.zhoukan.util.ConnectionPool;

public class GetDayReCurveMessSP {
	public Map<String, Object> getMess(String WORKDAY1,String WORKDAY2 ) {
		Connection conn = ConnectionPool.getOneConn();
		System.out.println("INFO | conn:" + conn);
		CallableStatement cs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			cs = conn.prepareCall("{call SP_GET_DAYRECURVEMESS(?,?,?)}");
			cs.setString(1, WORKDAY1);
			cs.setString(2, WORKDAY2);
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(3);
			List<Day_FinishBean> DayReCurveList = new ArrayList<Day_FinishBean>();
			while (rs.next()) {
				Day_FinishBean day_FinishBean = new Day_FinishBean();
				day_FinishBean.setDAYFINISH_WORKDAY(rs.getString("DAYFINISH_WORKDAY"));
				day_FinishBean.setDAYFINISH_TIME((rs
						.getString("DAYFINISH_TIME")));
				DayReCurveList.add(day_FinishBean);
			}
			map.put("DayReCurveList", DayReCurveList);
			System.out
					.println("INFO | DayReCurveList的大小为：" + DayReCurveList.size());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static void main(String[] args) {
		Map<String, Object> map = (Map<String, Object>) new GetDayReCurveMessSP()
				.getMess("2012-01-09 23:35:17","2012-01-11 23:35:20");
//		Day_FinishBean.setDAYFINISH_WORKDAY()
		List<?> list = (List<?>) map.get("DayReCurveList");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(((Day_FinishBean) list.get(i))
					.getDAYFINISH_WORKDAY());
			System.out.println(((Day_FinishBean) list.get(i))
					.getDAYFINISH_TIME());
		}
	}
}
