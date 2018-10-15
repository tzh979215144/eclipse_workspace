package org.zhoukan.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.Fm_clientBean;
import org.zhoukan.dao.FindClientMessSP;
import org.zhoukan.util.PraseXML;

public class GetClientMessService implements ServiceSYMBOLS {

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
				
		Fm_clientBean clientBean = new Fm_clientBean();
		
		Map<String, String> map1 = praseXML.getInMessageMap();
		
		Map<String, String> map2 = praseXML.getLOCAL_HEADMap();
		
		try {
			BeanUtils.populate(clientBean, map1);
			BeanUtils.populate(clientBean, map2);
		
			

			Map<String,String> clientMess = new FindClientMessSP().findById(clientBean.getCLIENT_NO());
			
			BeanUtils.populate(clientBean, clientMess);
			praseXML.setOutMessage(clientMess);			
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return praseXML.getRootXml();
	}

}
