<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <base href="<%=basePath%>">
	
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>登录表单</title>


	<!-- Meta-Tags -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //Meta-Tags -->

	<!-- Style --> <link rel="stylesheet" href="css/style.css" type="text/css" media="all">



</head>
<body>
	
	<% 
		/* 从本地磁盘中获取已保存的cookie */
		request.setCharacterEncoding("UTF-8");
		String username = "";
		String userpass = "";
		String backNews = "";
		
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if(cookies!=null && cookies.length>0)
		{
			for(Cookie c:cookies)
			{
				if("username".equals(c.getName()))
				{
					username = URLDecoder.decode(c.getValue(),"UTF-8");//解码并取值、赋值
				}
				if("userpass".equals(c.getName()))
				{
					userpass = URLDecoder.decode(c.getValue(),"UTF-8");
				}
				if("backNews".equals(c.getName()))
				{
					backNews = URLDecoder.decode(c.getValue(),"UTF-8");
				}
			}
		}
	%>
	<center>
	<div class="container w3layouts agileits">
	  <div class="login w3layouts agileits">
	    <h2>登 录</h2>
		<form action="<%= path %>/lyons.control/HandleLogin" method="post">
        <input type="text" name="username" value="<%= username %>" placeholder="用户名" required=""/>
        <input type="password" name="userpass" value="<%= userpass %>" placeholder="密码" required=""/>
        
        <ul >
				<li>
				
					<input type="checkbox" name="isCookie" value="isCookie">
					<label for="brand1"><span></span><font size="4" color="white">记住我</font></label>
				
				</li>
			</ul>
			<div class="send-button w3layouts agileits">
				
					<input type="submit" value="登 录">
					<hr></hr>
				
				<a href="jsp/join/register.jsp">还没注册？</a>
			</div>
		</form>
	  </div>
	</div>
	</center>
	
			<div class="social-icons w3layouts agileits">
				<p>- 其他方式登录 -</p>
				<ul>
					<li class="qq"><a href="jsp/join/login.jsp">
					<span class="icons w3layouts agileits"></span>
					<span class="text w3layouts agileits">QQ</span></a></li><br><br>
					<li class="weixin w3ls"><a href="jsp/join/login.jsp">
					<span class="icons w3layouts"></span>
					<span class="text w3layouts agileits">微信</span></a></li><br><br>
					<li class="weibo aits"><a href="jsp/join/login.jsp">
					<span class="icons agileits"></span>
					<span class="text w3layouts agileits">微博</span></a></li><br><br>
					<div class="clear"> </div>
				</ul>
			</div>
			<div class="clear"></div>
			
</body>
</html>