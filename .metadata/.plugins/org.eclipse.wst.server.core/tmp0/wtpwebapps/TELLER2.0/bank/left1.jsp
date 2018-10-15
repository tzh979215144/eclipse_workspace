<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List,org.zhoukan.dao.*,org.zhoukan.bean.*"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println(basePath);
%>
<head>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link href="css/default.css" rel="stylesheet">
<!-- 可选的Bootstrap主题文件（一般不使用） -->
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="js/jquery-3.2.1.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>

</head> 
 <ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
        <li class="active">
          <a href="#">
            <i ></i>首页</a>
        </li>
		<%
		LoginBean loginBean = new LoginBean();
		loginBean = (LoginBean)request.getSession().getAttribute("loginBean");
		MainMenuSP mainMenu = new MainMenuSP();
		List<MenuBean> list = mainMenu.getMenu(loginBean.getUSER_NAME());
		for(int i = 0; i < list.size(); i++){
		String id = list.get(i).getPOWER_ID();
		String name = list.get(i).getPOWER_NAME();
		System.out.println(id+"  "+name);} 
		%>
		<% for(int i = 0; i < list.size(); i++){%>
        <li>
          <a href="#systemSetting<%= i%>" class="nav-header collapsed" data-toggle="collapse">
            <i ></i><%= list.get(i).getPOWER_NAME()%>
            <span class="pull-right "></span></a>
          <ul id="systemSetting<%= i%>" class="nav nav-list collapse secondmenu" style="height: 0px;">
		<%
		ChildMenuSP child_menu = new ChildMenuSP();
		String id = list.get(i).getPOWER_ID();
		List<MenuBean> child_list = child_menu.getMenu(loginBean.getUSER_NAME(),id);
		for(int j = 0; j < child_list.size(); j++){ 
		%>
            <li>
              <a href="<%= child_list.get(j).getPOWER_PATH()%>" target="main">
                <i class=""></i><%= child_list.get(j).getPOWER_NAME()%></a>
            </li>
			<%} %>
          </ul>
        </li>
		<%} %>

      </ul>