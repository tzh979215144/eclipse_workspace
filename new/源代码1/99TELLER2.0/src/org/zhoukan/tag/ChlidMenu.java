package org.zhoukan.tag;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.zhoukan.bean.MenuBean;
import org.zhoukan.dao.ChildMenuSP;

public class ChlidMenu extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	private MenuBean mainMenu = null;
	
	private String userName = null;
	

	private List<MenuBean> list = null;
	
	private Iterator<MenuBean> it = null;
	
	private List<MenuBean> getList(){
		ChildMenuSP childMenu = new ChildMenuSP();
		List<MenuBean> list = childMenu.getMenu(userName, mainMenu.getPOWER_ID());
		//System.out.println(userName+mainMenu.getPOWER_ID());
		//System.out.println("子菜单的长度"+list.size());
		return list;
	}
	
	
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		this.list = this.getList();
		this.it = this.list.iterator();
		while(it.hasNext()){
			this.pageContext.setAttribute("chlidMenu", it.next());
			return EVAL_BODY_INCLUDE;
		}
		return SKIP_BODY;
	}


	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		if(it.hasNext()){
			this.pageContext.setAttribute("chlidMenu", it.next());
			return EVAL_BODY_AGAIN;
		}
		return SKIP_BODY;
	}
	
	public MenuBean getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(MenuBean mainMenu) {
		this.mainMenu = mainMenu;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
