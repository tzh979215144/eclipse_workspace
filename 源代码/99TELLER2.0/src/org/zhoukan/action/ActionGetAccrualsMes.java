/**
 * 作者：郝晓婷
 * 功能：计提信息查询Action
 * 日期：2012-03-08
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
import org.zhoukan.bean.AccrualsBean;
//import org.zhoukan.bean.StreamBean;
//import org.zhoukan.dao.ChangeStreamSP;
import org.zhoukan.dao.GetNOSP;
//import org.zhoukan.dao.StreamSP;
import org.zhoukan.struts.Action;
import org.zhoukan.util.MyDate;
import org.zhoukan.util.PraseXML;
import org.zhoukan.util.SocketUtil;

public class ActionGetAccrualsMes extends Action{
	@Override
	protected String excuse(Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		
		String teller2EsbXML = this.initRegister(map);
		
		if(teller2EsbXML == null){
			return null;
		}
		
		SocketUtil socketUtil = new SocketUtil(new Socket("127.0.0.1", 9999));//Socket连接
		
		socketUtil.writer(teller2EsbXML);
		
		String esb2TellerXML = socketUtil.reader();
		
		AccrualsBean accrualsBean = this.doAfter(esb2TellerXML);
		
		/****************************************************************/
		//DrawDownBean drawDownBean = this.doAfter(esb2TellerXML);
		//LoanBean loanBean = this.doAfter(esb2TellerXML);
		
		
		
		request.setAttribute("accrualsBean", accrualsBean);//设置accrualsBean属性
		
		try {
			request.getRequestDispatcher("/teller/accruals.jsp").forward(request, response);//设置请求页面
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return null;
	}

	
	public String initRegister(Map<String, String> map){
		
		PraseXML praseXML = new PraseXML(new File("E:\\Workspaces\\MyEclipse 8.5\\TELLER2.0\\src\\Send.xml"));
		
		praseXML.setOutMessage(map);
		
		praseXML.setLocalHeadTRAN_CODEText("MESSLOAN_NO4DD_NO4");//设置Teller端计提查询交易码
		
		praseXML.setLocalHeadTRAN_NAMEText("利息计提查询");//交易名称
		
		praseXML.setLocalHeadTRAN_SEQText(""+(new GetNOSP().getNO("front_tran_no")));
		
		praseXML.setLocalHeadTRAN_DATEText(MyDate.getTime());
		
		praseXML.setLocalHeadTRAN_STATUSText("1");
		
		praseXML.setLocalHeadBANK_IDText("2080");
		
		praseXML.setLocalHeadPROFIT_CENTERText("2080");
		
		praseXML.setBodySVR_IDText("MESSLOAN_NO4DD_NO4");
		//System.out.println("*******8");
		
		String teller2EsbXML = praseXML.getRootXml();
		System.out.println("INFO | teller2EsbXML:"+teller2EsbXML); 
		return teller2EsbXML;
	}
	
	public AccrualsBean doAfter(String xml){
		PraseXML praseXML = new PraseXML(xml);
		
		AccrualsBean accrualsBean = new AccrualsBean();

		//Map<String, String> mal = praseXML.getLOCAL_HEADMap();
		
		//Map<String, String> map = praseXML.getInMessageMap();
		Map<String, String> map = praseXML.getOutMessageMap();
		
		accrualsBean.setRecieveMess(praseXML.getLocalHeadRE_CODEText());
		
		try {
			//BeanUtils.populate(accrualsBean, mal);
			BeanUtils.populate(accrualsBean, map);
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String LOAN_NO = accrualsBean.getLOAN_NO();
		String DD_NO = accrualsBean.getDD_NO();
		System.out.println(LOAN_NO+"_____________"+DD_NO);
		
		return accrualsBean;
	}
}
