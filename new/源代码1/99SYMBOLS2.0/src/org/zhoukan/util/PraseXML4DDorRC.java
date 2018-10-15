package org.zhoukan.util;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.zhoukan.bean.DD4SettlePayBean;
import org.zhoukan.bean.DrawDrowBean;
import org.zhoukan.bean.RC4SettlePayBean;
import org.zhoukan.bean.ReceiptBean;
import org.zhoukan.bean.SettleRecBean;

public class PraseXML4DDorRC {

	private Document doc = null;
	
	public PraseXML4DDorRC(String xml){
		try {
			this.doc = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<DrawDrowBean> getBodyDrawDrowMess() {
		List<?> list = this.doc.selectNodes("//BODY/SVR_MESSAGE_IN/DRAWDROW_MESSAGE");
		List<DrawDrowBean> beans = new ArrayList<DrawDrowBean>();
		for(int i = 0; i < list.size(); i++){
			Node node = (Node)list.get(i);
			DrawDrowBean bean = new DrawDrowBean();
			Element el1 = (Element)node.selectSingleNode("//ACCT_TYPE");
			bean.setACCT_TYPE(el1.getTextTrim());
			Element el2 = (Element)node.selectSingleNode("//SELLE_METHOD");
			bean.setSELLE_METHOD(el2.getTextTrim());
			Element el3 = (Element)node.selectSingleNode("//SUB_ACCT_TYPE");
			bean.setSUB_ACCT_TYPE(el3.getTextTrim());
			Element el4 = (Element)node.selectSingleNode("//CCY");
			bean.setCCY(el4.getTextTrim());
			Element el5 = (Element)node.selectSingleNode("//BASE_ACCT_NO");
			bean.setBASE_ACCT_NO(el5.getTextTrim());
			Element el6 = (Element)node.selectSingleNode("//BRANCH");
			bean.setBRANCH(el6.getTextTrim());
			Element el7 = (Element)node.selectSingleNode("//NAME");
			bean.setNAME(el7.getTextTrim());
			beans.add(bean);
			
		}
		return beans;
	}
	
//	public List<SettleRecBean> getBodySettleRecMess() {
//		List<?> list = this.doc.selectNodes("//BODY/SVR_MESSAGE_IN/SETTLEREC_MESSAGE/SettleRecACCT");
//		System.out.println(list.size());
//		List<SettleRecBean> beans = new ArrayList<SettleRecBean>();
//		for(int i = 0; i < list.size(); i++){
//			Node node = (Node)list.get(i);
//			System.out.println(node.getName());
//			SettleRecBean bean = new SettleRecBean();
//			Element el1 = (Element)node.selectSingleNode("//ACCT_TYPE");
//			bean.setACCT_TYPE(el1.getTextTrim());
//			Element el2 = (Element)node.selectSingleNode("//SETTLE_METHOD");
//			bean.setSETTLE_METHOD(el2.getTextTrim());
//			Element el3 = (Element)node.selectSingleNode("//BASE_ACCT_NO");
//			bean.setBASE_ACCT_NO(el3.getTextTrim());
//			Element el4 = (Element)node.selectSingleNode("//CCY");
//			bean.setCCY(el4.getTextTrim());
//			Element el5 = (Element)node.selectSingleNode("//REC_AMT");
//			bean.setREC_AMT(Integer.valueOf(el5.getTextTrim()));
//			Element el6 = (Element)node.selectSingleNode("//SUM_AMT");
//			bean.setSUM_AMT(Integer.valueOf(el6.getTextTrim()));
//			Element el7 = (Element)node.selectSingleNode("//CLIENT_NAME");
//			bean.setCLIENT_NAME(el7.getTextTrim());
//			beans.add(bean);
//		}
//		return beans;
//	}
	
	public List<ReceiptBean> getBodyReceitpMess() {
		List<?> list = this.doc.selectNodes("//BODY/SVR_MESSAGE_IN/RECEPT_MESSAGE");
		List<ReceiptBean> beans = new ArrayList<ReceiptBean>();
		for(int i = 0; i < list.size(); i++){
			Node node = (Node)list.get(i);
			ReceiptBean bean = new ReceiptBean();
			Element el1 = (Element)node.selectSingleNode("//ACCT_TYPE");
			bean.setACCT_TYPE(el1.getTextTrim());
			Element el2 = (Element)node.selectSingleNode("//SELLE_METHOD");
			bean.setSELLE_METHOD(el2.getTextTrim());
			Element el3 = (Element)node.selectSingleNode("//SUB_ACCT_TYPE");
			bean.setSUB_ACCT_TYPE(el3.getTextTrim());
			Element el4 = (Element)node.selectSingleNode("//CCY");
			bean.setCCY(el4.getTextTrim());
			Element el5 = (Element)node.selectSingleNode("//BASE_ACCT_NO");
			bean.setBASE_ACCT_NO(el5.getTextTrim());
			Element el6 = (Element)node.selectSingleNode("//BRANCH");
			bean.setBRANCH(el6.getTextTrim());
			Element el7 = (Element)node.selectSingleNode("//NAME");
			bean.setNAME(el7.getTextTrim());
			Element el8 = (Element)node.selectSingleNode("//FREEZE");
			bean.setFREEZE(el8.getTextTrim());
			beans.add(bean);
			
		}
		return beans;
	}
	
	public List<DD4SettlePayBean> getBodyDrawDrow4SettlePayMess() {
		List<?> list = this.doc.selectNodes("//BODY/SVR_MESSAGE_IN/DRAWDROW_MESSAGE/DRAWDROWACCT");
		List<DD4SettlePayBean> beans = new ArrayList<DD4SettlePayBean>();
		for(int i = 0; i < list.size(); i++){
			Node node = (Node)list.get(i);
			DD4SettlePayBean bean = new DD4SettlePayBean();
			Element el1 = (Element)node.selectSingleNode("//ACCT_TYPE");
			bean.setACCT_TYPE(el1.getTextTrim());
			Element el2 = (Element)node.selectSingleNode("//SELLE_METHOD");
			bean.setSELLE_METHOD(el2.getTextTrim());
			Element el3 = (Element)node.selectSingleNode("//BASE_ACCT_NO");
			bean.setBASE_ACCT_NO(el3.getTextTrim());
			Element el4 = (Element)node.selectSingleNode("//CCY");
			bean.setCCY(el4.getTextTrim());
			Element el5 = (Element)node.selectSingleNode("//SEC_AMT");
			bean.setSEC_AMT(el5.getTextTrim());
			Element el6 = (Element)node.selectSingleNode("//NAME");
			bean.setNAME(el6.getTextTrim());
			Element el7 = (Element)node.selectSingleNode("//DD_AMT");
			bean.setDD_AMT(el7.getTextTrim());
			beans.add(bean);
		}
		return beans;
	}
	
	public List<RC4SettlePayBean> getBodyRECEPT4SettlePayMess() {
		List<?> list = this.doc.selectNodes("//BODY/SVR_MESSAGE_IN/AUTO_RECEPT_MESSAGE/RECEPTACCT");
		List<RC4SettlePayBean> beans = new ArrayList<RC4SettlePayBean>();
		for(int i = 0; i < list.size(); i++){
			Node node = (Node)list.get(i);
			RC4SettlePayBean bean = new RC4SettlePayBean();
			Element el1 = (Element)node.selectSingleNode("//ACCT_TYPE");
			bean.setACCT_TYPE(el1.getTextTrim());
			Element el2 = (Element)node.selectSingleNode("//SELLE_METHOD");
			bean.setSELLE_METHOD(el2.getTextTrim());
			Element el3 = (Element)node.selectSingleNode("//BASE_ACCT_NO");
			bean.setBASE_ACCT_NO(el3.getTextTrim());
			Element el4 = (Element)node.selectSingleNode("//CCY");
			bean.setCCY(el4.getTextTrim());
			Element el5 = (Element)node.selectSingleNode("//NAME");
			bean.setNAME(el5.getTextTrim());
			Element el6 = (Element)node.selectSingleNode("//FREEZE");
			bean.setFREEZE(el6.getTextTrim());
			beans.add(bean);
			
		}
		return beans;
	}
}
