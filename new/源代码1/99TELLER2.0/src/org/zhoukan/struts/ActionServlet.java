package org.zhoukan.struts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		response.setHeader("Cache-Control", "no-cache");
    	response.setDateHeader("Expires", 0);
    	new RequestProcess().process(request, response);
	}
}
