package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.zhoukan.util.ConnectionPool;

public class GetCurIntMessSP {
	// 调用存储过程获得界面的相关信息
	public Map<String, String> getMess(String BASE_ACCT_NO) {
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			cs = conn
					.prepareCall("{call SP_GET_CUEINTMESS(?,?)}");
			// 界面输入参数 贷款号
			cs.setString(1, BASE_ACCT_NO);
			// 开始注册开立表相关字段
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			map.put("CUR_INT", cs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("INFO | GetCurIntMessSP查询存储过程SQLException.......");
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
		Map<String, String> map = new GetCurIntMessSP().getMess("141020801033");
		// 利息
		System.out.println("INFO | 利息为："+map.get("CUR_INT"));


	}
}
