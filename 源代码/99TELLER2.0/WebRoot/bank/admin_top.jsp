<%@ page language="java" import="java.util.*" pageEncoding="GBK" isELIgnored="false"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<base href="<%=basePath %>">
<head>
<title> - 管理页面 </title>
<script type="text/javascript">
	var HttpRequest = null;
	
	function ajaxInitEngine(){
		if(window.XMLHttpRequest){
			HttpRequest = new XMLHttpRequest();
		}else if (window.ActiveXObject) { // IE浏览器
			try {
				HttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					HttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {alert('初始化Ajax引擎失败！');}
			}
		}
	}
	
	function sendRequest(){
		ajaxInitEngine();
		HttpRequest.open("GET","loginDown.do?loginId=${sessionScope.loginBean.USER_NAME}",true);
		//HttpRequest.onreadystatechange=changestate;
		HttpRequest.send(null);
	}
 </script>
<script language=JavaScript>
function logout(){
	var falg = confirm("您确定要退出系统吗？退出系统将自动签退！");
	if (falg){
		//top.location = "/TELLER2.0/index.jsp";
		sendRequest();
		top.window.close();
		return;

	}
}
</script>
<link href="images/skin.css" rel="stylesheet" type="text/css">
    <meta http-equiv=Content-Type content=text/html;charset=gb2312>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body leftmargin="0" topmargin="0"  onLoad="startclock()">
    <script language="JavaScript">
<!-- Hide
  var timerID = null
  var timerRunning = false
  function MakeArray(size) 
  {
  this.length = size;
  for(var i = 1; i <= size; i++)
  {
  this[i] = "";
  }
  return this;
  }
  function stopclock (){
  if(timerRunning)
  clearTimeout(timerID);
  timerRunning = false
  }
  function showtime () {
  var now = new Date();
  var year = now.getYear();
  var month = now.getMonth() + 1;
  var date = now.getDate();
  var hours = now.getHours();
  var minutes = now.getMinutes();
  var seconds = now.getSeconds();
  var day = now.getDay();
  Day = new MakeArray(7);
  Day[0]="星期天";
  Day[1]="星期一";
  Day[2]="星期二";
  Day[3]="星期三";
  Day[4]="星期四";
  Day[5]="星期五";
  Day[6]="星期六";
  var timeValue = "";
  timeValue += year + "年";
  timeValue += ((month < 10) ? "0" : "") + month + "月";
  timeValue += date + "日  ";
  timeValue += (Day[day]) + "  ";
  timeValue += ((hours <= 12) ? hours : hours - 12);
  timeValue += ((minutes < 10) ? ":0" : ":") + minutes;
  timeValue += ((seconds < 10) ? ":0" : ":") + seconds;
  timeValue += (hours < 12) ? "上午" : "下午";
  document.jsfrm.face.value = timeValue;
  timerID = setTimeout("showtime()",1000);
  timerRunning = true
  }
  function startclock () {
  stopclock();
  showtime()
  }
  //-->
</script>


 <form name='jsfrm'>
<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="admin_topbg" >

  <tr>
    <td width="50%" height="64"><img src="images/logo.gif" width="262" height="64"></td>
    <td width="50%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr style="margin: 0px">
        <td width="89%" height="38" class="admin_txt"><p><b>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 登录柜员：${sessionScope.loginBean.USER_NAME } &nbsp;登录号：${sessionScope.loginBean.LOGIN_ID }&nbsp; 网点号：${sessionScope.loginBean.NET_ID }&nbsp; &nbsp;&nbsp;&nbsp;<img src="images/pic14.gif" width="20" height="15">
<input type=text name='face' size=34 style="background-color:transparent; border: none ;color:#FFF">
        </b></p></td>
        <td width="10%"><a href="teller/admin_top.jsp" target="_self" onClick="logout();"><img src="images/out.gif" alt="安全退出" width="46" height="20" border="0"></a></td>
        <td width="1%">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="3">&nbsp;</td>   
        </tr>
    </table>
    </td>
  </tr>


</table>
</form>
</body>
</html>
