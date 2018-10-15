package org.zhoukan.service;

import java.util.Map;

import org.zhoukan.dao.GetRepMessSP;
import org.zhoukan.util.PraseXML;

public class GetRepMessService implements ServiceSYMBOLS {

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		Map<String, String> map = praseXML.getInMessageMap();
		String dd_no=map.get("FaFang");	
		Map<String,String> IntMess = new GetRepMessSP().getMess(dd_no);
		praseXML.setOutMessage(IntMess);
		System.out.println("INFO | 处理XML:" + praseXML.getRootXml());
		return praseXML.getRootXml();
	}

}
