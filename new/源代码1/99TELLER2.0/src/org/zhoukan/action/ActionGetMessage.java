package org.zhoukan.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.zhoukan.struts.Action;
import org.zhoukan.util.PraseXML;
import org.zhoukan.util.SocketUtil;

public class ActionGetMessage extends Action{

	@Override
	protected String excuse(Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		System.out.println("INFO | welcome to ajax get message!");
		SocketUtil socketUtil = new SocketUtil(new Socket("127.0.0.1", 9999));
		String getMess = null;
		String messageId = request.getParameter("CLIENT_NO");
		if(messageId != null){
			String mess = this.send2Esb("CLIENT_NO", messageId, null, null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		String AcctNo = request.getParameter("BASE_ACCT_NO"); 
		if(AcctNo != null){
			System.out.println("INFO | 输入的必要的NO为:"+AcctNo);
			String mess = this.send2Esb("BASE_ACCT_NO", AcctNo, null, null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		//发放计划获取贷款信息
		String FaFang=request.getParameter("FAFANG");
		if(FaFang != null){
			System.out.println("INFO | 输入的必要的NO为:"+FaFang);
			String mess = this.send2Esb("FaFang", FaFang, null, null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		//贷款回收结算查询
		String LOAN_NO7 = request.getParameter("LOAN_NO7");
		String DEBIT_NOTE_NO1 = request.getParameter("DEBIT_NOTE_NO1");
		if(LOAN_NO7!= null && DEBIT_NOTE_NO1!=null){
			System.out.println("INFO | 输入的必要的NO为:"+LOAN_NO7+"  "+DEBIT_NOTE_NO1);
			String mess = this.send2Esb("LOAN_NO", LOAN_NO7, "DEBIT_NOTE_NO", DEBIT_NOTE_NO1);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		
		
		
		String LOAN_NO = request.getParameter("LOAN_NO");
		if(LOAN_NO != null){
			System.out.println("INFO | 输入的必要的NO为:"+LOAN_NO);
			String mess = this.send2Esb("LOAN_NO", LOAN_NO, null, null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		String LOAN_NO2 = request.getParameter("LOAN_NO2");
		String DD_NO = request.getParameter("DD_NO");
		if(LOAN_NO2!= null && DD_NO!=null){
			System.out.println("INFO | 输入的必要的NO为:"+LOAN_NO2+"  "+DD_NO);
			String mess = this.send2Esb("LOAN_NO2", LOAN_NO2, "DD_NO", DD_NO);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}

		String LOAN_NO4 = request.getParameter("LOAN_NO4");
		String DD_NO4 = request.getParameter("DD_NO4");
		if(LOAN_NO4!= null && DD_NO4!=null){
			System.out.println("INFO | 输入的必要的NO为:"+LOAN_NO4+"  "+DD_NO4);
			String mess = this.send2Esb("LOAN_NO4", LOAN_NO4, "DD_NO4", DD_NO4);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		//日终配置查询
		String DAY = request.getParameter("DAY");
		if(DAY!= null){
			System.out.println("INFO | 输入的必要的NO为:"+DAY);
			String mess = this.send2Esb("DAY", DAY, null, null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		//日终跑批
		String JOR = request.getParameter("JOR");
		if(JOR!= null){
			System.out.println("INFO | 输入的必要的NO为:"+JOR);
			String mess = this.send2Esb("JOR", JOR, null, null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		//作业日终曲线 CURVE
		String CURVE = request.getParameter("CURVE");
		if(CURVE!= null){
			System.out.println("INFO | 输入的必要的NO为:"+CURVE);
			String mess = this.send2Esb("CURVE", CURVE, null, null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		
		//工作日日终曲线 CURVE
		String WORKDAY1 = request.getParameter("WORKDAY1");
		String WORKDAY2 = request.getParameter("WORKDAY2");
		if(WORKDAY1!= null && WORKDAY2 !=null ){
			System.out.println("INFO | 输入的必要的NO为:"+WORKDAY1+"  "+WORKDAY2);
			String mess = this.send2Esb2("WORKDAY1", WORKDAY1, "WORKDAY2",WORKDAY2, null,null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		
		//查询账户余额
		String BASE_ACCT_NO1 = request.getParameter("BASE_ACCT_NO1");
		if(BASE_ACCT_NO1!= null){
			System.out.println("INFO | 输入的必要的NO为:"+BASE_ACCT_NO1);
			String mess = this.send2Esb("BASE_ACCT_NO1", BASE_ACCT_NO1, null, null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		
		//账户利息查询
		String BASE_ACCT_NO2 = request.getParameter("BASE_ACCT_NO2");
		if(BASE_ACCT_NO2!= null){
			System.out.println("INFO | 输入的必要的NO为:"+BASE_ACCT_NO2);
			String mess = this.send2Esb("BASE_ACCT_NO2", BASE_ACCT_NO2, null, null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		
		//账户销户查询信息
		String BASE_ACCT_NO3 = request.getParameter("BASE_ACCT_NO3");
		if(BASE_ACCT_NO3!= null){
			System.out.println("INFO | 输入的必要的NO为:"+BASE_ACCT_NO3);
			String mess = this.send2Esb("BASE_ACCT_NO3", BASE_ACCT_NO3, null, null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		
		/*客户还款计划明细*/
		String LOAN_NO9 = request.getParameter("LOAN_NO9");
		String DD_NO9 = request.getParameter("DD_NO9");
		if(LOAN_NO9 != null && DD_NO9 != null){
			System.out.println("INFO | 输入的必要的NO为:"+LOAN_NO9+"  "+DD_NO9);
			String mess = this.send2Esb2("LOAN_NO9", LOAN_NO9, "DD_NO9", DD_NO9,null,null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		
		/* */
		String LOAN_NO5 = request.getParameter("LOAN_NO5");
		String DD_NO5 = request.getParameter("DD_NO5");
		if(LOAN_NO5 != null && DD_NO5 != null){
			System.out.println("INFO | 输入的必要的NO为:"+LOAN_NO5+"  "+DD_NO5);
			String mess = this.send2Esb2("LOAN_NO5", LOAN_NO5, "DD_NO5", DD_NO5,null,null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		
		
		String LOAN_NO51 = request.getParameter("LOAN_NO51");
		String DD_NO51 = request.getParameter("DD_NO51");
		String INVOICE_TYPE = request.getParameter("INVOICE_TYPE");
		if(LOAN_NO51 != null && DD_NO51 != null && INVOICE_TYPE!=null){
			System.out.println("INFO | 输入的必要的NO为:"+LOAN_NO51+"  "+DD_NO51+"  "+INVOICE_TYPE);
			String mess = this.send2Esb2("LOAN_NO51", LOAN_NO51, "DD_NO51", DD_NO51,"INVOICE_TYPE", INVOICE_TYPE);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		
		
		String LOAN_NO6 = request.getParameter("LOAN_NO6");
		if(LOAN_NO6!= null){
			System.out.println("INFO | 输入的必要的NO为:"+LOAN_NO6);
			String mess = this.send2Esb("LOAN_NO6", LOAN_NO6,null,null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		
		/*
		 * 贷款回收刷信息
		 */
		String 	DEBIT_NOTE_NO=request.getParameter("DEBIT_NOTE_NO");
		if(DEBIT_NOTE_NO!=null){
			System.out.println("INFO | 输入的必要的NO为:"+DEBIT_NOTE_NO);
			String mess = this.send2Esb("DEBIT_NOTE_NO", DEBIT_NOTE_NO,null,null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		/*
		 * 贷款发放刷
		 */

		String INT_BASIS = request.getParameter("INT_BASIS");
		if(INT_BASIS!= null){
			System.out.println("INFO | 输入的必要的NO为:"+INT_BASIS);
			String mess = this.send2Esb("INT_BASIS", INT_BASIS,null,null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller--:"+getMess);
		}
		//日终跑
		String LOADING=request.getParameter("LOADING");
		if(LOADING!= null){
			System.out.println("INFO | 输入的必要的NO为:"+LOADING);
			String mess = this.send2Esb("LOADING", LOADING,null,null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		
		String START=request.getParameter("START");
		if(START!= null){
			System.out.println("INFO | 输入的必要的NO为:"+START);
			String mess = this.send2Esb("START", START,null,null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		String DATA=request.getParameter("DATA");
		if(DATA!= null){
			System.out.println("INFO | 输入的必要的NO为:"+DATA);
			String mess = this.send2Esb("DATA", DATA,null,null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		String PRI_PLTY_BASIS = request.getParameter("PRI_PLTY_BASIS");
		if(PRI_PLTY_BASIS!= null){
			System.out.println("INFO | 输入的必要的NO为:"+PRI_PLTY_BASIS);
			String mess = this.send2Esb("PRI_PLTY_BASIS", PRI_PLTY_BASIS,null,null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller:"+getMess);
		}
		
		String INT_PLTY_BASIS = request.getParameter("INT_PLTY_BASIS");
		if(INT_PLTY_BASIS!= null){
			System.out.println("INFO | 输入的必要的NO为:"+INT_PLTY_BASIS);
			String mess = this.send2Esb("INT_PLTY_BASIS", INT_PLTY_BASIS,null,null);
			socketUtil.writer(mess);
			String getMs = socketUtil.reader();
			getMess = this.esb2Teller(getMs);
			System.out.println("INFO | esb2Teller--:"+getMess);
		}
		response.setContentType("text/xml; charset=GBK");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		out.println("<response>");
		out.println("<mess>");
		out.println(getMess);
		out.println("</mess>");
		out.println("</response>");
		out.close();
		System.out.println("-------");
		return null;
	}
	
	public String send2Esb(String key1, String value1, String key2, String value2){
		PraseXML praseXML = new PraseXML(new File("E:\\Workspaces\\MyEclipse 8.5\\TELLER2.0\\src\\Send.xml"));
		praseXML.setLocalHeadTRAN_CODEText("MESS"+key1);
		praseXML.setBodyMessage(key1, value1);
		if(key2 != null){
			praseXML.setBodyMessage(key2, value2);
			praseXML.setLocalHeadTRAN_CODEText("MESS"+key1+key2);
		}
		return praseXML.getRootXml();
	}
	public String send2Esb2(String key1, String value1, String key2, String value2,String key3, String value3){
		PraseXML praseXML = new PraseXML(new File("E:\\Workspaces\\MyEclipse 8.5\\TELLER2.0\\src\\Send.xml"));
		praseXML.setLocalHeadTRAN_CODEText("MESS"+key1);
		praseXML.setBodyMessage(key1, value1);
		if(key2 != null){
			praseXML.setBodyMessage(key2, value2);
			praseXML.setLocalHeadTRAN_CODEText("MESS"+key1+key2);
			if(key3!=null){
				praseXML.setBodyMessage(key3, value3);
				praseXML.setLocalHeadTRAN_CODEText("MESS"+key1+key2+key3);
			}
		}
		System.out.println("INFO | praseXML:"+praseXML.getRootXml());
		return praseXML.getRootXml();
	}
	public String esb2Teller(String xml){
		PraseXML praseXML = new PraseXML(xml);
		String outMess = praseXML.getOutMessage();
		if(outMess == null){
			outMess = "";
		}
		return outMess;
	}

}
