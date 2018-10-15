package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.zhoukan.util.ConnectionPool;

public class GetCheckBalMessSP {
	// 调用存储过程获得界面的相关信息
	public Map<String, String> getMess(String BASE_ACCT_NO) {
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			cs = conn.prepareCall("{call SP_GET_CHECKBALMESS(?,?,?,?,?,?)}");
			// 界面输入参数 账号
			cs.setString(1, BASE_ACCT_NO);
			// 开始注册账户开户表相关字段
			//账户姓名
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			//账户币种
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
			//账户余额
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			//账户类型
			cs.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
			//账户开户时间
			cs.registerOutParameter(6, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			// 开立表的信息
			map.put("CLIENT_SHORT", cs.getString(2));
			map.put("CCY", cs.getString(3));
			map.put("LEDGER_BAL", cs.getString(4));
			map.put("ACCT_TYPE", cs.getString(5));
			map.put("ACCT_OPEN_DATE", cs.getString(6));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("INFO | CheckBalance查询存储过程SQLException.......");
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
		Map<String, String> map = new GetCheckBalMessSP().getMess("141020801033");
		//账户姓名
		System.out.println(map.get("CLIENT_SHORT"));
		//账户币种
		System.out.println(map.get("CCY"));
		//账户余额
		System.out.println(map.get("LEDGER_BAL"));
		//余额类型
		System.out.println(map.get("ACCT_TYPE"));
		//账户开户时间
		System.out.println(map.get("ACCT_OPEN_DATE"));

	}
}
