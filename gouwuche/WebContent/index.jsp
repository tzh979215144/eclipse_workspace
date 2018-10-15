<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
 <!--   <title>首页</title>  --> 
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Motor</title>
    <meta name="description" content="">

        <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/templatemo-style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body class="about-page">
        <!-- Preloader -->
        <div id="loader-wrapper">
          <div id="loader"></div>
          <div class="loader-section section-left"></div>
          <div class="loader-section section-right"></div>
        </div>
        <!-- End Preloader -->
 	 <jsp:useBean id="loginBean" class="lyons.entity.Login" scope="session"/>
 
 	 <% request.setCharacterEncoding("UTF-8"); %>
 	    <nav class="col-lg-3 col-md-3 tm-footer-nav tm-footer-div">
 		<ul class="row margin-bottom-60">
    			<li>
    				<%
    				    String str = null;
    				    str = loginBean.getUsername();
    					if(str.equals("userNull")||str==null)
    					{
    					   HttpSession s= request.getSession(true);
                           s.invalidate();
                        %>
	     					<a href="jsp/join/login.jsp">登录</a>
	     		</li>
	     		<li>
	     		<a href="jsp/join/register.jsp">注册</a>
    					<%
    					   return;
    					}
    				 %>
   						<dl>
   							<dt>
	    						<a>欢迎您,<b><font color="red"><%= str %></font></b></a>
	    						<a href="<%= path %>/lyons.control/HandleExit"><font color="#CDC9C9">退出</font></a>
   							</dt>
   						</dl>
    			</li>
    		</ul>
    		</nav>
    		
    		<% 
                String value = null;
                value = request.getParameter("first");
                if(value!=null && "FP".equals(value))
                {%>
                   
                <%}
            %>
            
  </body>
</html>
