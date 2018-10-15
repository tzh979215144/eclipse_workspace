/*
 * 作者：杨蒙
 */

package org.zhoukan.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.Rb_tranBean;
import org.zhoukan.bean.RepayBean;
import org.zhoukan.dao.ChangeTranDetlSP;
import org.zhoukan.dao.GetNOSP;
import org.zhoukan.dao.RepaySP;
import org.zhoukan.dao.TranDetlSP;
import org.zhoukan.util.MyDate;
import org.zhoukan.util.PraseXML;

public class RepayService implements ServiceSYMBOLS{
	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		
		Rb_tranBean tranBean = new Rb_tranBean();
		
		RepayBean repayBean = new RepayBean();
		
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
			
			BeanUtils.populate(repayBean, map1);
			BeanUtils.populate(repayBean, map2);
			
			//添加值
			
			//String re_mess1 = new Repay_SearchSP().save(repayBean);
			String re_mess = new RepaySP().save(repayBean);
			String cha_mess = new ChangeTranDetlSP().change(seq, re_mess);
			if(cha_mess == null || "".equals(cha_mess) || "no".equalsIgnoreCase(cha_mess)){
				return null;
			}
		//	praseXML.setBodyMessage("BASE_ACCT_NO", base_acct_no);
//			praseXML.setBodyMessage("DD_KEY", repayBean.getDD_KEY());
//			praseXML.setBodyMessage("CCY", repayBean.getCCY());
//			praseXML.setBodyMessage("DD_DATE", repayBean.getDD_DATE());
//			praseXML.setBodyMessage("INT_RATE", repayBean.getINT_RATE());
//			praseXML.setBodyMessage("DD_AMT", repayBean.getDD_AMT());
			praseXML.setLocalHeadREFERENCEText(ref_no);
			praseXML.setLocalHeadRE_CODEText(re_mess);
			//praseXML.setLocalHeadRE_CODEText(re_mess2);
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
