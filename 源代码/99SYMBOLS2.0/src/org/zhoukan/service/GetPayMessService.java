package org.zhoukan.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.zhoukan.util.ConnectionPool;
import org.zhoukan.util.PraseXML;

public class GetPayMessService implements ServiceSYMBOLS{

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		Map<String, String> map = praseXML.getInMessageMap();
		String loanNo=map.get("LOAN_NO");
		
		String ddNo=map.get("DD_NO");
		//System.out.println(loanNo+"哈哈"+ddNo);
		String client=" ";
		String lender=" ";
		String loanManager=" ";
		String loanType=" ";
		String loanSubType=" ";
		String acctExec=" ";
		String ccy=" ";
		int ddAmt=0;
		double intRate=0;
		int loanAmt=0;
		int drawnAmt=0;
		String acctNo=" ";
		Connection conn = ConnectionPool.getOneConn();
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall("{call SP_GET_PAY_INFO(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1,loanNo);
			cs.setString(2,ddNo);
			cs.registerOutParameter(3,oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(4,oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(5,oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(6,oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(7,oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(8,oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(9,oracle.jdbc.OracleTypes.VARCHAR);
			cs.registerOutParameter(10,oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(11,oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(12,oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(13,oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(14,oracle.jdbc.OracleTypes.VARCHAR);
			cs.execute();
			client=cs.getString(3);
			lender=cs.getString(4);
			loanManager=" ";
			loanType=cs.getString(6);
			loanSubType=cs.getString(7);
			acctExec=" ";
			ccy=cs.getString(9);
			ddAmt=cs.getInt(10);
			intRate=cs.getDouble(11);
			loanAmt=cs.getInt(12);
			drawnAmt=cs.getInt(13);
			acctNo=cs.getString(14);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		praseXML.setBodyMessage("CLIENT",client);
		
		//praseXML.setBodyMessage("LENDER",lender);
		
		praseXML.setBodyMessage("LOAN_MANAGER", loanManager);
		
		praseXML.setBodyMessage("LOAN_TYPE", loanType);
	
		praseXML.setBodyMessage("LOAN_SUB_TYPE", loanSubType);
	
		praseXML.setBodyMessage("ACCT_EXEC", acctExec);
		
		praseXML.setBodyMessage("CCY", ccy);
		
		praseXML.setBodyMessage("DD_AMT", ddAmt+"");
		
		praseXML.setBodyMessage("INT_RATE", intRate+"");
		praseXML.setBodyMessage("LOAN_AMT", loanAmt+"");
		praseXML.setBodyMessage("DRAWN_AMT", drawnAmt+"");
	
		return praseXML.getRootXml();
	}

}
