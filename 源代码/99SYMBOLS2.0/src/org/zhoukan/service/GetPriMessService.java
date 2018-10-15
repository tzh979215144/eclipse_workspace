package org.zhoukan.service;


import java.util.Map;

import org.zhoukan.dao.GetPriRateMessSP;
import org.zhoukan.util.PraseXML;

public class GetPriMessService implements ServiceSYMBOLS {

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		Map<String, String> map = praseXML.getInMessageMap();
		String PRI_PLTY_BASIS=map.get("PRI_PLTY_BASIS");	
		Map<String,String> IntMess = new GetPriRateMessSP().getMess(PRI_PLTY_BASIS);
		praseXML.setOutMessage(IntMess);
		System.out.println("INFO | 处理XML:" + praseXML.getRootXml());
		return praseXML.getRootXml();
	}

}
