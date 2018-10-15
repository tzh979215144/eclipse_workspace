package org.zhoukan.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
/*
 * Author:
 * 消息的接收*/
public class MessageRecive {
	
	private String MQaddress = null;
	private String IP = null;
	private String id = null;
	
	public MessageRecive(String MQaddress,String IP,String id){
		this.MQaddress = MQaddress;
		this.IP = IP;
		this.id = id;
	}
	
	public String reciveMsg(){
		String xml = null;
		try {
			ConnectionFactory factory = 
				new ActiveMQConnectionFactory(
						ActiveMQConnection.DEFAULT_USER, 
						ActiveMQConnection.DEFAULT_PASSWORD,
						"tcp://"+this.IP+":61616");
			Connection connection = factory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//false表示不启用事务标志，Session.AUTO_ACKNOWLEDGE表示自动签收
			Destination destination = session.createQueue(MQaddress);
			MessageConsumer consumer = session.createConsumer(destination,"MessageID='"+this.id+"'");
			TextMessage xmlMessage = (TextMessage) consumer.receive(5000);
			//5000是毫秒最长等待时间
			System.out.println("INFO | MessageID='"+this.id+"'");
			String MessageID = xmlMessage.getStringProperty("MessageID");
			//拿到消息的MessageID
			System.out.println("INFO | ESB接收到的消息ID是：" + MessageID);
			System.out.println("INFO | ESB开始接收xml....");
			xml = xmlMessage.getText();
			System.out.println("INFO | ESB接收到的Text报文体:"+xmlMessage.getText());
			session.close();
			connection.close();
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		return xml;
	}
}
