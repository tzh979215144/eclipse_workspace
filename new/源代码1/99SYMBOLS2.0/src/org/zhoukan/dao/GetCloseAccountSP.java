package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.zhoukan.util.ConnectionPool;

public class GetCloseAccountSP {
	// 调用存储过程获得界面的相关信息
	public Map<String, String> getMess(String BASE_ACCT_NO) {
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			cs = conn.prepareCall("{call SP_GET_CloseAccMESS(?,?,?,?)}");
			// 界面输入参数 账号
			cs.setString(1, BASE_ACCT_NO);
			// 开始注册账户开户表相关字段
			//身份证号
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			//账户姓名
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
			//账户余额
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			
			cs.execute();
			// 开立表的信息
			map.put("GLOBAL_ID", cs.getString(2));
			map.put("CLIENT_SHORT", cs.getString(3));
			map.put("LEDGER_BAL", cs.getString(4));

			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("INFO | CloseAccount查询存储过程SQLException.......");
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
		Map<String, String> map = new GetCloseAccountSP().getMess("141020801033");
		//账户姓名
		System.out.println("INFO | CLIENT_SHORT:"+map.get("CLIENT_SHORT"));
		//账户身份证号
		System.out.println("INFO | GLOBAL_ID:"+map.get("GLOBAL_ID"));
		//账户余额
		System.out.println("INFO | LEDGER_BAL:"+map.get("LEDGER_BAL"));
	}
}
