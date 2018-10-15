package org.zhoukan.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.CL_RECEIPT_TBLBean;
import org.zhoukan.bean.Cl_InvoiceBean;
import org.zhoukan.bean.Rb_tranBean;
import org.zhoukan.dao.ChangeTranDetlSP;
import org.zhoukan.dao.GetNOSP;
import org.zhoukan.dao.GetReceiptMessSP;
import org.zhoukan.dao.PaidInvoiceSP;
import org.zhoukan.dao.ReceiptSP;
import org.zhoukan.dao.TranDetlSP;
import org.zhoukan.util.MyDate;
import org.zhoukan.util.PraseXML;

public class ReceiptService implements ServiceSYMBOLS{

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		
		Rb_tranBean tranBean = new Rb_tranBean();
		
		CL_RECEIPT_TBLBean cReceiptTBLBean=new CL_RECEIPT_TBLBean();
		
		Cl_InvoiceBean cInvoiceBean=new Cl_InvoiceBean();
		
		Map<String, String> map1 = praseXML.getInMessageMap();
		
		Map<String, String> map2 = praseXML.getLOCAL_HEADMap();
		
		try {
			BeanUtils.populate(tranBean, map1);
			BeanUtils.populate(tranBean, map2);
			String seq = new GetNOSP().getNO("SEQ_NO");
			tranBean.setSEQ_NO(seq);
			tranBean.setINTERNAL_KEY(seq);
			String ref_no = new GetNOSP().getNO("reference");
			tranBean.setREFERENCE(ref_no);
			String trf_seq = praseXML.getLocalHeadTRAN_SEQText();
			tranBean.setTRF_SEQ_NO(trf_seq);
			tranBean.setTFR_INTERNAL_KEY(trf_seq);
			Map<String, String> map = praseXML.getInMessageMap();
			tranBean.setBT_OFFICER_ID(map.get("OPER_ID"));
			tranBean.setCCY("ZRM");
			String bank = praseXML.getLocalHeadBANK_IDText();
			tranBean.setBRANCH(bank);
			tranBean.setPROFIT_CENTER(bank);
			tranBean.setTIME_STAMP(MyDate.getTime());
			tranBean.setTRAN_TYPE(praseXML.getLocalHeadTRAN_CODEText());
			tranBean.setTRACE_ID(praseXML.getBodySVR_IDText());
			tranBean.setSOURCE_MODULE("RB");
			tranBean.setTRAN_DATE(MyDate.getTime());
			tranBean.setTRAN_DATE_TIME(MyDate.getTime());
			String mess = new TranDetlSP().saveStream(tranBean);
			//未完待续
			System.out.println(mess);
			System.out.println(praseXML.getRootXml());
			if(mess == null || "".equals(mess) || "no".equalsIgnoreCase(mess)){
				return null;
			}
			
			BeanUtils.populate(cReceiptTBLBean, map1);
			BeanUtils.populate(cReceiptTBLBean, map2);
			
			String rECEIPT_KEY = new GetNOSP().getNO("RECEIPT_KEY");
			cReceiptTBLBean.setRECEIPT_KEY(rECEIPT_KEY);
			String rECEIPT_NO= new GetNOSP().getNO("RECEIPT_NO");
			cReceiptTBLBean.setRECEIPT_NO(rECEIPT_NO);
			cReceiptTBLBean.setRECEIPT_DATE(MyDate.getTime());
			cReceiptTBLBean.setTRAN_DATE(MyDate.getTime());
			cReceiptTBLBean.setRECEIPT_AMT(map1.get("REPAY_AMT"));//添加还款金额

			//等待!~
			String re_mess = new ReceiptSP().save(cReceiptTBLBean);
			String cha_mess = new ChangeTranDetlSP().change(seq, re_mess);
			if(cha_mess == null || "".equals(cha_mess) || "no".equalsIgnoreCase(cha_mess)){
				return null;
			}
			//回收明细表中插值
			BeanUtils.populate(cInvoiceBean, map1);
			BeanUtils.populate(cInvoiceBean, map2);
			new PaidInvoiceSP().save(cInvoiceBean,cReceiptTBLBean);
			
			praseXML.setBodyMessage("RECEIPT_KEY", rECEIPT_KEY);
			praseXML.setLocalHeadREFERENCEText(ref_no);
			praseXML.setLocalHeadRE_CODEText(re_mess);
			praseXML.setLocalHeadTRAN_RESPONSE_DATEText(MyDate.getTime());
			praseXML.setLocalHeadTRAN_STATUSText("0");
			
			
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
