package org.zhoukan.struts;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	
	protected abstract String excuse(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
	throws  IOException;
}
