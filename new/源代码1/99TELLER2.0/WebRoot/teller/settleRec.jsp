<%@ page language="java" import="java.util.*" pageEncoding="GBK"
	isELIgnored="false"%>
<%@page import="org.zhoukan.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	SettleRecBean reMess = (SettleRecBean) request
			.getAttribute("SettleRecBean");
	if (reMess != null) {
		pageContext.setAttribute("reMess", reMess.getRecieveMess());
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>贷款回收结算</title>
		<link href="../mages/css1/css.css" rel="stylesheet" type="text/css">
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
	function getReceiptMes(){
	var loan_no =document.getElementById('loan_no').value;
	var DEBIT_NOTE_NO=document.getElementById('DEBIT_NOTE_NO').value;
	if(loan_no == null || loan_no ==''){
		alert('贷款号不能为空');
		messRecieve();
		return false;
	}
	if(DEBIT_NOTE_NO == null || DEBIT_NOTE_NO ==''){
		alert('通知号不能为空');
		messRecieve();
		return false;
	}
	var ajax = new AjaxApi('getMessage.do', 'LOAN_NO7='+loan_no+'&DEBIT_NOTE_NO1='+DEBIT_NOTE_NO,doxml,messSend);
	 //actionmessage中配置，页面传值，执行完成的js,先开始时执行的
	 	 ajax.send();

	}
	 function doxml(xml){
		   messRecieve();	
	 var ORIG_BORRPWER = xml.getElementsByTagName('ORIG_BORRPWER')[0].text;	
	 var LENDER = xml.getElementsByTagName('LENDER')[0].text;
	 var INVOICE_TYPE = xml.getElementsByTagName('INVOICE_TYPE')[0].text;
	 var BILLED_AMT = xml.getElementsByTagName('BILLED_AMT')[0].text;
	 var ACCT_NO = xml.getElementsByTagName('ACCT_NO')[0].text;
	 var ACCT_AMT = xml.getElementsByTagName('ACCT_AMT')[0].text;
	 var CLIENT = xml.getElementsByTagName('CLIENT')[0].text;
	 var OTH_ACCT_NO = xml.getElementsByTagName('OTH_ACCT_NO')[0].text;
	 var OTH_ACCT_AMT = xml.getElementsByTagName('OTH_ACCT_AMT')[0].text;
	 var OTH_CLIENT = xml.getElementsByTagName('OTH_CLIENT')[0].text;
	 var OUTSTANDING = xml.getElementsByTagName('OUTSTANDING')[0].text;
	 var MONEY = xml.getElementsByTagName('MONEY')[0].text;
	 var OTH_MONEY = xml.getElementsByTagName('OTH_MONEY')[0].text;
	 document.getElementById('ORIG_BORRPWER').value = ORIG_BORRPWER;
	 document.getElementById('LENDER').value = LENDER;
	 document.getElementById('INVOICE_TYPE').value = INVOICE_TYPE;
	 document.getElementById('BILLED_AMT').value = BILLED_AMT;
	 document.getElementById('ACCT_NO').value = ACCT_NO;
	 document.getElementById('ACCT_AMT').value = ACCT_AMT;
	 document.getElementById('CLIENT').value = CLIENT;
	 document.getElementById('OTH_ACCT_NO').value = OTH_ACCT_NO;
	 document.getElementById('OTH_ACCT_AMT').value = OTH_ACCT_AMT;
	 document.getElementById('OTH_CLIENT').value = OTH_CLIENT;
	 document.getElementById('OUTSTANDING').value = OUTSTANDING;
	 document.getElementById('MONEY').value = MONEY;
	 document.getElementById('OTH_MONEY').value = OTH_MONEY;
	 
	 }
	</script>
	<body onLoad="messRecieve(${pageScope.reMess });">
		<form name="form1" method="post" action="settleRec.do">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>


					<tr>
						<th height="25" colspan="2" align="left" bgcolor="#006633"
							class="bg_tr">
							贷款回收结算页面
						</th>
					</tr>
				</tbody>
			</table>
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>
					<tr>
						<th class="bg_tr" align="center" colspan="4" height="25">
							贷款信息
						</th>
					</tr>
					<tr>
												<td width="12%" height="35" align="right" class="td_bg">
							通知单号：
						</td>
						<td class="td_bg" width="38%" height="35">
							<label>
								<input name="DEBIT_NOTE_NO" id="DEBIT_NOTE_NO" type="text" size="35"
									maxlength="38" value="${requestScope.SettleRecBean.DEBIT_NOTE_NO}">
							</label>
						</td>
						<td width="12%" align="right" class="td_bg">
							贷款号：
						</td>
						<td width="38%" class="td_bg">
							<label>
								<input name="LOAN_NO" id="loan_no" type="text" size="35"
									maxlength="38" value="${requestScope.SettleRecBean.LOAN_NO}">
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" align="right" class="td_bg">
							回收金额：
						</td>
						<td width="38%" class="td_bg">
							<label>
								<input name="BILLED_AMT" id="BILLED_AMT" type="text" size="35" maxlength="38" value="${requestScope.SettleRecBean.BILLED_AMT}">
							</label>
						</td>
						<td width="12%" align="right" class="td_bg">
							&nbsp;
						</td>
						<td width="38%" class="td_bg">
							<input type="button" name="find" value="查询"
								onclick="getReceiptMes()">
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="td_bg">
							贷款人编号：
						</td>
						<td class="td_bg" width="38%" height="35">
							<label>
								<input id="ORIG_BORRPWER" name="ORIG_BORRPWER" type="text" size="35" maxlength="38" value="${requestScope.SettleRecBean.ORIG_BORRPWER}">
							</label>
						</td>
						<td width="12%" align="right" class="td_bg">
							贷款人姓名：
						</td>
						<td width="38%" class="td_bg">
							<label>
								<input name="LENDER" id="LENDER" type="text" size="35" maxlength="38" value="${requestScope.SettleRecBean.LENDER}">
							</label>
						</td>
					</tr>


					<tr>
						<td width="12%" height="35" align="right" class="td_bg">
							金额类型：
						</td>
						<td class="td_bg" width="38%" height="35">
							<label>
								<input name="INVOICE_TYPE" id="INVOICE_TYPE" type="text" size="35" maxlength="38" value="${requestScope.SettleRecBean.INVOICE_TYPE}">
							</label>
						</td>
						<td width="12%" align="right" class="td_bg"> 
							应收未收金额： 
						</td>
						<td width="38%" class="td_bg">
							<label>
								<input name="OUTSTANDING" id="OUTSTANDING" type="text" size="35" maxlength="38" value="${requestScope.SettleRecBean.OUTSTANDING}">
							</label>
						</td>
					</tr>
				</tbody>
			</table>

			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>
					<tr>
						<th class="bg_tr" align="center" colspan="7" height="25">
							默认扣款账户信息
						</th>
					</tr>
					<tr>
						<td width="10%" height="35" align="center" class="table">
							账户类型
						</td>
						<td width="15%" height="35" align="center" class="table">
							结算方式
						</td>
						<td width="20%" height="35" align="center" class="table">
							结算账户
						</td>
						<td width="10%" height="35" align="center" class="table">
							回收币种
						</td>
						<td width="15%" height="35" align="center" class="table">
							帐户余额
						</td>
						<td width="15%" height="35" align="center" class="table">
							回收金额
						</td>
						<td width="15%" height="35" align="center" class="table">
							帐户持有人
						</td>
					</tr>
					<tr>
						<td height="35" align="center" class="td_bg">
							<select name="select8">
								<option>
									1 活期
								</option>
								<option>
									2 定期
								</option>
							</select>
						</td>
						<td height="35" align="center" class="td_bg">
							<select name="select9">
								<option>
									1 自动结算
								</option>
								<option>
									2 手动结算
								</option>
							</select>
						</td>
						<td height="35" align="center" class="td_bg">
							<input name="ACCT_NO" id="ACCT_NO" type="text" size="27" maxlength="27" value="${requestScope.SettleRecBean.ACCT_NO}">
						</td>
						<td height="35" align="center" class="td_bg">
							<select name="select6">
								<option>
									1 人民币
								</option>
								<option>
									2 美元
								</option>
								<option>
									3 欧元
								</option>
							</select>
						</td>
						<td height="35" align="center" class="td_bg">
							<input name="ACCT_AMT" id="ACCT_AMT" type="text" size="20" maxlength="20" value="${requestScope.SettleRecBean.ACCT_AMT}">
						</td>
						<td height="35" align="center" class="td_bg">
							<input name="MONEY" id="MONEY" type="text" size="20" maxlength="20"  value="${requestScope.SettleRecBean.MONEY}">
						</td>
						<td height="35" align="center" class="td_bg">
							<input name="CLIENT" id="CLIENT" type="text" size="20" maxlength="20" value="${requestScope.SettleRecBean.CLIENT}">
						</td>
					</tr>
					<tr>
						<th class="bg_tr" align="center" colspan="7" height="25">
							备用扣款账户信息
						</th>
					</tr>
					<tr>
						<td height="35" align="center" class="td_bg">
							<select name="select8">
								<option>
									1 活期
								</option>
								<option>
									2 定期
								</option>
							</select>
						</td>
						<td height="35" align="center" class="td_bg">
							<select name="select9">
								<option>
									1 自动结算
								</option>
								<option>
									2 手动结算
								</option>
							</select>
						</td>
						<td height="35" align="center" class="td_bg">
							<input name="OTH_ACCT_NO" id="OTH_ACCT_NO" type="text" size="27" maxlength="27" value="${requestScope.SettleRecBean.OTH_ACCT_NO}">
						</td>
						<td height="35" align="center" class="td_bg">
							<select name="select6">
								<option>
									1 人民币
								</option>
								<option>
									2 美元
								</option>
								<option>
									3 欧元
								</option>
							</select>
						</td>
						<td height="35" align="center" class="td_bg">
							<input name="OTH_ACCT_AMT" id="OTH_ACCT_AMT" type="text" size="20" maxlength="20" value="${requestScope.SettleRecBean.OTH_ACCT_AMT}">
						</td>
						<td height="35" align="center" class="td_bg">
							<input name="OTH_MONEY" id="OTH_MONEY" type="text" size="20" maxlength="20"  value="${requestScope.SettleRecBean.OTH_MONEY}">
						</td>
						<td height="35" align="center" class="td_bg">
							<input name="OTH_CLIENT" id="OTH_CLIENT" type="text" size="20" maxlength="20" value="${requestScope.SettleRecBean.OTH_CLIENT}">
						</td>
					</tr>
				</tbody>
			</table>
			<table width="99%" height="50" border="0" align="center"
				cellpadding="0" cellspacing="1">
				<tbody>
					<tr>
						<td width="46%" height="35" align="right" valign="bottom"
							class="td_bg">
							<input type="submit" name="Submit2" value="提交">
						</td>
						<td width="7%" height="35" align="center" class="td_bg">
							&quot;
						</td>
						<td width="46%" height="35" align="left" valign="bottom"
							class="td_bg">
							<input type="reset" name="reset" value="取消">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>
