package org.zhoukan.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.CL_LOANBean;
import org.zhoukan.bean.Cl_InvoiceBean;
import org.zhoukan.bean.Cl_drawDrowBean;
import org.zhoukan.bean.Rb_tranBean;
import org.zhoukan.dao.ChangeTranDetlSP;
import org.zhoukan.dao.GetNOSP;
import org.zhoukan.dao.InvoiceSP;
import org.zhoukan.dao.TranDetlSP;
import org.zhoukan.util.MyDate;
import org.zhoukan.util.PraseXML;

public class InvoiceService implements ServiceSYMBOLS{

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		
		Rb_tranBean tranBean = new Rb_tranBean();
		
		Cl_InvoiceBean invoiceBean = new Cl_InvoiceBean();
		
		CL_LOANBean loanBean = new CL_LOANBean();
		
		Cl_drawDrowBean drawDrowBean = new Cl_drawDrowBean();
		
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
			tranBean.setCCY(map.get("CCY"));
			String bank = praseXML.getLocalHeadBANK_IDText();
			tranBean.setBRANCH(bank);
			tranBean.setPROFIT_CENTER(bank);
			tranBean.setTIME_STAMP(MyDate.getTime());
			tranBean.setTRAN_TYPE(praseXML.getLocalHeadTRAN_CODEText());
			tranBean.setTRACE_ID(praseXML.getBodySVR_IDText());
			tranBean.setSOURCE_MODULE("CL");
			tranBean.setTRAN_DATE(MyDate.getTime());
			tranBean.setTRAN_DATE_TIME(MyDate.getTime());
			String mess = new TranDetlSP().saveStream(tranBean);
			//未完待续
			System.out.println(mess);
			System.out.println(praseXML.getRootXml());
			if(mess == null || "".equals(mess) || "no".equalsIgnoreCase(mess)){
				return null;
			}
			
			BeanUtils.populate(invoiceBean, map1);
			BeanUtils.populate(invoiceBean, map2);
			BeanUtils.populate(loanBean, map1);
			BeanUtils.populate(drawDrowBean, map1);
			String internal_key = new GetNOSP().getNO("INTERNAL_KEY3");
			invoiceBean.setINTERNAL_KEY(Integer.parseInt(internal_key));
			String debit_note_no =new GetNOSP().getNO("DEBIT_NOTE_NO");
			invoiceBean.setDEBIT_NOTE_NO(Integer.parseInt(debit_note_no));
			String invoice_tran_noo =new GetNOSP().getNO("INVOICE_TRAN_NOO");
			invoiceBean.setINVOICE_TRAN_NOO(invoice_tran_noo);
			//invoiceBean.setFULLY_SETTLED("N");
			//invoiceBean.setADVICE_SENT("N");
			//invoiceBean.setGL_POSTED("N");
			//invoiceBean.setUSER_ID(map2.get("OPER_ID"));
			//invoiceBean.setLAST_CHANGE_DATE(MyDate.getDate());
			
			
			String re_mess = new InvoiceSP().save(invoiceBean,loanBean,drawDrowBean);
			String cha_mess = new ChangeTranDetlSP().change(seq, re_mess);
			if(cha_mess == null || "".equals(cha_mess) || "no".equalsIgnoreCase(cha_mess)){
				return null;
			}
			praseXML.setBodyMessage("DEBIT_NOTE_NO", debit_note_no);
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
