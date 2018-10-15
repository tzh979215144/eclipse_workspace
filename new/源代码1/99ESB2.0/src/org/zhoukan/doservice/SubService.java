package org.zhoukan.doservice;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.StreamBean;
import org.zhoukan.dao.GetNOSP;
import org.zhoukan.dao.StreamSP;
import org.zhoukan.util.PraseXML;

public class SubService implements ServiceESB{
	
	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		
		String teller_SQE = praseXML.getLocalHeadTRAN_SEQText();
		
		String esb_SQE = new GetNOSP().getNO("esb_tran_no");
		
		praseXML.setLocalHeadTRAN_SEQText(esb_SQE);
		
		praseXML.setLocalHeadFRONT_SEQText(teller_SQE);
		
		StreamBean streamBean = new StreamBean();
		
		Map<String, String> map = praseXML.getLOCAL_HEADMap();
		
		try {
			BeanUtils.populate(streamBean, map);
			//streamBean.setFRONT_SEQ(teller_SQE);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String mess = new StreamSP().setStream(streamBean);
		
		if(mess.equalsIgnoreCase("ok")){
			return praseXML.getRootXml();
		}
		
		return null;
	}

}
