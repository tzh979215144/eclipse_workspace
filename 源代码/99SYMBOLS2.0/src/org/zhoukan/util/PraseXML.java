package org.zhoukan.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


public class PraseXML {

	private Document doc = null;
	
	
	
	public PraseXML(String xml){
		try {
			this.doc = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PraseXML(File file){
		try {
			SAXReader reader = new SAXReader();
			this.doc = reader.read(file);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PraseXML(Document doc){
		this.doc = doc;
	}
	
	
	
	public String getBodySVR_IDText(){
		Node el = this.doc.selectSingleNode("//BODY/SVR_ID");
		return el.getText();
	}
	
	
	
	public String getLocalHeadTRAN_NAMEEText(){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/TRAN_NAME");
		return el.getText();
	}
	public String getLocalHeadTRAN_CODEText(){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/TRAN_CODE");
		return el.getText();
	}
	public String getLocalHeadTRAN_SEQText(){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/TRAN_SEQ");
		return el.getText();
	}
	public String getLocalHeadFRONT_SEQText(){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/FRONT_SEQ");
		return el.getText();
	}
	public String getLocalHeadTRAN_DATEText(){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/TRAN_DATE");
		return el.getText();
	}
	
	public String getLocalHeadTRAN_RESPONSE_DATEText(){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/TRAN_RESPONSE_DATE");
		return el.getText();
	}
	public String getLocalHeadREFERENCEText(){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/REFERENCE");
		return el.getText();
	}
	public String getLocalHeadTRAN_STATUSText(){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/TRAN_STATUS");
		return el.getText();
	}
	
	public String getLocalHeadPROFIT_CENTERText(){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/PROFIT_CENTER");
		return el.getText();
	}
	
	public String getLocalHeadREVERSAL_RS_CODEText(){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/REVERSAL_RS_CODE");
		return el.getText();
	}
	
	public String getLocalHeadRE_CODEText(){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/RE_CODE");
		return el.getText();
	}
	
	public String getLocalHeadBANK_IDText(){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/BANK_ID");
		return el.getText();
	}
	
	
	
	public void setBodySVR_IDText(String SVR_ID){
		Node el = this.doc.selectSingleNode("//BODY/SVR_ID");
		el.setText(SVR_ID);
	}
	
	public void setLocalHeadTRAN_NAMEText(String TRAN_NAME){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/TRAN_NAME");
		el.setText(TRAN_NAME);
	}
	
	public void setLocalHeadTRAN_CODEText(String TRAN_CODE){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/TRAN_CODE");
		el.setText(TRAN_CODE);
	}
	public void setLocalHeadTRAN_SEQText(String TRAN_SEQ){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/TRAN_SEQ");
		el.setText(TRAN_SEQ);
	}
	
	public void setLocalHeadFRONT_SEQText(String FRONT_SEQ){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/FRONT_SEQ");
		el.setText(FRONT_SEQ);
	}
	public void setLocalHeadTRAN_DATEText(String TRAN_DATE){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/TRAN_DATE");
		el.setText(TRAN_DATE);
	}
	
	public void setLocalHeadTRAN_RESPONSE_DATEText(String TRAN_RESPONSE_DATE){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/TRAN_RESPONSE_DATE");
		el.setText(TRAN_RESPONSE_DATE);
	}
	public void setLocalHeadREFERENCEText(String REFERENCE){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/REFERENCE");
		el.setText(REFERENCE);
	}
	public void setLocalHeadTRAN_STATUSText(String TRAN_STATUS){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/TRAN_STATUS");
		el.setText(TRAN_STATUS);
	}
	public void setLocalHeadPROFIT_CENTERText(String PROFIT_CENTER){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/PROFIT_CENTER");
		el.setText(PROFIT_CENTER);
	}
	public void setLocalHeadREVERSAL_RS_CODEText(String REVERSAL_RS_CODE){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/REVERSAL_RS_CODE");
		el.setText(REVERSAL_RS_CODE);
	}
	public void setLocalHeadRE_CODEText(String RE_CODE){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/RE_CODE");
		el.setText(RE_CODE);
	}
	
	public void setLocalHeadBANK_IDText(String BANK_ID){
		Node el = this.doc.selectSingleNode("//LOCAL_HEAD/BANK_ID");
		el.setText(BANK_ID);
	}
	
	
	
	
	public String getSYSHeadSYS_IDText(String tag){
		Node el = this.doc.selectSingleNode("//SYS_HEAD/SYS_ID");
		return el.getText();
	}
	
	public String getSYSHeadMM_IDText(String tag){
		Node el = this.doc.selectSingleNode("//SYS_HEAD/MM_ID");
		return el.getText();
	}
	
	
	
	public void setBodyMessage(String tag, String value){
		Element message = (Element)this.doc.selectSingleNode("ROOT/BODY/SVR_MESSAGE_IN");
		Element el = message.addElement(tag);
		el.setText(value);
	}
	
	public void setBodyMessage(Element value){
		Element message = (Element)this.doc.selectSingleNode("ROOT/BODY/SVR_MESSAGE_IN");
		message.add(value);
		//el.setText(value);
	}
	
	public void setInMessage(Map<?, ?> SVR_MESSAGE_IN){
		Element message = (Element)this.doc.selectSingleNode("ROOT/BODY/SVR_MESSAGE_IN");
		
		Set<?> ss = SVR_MESSAGE_IN.keySet();
		
		for(Iterator<?> it = ss.iterator(); it.hasNext();){
			String name = (String)it.next();
			Element el = message.addElement(name);
			el.setText((String)SVR_MESSAGE_IN.get(name));
			
		}
		
		//message.setDocument(SVR_MESSAGE_IN);
		//message.setText(SVR_MESSAGE_IN);
	}
	public void setOutMessage(Map<?, ?> SVR_MESSAGE_OUT){
		System.out.println("INFO | The method of setOutMessage is running.....");
		Element message = (Element)this.doc.selectSingleNode("ROOT/BODY/SVR_MESSAGE_OUT");
		
		Set<?> ss = SVR_MESSAGE_OUT.keySet();
				
		for(Iterator<?> it = ss.iterator(); it.hasNext();){
			String name = (String)it.next();
			Element el = message.addElement(name);
			el.setText((String)SVR_MESSAGE_OUT.get(name));
			
		}
	}
	
	public void setOutMessage(Element value){
		Element message = (Element)this.doc.selectSingleNode("ROOT/BODY/SVR_MESSAGE_OUT");
		message.add(value);
		//el.setText(value);
	}
	
	
	public HashMap<String, String> getInMessageMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		Element message = (Element) this.doc.selectSingleNode("ROOT/BODY/SVR_MESSAGE_IN");
		for(Iterator<?> it = message.elementIterator(); it.hasNext();){
			Element el = (Element)it.next();
			String key = el.getName();
			String value = el.getTextTrim();
			//System.out.println(value);
			map.put(key, value);
		}
		
		return map;
	}
	
	public HashMap<String, String> getOutMessageMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		Element message = (Element) this.doc.selectSingleNode("ROOT/BODY/SVR_MESSAGE_OUT");
		for(Iterator<?> it = message.elementIterator(); it.hasNext();){
			Element el = (Element)it.next();
			String key = el.getName();
			String value = el.getTextTrim();
			//System.out.println(value);
			map.put(key, value);
		}
		
		return map;
	}
	
	public HashMap<String, String> getLOCAL_HEADMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		Element message = (Element) this.doc.selectSingleNode("ROOT/LOCAL_HEAD");
		for(Iterator<?> it = message.elementIterator(); it.hasNext();){
			Element el = (Element)it.next();
			String key = el.getName();
			String value = el.getTextTrim();
			//System.out.println(value);
			map.put(key, value);
		}
		
		return map;
	}
	
	public String getInMessage(){
		Element message = (Element) this.doc.selectSingleNode("ROOT/BODY/SVR_MESSAGE_IN");
		return message.asXML();
	}
	
	public String getOutMessage(){
		Element message = (Element) this.doc.selectSingleNode("ROOT/BODY/SVR_MESSAGE_OUT");
		return message.asXML();
	}
	
	public String getRootXml(){
		Element root = this.doc.getRootElement();
		return root.asXML();
	}

	public String getBodyTagName(String tag){
		Element message = (Element)this.doc.selectSingleNode("ROOT/BODY/SVR_MESSAGE_IN/"+tag);
		return message.asXML();
	}

	public String getBodyTagName1(String tag){
		Element message = (Element)this.doc.selectSingleNode("ROOT/BODY/SVR_MESSAGE_IN/"+tag);
		return message.getText();
	}
 	public String getBodyTagName2(String tag){
		Element message = (Element)this.doc.selectSingleNode("ROOT/BODY/SVR_MESSAGE_IN/RECEIPTTB_MESSAGE/RECEIPTTB/"+tag);
		return message.getText();
	}

	
	public Element getRootElement(){
		return this.doc.getRootElement();
	}
	
}
