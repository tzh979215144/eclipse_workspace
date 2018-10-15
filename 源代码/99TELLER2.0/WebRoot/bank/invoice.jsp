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
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>本息通知单</title>
		<link href="images/skin.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="teller/css/form-field-tooltip.css"  media="screen" type="text/css">
		<script type="text/javascript" src="teller/js/rounded-corners.js"></script>
		<script type="text/javascript" src="teller/js/form-field-tooltip.js"></script>
		<script type="text/javascript" src="/TELLER2.0/My97DatePicker/WdatePicker.js"></script>
	</head>
<script type="text/javascript">
  	  function getInvoice(){ 
		var DD_NO5=document.getElementById('dd_no5').value;
		var LOAN_NO5=document.getElementById('loan_no5').value;
     	
    if(DD_NO5 == '' || DD_NO5 == null){
		alert('发放号不能为空！');
		messRecieve();
		return false;
     	}
    if(LOAN_NO5 == '' || LOAN_NO5 == null){
		alert('贷款号不能为空！');
		messRecieve();
		return false;
     	}
	 //ajax
	 var ajax = new AjaxApi('getMessage.do', 'LOAN_NO5='+LOAN_NO5+'&DD_NO5='+DD_NO5,doxml,messSend);
	 //actionmessage中配置，页面传值，执行完成的js,先开始时执行的
	 	 ajax.send();
		
	 //执行
	  }
          function getFrontInvoice()
         {
            var DD_NO51=document.getElementById('dd_no').value;
		    var LOAN_NO51=document.getElementById('loan_no').value;
            var INVOICE_TYPE=document.getElementById('invoice_type').value;
    if(INVOICE_TYPE == '' || INVOICE_TYPE == null){
		alert('发放号不能为空！');
		messRecieve();
		return false;
     	}
    if(DD_NO51 == '' || DD_NO51 == null){
		alert('发放号不能为空！');
		messRecieve();
		return false;
     	}
    if(LOAN_NO51 == '' || LOAN_NO51 == null){
		alert('贷款号不能为空！');
		messRecieve();
		return false;
     	}
	 //ajax
	 var ajax = new AjaxApi('getMessage.do', 'LOAN_NO51='+LOAN_NO51+'&DD_NO51='+DD_NO51+'&INVOICE_TYPE='+INVOICE_TYPE,doxml1,messSend);
	 //actionmessage中配置，页面传值，执行完成的js,先开始时执行的
	 	 ajax.send();
		
	 //执行
         }
          function doxml1(xml){
         messRecieve();	
	    // var LOAN_NO = xml.getElementsByTagName('LOAN_NO51')[0].text;	
	    // var DD_NO = xml.getElementsByTagName('DD_NO51')[0].text;
         var INT_RATE = xml.getElementsByTagName('INT_RATE')[0].text;
         var DUE_DATE = xml.getElementsByTagName('DUE_DATE')[0].text;
         var INT_FROM = xml.getElementsByTagName('INT_FROM')[0].text;
         var BILLED_AMT = xml.getElementsByTagName('BILLED_AMT')[0].text;
	    // document.getElementById('LOAN_NO').value = LOAN_NO;
	    // document.getElementById('DD_NO').value = DD_NO;
         document.getElementById('INT_RATE').value = INT_RATE;
         document.getElementById('DUE_DATE').value = DUE_DATE;
         document.getElementById('INT_FROM').value = INT_FROM;
         document.getElementById('BILLED_AMT').value = BILLED_AMT;
	 
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
	  x=xml.documentElement.getElementsByTagName("Invoice");
      var tab=document.getElementById('txtInvoiceInfo');
      for (i=0;i<x.length;i++)
      {
      var newTr =tab.insertRow();
      var newTd1 = newTr.insertCell();
      xx=x[i].getElementsByTagName("DEBIT_NOTE_NO");
      newTd1.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";
      
      var newTd2 = newTr.insertCell();  
      xx=x[i].getElementsByTagName("INVOICE_TYPE");
      newTd2.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";

      var newTd3 = newTr.insertCell();  
      xx=x[i].getElementsByTagName("INT_FROM");
      newTd3.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";
        
      var newTd4 = newTr.insertCell();  
      xx=x[i].getElementsByTagName("DUE_DATE");
      newTd4.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";
        
        var newTd5 = newTr.insertCell();  
      xx=x[i].getElementsByTagName("INT_RATE");
      newTd5.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";
        
        var newTd6 = newTr.insertCell();  
      xx=x[i].getElementsByTagName("CCY");
      newTd6.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";
        
        var newTd7 = newTr.insertCell();  
      xx=x[i].getElementsByTagName("BILLED_AMT");
      newTd7.innerHTML = "<input type='text' value='"+xx[0].firstChild.nodeValue+"'/>";
      
      }
	
	 }
	 
	 function tgValue(xml,tgName){
	 	var val = xml.getElementsByTagName(tgName)[0];
	 	if(val == '' || val == null){
	 		return '';
	 	}
	 	return val.text;
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
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr>
					<td width="935" height="29" valign="top"
						background="images/content-bg.gif">
						<table width="100%" height="31" border="0" cellpadding="0"
							cellspacing="0" class="left_topbg" id="table2">
							<tr>
								<td height="31">
									<div class="titlebt">
										本息通知单
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
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
					<tr class="left_txt" align="left">
						<th  height="25">
							通知单信息
						</th>
						
					</tr>
		          <tr>
		            <td height="20"><table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
		              <tr>
		                <td></td>
		              </tr>
		            </table></td>
		          </tr>	
		    </table> 			
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>
					<tr>
						<td class="td_bg" width="50%" height="35">
							通知单号：
							<label>
								<input name="DEBIT_NOTE_NO" type="text" size="40"
									readonly="readonly"
									value="${requestScope.invoiceBean.DEBIT_NOTE_NO}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							贷 款 号：
							<label>
								<input name="LOAN_NO" type="text" size="40"
									value="${requestScope.invoiceBean.LOAN_NO}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								发 放 号：
								<input name="DD_NO" type="text" size="40" maxlength="40"
                                                                        onblur="getFrontInvoice();"
									value="${requestScope.invoiceBean.DD_NO}" />
							</label>
						</td>
						<td class="td_bg" width="50%"></td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								币 种 ：
								<select name="CCY">
									<option value="RMB" selected="selected">
										人民币
									</option>
									<option value="￥">
										美元
									</option>
									<option value="RY">
										日元
									</option>
									<option value="PON">
										英镑
									</option>
								</select>
							</label>
						</td>

						<td class="td_bg" width="50%" height="35">
							<label>
								开始计息日：

								<input type="text" name="INT_FROM" size="40" maxlength="40"
									value="${requestScope.invoiceBean.INT_FROM}">
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								利 率：
								<input name="INT_RATE" type="text" size="40" maxlength="40"
									value="${requestScope.invoiceBean.INT_RATE}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								金额类型：

								<select name="INVOICE_TYPE">
									<option value="PRL" selected="selected">
										本金
									</option>
									<option value="NT">
										利息
									</option>
									<option value="ODP">
										罚息
									</option>
									<option value="ODL">
										复利
									</option>
								</select>
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%">
							<label>
								到 期 日：

								<input type="text" name="DUE_DATE" size="40" maxlength="40"
									value="${requestScope.invoiceBean.DUE_DATE}">
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label>
								出单金额：

								<input type="text" name="BILLED_AMT" size="40" maxlength="40"
									value="${requestScope.invoiceBean.BILLED_AMT}">
							</label>
						</td>
					</tr>


				</tbody>
			</table>
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
					<tr class="left_txt" align="left">
						<th  height="25">
							通知单查询
						</th>
						
					</tr>
		          <tr>
		            <td height="20"><table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
		              <tr>
		                <td></td>
		              </tr>
		            </table></td>
		          </tr>	
		    </table> 			
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								发 放 号：
								<input name="DD_NO5" id="dd_no5" type="text" size="40" maxlength="40"
									value="${requestScope.invoiceBean.DD_NO}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							贷 款 号：
							<label>
								<input name="LOAN_NO5" id="loan_no5" type="text" size="40"
									value="${requestScope.invoiceBean.LOAN_NO}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35"></td>
						<td width="50%" height="30" align="left"><input type="button" value="查询"  onclick="getInvoice();"/></td>
					</tr>
				</tbody>
			</table>
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
					<tr class="left_txt" align="left">
						<th  height="25">
							查询信息
						</th>
						
					</tr>
		          <tr>
		            <td height="20"><table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
		              <tr>
		                <td></td>
		              </tr>
		            </table></td>
		          </tr>	
		    </table> 			
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>
					<tr>
						<td width="15%" height="35" align="center" class="left_txt2">
							通知单号
						</td>
						<td width="15%" height="35" align="center" class="left_txt2">
							金额类型
						</td>
						<td width="15%" height="35" align="center" class="left_txt2">
							开始计息日
						</td>
						<td width="14%" height="35" align="center" class="left_txt2">
							终止日期
						</td>
						<td width="13%" height="35" align="center" class="left_txt2">
							利率（%）
						</td>
						<td width="13%" height="35" align="center" class="left_txt2">
							币种
						</td>
						<td width="14%" height="35" align="center" class="left_txt2">
							出单金额
						</td>
					</tr>
                     <table id="txtInvoiceInfo" cellspacing="1" cellpadding="2" width="99%"
				        align="center" border="0">
					
				</tbody>
			</table>

			<table class="left_txt2" cellspacing="1" cellpadding="2" width="100%"
				align="center" border="0">
				<tbody>
					<tr>
						<td width="50%" height="30" align="right">
							<input type="submit" value="提交" onclick="messSend();" />
						</td>
						<td width="50%" height="30">
							<input type="reset" value="取消" />
						</td>
					</tr>

				</tbody>
			</table>
		</form>
	</body>
</html>
