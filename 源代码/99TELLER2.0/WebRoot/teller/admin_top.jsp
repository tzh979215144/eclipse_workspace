<%@ page language="java" import="java.util.*" pageEncoding="GBK" isELIgnored="false"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<base href="<%=basePath %>">
<head>
<title> - ����ҳ�� </title>
<script type="text/javascript">
	var HttpRequest = null;
	
	function ajaxInitEngine(){
		if(window.XMLHttpRequest){
			HttpRequest = new XMLHttpRequest();
		}else if (window.ActiveXObject) { // IE�����
			try {
				HttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					HttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {alert('��ʼ��Ajax����ʧ�ܣ�');}
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
	var falg = confirm("��ȷ��Ҫ�˳�ϵͳ���˳�ϵͳ���Զ�ǩ�ˣ�");
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
  Day[0]="������";
  Day[1]="����һ";
  Day[2]="���ڶ�";
  Day[3]="������";
  Day[4]="������";
  Day[5]="������";
  Day[6]="������";
  var timeValue = "";
  timeValue += year + "��";
  timeValue += ((month < 10) ? "0" : "") + month + "��";
  timeValue += date + "��  ";
  timeValue += (Day[day]) + "  ";
  timeValue += ((hours <= 12) ? hours : hours - 12);
  timeValue += ((minutes < 10) ? ":0" : ":") + minutes;
  timeValue += ((seconds < 10) ? ":0" : ":") + seconds;
  timeValue += (hours < 12) ? "����" : "����";
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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ��¼��Ա��${sessionScope.loginBean.USER_NAME } &nbsp;��¼�ţ�${sessionScope.loginBean.LOGIN_ID }&nbsp; ����ţ�${sessionScope.loginBean.NET_ID }&nbsp; &nbsp;&nbsp;&nbsp;<img src="images/pic14.gif" width="20" height="15">
<input type=text name='face' size=34 style="background-color:transparent; border: none ;color:#FFF">
        </b></p></td>
        <td width="10%"><a href="teller/admin_top.jsp" target="_self" onClick="logout();"><img src="images/out.gif" alt="��ȫ�˳�" width="46" height="20" border="0"></a></td>
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
