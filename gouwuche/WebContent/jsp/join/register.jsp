<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册表单</title>
<!-- Meta-Tags -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //Meta-Tags -->

	<!-- Style --> <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
</head>
<body>
		<jsp:useBean id="userBean" class="lyons.entity.Register" scope="request"/>
		<% request.setCharacterEncoding("UTF-8"); %>
		<div class="container w3layouts agileits">
		<div class="register w3layouts agileits" align="center">
		<h2>注 册</h2>
			<form action="<%= path %>/control.action" method="post">
				
			<input type="text" name="username" placeholder="用户名*" required=""/></td>
			<input type="password" name="userpass" placeholder="密码*" required="" /></td>
			<input type="password" name="again_userpass" placeholder="重复密码*" required=""/></td>
			<input type="text" name="phone" placeholder="电话号码*" required=""/></td>
            <input type="text" name="address"  placeholder="邮箱*" required=""/></td>
            <input type="text" name="realname" placeholder="真实姓名*" required=""/></td>
            <div class="send-button w3layouts agileits">
				
					<input type="submit" value="免费注册">
				
				<hr><font size="3" color="white">状态:</font><FONT color=yellow><jsp:getProperty name="userBean" property="backNews"/></FONT></hr>
			</div>
			</form>
        </div>
        </div>

</body>
</html>