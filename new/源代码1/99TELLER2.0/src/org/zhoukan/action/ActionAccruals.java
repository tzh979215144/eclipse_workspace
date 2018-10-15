/**
 * 作者：郝晓婷
 * 功能：计提利息调整Action
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
import org.zhoukan.bean.StreamBean;
import org.zhoukan.dao.ChangeStreamSP;
import org.zhoukan.dao.GetNOSP;
import org.zhoukan.dao.StreamSP;
import org.zhoukan.struts.Action;
import org.zhoukan.util.MyDate;
import org.zhoukan.util.PraseXML;
import org.zhoukan.util.SocketUtil;

public class ActionAccruals extends Action{
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
		
		praseXML.setInMessage(map);
		
		praseXML.setLocalHeadTRAN_CODEText("CL04");//设置Teller端计提交易码
		
		praseXML.setLocalHeadTRAN_NAMEText("利息计提调整");//交易名称
		
		praseXML.setLocalHeadTRAN_SEQText(""+(new GetNOSP().getNO("front_tran_no")));
		
		praseXML.setLocalHeadTRAN_DATEText(MyDate.getTime());
		
		praseXML.setLocalHeadTRAN_STATUSText("1");
		
		praseXML.setLocalHeadBANK_IDText("2080");
		
		praseXML.setLocalHeadPROFIT_CENTERText("2080");
		
		praseXML.setBodySVR_IDText("CL04");
		
		StreamBean bean = new StreamBean();//记流水
		try {
			BeanUtils.populate(bean, praseXML.getLOCAL_HEADMap());
			if(map.get("ACCT_ID")!= null){
				bean.setACCT_ID(map.get("ACCT_ID"));//记账号
			}
			if(map.get("SUB_ACCT_ID")!= null){//记子账号
				bean.setSUB_ACCT_ID(map.get("SUB_ACCT_ID"));
			}
			if(map.get("AMOUNT")!= null){//记交易金额
				bean.setAMOUNT(map.get("AMOUNT"));
			}
			if(map.get("CCY")!= null){//记币种
				bean.setCCY(map.get("CCY"));
			}
			if(map.get("OPER_ID")!= null){//记柜员号
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
	
	public AccrualsBean doAfter(String xml){
		PraseXML praseXML = new PraseXML(xml);
		
		AccrualsBean accrualsBean = new AccrualsBean();
		
		Map<String, String> mao = praseXML.getLOCAL_HEADMap();
		
		Map<String, String> map = praseXML.getInMessageMap();
		
		StreamBean streamBean = new StreamBean();
		
		accrualsBean.setRecieveMess(praseXML.getLocalHeadRE_CODEText());
		
		try {
			BeanUtils.populate(streamBean, mao);
			BeanUtils.populate(accrualsBean, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new ChangeStreamSP().change(streamBean);
		
		return accrualsBean;
	}
}
