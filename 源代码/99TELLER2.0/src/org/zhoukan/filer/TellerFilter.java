package org.zhoukan.filer;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.zhoukan.bean.LoginBean;
import org.zhoukan.dao.LoginCheckSP;

public class TellerFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hRequest = (HttpServletRequest)request;
		HttpSession session = hRequest.getSession();
		LoginBean loginBean = (LoginBean)session.getAttribute("loginBean");
		if(loginBean == null){
			
			hRequest.setAttribute("loginErr", "请登录");
			hRequest.getRequestDispatcher("/login.jsp").forward(hRequest, response);
			return;
		}
		
		int n = new LoginCheckSP().getCheck(loginBean.getORG_ID(), loginBean.getNET_ID(), loginBean.getUSER_NAME(), loginBean.getUSER_PASSWORD());
		
		if(n <= 0){
			hRequest.setAttribute("loginErr", "  请  登  录");
			hRequest.getRequestDispatcher("/login.jsp").forward(hRequest, response);
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
