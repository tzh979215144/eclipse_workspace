package org.zhoukan.struts;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestProcess {
	
	public void process (HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		
		String doPath = request.getServletPath();
		
		doPath = doPath.substring(doPath.lastIndexOf("/")+1, doPath.lastIndexOf("."));
		
		Attribute attribute = new Attribute("/action_config.properties");
		
		String className = attribute.getValue(doPath);//获得.do的action类
		
		Action action = ActionFactory.createAction(className);
		
		if(action==null){
			System.out.println(doPath+":找不到对象Action");
			return;
		}
		
		Map<String, String> map = new RequestGetParam().getParamsMap(request);
		
		String page = action.excuse(map ,request, response);
		
		if(page==null||page.equals("")){
			return;
		}
		if(page.indexOf("?") > -1){
			response.sendRedirect(page);
			return;
		} else {
			request.getRequestDispatcher(page).forward(request, response);
			return;
		}
		
	}
	
	
}
