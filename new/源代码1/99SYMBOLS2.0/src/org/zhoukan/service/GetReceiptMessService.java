package org.zhoukan.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.CL_RECEIPT_TBLBean;
import org.zhoukan.bean.Cl_InvoiceBean;
import org.zhoukan.bean.ReceiptBean;
import org.zhoukan.bean.SettleRecBean;
import org.zhoukan.dao.GetReceiptMessSP;
import org.zhoukan.dao.GetSettleRecSP;
import org.zhoukan.util.PraseXML;

public class GetReceiptMessService implements ServiceSYMBOLS {

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		
		CL_RECEIPT_TBLBean receiptBean=new CL_RECEIPT_TBLBean();		
		
		Map<String, String> map1 = praseXML.getInMessageMap();
		
		Map<String, String> map2 = praseXML.getLOCAL_HEADMap();
		
		try {
			BeanUtils.populate(receiptBean, map1);
			BeanUtils.populate(receiptBean, map2);
			System.out.println(receiptBean.getDEBIT_NOTE_NO());
			Map<String,String> receiptMess = new GetReceiptMessSP().getMessById(receiptBean.getDEBIT_NOTE_NO());		
			BeanUtils.populate(receiptBean, receiptMess);
			
			System.out.println("哈哈"+receiptMess);
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
