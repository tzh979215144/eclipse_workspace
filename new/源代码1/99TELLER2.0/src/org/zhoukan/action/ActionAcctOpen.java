/*	作用:账户开户业务层
 * 	作者：杨蒙
 */
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
import org.zhoukan.bean.OpenAccountBean;
import org.zhoukan.bean.StreamBean;
import org.zhoukan.dao.ChangeStreamSP;
import org.zhoukan.dao.GetNOSP;
import org.zhoukan.dao.StreamSP;
import org.zhoukan.struts.Action;
import org.zhoukan.util.MyDate;
import org.zhoukan.util.PraseXML;
import org.zhoukan.util.SocketUtil;



public class ActionAcctOpen extends Action{

	@Override
	protected String excuse(Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		
		String teller2EsbXML = this.initOpen(map);
		
		if(teller2EsbXML == null){
			return null;
		}
		
		SocketUtil socketUtil = new SocketUtil(new Socket("127.0.0.1", 9999));
		
		socketUtil.writer(teller2EsbXML);
		
		String esb2TellerXML = socketUtil.reader();
		
		OpenAccountBean openAccountBean = this.doAfter(esb2TellerXML);
		
		
		
		request.setAttribute("openAccountBean", openAccountBean);
		
		try {
			request.getRequestDispatcher("/teller/openCurrentAcct.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return null;
	}

	
	public String initOpen(Map<String, String> map){
		
		PraseXML praseXML = new PraseXML(new File("E:\\Workspaces\\MyEclipse 8.5\\TELLER2.0\\src\\Send.xml"));
		
		praseXML.setInMessage(map);
		
		praseXML.setLocalHeadTRAN_CODEText("RB01");
		
		praseXML.setLocalHeadTRAN_NAMEText("账户开户");
		
		praseXML.setLocalHeadTRAN_SEQText(""+(new GetNOSP().getNO("front_tran_no")));
		
		praseXML.setLocalHeadTRAN_DATEText(MyDate.getTime());
		
		praseXML.setLocalHeadTRAN_STATUSText("1");
		
		praseXML.setLocalHeadBANK_IDText("2080");
		
		praseXML.setLocalHeadPROFIT_CENTERText("2080");
		
		praseXML.setBodySVR_IDText("RB01");
		
		StreamBean bean = new StreamBean();
		try {
			BeanUtils.populate(bean, praseXML.getLOCAL_HEADMap());
			if(map.get("ACCT_ID")!= null){
				bean.setACCT_ID(map.get("ACCT_ID"));
			}
			if(map.get("SUB_ACCT_ID")!= null){
				bean.setSUB_ACCT_ID(map.get("SUB_ACCT_ID"));
			}
			if(map.get("AMOUNT")!= null){
				bean.setAMOUNT(map.get("AMOUNT"));
			}
			if(map.get("CCY")!= null){
				bean.setCCY(map.get("CCY"));
			}
			if(map.get("OPER_ID")!= null){
				bean.setOPER_ID(map.get("OPER_ID"));
			}
			
			bean.setSOURCE_MODULE("RB");
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String mess = new StreamSP().setStream(bean);
		
		if(mess.equalsIgnoreCase("ok")){
			String teller2EsbXML = praseXML.getRootXml();
			System.out.println("INFO | teller2EsbXML:"+teller2EsbXML); 
			return teller2EsbXML;
		}
		
		return null;
	}
	
	public OpenAccountBean doAfter(String xml){
		PraseXML praseXML = new PraseXML(xml);
		
		OpenAccountBean accountBean = new OpenAccountBean();
		
		Map<String, String> mao = praseXML.getLOCAL_HEADMap();
		
		Map<String, String> map = praseXML.getInMessageMap();
		
		StreamBean streamBean = new StreamBean();
		
		accountBean.setRecieveMess(praseXML.getLocalHeadRE_CODEText());
		
		try {
			BeanUtils.populate(streamBean, mao);
			BeanUtils.populate(accountBean, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new ChangeStreamSP().change(streamBean);
		
		return accountBean;
	}
}
