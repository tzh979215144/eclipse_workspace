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
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>贷款回收</title>
		<link href="../mages/css1/css.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="myjs/Ajax.js"></script>

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
	
	function getReceiptMess(value){  
		  var DEBIT_NOTE_NO = value;
	if(DEBIT_NOTE_NO == '' || DEBIT_NOTE_NO == null){
		alert('通知单号不能为空！');
		messRecieve();
		return false;
     	}
	 //ajax
	 var ajax = new AjaxApi('getMessage.do', 'DEBIT_NOTE_NO='+DEBIT_NOTE_NO,doxml,messSend);
	 //actionmessage中配置，页面传值，执行完成的js,先开始时执行的
	 	 ajax.send();
		
	 //执行
	  }
	
	  function doxml(xml){
		   messRecieve();	
	 var LOAN_KEY = xml.getElementsByTagName('LOAN_KEY')[0].text;
	 document.getElementById('loan_key').value=LOAN_KEY;
	 var DD_KEY= xml.getElementsByTagName('DD_KEY')[0].text;
	 document.getElementById('dd_key').value=DD_KEY;
	 var BORROWER= xml.getElementsByTagName('BORROWER')[0].text;
	 document.getElementById('borrower').value=BORROWER;
	 var BOOK_BRANCH= xml.getElementsByTagName('BOOK_BRANCH')[0].text;
	 document.getElementById('book_branch').value=BOOK_BRANCH;
	 var LOAN_MANAGER= xml.getElementsByTagName('LOAN_MANAGER')[0].text;
	 document.getElementById('loan_manager').value=LOAN_MANAGER;
	 var LENDER= xml.getElementsByTagName('LENDER')[0].text;
	 document.getElementById('lender').value=LENDER;
	 //var RECEIPT_DATE= xml.getElementsByTagName('RECEIPT_DATE')[0].text;
	 //document.getElementById('receipt_date').value=RECEIPT_DATE;
	 //var REASON_DESC= xml.getElementsByTagName('REASON_DESC')[0].text;
	 //document.getElementById('reason_desc').value=REASON_DESC;
	 var REPAY_AMT= xml.getElementsByTagName('REPAY_AMT')[0].text;
	 document.getElementById('repay_amt').value=REPAY_AMT;
	 var OUTSTANDING= xml.getElementsByTagName('OUTSTANDING')[0].text;
	 document.getElementById('outstanding').value=OUTSTANDING;
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
		<form name="form1" method="post" action="receipt.do">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>


					<tr>
						<th height="25" colspan="2" align="left" bgcolor="#006633"
							class="bg_tr">
							贷款本息回收页面
						</th>
					</tr>
				</tbody>
			</table>
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>


					<tr>
						<th class="bg_tr" align="center" colspan="2" height="25">
							基本信息
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" colspan="2" height="35">
							通知单号：
							<label>
								<input name="DEBIT_NOTE_NO" type="text" size="35" maxlength="38"
									onblur="getReceiptMess(this.value);"
									value="${requestScope.receiptBean.DEBIT_NOTE_NO}">
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							贷款号：
							<label>
								<input name="LOAN_KEY" id="loan_key" type="text" size="35"
									maxlength="38" value="${requestScope.receiptBean.LOAN_KEY}">
							</label>
						</td>
						<td class="td_bg" width="50%">
							发放号：
							<label>
								<input name="DD_KEY" id="dd_key" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.DD_KEY}">
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="35">
							回收号：

							<label>
								${requestScope.receiptBean.RECEIPT_KEY}
							</label>
						</td>
						<td width="50%" align="center" class="td_bg">
							<label>
								<input type="submit" name="Submit" value="查询">
							</label>
						</td>
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
							借款人编号：
						</td>
						<td class="td_bg" width="38%" height="35">
							<label>
								<input name="BORROWER" id="borrower" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.BORROWER}">
							</label>
						</td>
						<td width="12%" align="right" class="td_bg">
							贷款状态：
						</td>
						<td width="38%" class="td_bg">
							<label>

								<select name="STATUS">
									<option>
										1 活动
									</option>
									<option>
										2 冻结
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="td_bg">
							贷款经办机构：
						</td>
						<td class="td_bg" width="38%" height="35">
							<label>
								<input name="BOOK_BRANCH" id="book_branch" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.BOOK_BRANCH}">
							</label>
						</td>
						<td width="12%" align="right" class="td_bg">
							借款人名称：
						</td>
						<td width="38%" class="td_bg">
							<label>
								<input name="LENDER" id="lender" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.LENDER}">
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="td_bg">
							币种：
						</td>
						<td class="td_bg" width="38%" height="35">

							<label>
								<select name="CCY">
									<option value="rmb">
										1 人民币
									</option value="my">
									<option>
										2 美元
									</option>
									<option value="oy">
										3 欧元
									</option>
								</select>
							</label>
							<label></label>
						</td>
						<td width="12%" align="right" class="td_bg">
							贷款管理行：
						</td>
						<td width="38%" class="td_bg">
							<label>
								<input name="LOAN_MANAGER" id="loan_manager" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.LOAN_MANAGER}">
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="td_bg">
							贷款类型：
						</td>
						<td class="td_bg" width="38%" height="35">
							<label>
								<select name=BORROWER_TYPE>
									<option>
										1 个人贷款
									</option>
									<option>
										2 公司贷款
									</option>
									<option>
										3 团体贷款
									</option>
								</select>
							</label>
						</td>
						<td width="12%" align="right" class="td_bg">
							贷款子类型：
						</td>
						<td width="38%" class="td_bg">
							<label>

								<select name="LOAN_SUB_TYPE">
									<option>
										101 个人贷款
									</option>
									<option>
										102 个人子贷款
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="td_bg">
							还款类型：
						</td>
						<td class="td_bg" width="38%" height="35">
							<label>
								<select name="RECEIPT">
									<option value="1">
										1 等额本金
									</option>
									<option value="2">
										2 等额本息
									</option>
									<option value="3">
										3 利随本清
									</option>
								</select>
							</label>
						</td>
						<td width="12%" align="right" class="td_bg">
							是否循环贷款：
						</td>
						<td width="38%" class="td_bg">
							<label>

								<select name="REVOLVE_VN">
									<option>
										1 是
									</option>
									<option>
										2 否
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="td_bg">
							付款人：
						</td>
						<td class="td_bg" width="38%" height="35">
							<label>
								<input name="PAYER" id="payer" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.PAYER}">
							</label>
						</td>
						<td width="12%" align="right" class="td_bg">
							还款日期：
						</td>
						<td width="38%" class="td_bg">
							<label>
								<input name="RECEIPT_DATE" id="receipt_date" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.RECEIPT_DATE}">
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="td_bg">
							描述：
						</td>
						<td class="td_bg" width="38%" height="35">
							<label>
								<input name="NARRATIVE" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.NARRATIVE}">
							</label>
						</td>
						<td width="12%" align="right" class="td_bg">
							回收方式：
						</td>
						<td width="38%" class="td_bg">
							<label>

								<select name="select5">
									<option>
										1 手动
									</option>
									<option>
										2 自动
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="td_bg">
							还款金额：
						</td>
						<td class="td_bg" width="38%" height="35">
							<label>
								<input name="REPAY_AMT" id="repay_amt" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.REPAY_AMT}">
							</label>
						</td>
						<td width="12%" align="right" class="td_bg">
							贷款余额：
						</td>
						<td width="38%" class="td_bg">
							<label>
								<input name="OUTSTANDING" id="outstanding" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.OUTSTANDING}">
							</label>
						</td>
					</tr>
				</tbody>
			</table>
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>
					<tr>
						<th class="bg_tr" align="center" colspan="6" height="25">
							贷款回收查询
						</th>
					</tr>
					<tr>
						<td width="16%" height="35" align="center" class="table">
							贷款人
						</td>
						<td width="20%" height="35" align="center" class="table">
							到期日期
						</td>
						<td width="16%" height="35" align="center" class="table">
							还款币种
						</td>
						<td width="16%" height="35" align="center" class="table">
							应还金额
						</td>
						<td width="16%" height="35" align="center" class="table">
							发放号
						</td>
						<td width="16%" height="35" align="center" class="table">
							利率(%)
						</td>
					</tr>
					<tr>
						<td width="16%" height="35" align="center" class="td_bg">
							<input name="textfield34" type="text" size="18" maxlength="38">
						</td>
						<td width="20%" height="35" align="center" class="td_bg">
							<input name="textfield342" type="text" size="25" maxlength="38">
						</td>
						<td width="16%" height="35" align="center" class="td_bg">
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
						<td width="16%" height="35" align="center" class="td_bg">
							<input name="textfield343" type="text" size="18" maxlength="38">
						</td>
						<td width="16%" height="35" align="center" class="td_bg">
							<input name="textfield344" type="text" size="18" maxlength="38">
						</td>
						<td width="16%" height="35" align="center" class="td_bg">
							<input name="textfield345" type="text" size="18" maxlength="38">
						</td>
					</tr>
					<tr>
						<td width="68%" height="35" align="center" class="td_bg"
							colspan="4"></td>
						<td width="16%" height="35" align="center" class="td_bg">
							<input type="submit" name="Submit2" value="添加">
						</td>
						<td width="16%" height="35" align="center" class="td_bg">
							<input type="submit" name="Submit2" value="删除">
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
							<input type="submit" value="提交" onclick="messSend();" />
						</td>
						<td width="7%" height="35" align="center" class="td_bg"></td>
						<td width="46%" height="35" align="left" valign="bottom"
							class="td_bg">
							<input type="reset" value="取消"/>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>
