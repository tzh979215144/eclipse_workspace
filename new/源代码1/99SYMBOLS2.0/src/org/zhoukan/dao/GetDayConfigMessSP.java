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

//根据贷款号运用Ajax来查询相关信息
public class GetDayConfigMessSP {
	// 调用存储过程获得界面的相关信息
	public Map<String, Object> getMess() {
		Connection conn = ConnectionPool.getOneConn();
		System.out.println("INFO | conn:"+conn);
		CallableStatement cs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			cs = conn.prepareCall("{call SP_GET_DAYCONFMESS(?)}");
			cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1);
			List<Day_JournalBean> DayConfigcList = new ArrayList<Day_JournalBean>();
			while (rs.next()) {
				Day_JournalBean day_JournalBean = new Day_JournalBean();
				day_JournalBean.setDAYJOURNAL_ID(rs.getString("DAYJOURNAL_ID"));
				day_JournalBean.setDAYCONFIG_ID(rs.getString("DAYCONFIG_ID"));
				day_JournalBean.setDAYCONFIG_ENAME(rs
						.getString("DAYCONFIG_ENAME"));
				day_JournalBean.setDAYCONFIG_CNAME(rs
						.getString("DAYCONFIG_CNAME"));
				day_JournalBean.setDAYJOURNAL_WORKDAY(rs
						.getString("DAYJOURNAL_WORKDAY"));
				day_JournalBean.setDAYJOURNAL_BEGIN(rs
						.getString("DAYJOURNAL_BEGIN"));
				day_JournalBean.setDAYJOURNAL_END(rs
						.getString("DAYJOURNAL_END"));
				day_JournalBean.setDAYJOURNAL_TIME(rs
						.getString("DAYJOURNAL_TIME"));
				day_JournalBean.setDAYJOURNAL_SEQ(rs
						.getString("DAYJOURNAL_SEQ"));
				day_JournalBean.setDAYJOURNAL_ISSUCCESS(rs
						.getString("DAYJOURNAL_ISSUCCESS"));
				day_JournalBean.setDAYJOURNAL_REASON(rs
						.getString("DAYJOURNAL_REASON"));
				day_JournalBean.setDAYJOURNAL_RECODE(rs
						.getString("DAYJOURNAL_RECODE"));
				day_JournalBean.setDAYJOURNAL_RESULT(rs
						.getString("DAYJOURNAL_RESULT"));
				day_JournalBean.setDAYJOURNAL_STATUS(rs
						.getString("DAYJOURNAL_STATUS"));
				DayConfigcList.add(day_JournalBean);
			}
			map.put("DayConfigcList", DayConfigcList);
			System.out.println("INFO | DayConfigcList的大小为："
					+ DayConfigcList.size());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("INFO | DayConfig查询存储过程SQLException.......");
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

	public static void main(String[] args) {
		Map<String, Object> map = (Map<String, Object>) new GetDayConfigMessSP()
				.getMess();
		List<?> list = (List<?>) map.get("DayConfigcList");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(((Day_JournalBean) list.get(i))
					.getDAYCONFIG_ID());
			System.out.println(((Day_JournalBean) list.get(i))
					.getDAYCONFIG_ENAME());
			System.out.println(((Day_JournalBean) list.get(i))
					.getDAYCONFIG_CNAME());
		}
	}
}
