<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>message.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <script>
  window.setTimeout('logout();',3000);
	 function logout(){
		<%session.invalidate();%>
		 window.parent.location.href="<%=request.getContextPath()%>/login.jsp";
	}
                  </script>
  <body>
      
      <div style="width:400px;position:relative;left:50%;margin-left:-200px;margin-top:100px;border:1px solid #bddf94;font-size:12px;">
          <div style="height:30px;border-bottom:1px solid #bddf94;background-color: #f7ffe7;line-height:30px;padding-left:10px;">
            <span style="font-weight:bold;color:#428608;">提示</span>
          </div>
          <div style="height:70px;padding:8px;text-align:center;">
                       <%= request.getAttribute("msg") %>
          <div style="text-align:center;padding-bottom:10px;">
            <div style="height:70px;padding:8px;text-align:center; font: 宋体; font-size: 12">
                            即将退出此系统，谢谢！！
          <div style="text-align:center;padding-bottom:10px;">

          </div>
            <!-- <input type="button" value="确定" onclick="location.href='<%=request.getContextPath()%>/jsp/web/center.jsp'"/>  --> 
            <input type="button" value="确定" onclick="logout()"/>
          </div>
      </div>
      
     
  </body>
</html>
