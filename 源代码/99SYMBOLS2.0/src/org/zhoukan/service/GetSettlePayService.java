package org.zhoukan.service;

import java.util.Map;
import org.zhoukan.dao.GetSettlePayMessSP;
import org.zhoukan.util.PraseXML;

public class GetSettlePayService implements ServiceSYMBOLS {

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		Map<String, String> map = praseXML.getInMessageMap();
		String loan_no=map.get("LOAN_NO2");
		String dd_no=map.get("DD_NO");
		Map<String,String> spMess = new GetSettlePayMessSP().findByDDNoAndLoan(loan_no,dd_no);
		praseXML.setOutMessage(spMess);
		System.out.println("INFO | 处理XML:" + praseXML.getRootXml());
		return praseXML.getRootXml();
	}

}
