package org.zhoukan.service;

import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.zhoukan.bean.Cl_InvoiceBean;
import org.zhoukan.dao.GetInvoiceSP;
import org.zhoukan.util.PraseXML;

public class GetInvoiceService implements ServiceSYMBOLS{

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		
		System.out.println("INFO | 收到XML:" + praseXML.getRootXml());
		
		Map<String, String> map = praseXML.getInMessageMap();
		
		String LOAN_NO = map.get("LOAN_NO5"); 
		
		String DD_NO = map.get("DD_NO5");
		
		System.out.println("INFO | 输入的NO:" + LOAN_NO);
		
		System.out.println("INFO | 输入的NO:" + DD_NO);
		
		Map<String, Object> map2 = new GetInvoiceSP().getInvoice(LOAN_NO,DD_NO);
		
		if (!map2.containsKey("err")) {
			@SuppressWarnings("unchecked")
			List<Cl_InvoiceBean> InvoiceList = (List<Cl_InvoiceBean>) map2.get("invoice");
			map2.remove("invoice");
			String Invoice = "<InvoiceSched>";
			if (InvoiceList != null)
				for (int i = 0; i < InvoiceList.size(); i++) {
					Cl_InvoiceBean invoice = InvoiceList.get(i);
					Invoice += "<Invoice>";
					
					Invoice += "<DEBIT_NOTE_NO>"
						+ String.valueOf(invoice.getDEBIT_NOTE_NO())
						+ "</DEBIT_NOTE_NO>";
					
					Invoice += "<INVOICE_TYPE>"
							+ invoice.getINVOICE_TYPE()
							+ "</INVOICE_TYPE>";
					
					Invoice += "<INT_FROM>"
							+ invoice.getINT_FROM()
							+ "</INT_FROM>";
					
					Invoice += "<DUE_DATE>"
						+ invoice.getDUE_DATE()
						+ "</DUE_DATE>";
					
					Invoice += "<INT_RATE>"
						+ String.valueOf(invoice.getINT_RATE())
						+ "</INT_RATE>";
					
					Invoice += "<CCY>"
						+ invoice.getCCY()
						+ "</CCY>";
					
					Invoice += "<BILLED_AMT>"
						+ String.valueOf(invoice.getBILLED_AMT())
						+ "</BILLED_AMT>";
					Invoice += "</Invoice>";
				}
			Invoice += "</InvoiceSched>";
			PraseXML praseXMLInvoice = new PraseXML(Invoice);
			Element XMLInvoice = praseXMLInvoice.getRootElement();
			praseXML.setOutMessage(XMLInvoice);
			praseXML.setOutMessage(map2);
			System.out.println("INFO | 处理XML:" + praseXML.getRootXml());
			return praseXML.getRootXml();
		}
		return praseXML.getRootXml();
	}

}

