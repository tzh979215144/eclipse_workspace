package org.zhoukan.service;


import java.util.Map;
import org.zhoukan.dao.GetLoanMessSP;
import org.zhoukan.util.PraseXML;

public class GetLoanMessService implements ServiceSYMBOLS {

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		Map<String, String> map = praseXML.getInMessageMap();
		String loan_no=map.get("LOAN_NO");	
		Map<String,String> loanMess = new GetLoanMessSP().getMess(loan_no);
		praseXML.setOutMessage(loanMess);
		System.out.println("INFO | 处理XML:" + praseXML.getRootXml());
		return praseXML.getRootXml();
	}

}

