<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath+"bank"%>">
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link href="css/default.css" rel="stylesheet">
<!-- 可选的Bootstrap主题文件（一般不使用） -->
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="js/jquery-3.2.1.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>
<frameset rows="60,*,30" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="/TELLER2.0/bank/top.html" name="top"  noresize="noresize" marginwidth="0" marginheight="0" id="topFrame" title="topFrame" />
  <frameset cols="180,*" frameborder="no" border="0" framespacing="0">
    <frame src="/TELLER2.0/bank/left1.jsp" name="left"  noresize="noresize" marginwidth="0" marginheight="0" id="leftFrame" title="leftFrame" />
    
	<frameset rows="*,80"  frameborder="NO" border="0" framespacing="0">
		<frame src="" name="main" marginwidth="0" marginheight="0" id="mainFrame" title="mainFrame" />
		<frame src="/TELLER2.0/bank/mess.jsp" name="mess" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" target="_self" id="messFrame"/>
	</frameset>		
  </frameset>
  </frameset>
</head>

<body>

</body>