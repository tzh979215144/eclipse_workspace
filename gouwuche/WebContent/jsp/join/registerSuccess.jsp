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
    
    <title>My JSP 'landing.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="refresh" content="3; url=<%= path %>/jsp/join/login.jsp"> 
	
	<!-- <link rel="stylesheet" type="text/css" href="<%= path %>/css/nav.css">  -->

    	<!-- Meta-Tags -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //Meta-Tags -->

	<!-- Style --> <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
    
  </head>
  
  <body>
  
   		<% request.setCharacterEncoding("UTF-8"); %>
  	<div class="container w3layouts agileits">
	  <div class="login w3layouts agileits">
	    <h3><font color="Aquamarine">娉ㄥ唽鎴愬姛锛屼笁绉掑悗鑷�鍔ㄨ烦杞�鍒扮櫥褰曠晫闈�锛�</font></h3> 
	  </div>
	  </div>		


  </body>
</html>
