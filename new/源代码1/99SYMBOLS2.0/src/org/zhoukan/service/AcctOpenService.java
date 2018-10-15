/*
 * 作者：杨蒙
 */

package org.zhoukan.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.Fm_acctBean;
import org.zhoukan.bean.Rb_tranBean;
import org.zhoukan.dao.ChangeTranDetlSP;
import org.zhoukan.dao.GetNOSP;
import org.zhoukan.dao.OpenAcctSP;
import org.zhoukan.dao.TranDetlSP;
import org.zhoukan.util.MyDate;
import org.zhoukan.util.PraseXML;

public class AcctOpenService implements ServiceSYMBOLS{
	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		
		Rb_tranBean tranBean = new Rb_tranBean();
		
		Fm_acctBean acctBean = new Fm_acctBean();
		
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
			
			BeanUtils.populate(acctBean, map1);
			BeanUtils.populate(acctBean, map2);
			String internal_key = new GetNOSP().getNO("INTERNAL_KEY");
			acctBean.setINTERNAL_KEY(Integer.parseInt(internal_key));
			String base_acct_no=new GetNOSP().getNO("BASE_ACCT_NO");
			acctBean.setBRANCH(bank);
			acctBean.setPROFIT_CENTRE(bank);
			acctBean.setOPEN_TRAN_DATE(MyDate.getTime());
			acctBean.setACCT_DECS("新开账户");
			acctBean.setCERTIFICATE_NO("12345678");
			acctBean.setDEL_FLAG("N");
			acctBean.setLEDGER_BAL(0);
			acctBean.setACUAL_BAL(0);
			acctBean.setPREV_DAY_LEDGER_BAL(0);
			acctBean.setPREV_DAY_ACUAL_BAL(0);
			acctBean.setTOLERANCE_AMT(0);
			acctBean.setTOTAL_AUTH_OD(0);
			acctBean.setUSER_ID(map.get("OPER_ID"));
			acctBean.setTRAN_DATE(MyDate.getTime());
			acctBean.setTRAN_ALLOWED("Y");
			acctBean.setAGG_BAL(0);
			acctBean.setPREV_DAY_AGG_BAL(0);
			acctBean.setBASE_INTERNAL_KEY(internal_key);
			acctBean.setISLOCKED("N");
			acctBean.setBASE_ACCT_NO(base_acct_no);
			
			String re_mess = new OpenAcctSP().save(acctBean);
			String cha_mess = new ChangeTranDetlSP().change(seq, re_mess);
			if(cha_mess == null || "".equals(cha_mess) || "no".equalsIgnoreCase(cha_mess)){
				return null;
			}
			praseXML.setBodyMessage("BASE_ACCT_NO", base_acct_no);
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
