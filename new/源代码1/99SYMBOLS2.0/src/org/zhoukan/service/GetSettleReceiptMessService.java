package org.zhoukan.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.Cl_InvoiceBean;
import org.zhoukan.bean.SettleRecBean;
import org.zhoukan.dao.GetReceiptMessSP;
import org.zhoukan.dao.GetSettleRecSP;
import org.zhoukan.util.PraseXML;

public class GetSettleReceiptMessService implements ServiceSYMBOLS{
	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		
		SettleRecBean settleRecBean=new SettleRecBean();		
		
		Map<String, String> map1 = praseXML.getInMessageMap();
		
		Map<String, String> map2 = praseXML.getLOCAL_HEADMap();
		
		try {
			BeanUtils.populate(settleRecBean, map1);
			BeanUtils.populate(settleRecBean, map2);
		
			Map<String,String> receiptMess = new GetSettleRecSP().getMess(settleRecBean);		
			BeanUtils.populate(settleRecBean, receiptMess);
			
			praseXML.setOutMessage(receiptMess);			
			
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
