<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="org.zhoukan.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	DrawDrowBean reMess = (DrawDrowBean) request
			.getAttribute("DrawDrowBean");
	if (reMess != null) {
		pageContext.setAttribute("reMess", reMess.getRecieveMess());
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>账户开户</title>
		<link href="mages/css1/css.css" rel="stylesheet" type="text/css">
	</head>
	<script type="text/javascript">
function getLOAN(value) {
	var LOAN_NO = value;
	if (LOAN_NO == '' || LOAN_NO == null) {
		alert('贷款号不能为空！');
		messRecieve();
		return false;
	}
	//ajax
	var ajax = new AjaxApi('getMessage.do', 'LOAN_NO=' + LOAN_NO, doxml,
			messSend);
	//actionmessage中配置，页面传值，执行完成的js,先开始时执行的
	ajax.send();

	//执行
}
function getRate(value) {
	var INT_BASIS = value;
	if (INT_BASIS == '' || INT_BASIS == null) {
		alert('利息利率代码不能为空！');
		messRecieve();
		return false;
	}
	//ajax
	var ajax = new AjaxApi('getMessage.do', 'INT_BASIS=' + INT_BASIS, doxml2,
			messSend);
	//actionmessage中配置，页面传值，执行完成的js,先开始时执行的
	ajax.send();

	//执行
}
function doxml2(xml) {
	messRecieve();

	var INT_BASIS_RATE = tgValue(xml, 'INT_BASIS_RATE');
	var INT_RATE = tgValue(xml, 'INT_RATE');
	var INT_SPREAD = tgValue(xml, 'INT_SPREAD');
	document.getElementById('INT_BASIS_RATE').value = INT_BASIS_RATE;
	document.getElementById('INT_RATE').value = INT_RATE;
	document.getElementById('INT_SPREAD').value = INT_SPREAD;
}
function getRate1(value) {
	var PRI_PLTY_BASIS = value;
	if (PRI_PLTY_BASIS == '' || PRI_PLTY_BASIS == null) {
		alert('罚息利率代码不能为空！');
		messRecieve();
		return false;
	}
	//ajax
	var ajax = new AjaxApi('getMessage.do', 'PRI_PLTY_BASIS=' + PRI_PLTY_BASIS,
			doxml3, messSend);
	//actionmessage中配置，页面传值，执行完成的js,先开始时执行的
	ajax.send();

	//执行
}
function doxml3(xml) {
	messRecieve();

	var PRI_PLTY_ABS = tgValue(xml, 'PRI_PLTY_ABS');
	var PRI_PLTY_SPREAD = tgValue(xml, 'PRI_PLTY_SPREAD');
	var PRI_PLTY_RATE = tgValue(xml, 'PRI_PLTY_RATE');
	document.getElementById('PRI_PLTY_ABS').value = PRI_PLTY_ABS;
	document.getElementById('PRI_PLTY_SPREAD').value = PRI_PLTY_SPREAD;
	document.getElementById('PRI_PLTY_RATE').value = PRI_PLTY_RATE;
}
function getRate2(value) {
	var INT_PLTY_BASIS = value;
	if (INT_PLTY_BASIS == '' || INT_PLTY_BASIS == null) {
		alert('复利利率代码不能为空！');
		messRecieve();
		return false;
	}
	//ajax
	var ajax = new AjaxApi('getMessage.do', 'INT_PLTY_BASIS=' + INT_PLTY_BASIS,
			doxml4, messSend);
	//actionmessage中配置，页面传值，执行完成的js,先开始时执行的
	ajax.send();

	//执行
}
function doxml4(xml) {
	messRecieve();

	var INT_PLTY_ABS = tgValue(xml, 'INT_PLTY_ABS');
	var INT_PLTY_SPREAD = tgValue(xml, 'INT_PLTY_SPREAD');
	var INT_PLTY_RATE = tgValue(xml, 'INT_PLTY_RATE');
	document.getElementById('INT_PLTY_ABS').value = INT_PLTY_ABS;
	document.getElementById('INT_PLTY_SPREAD').value = INT_PLTY_SPREAD;
	document.getElementById('INT_PLTY_RATE').value = INT_PLTY_RATE;
}

function doxml(xml) {
	messRecieve();
	//var  LOAN_AMT= xml.getElementsByTagName('LOAN_AMT')[0].text;	
	//var AV_AMT = xml.getElementsByTagName('LOAN_AMT')[0].text;
	//var BORROWER = xml.getElementsByTagName('BORROWER')[0].text;
	//var LEANDER = xml.getElenmentsByTagName('LENDER')[0].text;
	//var MATURITY = xml.getElenmentsByTagName('MATURITY')[0].text;
	var LOAN_AMT = tgValue(xml, 'LOAN_AMT');
	var AV_AMT = tgValue(xml, 'AV_AMT');
	var BORROWER = tgValue(xml, 'BORROWER');
	var LENDER = tgValue(xml, 'LENDER');

	document.getElementById('LOAN_AMT').value = LOAN_AMT;
	document.getElementById('AV_AMT').value = AV_AMT;
	document.getElementById('BORROWER').value = BORROWER;
	document.getElementById('LENDER').value = LENDER;

}

function tgValue(xml, tgName) {
	var val = xml.getElementsByTagName(tgName)[0].text;
	if (val == '' || val == null) {
		return '';
	}
	return val;
}
</script>
	<script type="text/javascript">
function AjaxApi() {

	var debug = false;

	if (debug)
		alert("new AjaxApi()");

	this.parameters = arguments; //参数列表

	this.param = null; //请求参数

	this.url = null; //请求地址

	AjaxApi.prototype.request = false;//Ajax 请求核心对象
	AjaxApi.prototype.returnfunction = null;
	AjaxApi.prototype.starfunction = null;

	this.intiEngine = function() {//初始化Ajax引擎

		if (window.XMLHttpRequest) {

			AjaxApi.prototype.request = new XMLHttpRequest();

		} else if (window.ActiveXObject) { // IE浏览器

			try {
				AjaxApi.prototype.request = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					AjaxApi.prototype.request = new ActiveXObject(
							"Microsoft.XMLHTTP");
				} catch (e) {
					alert('初始化Ajax引擎失败！');
				}
			}
		}
	}

	this.iniParams = function() {//初始化参数

		if (this.parameters.length == 4) {

			this.url = this.parameters[0]

			this.param = this.parameters[1];

			AjaxApi.prototype.returnfunction = this.parameters[2];

			AjaxApi.prototype.starfunction = this.parameters[3];
		}
	}

	this.send = function() {//主方法
		var url2 = this.url + "?" + this.param;
		this.request.open("GET", url2, true);
		this.request.onreadystatechange = this.onChange;
		this.request.send(null);
	}

	this.onChange = function() {//调用方法
		var state = AjaxApi.prototype.request.readyState;

		if (state == 1) {

			if (AjaxApi.prototype.starfunction != null) {
				AjaxApi.prototype.starfunction();
			}
		}
		if (state == 4) {

			if (AjaxApi.prototype.request.status == 200) {
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
		<form name="form1" method="POST" action="drawDrow.do"
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
										贷款发放
									</div>
								</td>
							</tr>
						</table>
					</td>
					<td width="16" valign="top" background="images/mail_rightbg.gif">
						<img src="images/nav-right-bg.gif" width="16" height="29" />
					</td>
				</tr>

				<tbody>

					<tr>
						<th height="25" colspan="2" align="left" bgcolor="#006633"
							class="bg_tr">
							贷款发放页面
						</th>
					</tr>
				</tbody>
			</table>
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>

					<tr>
						<th class="bg_tr" align="center" colspan="2" height="25">
							发放信息
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							发放号：
							<label>
								<input name="DD_NO" type="text" size="40" readonly="readonly"
									value="${requestScope.DrawDrowBean.DD_NO}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							贷款号：
							<label>
								<input name="LOAN_NO" type="text" size="40"
									onblur="getLOAN(this.value);"
									value="${requestScope.DrawDrowBean.LOAN_NO}" />
							</label>
						</td>
					</tr>



				</tbody>
			</table>
			<table class="table" cellspacing="1" cellpadding="2" width="100%"
				align="center" border="0">
				<tbody>
					<tr>
						<th class="bg_tr" align="center" colspan="2" height="25">
							账户信息
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								贷款币种：
								<select name="LOAN_CCY">
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
						<td width="50%" class="td_bg">
							<label>
								贷款额度：
								<input name="LOAN_AMT" type="text" size="40" maxlength="40"
									value="${requestScope.DrawDrowBean.LOAN_AMT}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								可用金额：
								<input type="text" name="AV_AMT" size="40" maxlength="40"
									value="${requestScope.DrawDrowBean.AV_AMT}" />
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label>
								负 责 人：
								<input name="OFFICER_NAME" type="text" size="40" maxlength="40"
									value="${sessionScope.loginBean.USER_NAME}" />
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								发放币种：
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
						<td class="td_bg" width="50%">
							<label>
								贷 款 人：
								<input type="text" name="LENDER" size="40" maxlength="40"
									value="${requestScope.DrawDrowBean.LENDER}">
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								贷款人客户号：

								<input type="text" name="BORROWER" size="40" maxlength="40"
									value="${requestScope.DrawDrowBean.BORROWER}">
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label>
								到 期 日：

								<input type="text" name="MATURITY" size="40" maxlength="40"
									value="${requestScope.DrawDrowBean.MATURITY}">
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<input name="OPER_ID" type="hidden"
								value="${sessionScope.loginBean.USER_NAME }" />
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								发放日期：

								<input type="text" name="DD_DATE" size="40" maxlength="40"
									value="${requestScope.DrawDrowBean.DD_DATE}">
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label>
								发放金额：

								<input type="text" name="DD_AMT" size="40" maxlength="40"
									value="${requestScope.DrawDrowBean.DD_AMT}">
							</label>
						</td>
					</tr>
					<tr>
						<th class="bg_tr" align="center" colspan="2" height="25">
							利息利率
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								利息基准代号：
								<input name="INT_BASIS" type="text" size="40"
									onblur="getRate(this.value);"
									value="${requestScope.DrawDrowBean.INT_BASIS}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								基准利率：
								<input name="INT_BASIS_RATE" type="text" size="40"
									value="${requestScope.DrawDrowBean.INT_BASIS_RATE}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								利差百分比：
								<input name="INT_SPREAD" type="text" size="40"
									value="${requestScope.DrawDrowBean.INT_SPREAD}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								实际利率：
								<input name="INT_RATE" type="text" size="40"
									value="${requestScope.DrawDrowBean.INT_RATE}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								基准月天数：
								<select name="MONTH_BASIS_INT">
									<option value="ACT" selected="selected">
										实际天数
									</option>
									<option value="30A">
										美式30天
									</option>
									<option value="30E">
										欧式30天
									</option>
								</select>
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								基准年天数：
								<select name="YEAR_BASIS_INT">
									<option value="360" selected="selected">
										360天
									</option>
									<option value="365">
										365天
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<th class="bg_tr" align="center" colspan="2" height="25">
							罚息利率
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								利息基准代号：
								<input name="PRI_PLTY_BASIS" type="text" size="40"
									onblur="getRate1(this.value);"
									value="${requestScope.DrawDrowBean.PRI_PLTY_BASIS}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								基准利率：
								<input name="PRI_PLTY_ABS" type="text" size="40"
									value="${requestScope.DrawDrowBean.PRI_PLTY_ABS}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								利差百分比：
								<input name="PRI_PLTY_SPREAD" type="text" size="40"
									value="${requestScope.DrawDrowBean.PRI_PLTY_SPREAD}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								实际利率：
								<input name="PRI_PLTY_RATE" type="text" size="40"
									value="${requestScope.DrawDrowBean.PENALTY_ODI_RATE_TYPE}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								基准月天数：
								<select name="MONTH_BASIS_PEN">
									<option value="ACT" selected="selected">
										实际天数
									</option>
									<option value="30A">
										美式30天
									</option>
									<option value="30E">
										欧式30天
									</option>
								</select>
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								基准年天数：
								<select name="YEAR_BASIS_PEN">
									<option value="360" selected="selected">
										360天
									</option>
									<option value="365">
										365天
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<th class="bg_tr" align="center" colspan="2" height="25">
							复息利率
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								利息基准代号：
								<input name="INT_PLTY_BASIS" type="text" size="40"
									onblur="getRate2(this.value);"
									value="${requestScope.DrawDrowBean.INT_PLTY_RATE}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								基准利率：
								<input name="INT_PLTY_ABS" type="text" size="40"
									value="${requestScope.DrawDrowBean.INT_PLTY_RATE}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								利差百分比：
								<input name="INT_PLTY_SPREAD" type="text" size="40"
									value="${requestScope.DrawDrowBean.INT_PLTY_SPREAD}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								实际利率：
								<input name="INT_PLTY_RATE" type="text" size="40"
									value="${requestScope.DrawDrowBean.PENALTY_ODI_RATE_TYPE1}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								基准月天数：
								<select name="MONTH_BASIS_PLTY">
									<option value="ACT" selected="selected">
										实际天数
									</option>
									<option value="30A">
										美式30天
									</option>
									<option value="30E">
										欧式30天
									</option>
								</select>
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								基准年天数：
								<select name="YEAR_BASIS_PLTY">
									<option value="360" selected="selected">
										360天
									</option>
									<option value="365">
										365天
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
