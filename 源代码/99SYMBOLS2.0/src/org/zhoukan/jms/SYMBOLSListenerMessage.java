package org.zhoukan.jms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.zhoukan.thead.ServiceRunable;



public class SYMBOLSListenerMessage implements MessageListener{
	private MessageConsumer consumer = null;
	private String IP = "127.0.0.1";
	private ExecutorService fixedTheadPool = Executors.newFixedThreadPool(30);
	
	public SYMBOLSListenerMessage(){
		this.init();
	}
	
	private void init(){
		System.out.println("INFO | 欢迎光临 来到 SYMBOLS 监听！！！！！！！！！！！！！！");
		try {
			ConnectionFactory factory = 
				new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
						ActiveMQConnection.DEFAULT_PASSWORD, "tcp://"+ this.IP +":61616");

			Connection connection = factory.createConnection();
			connection.start();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("esb2symbols");
			
			this.consumer = session.createConsumer(destination);
			
			this.consumer.setMessageListener(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		if(message instanceof TextMessage){
			TextMessage TextMsg = (TextMessage)message;
			try {
				String ID = message.getStringProperty("MessageID");
				String xml = (String)TextMsg.getText();
				
				fixedTheadPool.submit(new ServiceRunable(xml, ID));
				
				System.out.println("----------------------------------------");
				System.out.println("INFO | 消息ID是：" + ID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
