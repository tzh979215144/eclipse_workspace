package org.zhoukan.thead;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.Calendar;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.ESBServiceBean;
import org.zhoukan.bean.StreamBean;
import org.zhoukan.dao.ChangeStreamSP;
import org.zhoukan.dao.GetCodeClassSP;
import org.zhoukan.jms.MessageRecive;
import org.zhoukan.jms.MessageSend;
import org.zhoukan.util.PraseXML;
import org.zhoukan.util.ServiceESBFactory;
import org.zhoukan.util.SocketUtil;

public class ServiceRunable implements Runnable {

	private Socket socket = null;
    //唯一的标识id，当前时间到毫秒级别和当前线程的id，确保唯一
	private String id = "" + Calendar.getInstance().getTimeInMillis()  
			+ Thread.currentThread().getId();
	public ServiceRunable(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		SocketUtil socketUtil = new SocketUtil(socket);

		try {
			// 读
			String xml = socketUtil.reader();
			System.out.println("INFO | ESB收到Teller的信息:" + xml);
	/*----------------------------------------------------------*/
			// 业务处理
			System.out.println("INFO | 业务处理开始........ ");
			ESBServiceBean serviceBean = this.init(xml);
			System.out.println("INFO | 获得ESBServiceBean...");
            System.out.println("INFO | 服务类型为："+serviceBean.getSUB_SERVICE_CLASS());
			String xmlReq = ServiceESBFactory.createService(
					serviceBean.getSUB_SERVICE_CLASS()).doSth(
					serviceBean.getXml());

			System.out.println("INFO | ESB运用工厂处理以后的信息:" + xmlReq);

			new MessageSend(xmlReq, "esb2symbols", this.id).send2Message();
			System.out.println("INFO | ESB发送消息到symbols完成....");
			String xmlResp = new MessageRecive("symbols2esb", "127.0.0.1",
					this.id).reciveMsg();
			System.out.println("INFO | ESB已经接收symbols消息完成....");
			System.out.println("INFO | ESB接收收到的xml:" + xmlResp);
			//
			this.doAfter(xmlResp);
			//将处理结果写回Teller端
			socketUtil.writer(xmlResp);
			System.out.println("INFO | ESB已经成功将处理结果发送至Teller...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// log4j处理
			// 返回异常
		}

	}

	public ESBServiceBean init(String xml) {
        //解析XML  
		PraseXML praseXML = new PraseXML(xml);
	    System.out.println("INFO | 解析Teller传来的XML报文.....");
        //封装Teller流水号，ESB流水号，服务类，XML
		ESBServiceBean serviceBean = new ESBServiceBean();
        //获得前端流水号
		String tran_code = praseXML.getLocalHeadTRAN_CODEText();
        //赋值
        System.out.println("INFO | 数据库配置的交易代号："+tran_code);
		serviceBean.setTELLER_TRAN_NO(tran_code);
		serviceBean = new GetCodeClassSP().getCodeClass(serviceBean);
		
		System.out.println("INFO | SYMBOLS端交易码："+serviceBean.getSYMBOLS_TRAN_NO());
		praseXML.setBodySVR_IDText(serviceBean.getSYMBOLS_TRAN_NO());
        System.out.println("INFO | ESB获取数据完成......");
		serviceBean.setXml(praseXML.getRootXml());

		return serviceBean;
	}

	public void doAfter(String xml) {

		PraseXML praseXML = new PraseXML(xml);

		Map<String, String> map = praseXML.getLOCAL_HEADMap();

		if (map.get("TRAN_SEQ") == null) {
			return;
		}

		StreamBean streamBean = new StreamBean();

		try {
			BeanUtils.populate(streamBean, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new ChangeStreamSP().change(streamBean);

	}
}
