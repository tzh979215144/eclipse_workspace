package org.zhoukan.service;

import java.util.Map;

import org.zhoukan.dao.GetIntRateMessSP;
import org.zhoukan.util.PraseXML;

public class GetIntRateMessService implements ServiceSYMBOLS {

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		Map<String, String> map = praseXML.getInMessageMap();
		String INT_BASIS=map.get("INT_BASIS");	
		Map<String,String> IntMess = new GetIntRateMessSP().getMess(INT_BASIS);
		praseXML.setOutMessage(IntMess);
		System.out.println("INFO | 处理XML:" + praseXML.getRootXml());
		return praseXML.getRootXml();
	}

}
