<%@ page language="java" import="java.util.*" pageEncoding="GBK" contentType="text/html; charset=GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  function AjaxApi(){
	
	var debug = false;
	
	if(debug)alert("new AjaxApi()");
	
	//this.params = "";//����
	
	AjaxApi.prototype.request = false;//Ajax ������Ķ���
	AjaxApi.prototype.returnfunction = null; 
	AjaxApi.prototype.starfunction = null; 
	//this.requestURL="";
	
	/**
	 * ��ʼ��Ajax����
	 */
	this.setReturnfun=function(fuc){
	AjaxApi.prototype.returnfunction=fuc;
	}
	
	this.setStarfun=function(fuc){
	AjaxApi.prototype.starfunction=fuc;
	}
	
	this.initEngine = function(){
		if(debug)alert("AjaxApi().initEngine()");
		alert("��ʼ��Ajax����");
		if(window.XMLHttpRequest){
			AjaxApi.prototype.request = new XMLHttpRequest();
		}else if (window.ActiveXObject) { // IE�����
			try {
				AjaxApi.prototype.request = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					AjaxApi.prototype.request = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {alert('��ʼ��Ajax����ʧ�ܣ�');}
			}
		}
	}
	
	this.initEngine();
	
	this.send=function(url,params){
		alert("Ajax���ͣ�");
		this.request = AjaxApi.prototype.request;
		this.url = url + "?" + params;
		this.request.open("GET", this.url ,true);
		this.request.onreadystatechange=this.onChange
		this.request.send(null);
	}
	
	this.onChange = function(){
		var state = AjaxApi.prototype.request.readyState;
		if(state == 1){
			if(AjaxApi.prototype.starfunction!=null){
				AjaxApi.prototype.starfunction();
			}
		}
		if(state == 4){
		alert("Ajax״̬Ϊ4��");
			if(AjaxApi.prototype.request.status==200){
				var docXMl = AjaxApi.prototype.request.responseXML;
				alert("Ajax������ɣ�");
				AjaxApi.prototype.returnfunction(docXMl);
			}
		}
	}
}
  </script>
   
  <script type="text/javascript">
  function test(){
  alert(1);
  var ajaxx = new AjaxApi();
  ajaxx.setReturnfun(doit);
  ajaxx.send('loginDown.do','mess=nihao');
  }
  function doit(docXml){
  //alert(docXml.getElementsByTagName('mess').[0].text);
  alert(docXml.text);
  
  }
  </script>
  <body>
    This is my JSP page. <br>
    <input type="button" value="ajax" onclick="test();"/>
    <input type="button" value="ajax2" onclick="test2();"/>
    <hr/>
    <%System.out.print(request.getParameter("RECEPT_MESSAGE")); %>
    <br/>
    <%=request.getParameter("DRAWDROW_MESSAGE") %>
  </body>
</html>
