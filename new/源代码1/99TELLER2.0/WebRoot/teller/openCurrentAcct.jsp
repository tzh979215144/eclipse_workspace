<%@ page language="java" import="java.util.*" pageEncoding="GBK"
	isELIgnored="false"%>
<%@page import="org.zhoukan.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	OpenAccountBean reMess = (OpenAccountBean) request
			.getAttribute("openAccountBean");
	if (reMess != null) {
		pageContext.setAttribute("reMess", reMess.getRecieveMess());
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>账户开户</title>
		<link href="../mages/css1/css.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="js/calendar.js" ></script>  
		<script type="text/javascript" src="js/calendar-zh.js" ></script>
		<script type="text/javascript" src="js/calendar-setup.js"></script>
	</head>
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
function Registe(){
	window.location.href="clientRegiste.jsp";
}
function messSend(){
  	var frameBottom = parent.document.getElementById("messFrame");
  	var messageWin = frameBottom.contentWindow;
  	var sendMess = messageWin.document.getElementById("sendMess");
  	var recieveMess = messageWin.document.getElementById("recieveMess");
  	sendMess.innerHTML='正在执行......';
  	recieveMess.innerHTML='';
}
function messRecieve(mess){
	var frameBottom = parent.document.getElementById("messFrame");
  	var messageWin = frameBottom.contentWindow;
  	var sendMess = messageWin.document.getElementById("sendMess");
  	var recieveMess = messageWin.document.getElementById("recieveMess");
  	if(mess == null || mess==undefined){
  		mess='0000';
  	}
  	sendMess.innerHTML='执行完成';
  	recieveMess.innerHTML=mess;
  	//alert(1);
}
</script>

	<script type="text/javascript">
function $(name){
 return document.getElementById(name).value;
}
function check(){
	var GLOBAL_ID =  $("GLOBAL_ID");
	if(GLOBAL_ID == null || GLOBAL_ID ==''){
		alert('证件号不能为空');
		messRecieve();
		return false;
	}
	var glTxt =/^[0-9][0-9]{16}.{1}$/;
	if(!glTxt.test(GLOBAL_ID)){
		alert('证件号格式不对！必须是18位');
		messRecieve();
		return false;
	}
	var GLOBAL_ID_AGAIN = $("GLOBAL_ID_AGAIN");
	if(GLOBAL_ID_AGAIN != GLOBAL_ID){
		alert('两次输入证件号不一致！');
		messRecieve();
		return false;
	}
	
	var CH_CLIENT_NAME = $("CH_CLIENT_NAME");
	if(CH_CLIENT_NAME == '' || CH_CLIENT_NAME == null){
		alert("中文名不能为空");
		messRecieve();
		return false;
	}
	 
	var CLIENT_SHORT = $('CLIENT_SHORT');
	if(CLIENT_SHORT == '' || CLIENT_SHORT == null){
		alert("客户简称不能为空！");
		messRecieve();
		return false;
	}
	var CLIENT_NO = $("CLIENT_NO");
	if(!(CLIENT_NO =='' || CLIENT_NO == null)){
		alert("客户号不能输入！");
		messRecieve();
		return false;
	}
	return true;
}
</script>

	
	<script type="text/javascript">
  	  function getClient(value){  
		  var CLIENT_NO = value;
	if(CLIENT_NO == '' || CLIENT_NO == null){
		alert('客户号不能为空！');
		messRecieve();
		return false;
     	}
	 //ajax
	 var ajax = new AjaxApi('getMessage.do', 'CLIENT_NO='+CLIENT_NO,doxml,messSend);
	 //actionmessage中配置，页面传值，执行完成的js,先开始时执行的
	 	 ajax.send();
		
	 //执行
	  }
	
	  function doxml(xml){
		   messRecieve();	
	 var CLIENT_SHORT = xml.getElementsByTagName('CLIENT_SHORT')[0].text;	
	 var GLOBAL_ID = xml.getElementsByTagName('GLOBAL_ID')[0].text;
	 document.getElementById('client_short').value = CLIENT_SHORT;
	 document.getElementById('global_id').value = GLOBAL_ID;
	 
	 }
	 
	 function tgValue(xml,tgName){
	 	var val = xml.getElementsByTagName(tgName)[0];
	 	if(val == '' || val == null){
	 		return '';
	 	}
	 	return val.text;
	}
  </script>
	<body onLoad="messRecieve(${pageScope.reMess });">
		<form name="form1" method="POST" action="acctOpen.do"
			onSubmit="return check();">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>

					<tr>
						<th height="25" colspan="2" align="left" bgcolor="#006633"
							class="bg_tr">
							活期账户页面
						</th>
					</tr>
				</tbody>
			</table>
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>

					<tr>
						<th class="bg_tr" align="center" colspan="2" height="25">
							账号信息
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							账 号：
							<label>
								<input name="BASE_ACCT_NO" type="text" size="40"
									readonly="readonly"
									value="${requestScope.openAccountBean.BASE_ACCT_NO}" />
							</label>
						</td>
						<td class="td_bg" width="50%">
							账户类型：
							<label>
								<select name="ACCT_TYPE">
									<option value="1" selected="selected">
										个人
									</option>
									<option value="2">
										单位
									</option>
								</select>
								<a class="must">*</a>
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							客户号：
							<label>
								<input name="CLIENT_NO" id="client_no" type="text" size="40"
									maxlength="38" onblur="getClient(this.value);"
									value="${requestScope.openAccountBean.CLIENT_NO}" />
							</label>
						</td>
						<td class="td_bg" width="50%">
							证件类型：
							<label>
								<select name="GLOBAL_ID_TYPE">
									<option value="identity_card" selected="selected">
										身份证
									</option>
									<option value="military_card">
										军人证
									</option>
									<option value="passport">
										护照
									</option>
								</select>
								<a class="must">*</a>
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="46">
							证件号码：
							<label>
								<input name="GLOBAL_ID" id="global_id" type="text" size="38"
									maxlength="38"
									value="${requestScope.openAccountBean.GLOBAL_ID}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="46">
							客户简称：
							<label>
								<input name="CLIENT_SHORT" id="client_short" type="text"
									size="38" maxlength="38"
									value="${requestScope.openAccountBean.CLIENT_SHORT}" />
							</label>
						</td>
					</tr>

					<tr>
						<td width="50%" align="center" class="td_bg" colspan="2">
							<label>
								<input type="button" name="Submit" value="建立客户信息"
									onclick="Registe()" />
							</label>
						</td>
					</tr>

				</tbody>
			</table>
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>
					<tr>
						<th class="bg_tr" align="center" colspan="2" height="25">
							账户明细
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							中文名：
							<label>
								<input name="CH_ACCT_NAME" type="text" size="40" maxlength="40"
									value="${requestScope.openAccountBean.CH_ACCT_NAME}" />
							</label>
						</td>
						<td width="50%" class="td_bg">
							<label>
								英文名：
								<input name="ALT_ACCT_NAME" type="text" size="40" maxlength="40"
									value="${requestScope.openAccountBean.ALT_ACCT_NAME}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								客户类型：
								<select name="CLIENT_TYPE">
									<option value="COM" selected="selected">
										普通客户
									</option>
									<option value="VIP">
										VIP客户
									</option>
									<option value="INT">
										银行员工
									</option>
								</select>
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label>
								客户经理编号：
								<input name="OFFICER_ID" type="text" size="40" maxlength="40"
									value="${requestScope.openAccountBean.OFFICER_ID}" />
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								开户时间：<input type="text" id="EntTime" name="ACCT_OPEN_DATE" onclick="return showCalendar('EntTime', 'y-mm-dd');" value="${requestScope.openAccountBean.ACCT_OPEN_DATE}" />
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label>
								账户状态：
								<select name="ACCT_STATUS">
									<option value="A" selected="selected">
										活动
									</option>
									<option value="B">
										销户
									</option>
									<option value="C">
										睡眠户
									</option>
									<option value="D">
										充公户
									</option>
									<option value="E">
										不活动
									</option>
									<option value="F">
										新建
									</option>
									<option value="G">
										已清除
									</option>
									<option value="H">
										待激活
									</option>
								</select>
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								账户币种：
								<select name="CCY">
									<option value="CNY" selected="selected">
										人民币
									</option>
									<option value="MY">
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

						<td class="td_bg" width="50%">
							<label>
								余额类型：
								<select name="ACTUAL_OR_LEDGER_BAL">
									<option value="A" selected="selected">
										可用
									</option>
									<option value="L">
										账面
									</option>
								</select>
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								支取方式：
								<select name="STMT_PBK">
									<option value="P" selected="selected">
										存折
									</option>
									<option value="S">
										对照单
									</option>
								</select>
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label></label>
							<label>
								账户属性：
								<select name="ACCT_NATURE">
									<option value="B" selected="selected">
										基本户
									</option>
									<option value="C">
										一般户
									</option>
									<option value="S">
										专用户
									</option>
									<option value="T">
										临时户
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								账户限制标志：
								<select name="RESTRAINT_PRESENT">
									<option value="N" selected="selected">
										否
									</option>
									<option value="Y">
										是
									</option>
								</select>
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label></label>
							<label>
								存款类型：
								<select name="DEPOSIT_TYPE">
									<option value="T" selected="selected">
										定期账户
									</option>
									<option value="C">
										往来账户
									</option>
									<option value="S">
										储蓄账户
									</option>
									<option value="A">
										AIO账户
									</option>
								</select>
							</label>
						</td>
					</tr>


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
