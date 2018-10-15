<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="org.zhoukan.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	InvoiceBean reMess = (InvoiceBean) request
			.getAttribute("invoiceBean");
	if (reMess != null) {
		pageContext.setAttribute("reMess", reMess.getRecieveMess());
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>日终批处理</title>
		<link href="mages/css1/css.css" rel="stylesheet" type="text/css">
	</head>
<script type="text/javascript">
  	  function getLoading(){ 
	 //ajax
	 var ajax = new AjaxApi('getMessage.do', 'LOADING='+'LOADING',doxml,messSend);
	 //actionmessage中配置，页面传值，执行完成的js,先开始时执行的
	 	 ajax.send();
		
	 //执行
	  }
	 
	 function tgValue(xml,tgName){
	 	var val = xml.getElementsByTagName(tgName)[0];
	 	if(val == '' || val == null){
	 		return '';
	 	}
	 	return val.text;
	}
	
	  function doxml(xml){
      var txt,xx,x,i;
      messRecieve();	
	  x=xml.documentElement.getElementsByTagName("Day_finish");
      var tab=document.getElementById('txtInvoiceInfo');
      for (i=0;i<x.length;i++)
      {
      var newTr =tab.insertRow();
      var newTd1 = newTr.insertCell();
      xx=x[i].getElementsByTagName("PROCESS_SEQ_NO");
      newTd1.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";
    
      var newTd5 = newTr.insertCell();  
      xx=x[i].getElementsByTagName("PROCESS_NAME");
      newTd5.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";
      
      var newTd2 = newTr.insertCell();  
      xx=x[i].getElementsByTagName("START_TIME");
      newTd2.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";

      var newTd3 = newTr.insertCell();  
      xx=x[i].getElementsByTagName("END_TIME");
      newTd3.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";
        
      var newTd4 = newTr.insertCell();  
      xx=x[i].getElementsByTagName("RESULT");
      newTd4.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";

      }
}     function getData(){ 
	 //ajax
	 var ajax = new AjaxApi('getMessage.do', 'DATA='+'DATA',doxml2,messSend);
	 //actionmessage中配置，页面传值，执行完成的js,先开始时执行的
	 	 ajax.send();
		
	 //执行
	  }
	
	  function doxml2(xml){
      var txt,xx,x,i;
      messRecieve();	
	  x=xml.documentElement.getElementsByTagName("Day_finish");
      var tab=document.getElementById('txtInvoiceInfo');
      for (i=0;i<x.length;i++)
      {
      var newTr =tab.insertRow();
      var newTd1 = newTr.insertCell();
      xx=x[i].getElementsByTagName("PROCESS_SEQ_NO");
      newTd1.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";
    
      var newTd5 = newTr.insertCell();  
      xx=x[i].getElementsByTagName("PROCESS_NAME");
      newTd5.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";
      
      var newTd2 = newTr.insertCell();  
      xx=x[i].getElementsByTagName("START_TIME");
      newTd2.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";

      var newTd3 = newTr.insertCell();  
      xx=x[i].getElementsByTagName("END_TIME");
      newTd3.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";
        
      var newTd4 = newTr.insertCell();  
      xx=x[i].getElementsByTagName("RESULT");
      newTd4.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";

      }
}
         function getStart(){ 
	 //ajax
	 var ajax = new AjaxApi('getMessage.do', 'START='+'START',doxml1,messSend);
	 //actionmessage中配置，页面传值，执行完成的js,先开始时执行的
	 	 ajax.send();
		
	 //执行
	  }
	
      function doxml1(xml){
      messRecieve();	
      
      }
	
  </script>
  <script type="text/javascript">
function AjaxApi(){
  
  		var debug = false;
		
		if(debug)alert("new AjaxApi()");
		
		this.parameters = arguments;		//参数列表
		
		this.param = null;			//请求参数
		
		this.url = null;   			//请求地址
		
		AjaxApi.prototype.request = false;//Ajax 请求核心对象
		AjaxApi.prototype.returnfunction = null; 
		AjaxApi.prototype.starfunction = null; 
		
		this.intiEngine=function(){//初始化Ajax引擎
		
			if(window.XMLHttpRequest){
			
				AjaxApi.prototype.request = new XMLHttpRequest();
				
			}else if (window.ActiveXObject) { // IE浏览器
			
				try {
					AjaxApi.prototype.request = new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					try {
						AjaxApi.prototype.request = new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {alert('初始化Ajax引擎失败！');}
				}
			}
		}
		
		
		this.iniParams=function(){//初始化参数
		
			if(this.parameters.length == 4){
			
				this.url = this.parameters[0]
				
				this.param = this.parameters[1];
				
				AjaxApi.prototype.returnfunction = this.parameters[2];
				
				AjaxApi.prototype.starfunction = this.parameters[3];
			}
		}
		
		
		this.send=function(){//主方法
			var url2 = this.url + "?" + this.param;
			this.request.open("GET", url2 ,true);
			this.request.onreadystatechange=this.onChange;
			this.request.send(null);
		}
		
		
		this.onChange = function(){//调用方法
			var state = AjaxApi.prototype.request.readyState;
			
			if(state == 1){
			
				if(AjaxApi.prototype.starfunction!=null){
					AjaxApi.prototype.starfunction();
				}
			}
			if(state == 4){
			
				if(AjaxApi.prototype.request.status==200){
					var xmlDoc = AjaxApi.prototype.request.responseXML;  
			    	AjaxApi.prototype.returnfunction(xmlDoc);
				}
			}
		}
		
		this.intiEngine();//执行初始化
		this.iniParams();//
		
  }
</script>
	<!--  <script type="text/javascript" src="/TELLER2.0/myjs/change.js"> </script>-->
	<script type="text/javascript">
function sele() {
	form2.action = "getInvoiceMessage.do";
	form2.submit;
}
function messSend() {
	var frameBottom = parent.document.getElementById("messFrame");
	var messageWin = frameBottom.contentWindow;
	var sendMess = messageWin.document.getElementById("sendMess");
	var recieveMess = messageWin.document.getElementById("recieveMess");
	sendMess.innerHTML = '正在执行......';
	recieveMess.innerHTML = '';
}
function messRecieve(mess) {
	var frameBottom = parent.document.getElementById("messFrame");
	var messageWin = frameBottom.contentWindow;
	var sendMess = messageWin.document.getElementById("sendMess");
	var recieveMess = messageWin.document.getElementById("recieveMess");
	if (mess == null || mess == undefined) {
		mess = '0000';
	}
	sendMess.innerHTML = '执行完成';
	recieveMess.innerHTML = mess;
	//alert(1);
}
</script>

	<script type="text/javascript">
function $(name) {
	return document.getElementById(name).value;
}
function check() {
	var GLOBAL_ID = $("GLOBAL_ID");
	if (GLOBAL_ID == null || GLOBAL_ID == '') {
		alert('证件号不能为空');
		messRecieve();
		return false;
	}
	var glTxt = /^[0-9][0-9]{16}.{1}$/;
	if (!glTxt.test(GLOBAL_ID)) {
		alert('证件号格式不对！必须是18位');
		messRecieve();
		return false;
	}
	var GLOBAL_ID_AGAIN = $("GLOBAL_ID_AGAIN");
	if (GLOBAL_ID_AGAIN != GLOBAL_ID) {
		alert('两次输入证件号不一致！');
		messRecieve();
		return false;
	}

	var CH_CLIENT_NAME = $("CH_CLIENT_NAME");
	if (CH_CLIENT_NAME == '' || CH_CLIENT_NAME == null) {
		alert("中文名不能为空");
		messRecieve();
		return false;
	}

	var CLIENT_SHORT = $('CLIENT_SHORT');
	if (CLIENT_SHORT == '' || CLIENT_SHORT == null) {
		alert("客户简称不能为空！");
		messRecieve();
		return false;
	}
	var CLIENT_NO = $("CLIENT_NO");
	if (!(CLIENT_NO == '' || CLIENT_NO == null)) {
		alert("客户号不能输入！");
		messRecieve();
		return false;
	}
	return true;
}
</script>

	<SCRIPT language=javascript>
<!--
var displayBar=true;
function switchBar(obj){
	if (displayBar)
	{
		parent.frame.cols="0,*";
		displayBar=false;
		obj.value="打开左边管理菜单";
	}
	else{
		parent.frame.cols="195,*";
		displayBar=true;
		obj.value="关闭左边管理菜单";
	}
}

function fullmenu(url){
	if (url==null) {url = "admin_left.asp";}
	parent.leftFrame.location = url;
}

//-->
</SCRIPT>
	<body onLoad="messRecieve(${pageScope.reMess });">
		<form name="form1" method="POST" action="invoice.do"
			onSubmit="return check();">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr>
					<td width="17" height="29" valign="top"
						background="images/mail_leftbg.gif">
						<img src="images/left-top-right.gif" width="17" height="29" />
					</td>
					<td width="935" height="29" valign="top"
						background="images/content-bg.gif">
						<table width="100%" height="31" border="0" cellpadding="0"
							cellspacing="0" class="left_topbg" id="table2">
							<tr>
								<td height="31">
									<div class="titlebt">
										日终启动页
									</div>
								</td>
							</tr>
						</table>
					</td>
					<td width="16" valign="top" background="images/mail_rightbg.gif">
						<img src="images/nav-right-bg.gif" width="16" height="29" />
					</td>
				</tr>
				
			</table>
			
					
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>
					<tr>
						<th class="bg_tr" align="center" colspan="7" height="25">
							日终项目信息
						</th>
					</tr>
					<tr>
						<td width="15%" height="35" align="center" class="table">
							项目序号
						</td>
						<td width="15%" height="35" align="center" class="table">
							项目名称
						</td>
						<td width="15%" height="35" align="center" class="table">
							开始时间
						</td>
						<td width="14%" height="35" align="center" class="table">
							结束时间
						</td>
						<td width="13%" height="35" align="center" class="table">
							执行结果
						</td>

					</tr>
                     <table id="txtInvoiceInfo" cellspacing="1" cellpadding="2" width="99%"
				        align="center" border="0">
					
				</tbody>
			</table>

			<table class="table" cellspacing="1" cellpadding="2" width="100%"
				align="center" border="0">
				<tbody>
					<tr>
						<td width="50%" height="30" align="right"><input type="button" value="载入"  onclick="getLoading();"/></td>
						<td width="50%" height="30" align="right"><input type="button" value="启动"  onclick="getStart();"/></td>
						<td width="50%" height="30" align="right"><input type="button" value="刷新"  onclick="getData();"/></td>
					</tr>

				</tbody>
			</table>
		</form>
	</body>
</html>
