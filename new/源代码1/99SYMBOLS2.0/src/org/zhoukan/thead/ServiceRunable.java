package org.zhoukan.thead;

import org.zhoukan.dao.GetServerClassSP;
import org.zhoukan.jms.MessageSend;
import org.zhoukan.util.PraseXML;
import org.zhoukan.util.ServiceSYMBOLSFactory;


public class ServiceRunable implements Runnable{

	private String xml = null;
	private String id = null;
	
	public ServiceRunable(String xml,String id){
		this.xml = xml;
		this.id = id;
	}
	
	@Override
	public void run() {
		//根据xml里的服务查到classPath
		System.out.println("INFO | the method of symbols run is running..........");
		String className = this.init(xml);
		
		System.out.println("INFO | 数据库中配置的类路径:"+className);
		
		String xmlResp = ServiceSYMBOLSFactory.createService(className).doSth(xml);
		
		System.out.println("INFO | symbols处理结果是："+xmlResp);
		new MessageSend(xmlResp, "symbols2esb", id).send2Message();
		System.out.println("INFO | symbols发送完成...");
	}
	
	public String init(String xml){
		System.out.println("INFO | symbols开始查找调用服务...");
		String ser_id = new PraseXML(xml).getBodySVR_IDText();
		System.out.println("INFO | symbols数据库配置的SVR_ID："+ser_id);
		return new GetServerClassSP().getClassName(ser_id);
	}

}
