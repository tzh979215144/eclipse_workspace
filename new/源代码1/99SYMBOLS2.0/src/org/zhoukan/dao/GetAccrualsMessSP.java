package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.zhoukan.util.ConnectionPool;

//根据贷款号和发放号运用Ajax来查询相关信息
public class GetAccrualsMessSP {
	// 调用存储过程获得界面的相关信息
	public Map<String, String> getMess(String Loan_no, String DD_no) {
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			cs = conn
					.prepareCall("{call SP_GET_ACCRUALSMESS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 界面输入参数 贷款号
			cs.setString(1, Loan_no);
			// 界面输入参数 发放号
			cs.setString(2, DD_no);
			// 开始注册开立表相关字段
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(6, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(7, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(8, oracle.jdbc.OracleTypes.VARCHAR);
			// 开始注册计提表相关字段
			cs.registerOutParameter(9, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(10, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(11, oracle.jdbc.OracleTypes.VARCHAR);
			
			cs.registerOutParameter(18, oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(19, oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(20, oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(21, oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(22, oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(23, oracle.jdbc.OracleTypes.NUMBER);
			// 开始注册发放表相关字段
			cs.registerOutParameter(12, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(13, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(14, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(15, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(16, oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(17, oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			// 开立表的信息
			map.put("LENDER", cs.getString(3));
			map.put("STATUS", cs.getString(4));
			map.put("ORIG_LOAN_AMT", cs.getString(5));
			map.put("LOAN_TYPE", cs.getString(6));
			map.put("LOAN_SUB_TYPE", cs.getString(7));
			map.put("BOOK_BRANCH", cs.getString(8));
			// 计提表的信息
			map.put("INTEREST_AMT", cs.getString(9));
			map.put("PENALTY_AMT_PRI", cs.getString(10));
			map.put("PENALTY_AMT_INT", cs.getString(11));
			// 发放表的信息...
			map.put("DD_AMT", cs.getString(12));
			map.put("DD_DATE",cs.getString(13));
			map.put("INT_OUTSTANDING", cs.getString(14));
			map.put("DOP_OUTSTANDING", cs.getString(15));
			map.put("ODI_OUTSTANDING", cs.getString(16));
			//贷款开立表的合同金额
			//map.put("TEST", cs.getString(17));
			map.put("NOT_FOND", " "+(Integer.valueOf(cs.getString(5))-Integer.valueOf(cs.getString(12))));
			//计提表中利率相关信息
			map.put("INT_RATE", Float.toString(cs.getFloat(18)));
			map.put("INT_BASISRATE",Float.toString(cs.getFloat(19)));
			map.put("PRI_PLTI_RATE", Float.toString(cs.getFloat(20)));
			map.put("PRI_PLTY_ABS", Float.toString(cs.getFloat(21)));
			map.put("INT_PITY_RATE", Float.toString(cs.getFloat(22)));
			map.put("INT_PITY_ABS", Float.toString(cs.getFloat(23)));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("INFO | Accruals查询存储过程SQLException.......");
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
		Map<String, String> map = new GetAccrualsMessSP().getMess("2080000026",
				"20111205070");
		// 借款人
		System.out.println(map.get("BORROWER"));
		// 贷款状态
		System.out.println(map.get("STATUS"));
		// 合同金额
		System.out.println(map.get("ORIG_LOAN_AMT"));
		// 贷款类型
		System.out.println(map.get("LOAN_TYPE"));
		// 贷款子类型
		System.out.println(map.get("LOAN_SUB_TYPE"));
		// 贷款经办机构
		System.out.println(map.get("BOOK_BRANCH"));
		// 应计利息
		System.out.println(map.get("INTEREST_AMT"));
		// 应计罚息
		System.out.println(map.get("PENALTY_AMT_PRI"));
		// 应计复利
		System.out.println(map.get("PENALTY_AMT_INT"));
		// 发放金额
		System.out.println(map.get("DD_AMT"));
		// 发放日期
		System.out.println(map.get("DD_DATE"));
		// 应收利息
		System.out.println(map.get("INT_OUTSTANDING"));
		// 应收罚息
		System.out.println(map.get("DOP_OUTSTANDING"));
		// 应收复利
		System.out.println(map.get("ODI_OUTSTANDING"));
		//未发放金额
		System.out.println(map.get("NOT_FOND"));
	}
}
