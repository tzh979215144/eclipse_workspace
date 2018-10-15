package org.zhoukan.action;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.SettlePayBean_TE;
import org.zhoukan.struts.Action;
import org.zhoukan.util.PraseXML;
import org.zhoukan.util.SocketUtil;

public class ActionGetPayInfo extends Action{

	@Override
	protected String excuse(Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		String teller2EsbXML = this.initRegister(map);
		if(teller2EsbXML == null){
			return null;
		}
        SocketUtil socketUtil = new SocketUtil(new Socket("127.0.0.1", 9999));
		
		socketUtil.writer(teller2EsbXML);
		
		String esb2TellerXML = socketUtil.reader();
		
		SettlePayBean_TE settlePayBean = this.doAfter(esb2TellerXML);
		request.setAttribute("settlePayBean", settlePayBean);
		try {
			request.getRequestDispatcher("/teller/settlePay.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	

	private SettlePayBean_TE doAfter(String xml) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(xml);
		SettlePayBean_TE settlePayBean=new SettlePayBean_TE();	
		Map<String, String> map = praseXML.getInMessageMap();
		settlePayBean.setReceiveMess(praseXML.getLocalHeadRE_CODEText());
		try {
			BeanUtils.populate(settlePayBean, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return settlePayBean;
	}



	private String initRegister(Map<String, String> map) {
		// TODO Auto-generated method stub
		PraseXML praseXML = new PraseXML(new File("E:\\Workspaces\\MyEclipse 8.5\\TELLER2.0\\src\\Send.xml"));
		praseXML.setInMessage(map);
		praseXML.setLocalHeadTRAN_CODEText("MESSLOAN_NO2DD_NO1");
		praseXML.setBodySVR_IDText("MESSLOAN_NO2DD_NO1");
		String teller2EsbXML = praseXML.getRootXml();
		return teller2EsbXML;
	}
     
}
