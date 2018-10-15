package org.zhoukan.filer;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	

	public void init(FilterConfig config) throws ServletException {
		// 初始化
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html; charset=GBK");
		chain.doFilter(request, response);//添加过滤器链；
	}

	public void destroy() {
		//销毁
	}

}
