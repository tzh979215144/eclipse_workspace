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
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;  
	 background:url(teller/images/bg_17.jpg)
}
-->
</style>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
<body> 
<%--雕纹花开始--%>
 <script Language="javascript">
function a(x,y,color)
{document.write("<img border='0' style='position: absolute; left: "+(x+100)+"; top: "+(y+200)+";background-color: "+color+"' src='px.gif' width=1 height=1>")}
</script>
<script>

for(t=1;t<=360;t++){
lo=200 * Math.sin(2 * (Math.PI / 180) * t);
x = lo * Math.cos((Math.PI / 180) * t);
y = lo * Math.sin((Math.PI / 180) * t); 
a(x,y,"#000000");
lo=200 * Math.cos(2 * (Math.PI / 180) * t);
x = lo * Math.cos((Math.PI / 180) * t);
y = lo * Math.sin((Math.PI / 180) * t); 
a(x,y,"#ff0000");
}
</script>
<%-- 飞雪开始--%>
<style>
.drop { position: absolute; width: 3;  filter: flipV(), flipH(); font-size: 40; color:white}
</style>
<script language="javascript">
snow = true;    // false-rain;   true-snow
snowsym = " * "  //These are the symbols for each
rainsym = " * "  //You can put images here.
howmany = 22     //How many drops/snowflakes?

/**************Do not need to change anything below***********/
if(snow){sym = snowsym; speed=1; angle=10; drops=howmany}
else{sym = rainsym; speed=50; drops=howmany; angle=6}
movex = -speed/angle; movey = speed; count = 0;   

function moverain(){
for(move = 0; move < drops; move++){
xx[move]+=movex;  yy[move]+=mv[move];
hmm = Math.round(Math.random()*1);
if(xx[move] < 0){xx[move] = maxx+10;}
if(yy[move] > maxy){yy[move] = 10;}
drop[move].left = xx[move]
drop[move].top = yy[move]+document.body.scrollTop;
}setTimeout('moverain()','1')}

</script>
<script language="javascript">

if (document.all){
drop = new Array(); xx = new Array(); yy = new Array(); mv = new Array()
ly = "document.all[\'"; st = "\'].style"
for(make = 0; make < drops; make++){
document.write('<div id="drop'+make+'" class=drop>'+sym+'</div>');
drop[make] = eval(ly+'drop'+make+st);
maxx = document.body.clientWidth-40
maxy = document.body.clientHeight-40
xx[make] = Math.random()*maxx;
yy[make] = -100-Math.random()*maxy;
drop[make].left = xx[make]
drop[make].top = yy[make]
mv[make] = (Math.random()*5)+speed/16;
drop[make].fontSize = (Math.random()*10)+20;
if(snow){col = 'white'}else{col = 'blue'}
drop[make].color = col;
}
window.onload=moverain
}
</script>
<%-- 飞雪结束--%>
<%-- <script language="JavaScript1.2">
var ie=document.all
var dom=document.getElementById
var ns4=document.layers

var bouncelimit=32 //(must be divisible by 8)
var curtop
var direction="up"
var boxheight=''

function initbox(){
if (!dom&&!ie&&!ns4)
return
crossobj=(dom)?document.getElementById("dropin").style : ie? document.all.dropin : document.dropin
scroll_top=(ie)? document.body.scrollTop : window.pageYOffset
crossobj.top=scroll_top-250
crossobj.visibility=(dom||ie)? "visible" : "show"
dropstart=setInterval("dropin()",50)
}

function dropin(){
scroll_top=(ie)? document.body.scrollTop : window.pageYOffset
if (parseInt(crossobj.top)<100+scroll_top)
crossobj.top=parseInt(crossobj.top)+40
else{
clearInterval(dropstart)
bouncestart=setInterval("bouncein()",50)
}
}

function bouncein(){
crossobj.top=parseInt(crossobj.top)-bouncelimit
if (bouncelimit<0)
bouncelimit+=8
bouncelimit=bouncelimit*-1
if (bouncelimit==0){
clearInterval(bouncestart)
}
}

function dismissbox(){
if (window.bouncestart) clearInterval(bouncestart)
crossobj.visibility="hidden"
}


function get_cookie(Name) {
var search = Name + "="
var returnvalue = ""
if (document.cookie.length > 0) {
offset = document.cookie.indexOf(search)
if (offset != -1) {
offset += search.length
end = document.cookie.indexOf(";", offset)
if (end == -1)
end = document.cookie.length;
returnvalue=unescape(document.cookie.substring(offset, end))
}
}
return returnvalue;
}

function dropornot(){
if (get_cookie("droppedin")==""){
window.onload=initbox
document.cookie="droppedin=yes"
}
}
dropornot()
</script>
<div id="dropin" style="position:absolute;visibility:hidden;left:760;top:100;width:250;height:144; background:url(images/login-wel.gif)">

<div align="right"><a href="javascript:dismissbox()">[关闭窗口] </a></div>
<hr>
<span style=" font-size:14px; font-family:Arial, Helvetica, sans-serif ;font-style:inherit " >友情提示：
   帅哥美女：打起精神，新的一天才刚开始哟....！！！</span>
</div>   
<center>--%>
<div style="margin-top:150px; margin-bottom:150px;">
  <h1>
  <%--变色字体--%>

<h2 align="center"><font color="#800000">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;  &nbsp;&nbsp;    &nbsp;  &nbsp;&nbsp;&nbsp; 欢迎光临!!</font>&nbsp;</h2>
<p align="center">&nbsp;</p>
  </h1>   
</div>
</center>
        <td width="51%" class="left_txt" align="center">  
		<div style=" text-align:center; font-size:12px; font-style:inherit; margin:0px; font:'宋体'"> 
        
         <span id="theText" style="width:100%">
		&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &copy;版权所有：Object项目开发小组<br>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/icon-phone.gif" width="17" height="14">&nbsp; 联系我们：QQ12345678 </span>
         <script>
<!--
var from = 5;
var to = 50;
var delay = 5;
var glowColor = "lime";
var i = to;
var j = 0;
textPulseDown();

function textPulseUp()
{
if (!document.all)
return   
if (i < to)
{
theText.style.filter = "Glow(Color=" + glowColor + ", Strength=" + i + ")";
i++;
theTimeout = setTimeout('textPulseUp()',delay);
return 0;
}

if (i = to)
{
theTimeout = setTimeout('textPulseDown()',delay);
return 0;
}


}

function textPulseDown()
{
if (!document.all)
return
if (i > from)
{
theText.style.filter = "Glow(Color=" + glowColor + ", Strength=" + i + ")";
i--;
theTimeout = setTimeout('textPulseDown()',delay);
return 0;
}

if (i = from)
{
theTimeout = setTimeout('textPulseUp()',delay);
return 0;
}
}

//-->
</script>
        
</div>
             </td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  
</table>
</body>
</html>
