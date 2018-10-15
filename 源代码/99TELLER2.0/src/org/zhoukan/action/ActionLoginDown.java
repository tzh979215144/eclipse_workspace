package org.zhoukan.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zhoukan.dao.LoginDownSP;
import org.zhoukan.struts.Action;

public class ActionLoginDown extends Action{

	@Override
	protected String excuse(Map<String, String> map ,HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//System.out.println("签退！！");
		String loginId = request.getParameter("loginId");
		//System.out.println(loginId);
		if(loginId != null)new LoginDownSP().down(loginId);
		return null;
	}

}
