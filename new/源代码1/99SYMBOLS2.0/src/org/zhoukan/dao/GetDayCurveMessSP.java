package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zhoukan.bean.Day_JournalBean;
import org.zhoukan.util.ConnectionPool;

public class GetDayCurveMessSP {
	public Map<String, Object> getMess() {
		Connection conn = ConnectionPool.getOneConn();
		System.out.println("INFO | conn:" + conn);
		CallableStatement cs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			cs = conn.prepareCall("{call SP_GET_DAYCURVEMESS(?)}");
			cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			List<Day_JournalBean> DayCurveList = new ArrayList<Day_JournalBean>();
			while (rs.next()) {
				Day_JournalBean day_JournalBean = new Day_JournalBean();
				day_JournalBean.setDAYCONFIG_ID(rs.getString("DAYCONFIG_ID"));
				day_JournalBean.setDAYJOURNAL_TIME(rs
						.getString("DAYJOURNAL_TIME"));
				DayCurveList.add(day_JournalBean);
			}
			map.put("DayCurveList", DayCurveList);
			System.out
					.println("INFO | DayCurveList的大小为：" + DayCurveList.size());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static void main(String[] args) {
		Map<String, Object> map = (Map<String, Object>) new GetDayCurveMessSP()
				.getMess();
		List<?> list = (List<?>) map.get("DayCurveList");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(((Day_JournalBean) list.get(i))
					.getDAYCONFIG_ID());
			System.out.println(((Day_JournalBean) list.get(i))
					.getDAYJOURNAL_TIME());
		}
	}
}
