package org.zhoukan.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.CL_AccrualsBean;
import org.zhoukan.bean.CL_LOANBean;
import org.zhoukan.bean.Cl_drawDrowBean;
import org.zhoukan.dao.GetAccrualsMessSP;
import org.zhoukan.util.MyDate;
import org.zhoukan.util.PraseXML;

public class GetAccrualsService implements ServiceSYMBOLS{
	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		
		CL_AccrualsBean cL_AccrualsBean = new CL_AccrualsBean();
		CL_LOANBean cL_LOANBean = new CL_LOANBean();//贷款开立Bean
		Cl_drawDrowBean l_drawDrowBean = new Cl_drawDrowBean();//贷款发放Bean
		
		/**************************************************************/
		
		Map<String, String> map1 = praseXML.getOutMessageMap();
		Map<String, String> mao = praseXML.getLOCAL_HEADMap();

		Map<String, String> map4;
		
		try {
			BeanUtils.populate(cL_LOANBean, map1);
			BeanUtils.populate(cL_LOANBean, mao);
			
			BeanUtils.populate(l_drawDrowBean, map1);
			BeanUtils.populate(l_drawDrowBean, mao);
			
			BeanUtils.populate(cL_AccrualsBean, map1);
			BeanUtils.populate(cL_AccrualsBean, mao);
			
			String LOAN_NO;
			String DD_NO;
			
			LOAN_NO = cL_AccrualsBean.getLOAN_NO();
			DD_NO = l_drawDrowBean.getDD_NO();
			
			//System.out.println(LOAN_NO+"_____________"+DD_NO);
			
			map4 = new GetAccrualsMessSP().getMess(LOAN_NO, DD_NO);//调用存储过程
			//System.out.println("_____");
			
			System.out.println("哈"+map4);
			praseXML.setOutMessage(map4);
			
			
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

