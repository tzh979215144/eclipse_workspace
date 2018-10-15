package org.zhoukan.service;


import java.util.Map;
import org.zhoukan.dao.GetFrontInvoiceSP;
import org.zhoukan.util.PraseXML;

public class GetFrontInvoiceService implements ServiceSYMBOLS {

	@Override
	public String doSth(String xml) {
		// TODO Auto-generated method stub
		
		PraseXML praseXML = new PraseXML(xml);
		Map<String, String> map = praseXML.getInMessageMap();
		String loan_no=map.get("LOAN_NO51");
		System.out.println(loan_no);
		String dd_no=map.get("DD_NO51");
		System.out.println(dd_no);
		String invoice_Type=map.get("INVOICE_TYPE");
		System.out.println(invoice_Type);
		Map<String,String> invoiceMess = new GetFrontInvoiceSP().getFrontInvoice(loan_no, dd_no, invoice_Type);
		System.out.println(invoiceMess);
		praseXML.setOutMessage(invoiceMess);
		System.out.println("INFO | 处理XML:" + praseXML.getRootXml());
		return praseXML.getRootXml();
	}

}

