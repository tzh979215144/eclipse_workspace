package org.zhoukan.service;

import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.zhoukan.bean.Cl_DayFinishiBean;
import org.zhoukan.dao.LoadingSP;
import org.zhoukan.util.PraseXML;

public class LoadingDayFinishService implements ServiceSYMBOLS{

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		
		System.out.println("INFO | 收到XML:" + praseXML.getRootXml());
		
		
		Map<String, Object> map2 = new LoadingSP().load();
		
		if (!map2.containsKey("err")) {
			@SuppressWarnings("unchecked")
			List<Cl_DayFinishiBean> DayFinishList = (List<Cl_DayFinishiBean>) map2.get("Day_finish");
			map2.remove("Day_finish");
			String Day_finish = "<Day_finishSched>";
			if (DayFinishList != null)
				for (int i = 0; i < DayFinishList.size(); i++) {
					Cl_DayFinishiBean Bean1 = DayFinishList.get(i);
					Day_finish += "<Day_finish>";
					
					Day_finish += "<PROCESS_SEQ_NO>"
						+ Bean1.getPROCESS_SEQ_NO()
						+ "</PROCESS_SEQ_NO>";
					
					Day_finish += "<START_TIME>"
							+ Bean1.getSTART_TIME()
							+ "</START_TIME>";
					
					Day_finish += "<END_TIME>"
						+ Bean1.getSTART_TIME()
						+ "</END_TIME>";
					
					Day_finish += "<RESULT>"
							+ Bean1.getRESULT()
							+ "</RESULT>";
					
					Day_finish += "<PROCESS_NAME>"
						+ Bean1.getPROCESS_NAME()
						+ "</PROCESS_NAME>";
	
					Day_finish += "</Day_finish>";
				}
			Day_finish += "</Day_finishSched>";
			PraseXML praseXMLInvoice = new PraseXML(Day_finish);
			Element XMLInvoice = praseXMLInvoice.getRootElement();
			praseXML.setOutMessage(XMLInvoice);
			praseXML.setOutMessage(map2);
			System.out.println("INFO | 处理XML:" + praseXML.getRootXml());
			return praseXML.getRootXml();
		}
		return praseXML.getRootXml();
	}

}

