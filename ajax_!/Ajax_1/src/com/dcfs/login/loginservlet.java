package com.dcfs.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.dcfs.dao.UserLogin;
import com.dcfs.model.User;



@SuppressWarnings("serial")
public class loginservlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at:: ").append(request.getContextPath());
		doPost(request, response);
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> result = new HashMap<String,String>();
		System.out.println("����servlet");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("username"+username);
		System.out.println("password"+password);
		
		UserLogin userlogin=new UserLogin();
		
		request.setAttribute("msg1", "��¼�ɹ���");
		   response.setContentType("application/json");
           response.setCharacterEncoding("UTF-8");
           User user=new User();
          user.setUsername(username);
          user.setPassword(password);
           response.setContentType("application/x-json;charset=UTF-8");
           PrintWriter print=response.getWriter();
           JSONObject jsonObj = new JSONObject();
           try {
			jsonObj.put("username",username);
			 jsonObj.put("password",password);
	           jsonObj.put("msg2","�ɹ���");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
          
           
          
           print.print(jsonObj.toString()); //�������Ҫ��һ��Ҫת���ַ�����ʽ
           print.flush();
           print.close();

		
//		
//		boolean flag = false;
//		try {
//			flag = userlogin.login(username,password);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if(flag){
//			request.setAttribute("msg", "��¼�ɹ���");
//			request.getRequestDispatcher("success.jsp").forward(request, response);
//		}else{
//			request.setAttribute("msg", "��¼ʧ�ܣ�");
//			request.getRequestDispatcher("error.jsp").forward(request, response);
//		}
//			

	}
}
