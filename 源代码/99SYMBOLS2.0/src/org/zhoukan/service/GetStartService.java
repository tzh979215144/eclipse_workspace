package org.zhoukan.service;

import org.zhoukan.dao.StartSP;
import org.zhoukan.util.PraseXML;

public class GetStartService implements ServiceSYMBOLS{

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		
		System.out.println("INFO | 收到XML:" + praseXML.getRootXml());
		new StartSP().go();
		return praseXML.getRootXml();
	}

}

