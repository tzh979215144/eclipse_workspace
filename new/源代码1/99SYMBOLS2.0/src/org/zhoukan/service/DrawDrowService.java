/*
 * 作者：杨蒙
 */

package org.zhoukan.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.Cl_drawDrowBean;
import org.zhoukan.bean.Rb_tranBean;
import org.zhoukan.dao.ChangeTranDetlSP;
import org.zhoukan.dao.DrawDrowSP;
import org.zhoukan.dao.GetNOSP;
import org.zhoukan.dao.TranDetlSP;
import org.zhoukan.util.MyDate;
import org.zhoukan.util.PraseXML;

public class DrawDrowService implements ServiceSYMBOLS{
	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		
		Rb_tranBean tranBean = new Rb_tranBean();
		
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
			tranBean.setCCY(map.get("CCY"));//-------------------
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
			
			BeanUtils.populate(drawDrowBean, map1);
			BeanUtils.populate(drawDrowBean, map2);
			String dd_key = new GetNOSP().getNO("DD_KEY");
			drawDrowBean.setDD_KEY(Integer.parseInt(dd_key));
			drawDrowBean.setTRAN_DATE(MyDate.getTime());
			drawDrowBean.setUSER_ID(map.get("OPER_ID"));
			String dd_no = new GetNOSP().getNO("DD_NO");
			drawDrowBean.setDD_NO(dd_no);
			
			System.out.println("--------------");
			String re_mess = new DrawDrowSP().save(drawDrowBean);
			String cha_mess = new ChangeTranDetlSP().change(seq, re_mess);
			if(cha_mess == null || "".equals(cha_mess) || "no".equalsIgnoreCase(cha_mess)){
				return null;
			}
			praseXML.setBodyMessage("DD_NO", dd_no);
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
