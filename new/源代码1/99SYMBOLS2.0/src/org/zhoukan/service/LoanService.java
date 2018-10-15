package org.zhoukan.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.CL_LOANBean;
import org.zhoukan.bean.Rb_tranBean;
import org.zhoukan.dao.ChangeTranDetlSP;
import org.zhoukan.dao.GetNOSP;
import org.zhoukan.dao.TranDetlSP;
import org.zhoukan.util.MyDate;
import org.zhoukan.util.PraseXML;
import org.zhoukan.dao.LoanSP;

public class LoanService implements ServiceSYMBOLS{

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		
		Rb_tranBean tranBean = new Rb_tranBean();
		
		CL_LOANBean cloanBean = new CL_LOANBean();
		
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
			
			BeanUtils.populate(cloanBean, map1);
			BeanUtils.populate(cloanBean, map2);
			//cloanBean.setCL_CLIENT("Y");
			String cloan_no = new GetNOSP().getNO("LOAN_NO");
			cloanBean.setLOAN_NO(cloan_no);
			cloanBean.setHUNTING_STATUS("Y");
			cloanBean.setPRI_BILLING_DAYS(5);
			cloanBean.setMAX_INT_RATE(0);
			cloanBean.setMIN_INT_RATE(0);
			cloanBean.setOUTSTANDING(0);
			cloanBean.setORIG_LOAN_AMT(0);
			cloanBean.setLOAN_KEY(Integer.parseInt(new GetNOSP().getNO("LOAN_KEY")));
			cloanBean.setREVOLVE_YN("N");
			cloanBean.setORIG_BOOK_BRANCH("NONE");
			cloanBean.setLOAN_MANAGER("温家宝");
			cloanBean.setBORROWER_TYPE("个人");
			cloanBean.setORIG_BORRPWER("nobody");
			cloanBean.setSTATUS("Y");
			cloanBean.setBY_ACCT_59(map1.get("BY_ACCT_NO"));
			cloanBean.setINTERNAL_KEY(new GetNOSP().getNO("INTERNAL_KEY2"));
			

			String re_mess = new LoanSP().save(cloanBean);
			String cha_mess = new ChangeTranDetlSP().change(seq, re_mess);
			if(cha_mess == null || "".equals(cha_mess) || "no".equalsIgnoreCase(cha_mess)){
				return null;
			}
			praseXML.setBodyMessage("LOAN_NO", cloan_no);
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
