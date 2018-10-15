package org.zhoukan.tag;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.zhoukan.bean.LoginBean;
import org.zhoukan.bean.MenuBean;
import org.zhoukan.dao.MainMenuSP;

public class MenuTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	private LoginBean loginBean = null;
	
	private List<MenuBean> list = null;
	
	private Iterator<MenuBean> it = null;
	
	private List<MenuBean> getList(){
		MainMenuSP mainMenu = new MainMenuSP();
		List<MenuBean> list = mainMenu.getMenu(this.loginBean.getUSER_NAME());
		return list;
	}
	
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		this.list = this.getList();
		this.it = this.list.iterator();
		while(this.it.hasNext()){
			this.pageContext.setAttribute("menuBean", this.it.next());
			return EVAL_BODY_INCLUDE;
		}
		return SKIP_BODY;
	}
	
	
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		if(it.hasNext()){
			this.pageContext.setAttribute("menuBean", this.it.next());
			return EVAL_BODY_AGAIN;
		}
		return SKIP_BODY;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}


	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	
	
}
