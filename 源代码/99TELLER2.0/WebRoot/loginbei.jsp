<%@ page language="java" import="java.util.*" pageEncoding="GBK" isELIgnored="false"%>
<%@page import="org.zhoukan.dao.GetNOSP"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String n = new GetNOSP().getNO("login_no");
if(!n.equals("-1"))pageContext.setAttribute("login_no",n);
%>
<html>
<head>
<base href="<%=basePath%>">
	<TITLE>�û���¼</TITLE>
	<LINK href="images/Default.css" type=text/css rel=stylesheet>
	<LINK href="images/xtree.css" type=text/css rel=stylesheet>
	<LINK href="images/User_Login.css" type=text/css rel=stylesheet>
    <META http-equiv=Content-Type content="text/html; charset=GBK">
    <META content="MSHTML 6.00.6000.16809" name=GENERATOR>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<STYLE type=text/css>
BODY {
	FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: ����
}
TD {
	FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: ����
}
</STYLE>
<style type="text/css">
<!--
a{ color:#008EE3}
a:link  { text-decoration: none;color:#008EE3}
A:visited {text-decoration: none;color:#666666}
A:active {text-decoration: underline}
A:hover {text-decoration: underline;color: #0066CC}
A.b:link {
	text-decoration: none;
	font-size:12px;
	font-family: "Helvetica,΢���ź�,����";
	color: #FFFFFF;
}
A.b:visited {
	text-decoration: none;
	font-size:12px;
	font-family: "Helvetica,΢���ź�,����";
	color: #FFFFFF;
}
A.b:active {
	text-decoration: underline;
	color: #FF0000;

}
A.b:hover {text-decoration: underline; color: #ffffff}

.table1 {
	border: 1px solid #CCCCCC;
}
.font {
	font-size: 12px;
	text-decoration: none;
	color: #999999;
	line-height: 20px;
	

}
.input {
	font-size: 12px;
	color: #999999;
	text-decoration: none;
	border: 0px none #999999;


}

td {
	font-size: 12px;
	color: #007AB5;
}
form {
	margin: 1px;
	padding: 1px;
}
input {
	border: 0px;
	height: 26px;
	color: #007AB5;

	.unnamed1 {
	border: thin none #FFFFFF;
}
.unnamed1 {
	border: thin none #FFFFFF;
}
select {
	border: 1px solid #cccccc;
	height: 18px;
	color: #666666;

	.unnamed1 {
	border: thin none #FFFFFF;
}
body {
	background-repeat: no-repeat;
	background-color: #9CDCF9;
	background-position: 0px 0px;

}
.tablelinenotop {
	border-top: 0px solid #CCCCCC;
	border-right: 1px solid #CCCCCC;
	border-bottom: 0px solid #CCCCCC;
	border-left: 1px solid #CCCCCC;
}
.tablelinenotopdown {

	border-top: 1px solid #eeeeee;
	border-right: 1px solid #eeeeee;
	border-bottom: 1px solid #eeeeee;
	border-left: 1px solid #eeeeee;
}
.style6 {FONT-SIZE: 9pt; color: #7b8ac3; }

-->
</style>
</head>
<body>
<table width="681" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top:120px">
  <tr>
    <td width="353" height="259" align="center" valign="bottom" background="mages/login_1.gif">
    <table width="90%" border="0" cellspacing="3" cellpadding="0">
      <tr>
        <td align="right" valign="bottom" style="color:#05B8E4">Power by DreamHigh Copyright 2012 </td>
      </tr>
    </table></td>
    <td width="195" background="mages/login_2.gif"><table width="190" height="106" border="0" align="center" cellpadding="2" cellspacing="0">
      <form id=form1 name=form1 onSubmit="javascript:return WebForm_OnSubmit();" action="login.do" method="post">
            <tr>
              <td height="50" colspan="2" align="left"><INPUT id=txt style="WIDTH: 130px" name="LOGIN_ID" value="${pageScope.login_no }" readonly type="hidden"></td>
            </tr>
						 <tr>
              <td width="60" height="30" align="left">�� �� ��</td>
			  <td><input name="ORG_ID" type="TEXT" style="background:url(mages/login_6.gif) repeat-x; border:solid 1px #27B3FE; height:20px; background-color:#FFFFFF" id="ORG_ID"size="13"></td>
            </tr>
			 <tr>
              <td width="60" height="30" align="left">�� �� ��</td>
			  <td><input name="NET_ID" type="TEXT" style="background:url(mages/login_6.gif) repeat-x; border:solid 1px #27B3FE; height:20px; background-color:#FFFFFF" id="NET_ID"size="13"></td>
			 </tr>
            <tr>
              <td width="60" height="30" align="left">��¼����</td>
              <td><input name="USER_NAME" type="TEXT" style="background:url(mages/login_6.gif) repeat-x; border:solid 1px #27B3FE; height:20px; background-color:#FFFFFF" id="USER_NAME"size="13"></td>
            </tr>
            <tr>
              <<td width="60" height="30" align="left">��¼����</td>
              <td><input name="USER_PASSWORD" TYPE="PASSWORD" style="background:url(mages/login_6.gif) repeat-x; border:solid 1px #27B3FE; height:20px; background-color:#FFFFFF" id="USER_PASSWORD" size="16"></td>
            </tr>
           
            <tr>
              <td height="40" colspan="2" align="center" style="HEIGHT: 18px"><SPAN><img src="mages/tip.gif" width="16" height="16">${requestScope.loginErr}</SPAN></td>
          <tr>
              <td colspan="2" align="center"><input type="submit" name="btn" onclick='javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions("btn", "", true, "", "", false, false))' style="background:url(mages/login_5.gif) no-repeat" value=" ��  ¼  "> 
			  <input type="reset" name="Submit" style="background:url(mages/login_5.gif) no-repeat" value=" ȡ  �� "></td>
            <tr>
              <td height="5" colspan="2"></td>
        </form>
    </table></td>
    <td width="133" background="mages/login_3.gif">&nbsp;</td>
  </tr>
  <tr>
    <td height="161" colspan="3" background="mages/login_4.gif"></td>
  </tr>
</table>
</body>
</html>