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
		<title>�˻�����</title>
		<link href="mages/css1/css.css" rel="stylesheet" type="text/css">
	</head>
	<script type="text/javascript">
function getLOAN(value) {
	var LOAN_NO = value;
	if (LOAN_NO == '' || LOAN_NO == null) {
		alert('����Ų���Ϊ�գ�');
		messRecieve();
		return false;
	}
	//ajax
	var ajax = new AjaxApi('getMessage.do', 'LOAN_NO=' + LOAN_NO, doxml,
			messSend);
	//actionmessage�����ã�ҳ�洫ֵ��ִ����ɵ�js,�ȿ�ʼʱִ�е�
	ajax.send();

	//ִ��
}
function getRate(value) {
	var INT_BASIS = value;
	if (INT_BASIS == '' || INT_BASIS == null) {
		alert('��Ϣ���ʴ��벻��Ϊ�գ�');
		messRecieve();
		return false;
	}
	//ajax
	var ajax = new AjaxApi('getMessage.do', 'INT_BASIS=' + INT_BASIS, doxml2,
			messSend);
	//actionmessage�����ã�ҳ�洫ֵ��ִ����ɵ�js,�ȿ�ʼʱִ�е�
	ajax.send();

	//ִ��
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
		alert('��Ϣ���ʴ��벻��Ϊ�գ�');
		messRecieve();
		return false;
	}
	//ajax
	var ajax = new AjaxApi('getMessage.do', 'PRI_PLTY_BASIS=' + PRI_PLTY_BASIS,
			doxml3, messSend);
	//actionmessage�����ã�ҳ�洫ֵ��ִ����ɵ�js,�ȿ�ʼʱִ�е�
	ajax.send();

	//ִ��
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
		alert('�������ʴ��벻��Ϊ�գ�');
		messRecieve();
		return false;
	}
	//ajax
	var ajax = new AjaxApi('getMessage.do', 'INT_PLTY_BASIS=' + INT_PLTY_BASIS,
			doxml4, messSend);
	//actionmessage�����ã�ҳ�洫ֵ��ִ����ɵ�js,�ȿ�ʼʱִ�е�
	ajax.send();

	//ִ��
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

	this.parameters = arguments; //�����б�

	this.param = null; //�������

	this.url = null; //�����ַ

	AjaxApi.prototype.request = false;//Ajax ������Ķ���
	AjaxApi.prototype.returnfunction = null;
	AjaxApi.prototype.starfunction = null;

	this.intiEngine = function() {//��ʼ��Ajax����

		if (window.XMLHttpRequest) {

			AjaxApi.prototype.request = new XMLHttpRequest();

		} else if (window.ActiveXObject) { // IE�����

			try {
				AjaxApi.prototype.request = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					AjaxApi.prototype.request = new ActiveXObject(
							"Microsoft.XMLHTTP");
				} catch (e) {
					alert('��ʼ��Ajax����ʧ�ܣ�');
				}
			}
		}
	}

	this.iniParams = function() {//��ʼ������

		if (this.parameters.length == 4) {

			this.url = this.parameters[0]

			this.param = this.parameters[1];

			AjaxApi.prototype.returnfunction = this.parameters[2];

			AjaxApi.prototype.starfunction = this.parameters[3];
		}
	}

	this.send = function() {//������
		var url2 = this.url + "?" + this.param;
		this.request.open("GET", url2, true);
		this.request.onreadystatechange = this.onChange;
		this.request.send(null);
	}

	this.onChange = function() {//���÷���
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

	this.intiEngine();//ִ�г�ʼ��
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
	sendMess.innerHTML = '����ִ��......';
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
	sendMess.innerHTML = 'ִ�����';
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
		alert('֤���Ų���Ϊ��');
		messRecieve();
		return false;
	}
	var glTxt = /^[0-9][0-9]{16}.{1}$/;
	if (!glTxt.test(GLOBAL_ID)) {
		alert('֤���Ÿ�ʽ���ԣ�������18λ');
		messRecieve();
		return false;
	}
	var GLOBAL_ID_AGAIN = $("GLOBAL_ID_AGAIN");
	if (GLOBAL_ID_AGAIN != GLOBAL_ID) {
		alert('��������֤���Ų�һ�£�');
		messRecieve();
		return false;
	}

	var CH_CLIENT_NAME = $("CH_CLIENT_NAME");
	if (CH_CLIENT_NAME == '' || CH_CLIENT_NAME == null) {
		alert("����������Ϊ��");
		messRecieve();
		return false;
	}

	var CLIENT_SHORT = $('CLIENT_SHORT');
	if (CLIENT_SHORT == '' || CLIENT_SHORT == null) {
		alert("�ͻ���Ʋ���Ϊ�գ�");
		messRecieve();
		return false;
	}
	var CLIENT_NO = $("CLIENT_NO");
	if (!(CLIENT_NO == '' || CLIENT_NO == null)) {
		alert("�ͻ��Ų������룡");
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
		obj.value="����߹���˵�";
	}
	else{
		parent.frame.cols="195,*";
		displayBar=true;
		obj.value="�ر���߹���˵�";
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
										�����
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
							�����ҳ��
						</th>
					</tr>
				</tbody>
			</table>
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>

					<tr>
						<th class="bg_tr" align="center" colspan="2" height="25">
							������Ϣ
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							���źţ�
							<label>
								<input name="DD_NO" type="text" size="40" readonly="readonly"
									value="${requestScope.DrawDrowBean.DD_NO}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							����ţ�
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
							�˻���Ϣ
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								������֣�
								<select name="LOAN_CCY">
									<option value="RMB" selected="selected">
										�����
									</option>
									<option value="��">
										��Ԫ
									</option>
									<option value="RY">
										��Ԫ
									</option>
									<option value="PON">
										Ӣ��
									</option>
								</select>
							</label>
						</td>
						<td width="50%" class="td_bg">
							<label>
								�����ȣ�
								<input name="LOAN_AMT" type="text" size="40" maxlength="40"
									value="${requestScope.DrawDrowBean.LOAN_AMT}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								���ý�
								<input type="text" name="AV_AMT" size="40" maxlength="40"
									value="${requestScope.DrawDrowBean.AV_AMT}" />
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label>
								�� �� �ˣ�
								<input name="OFFICER_NAME" type="text" size="40" maxlength="40"
									value="${sessionScope.loginBean.USER_NAME}" />
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								���ű��֣�
								<select name="CCY">
									<option value="RMB" selected="selected">
										�����
									</option>
									<option value="��">
										��Ԫ
									</option>
									<option value="RY">
										��Ԫ
									</option>
									<option value="PON">
										Ӣ��
									</option>
								</select>
							</label>
						</td>
						<td class="td_bg" width="50%">
							<label>
								�� �� �ˣ�
								<input type="text" name="LENDER" size="40" maxlength="40"
									value="${requestScope.DrawDrowBean.LENDER}">
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								�����˿ͻ��ţ�

								<input type="text" name="BORROWER" size="40" maxlength="40"
									value="${requestScope.DrawDrowBean.BORROWER}">
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label>
								�� �� �գ�

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
								�������ڣ�

								<input type="text" name="DD_DATE" size="40" maxlength="40"
									value="${requestScope.DrawDrowBean.DD_DATE}">
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label>
								���Ž�

								<input type="text" name="DD_AMT" size="40" maxlength="40"
									value="${requestScope.DrawDrowBean.DD_AMT}">
							</label>
						</td>
					</tr>
					<tr>
						<th class="bg_tr" align="center" colspan="2" height="25">
							��Ϣ����
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								��Ϣ��׼���ţ�
								<input name="INT_BASIS" type="text" size="40"
									onblur="getRate(this.value);"
									value="${requestScope.DrawDrowBean.INT_BASIS}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								��׼���ʣ�
								<input name="INT_BASIS_RATE" type="text" size="40"
									value="${requestScope.DrawDrowBean.INT_BASIS_RATE}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								����ٷֱȣ�
								<input name="INT_SPREAD" type="text" size="40"
									value="${requestScope.DrawDrowBean.INT_SPREAD}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								ʵ�����ʣ�
								<input name="INT_RATE" type="text" size="40"
									value="${requestScope.DrawDrowBean.INT_RATE}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								��׼��������
								<select name="MONTH_BASIS_INT">
									<option value="ACT" selected="selected">
										ʵ������
									</option>
									<option value="30A">
										��ʽ30��
									</option>
									<option value="30E">
										ŷʽ30��
									</option>
								</select>
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								��׼��������
								<select name="YEAR_BASIS_INT">
									<option value="360" selected="selected">
										360��
									</option>
									<option value="365">
										365��
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<th class="bg_tr" align="center" colspan="2" height="25">
							��Ϣ����
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								��Ϣ��׼���ţ�
								<input name="PRI_PLTY_BASIS" type="text" size="40"
									onblur="getRate1(this.value);"
									value="${requestScope.DrawDrowBean.PRI_PLTY_BASIS}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								��׼���ʣ�
								<input name="PRI_PLTY_ABS" type="text" size="40"
									value="${requestScope.DrawDrowBean.PRI_PLTY_ABS}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								����ٷֱȣ�
								<input name="PRI_PLTY_SPREAD" type="text" size="40"
									value="${requestScope.DrawDrowBean.PRI_PLTY_SPREAD}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								ʵ�����ʣ�
								<input name="PRI_PLTY_RATE" type="text" size="40"
									value="${requestScope.DrawDrowBean.PENALTY_ODI_RATE_TYPE}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								��׼��������
								<select name="MONTH_BASIS_PEN">
									<option value="ACT" selected="selected">
										ʵ������
									</option>
									<option value="30A">
										��ʽ30��
									</option>
									<option value="30E">
										ŷʽ30��
									</option>
								</select>
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								��׼��������
								<select name="YEAR_BASIS_PEN">
									<option value="360" selected="selected">
										360��
									</option>
									<option value="365">
										365��
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<th class="bg_tr" align="center" colspan="2" height="25">
							��Ϣ����
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								��Ϣ��׼���ţ�
								<input name="INT_PLTY_BASIS" type="text" size="40"
									onblur="getRate2(this.value);"
									value="${requestScope.DrawDrowBean.INT_PLTY_RATE}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								��׼���ʣ�
								<input name="INT_PLTY_ABS" type="text" size="40"
									value="${requestScope.DrawDrowBean.INT_PLTY_RATE}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								����ٷֱȣ�
								<input name="INT_PLTY_SPREAD" type="text" size="40"
									value="${requestScope.DrawDrowBean.INT_PLTY_SPREAD}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								ʵ�����ʣ�
								<input name="INT_PLTY_RATE" type="text" size="40"
									value="${requestScope.DrawDrowBean.PENALTY_ODI_RATE_TYPE1}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								��׼��������
								<select name="MONTH_BASIS_PLTY">
									<option value="ACT" selected="selected">
										ʵ������
									</option>
									<option value="30A">
										��ʽ30��
									</option>
									<option value="30E">
										ŷʽ30��
									</option>
								</select>
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								��׼��������
								<select name="YEAR_BASIS_PLTY">
									<option value="360" selected="selected">
										360��
									</option>
									<option value="365">
										365��
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<td width="50%" height="30" align="right">
							<input type="submit" value="�ύ" onclick="messSend();" />
						</td>
						<td width="50%" height="30">
							<input type="reset" value="ȡ��" />
						</td>
					</tr>


				</tbody>
			</table>
		</form>
	</body>
</html>
