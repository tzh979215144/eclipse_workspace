package org.zhoukan.start;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.zhoukan.thead.ServiceRunable;
import org.zhoukan.util.ConnectionPool;

public class ESB2_0_START {

	public static void main(String[] args) {
		try {
			ServerSocket sSocket = new ServerSocket(9999);
			ExecutorService fixedTheadPool = Executors.newFixedThreadPool(30);//创建一个可重用30条线程的线程池
			System.out.println("INFO | 欢迎来到ESB.......");
			ConnectionPool.initConnection();
			while(true){
				System.out.println("-------------------------------------");
				Socket socket = sSocket.accept();
				fixedTheadPool.submit(new ServiceRunable(socket));// 提交一个 ServiceRunable任务用于执行，并返回一个表示该任务的 Future
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
