<%@ page language="java" import="java.util.*" pageEncoding="GBK" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script language="javascript" src="js/getFlowNo.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
 <body>

<fieldset>

<legend><label style="font-size: 14px;">消息</label></legend>
<table border="0" width="80%">
<tbody>
<tr>
	<td style="width: 30%;" ><div align="left" style="font-size: 13px;">发送消息:</div></td><td><div align="left" id="sendMess" style="font-size: 13px;"></div></td>
</tr>
<tr>
	<td style="width: 20%;" ><div align="left" style="font-size: 13px;">返  回  码:</div></td><td><div align="left" id="recieveMess" style="font-size: 13px;"></div></td>
</tr>
</tbody>
</table>

</fieldset>                
      
</body>
</html>
