<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
   <title>SmarTeller</title>
   <style type="text/css">
* {margin:0px;padding:0px;}
html,body {height:100%;}
body {font-size:14px; line-height:24px;}
#tip {position: absolute;right: 0px;bottom: 0px;height: 0px;width: 180px;border: 1px solid #CCCCCC;background-color: #eeeeee;padding: 1px;overflow:hidden;display:none;font-size:12px;z-index:10;}
#tip p {padding:6px;}
#tip h1,#detail h1 {font-size:14px;height:25px;line-height:25px;background-color:#0066CC;color:#FFFFFF;padding:0px 3px 0px 3px;}
#tip h1 a,#detail h1 a {float:right;text-decoration:none;color:#FFFFFF;}
#shadow {position:absolute;width:100%;height:100%;background:#CCCCCC;-moz-opacity:0.5;filter:Alpha(Opacity=50);opacity: 0.8;z-index:11;display:none;overflow:hidden;}
#detail {width:500px;height:200px;border:3px double #ccc;background-color:#FFFFFF;position:absolute;z-index:30;display:none;left:30%;top:30%}
</style>
   
 <script type="text/javascript">
var handle;
function start()
{
var obj = document.getElementById("tip");
if (parseInt(obj.style.height)==0)
{ obj.style.display="block";
handle = setInterval("changeH('up')",2);
}else
{
     handle = setInterval("changeH('down')",2) 
} 
}
function changeH(str)
{
var obj = document.getElementById("tip");
if(str=="up")
{
if (parseInt(obj.style.height)>200)
   clearInterval(handle);
else
   obj.style.height=(parseInt(obj.style.height)+8).toString()+"px";
}
if(str=="down")
{
if (parseInt(obj.style.height)<8)
{ clearInterval(handle);
   obj.style.display="none";
}
else 
   obj.style.height=(parseInt(obj.style.height)-8).toString()+"px"; 
}
}
function showwin()
{
document.getElementsByTagName("html")[0].style.overflow = "hidden";
start();
document.getElementById("shadow").style.display="block";
document.getElementById("detail").style.display="block"; 
}
function recover()
{
document.getElementsByTagName("html")[0].style.overflow = "auto";
document.getElementById("shadow").style.display="none";
document.getElementById("detail").style.display="none"; 
}
</script> 


   
   
  </head>
<frameset rows="64,*"  frameborder="NO" border="0" framespacing="0">
	<frame src="/TELLER2.0/teller/admin_top.jsp" noresize="noresize" frameborder="0" name="topFrame" scrolling="no" marginwidth="0" marginheight="0" target="_self" />
	  <frameset cols="184,*"  rows="*" id="frame">
		<frame src="/TELLER2.0/teller/left.jsp" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="no" target="main" />
		<frameset rows="*,80"  frameborder="NO" border="0" framespacing="0">
			<frame src="/TELLER2.0/teller/right.jsp" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" target="_self" />
			<frame src="/TELLER2.0/teller/mess.jsp" name="mess" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" target="_self" id="messFrame"/>
		</frameset>	
	 </frameset>
	</frameset>
 <noframes>
 <body>

 </body>
  </noframes>  
</html>
    