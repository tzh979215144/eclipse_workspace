package org.zhoukan.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.CL_AccrualsBean;
import org.zhoukan.bean.Cl_drawDrowBean;
import org.zhoukan.bean.Rb_tranBean;
import org.zhoukan.dao.AccrualsSP;
import org.zhoukan.dao.ChangeTranDetlSP;
import org.zhoukan.dao.GetNOSP;
import org.zhoukan.dao.TranDetlSP;
import org.zhoukan.util.MyDate;
import org.zhoukan.util.PraseXML;

public class AccrualsService implements ServiceSYMBOLS{
	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		
		Rb_tranBean tranBean = new Rb_tranBean();//流水Bean
		Cl_drawDrowBean drawdrowbean = new Cl_drawDrowBean();//贷款发放表bean
		CL_AccrualsBean cL_AccrualsBean = new CL_AccrualsBean();//账户开户Bean
		
		/**************************************************************/
		
		Map<String, String> map1 = praseXML.getInMessageMap();
		
		Map<String, String> map2 = praseXML.getLOCAL_HEADMap();
		
		try {
			BeanUtils.populate(tranBean, map1);
			BeanUtils.populate(tranBean, map2);
			String seq = new GetNOSP().getNO("SEQ_NO");//获得流水号
			tranBean.setSEQ_NO(seq);
			tranBean.setINTERNAL_KEY(seq);
			String ref_no = new GetNOSP().getNO("reference");//设置参考号
			tranBean.setREFERENCE(ref_no);
			String trf_seq = praseXML.getLocalHeadTRAN_SEQText();
			tranBean.setTRF_SEQ_NO(trf_seq);
			tranBean.setTFR_INTERNAL_KEY(trf_seq);
			Map<String, String> map = praseXML.getInMessageMap();
			tranBean.setBT_OFFICER_ID(map.get("OPER_ID"));//柜员号
			tranBean.setCCY("ZRM");
			String bank = praseXML.getLocalHeadBANK_IDText();//银行？？
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
			
			////////////////////////////////////////////////////////////////////
			
			System.out.println(mess);
			System.out.println(praseXML.getRootXml());
			if(mess == null || "".equals(mess) || "no".equalsIgnoreCase(mess)){
				return null;
			}
			BeanUtils.populate(cL_AccrualsBean, map1);
			BeanUtils.populate(cL_AccrualsBean, map2);
			
			BeanUtils.populate(drawdrowbean, map1);
			BeanUtils.populate(drawdrowbean, map2);
			
			//String internal_key = new GetNOSP().getNO("INTERNAL_KEY");//获得账户主键
			//cL_AccrualsBean.setLOAN_NO(Integer.parseInt(internal_key));
			//cL_AccrualsBean.setACC_INT(internal_key);
			
			//cL_AccrualsBean.setLOAN_NO("LOAN_NO");
			
			//String base_acct_no = new GetNOSP().getNO("BASE_ACCT_NO");//获得主账户账号
			
			
			String re_mess = new AccrualsSP().update(cL_AccrualsBean,drawdrowbean);//调用计提调整存储过程
			
			String cha_mess = new ChangeTranDetlSP().change(seq, re_mess);
			if(cha_mess == null || "".equals(cha_mess) || "no".equalsIgnoreCase(cha_mess)){
				return null;
			}
			//praseXML.setBodyMessage("INTERNAL_KEY", internal_key);
			//praseXML.setBodyMessage("BASE_ACCT_NO", base_acct_no);
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

