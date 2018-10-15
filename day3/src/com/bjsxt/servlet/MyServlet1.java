package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet1
 */
public class MyServlet1 extends HttpServlet {

/*	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			//res.getWriter().write("<b>this is my first page in servlet!</b>");
			String addr= req.getLocalAddr();
	
	}*/
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//res.getWriter().write("<b>this is my first page in servlet!</b>");
//		req里面有所有的请求信息	
		//获取请求头数据
					//获取请求方式
							String method = req.getMethod();
							System.out.println(method);
					//获取请求URL
							StringBuffer URL = req.getRequestURL();
							System.out.println(URL);
							//获取请求URi,请求信息
							String uri = req.getRequestURI();
							System.out.println(uri);
							//获取协议
							String h =req.getScheme();
							System.out.println(h);
				
	}
}
