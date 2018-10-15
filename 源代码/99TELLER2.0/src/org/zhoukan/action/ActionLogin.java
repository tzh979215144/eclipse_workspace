package org.zhoukan.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.zhoukan.bean.LoginBean;
import org.zhoukan.dao.LoginCheckSP;
import org.zhoukan.dao.LoginRecordSP;
import org.zhoukan.struts.Action;
import org.zhoukan.util.MyDate;

public class ActionLogin extends Action{

	@Override
	protected String excuse(Map<String, String> map ,HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		// TODO Auto-generated method stub
		LoginBean loginBean = new LoginBean();
		try {
			BeanUtils.populate(loginBean, map);
			loginBean.setLOGIN_UPTIME(MyDate.getTime());
			loginBean.setLOGIN_IP(request.getRemoteAddr());
			loginBean.setWORKDAY(MyDate.getDate());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			System.out.println("bean 初始化错误");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			System.out.println("bean 初始化错误");
		}
		//System.out.println(loginBean.getUSER_NAME());
		int n = new LoginCheckSP().getCheck(loginBean.getORG_ID(), loginBean.getNET_ID(), loginBean.getUSER_NAME(), loginBean.getUSER_PASSWORD());
		if(n <= 0){
			request.setAttribute("loginErr", "姓名或密码或网点不对");
			System.out.println("11111111111111姓名或密码或网点不对");
			return "/login.jsp";
		}
		
		String record = new LoginRecordSP().log(loginBean);
		if(record.equalsIgnoreCase("no")){
			request.setAttribute("loginErr", "你已经签退了！");
			return "/login.jsp";
		}
		HttpSession session = request.getSession();
		session.setAttribute("loginBean", loginBean);
//		return "/teller/main.jsp";
		return "bank/main.jsp";
	}

}
