package org.zhoukan.service;


import java.util.Map;

import org.zhoukan.dao.GetPltyRateMessSP;
import org.zhoukan.util.PraseXML;

public class GetPltyMessService implements ServiceSYMBOLS {

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		Map<String, String> map = praseXML.getInMessageMap();
		String INT_PLTY_BASIS=map.get("INT_PLTY_BASIS");	
		Map<String,String> IntMess = new GetPltyRateMessSP().getMess(INT_PLTY_BASIS);
		praseXML.setOutMessage(IntMess);
		System.out.println("INFO | 处理XML:" + praseXML.getRootXml());
		return praseXML.getRootXml();
	}

}
