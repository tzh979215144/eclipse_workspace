package org.zhoukan.action;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.zhoukan.struts.Action;
import org.zhoukan.util.PraseXML;
import org.zhoukan.util.SocketUtil;

public class TestAction extends Action{

	@Override
	protected String excuse(Map<String, String> map ,HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Map<String, String> xml = map;
		System.out.println(xml);
		File f = new File("D:\\WorkSpace\\TELLER2.0\\src\\Send.xml");
		SAXReader reader = new SAXReader();
		String xmls = null;
		try {
			Document doc = reader.read(f);
			PraseXML praseXML = new PraseXML(doc);
			praseXML.setInMessage(xml);
			//praseXML.setInMessage(doc);
			xmls = praseXML.getRootXml();
			System.out.println("发送的字符"+xmls);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Socket socket = new Socket("127.0.0.1", 9999);
		SocketUtil socketUtil = new SocketUtil(socket);
		socketUtil.writer(xmls);
		String xml1 = socketUtil.reader();
		System.out.println(xml1);
		socketUtil.close();
		return "/MyJsp.jsp";
	}

}
