package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zhoukan.bean.CL_RepaySchedTmpBean;
import org.zhoukan.util.ConnectionPool;

public class GetRepayTmpMessSP {
	// 调用存储过程获得界面的相关信息
	public Map<String, Object> getMess(String Loan_no, String DD_no) {
	//System.out.println(NumberFormat.getCurrencyInstance().format(1234));
		

		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			cs = conn
					.prepareCall("{call SP_GET_REPAYTMPMESS(?,?,?)}");
			// 界面输入参数 贷款号
			cs.setString(1, Loan_no);
			// 界面输入参数 发放号
			cs.setString(2, DD_no);
			/*注册游标*/
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(3);
			List<CL_RepaySchedTmpBean> RepaySchedTmpList = new ArrayList<CL_RepaySchedTmpBean>();
			while (rs.next()) {
				CL_RepaySchedTmpBean  repaySchedTmpBean = new CL_RepaySchedTmpBean();
				repaySchedTmpBean.setCOUNTER(rs.getString("COUNTER"));
				repaySchedTmpBean.setLOAN_NO(Loan_no);
				repaySchedTmpBean.setDD_NO(DD_no);
				repaySchedTmpBean.setSTART_DATE(rs.getString("START_DATE").substring(0, 10));
				repaySchedTmpBean.setEND_DATE(rs.getString("END_DATE").substring(0, 10));
				repaySchedTmpBean.setINT_RATE(rs.getInt("INT_RATE"));
				repaySchedTmpBean.setREPAY_AMT((rs.getInt("REPAY_AMT")));
				repaySchedTmpBean.setINT_AMT((rs.getInt("INT_AMT")));
				repaySchedTmpBean.setDD_AMT((rs.getString("DD_AMT")));
				repaySchedTmpBean.setDD_DATE(rs.getString("DD_DATE").substring(0, 10));

				RepaySchedTmpList.add(repaySchedTmpBean);
			}
			map.put("RepaySchedTmpList", RepaySchedTmpList);
			System.out.println("INFO | DayFinishList的大小为："
					+ RepaySchedTmpList.size());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("INFO | DayFinish查询存储过程SQLException.......");
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
		Map<String, Object> map = (Map<String, Object>) new GetRepayTmpMessSP()
				.getMess("2080000033", "20111205076");
		   //  2080000033   20111205076
		List<?> list = (List<?>) map.get("RepaySchedTmpList");
		for (int i = 0; i < list.size(); i++) {
			
			System.out.println("INFO | getCOUNTER:"+((CL_RepaySchedTmpBean) list.get(i))
					.getCOUNTER());
			System.out.println("INFO | getLOAN_NO:"+((CL_RepaySchedTmpBean) list.get(i))
					.getLOAN_NO());
			System.out.println("INFO | getDD_NO:"+((CL_RepaySchedTmpBean) list.get(i))
					.getDD_NO());
			System.out.println("INFO | getSTART_DATE:"+((CL_RepaySchedTmpBean) list.get(i))
					.getSTART_DATE());
			System.out.println("INFO | getEND_DATE:"+((CL_RepaySchedTmpBean) list.get(i))
					.getEND_DATE());
			System.out.println("INFO | getINT_RATE:"+((CL_RepaySchedTmpBean) list.get(i))
					.getINT_RATE());
			System.out.println("INFO | getREPAY_AMT:"+((CL_RepaySchedTmpBean) list.get(i))
					.getREPAY_AMT());
			System.out.println("INFO | getINT_AMT:"+((CL_RepaySchedTmpBean) list.get(i))
					.getINT_AMT());
			System.out.println("INFO | getDD_AMT:"+((CL_RepaySchedTmpBean) list.get(i))
					.getDD_AMT());
			System.out.println("INFO | getDD_DATE:"+((CL_RepaySchedTmpBean) list.get(i))
					.getDD_DATE());
		}
	}
}
