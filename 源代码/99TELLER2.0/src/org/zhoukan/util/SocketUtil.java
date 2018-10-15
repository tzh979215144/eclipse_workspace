package org.zhoukan.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class SocketUtil {

	private Socket socket = null;
	private PrintWriter writer = null;
	private BufferedReader reader = null;
	
	public SocketUtil(Socket socket){
		this.socket = socket;
	}
	
	public String reader(){
		String message = "";
		try {
			reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
//			this.socket.setSoTimeout(6000);
			message = reader.readLine();
			//System.out.println(message);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "<err>连接断开</err>";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "<err></err>";
		}
		return message;
	}
	
	public void writer(String xmlSting) throws IOException{
		writer = new PrintWriter(this.socket.getOutputStream());
		writer.println(xmlSting);
		writer.flush();
	}
	public void close() throws IOException{
		writer.close();
		reader.close();
		socket.close();
	}
	
}
