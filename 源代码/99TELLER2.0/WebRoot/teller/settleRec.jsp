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
		<title>������ս���</title>
		<link href="../mages/css1/css.css" rel="stylesheet" type="text/css">
	</head>
	<script type="text/javascript">
function AjaxApi(){
  
  		var debug = false;
		
		if(debug)alert("new AjaxApi()");
		
		this.parameters = arguments;		//�����б�
		
		this.param = null;			//�������
		
		this.url = null;   			//�����ַ
		
		AjaxApi.prototype.request = false;//Ajax ������Ķ���
		AjaxApi.prototype.returnfunction = null; 
		AjaxApi.prototype.starfunction = null; 
		
		this.intiEngine=function(){//��ʼ��Ajax����
		
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
		
		
		this.iniParams=function(){//��ʼ������
		
			if(this.parameters.length == 4){
			
				this.url = this.parameters[0]
				
				this.param = this.parameters[1];
				
				AjaxApi.prototype.returnfunction = this.parameters[2];
				
				AjaxApi.prototype.starfunction = this.parameters[3];
			}
		}
		
		
		this.send=function(){//������
			var url2 = this.url + "?" + this.param;
			this.request.open("GET", url2 ,true);
			this.request.onreadystatechange=this.onChange;
			this.request.send(null);
		}
		
		
		this.onChange = function(){//���÷���
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
		
		this.intiEngine();//ִ�г�ʼ��
		this.iniParams();//
		
  }
</script>
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
	function getReceiptMes(){
	var loan_no =document.getElementById('loan_no').value;
	var DEBIT_NOTE_NO=document.getElementById('DEBIT_NOTE_NO').value;
	if(loan_no == null || loan_no ==''){
		alert('����Ų���Ϊ��');
		messRecieve();
		return false;
	}
	if(DEBIT_NOTE_NO == null || DEBIT_NOTE_NO ==''){
		alert('֪ͨ�Ų���Ϊ��');
		messRecieve();
		return false;
	}
	var ajax = new AjaxApi('getMessage.do', 'LOAN_NO7='+loan_no+'&DEBIT_NOTE_NO1='+DEBIT_NOTE_NO,doxml,messSend);
	 //actionmessage�����ã�ҳ�洫ֵ��ִ����ɵ�js,�ȿ�ʼʱִ�е�
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
							������ս���ҳ��
						</th>
					</tr>
				</tbody>
			</table>
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>
					<tr>
						<th class="bg_tr" align="center" colspan="4" height="25">
							������Ϣ
						</th>
					</tr>
					<tr>
												<td width="12%" height="35" align="right" class="td_bg">
							֪ͨ���ţ�
						</td>
						<td class="td_bg" width="38%" height="35">
							<label>
								<input name="DEBIT_NOTE_NO" id="DEBIT_NOTE_NO" type="text" size="35"
									maxlength="38" value="${requestScope.SettleRecBean.DEBIT_NOTE_NO}">
							</label>
						</td>
						<td width="12%" align="right" class="td_bg">
							����ţ�
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
							���ս�
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
							<input type="button" name="find" value="��ѯ"
								onclick="getReceiptMes()">
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="td_bg">
							�����˱�ţ�
						</td>
						<td class="td_bg" width="38%" height="35">
							<label>
								<input id="ORIG_BORRPWER" name="ORIG_BORRPWER" type="text" size="35" maxlength="38" value="${requestScope.SettleRecBean.ORIG_BORRPWER}">
							</label>
						</td>
						<td width="12%" align="right" class="td_bg">
							������������
						</td>
						<td width="38%" class="td_bg">
							<label>
								<input name="LENDER" id="LENDER" type="text" size="35" maxlength="38" value="${requestScope.SettleRecBean.LENDER}">
							</label>
						</td>
					</tr>


					<tr>
						<td width="12%" height="35" align="right" class="td_bg">
							������ͣ�
						</td>
						<td class="td_bg" width="38%" height="35">
							<label>
								<input name="INVOICE_TYPE" id="INVOICE_TYPE" type="text" size="35" maxlength="38" value="${requestScope.SettleRecBean.INVOICE_TYPE}">
							</label>
						</td>
						<td width="12%" align="right" class="td_bg"> 
							Ӧ��δ�ս� 
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
							Ĭ�Ͽۿ��˻���Ϣ
						</th>
					</tr>
					<tr>
						<td width="10%" height="35" align="center" class="table">
							�˻�����
						</td>
						<td width="15%" height="35" align="center" class="table">
							���㷽ʽ
						</td>
						<td width="20%" height="35" align="center" class="table">
							�����˻�
						</td>
						<td width="10%" height="35" align="center" class="table">
							���ձ���
						</td>
						<td width="15%" height="35" align="center" class="table">
							�ʻ����
						</td>
						<td width="15%" height="35" align="center" class="table">
							���ս��
						</td>
						<td width="15%" height="35" align="center" class="table">
							�ʻ�������
						</td>
					</tr>
					<tr>
						<td height="35" align="center" class="td_bg">
							<select name="select8">
								<option>
									1 ����
								</option>
								<option>
									2 ����
								</option>
							</select>
						</td>
						<td height="35" align="center" class="td_bg">
							<select name="select9">
								<option>
									1 �Զ�����
								</option>
								<option>
									2 �ֶ�����
								</option>
							</select>
						</td>
						<td height="35" align="center" class="td_bg">
							<input name="ACCT_NO" id="ACCT_NO" type="text" size="27" maxlength="27" value="${requestScope.SettleRecBean.ACCT_NO}">
						</td>
						<td height="35" align="center" class="td_bg">
							<select name="select6">
								<option>
									1 �����
								</option>
								<option>
									2 ��Ԫ
								</option>
								<option>
									3 ŷԪ
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
							���ÿۿ��˻���Ϣ
						</th>
					</tr>
					<tr>
						<td height="35" align="center" class="td_bg">
							<select name="select8">
								<option>
									1 ����
								</option>
								<option>
									2 ����
								</option>
							</select>
						</td>
						<td height="35" align="center" class="td_bg">
							<select name="select9">
								<option>
									1 �Զ�����
								</option>
								<option>
									2 �ֶ�����
								</option>
							</select>
						</td>
						<td height="35" align="center" class="td_bg">
							<input name="OTH_ACCT_NO" id="OTH_ACCT_NO" type="text" size="27" maxlength="27" value="${requestScope.SettleRecBean.OTH_ACCT_NO}">
						</td>
						<td height="35" align="center" class="td_bg">
							<select name="select6">
								<option>
									1 �����
								</option>
								<option>
									2 ��Ԫ
								</option>
								<option>
									3 ŷԪ
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
							<input type="submit" name="Submit2" value="�ύ">
						</td>
						<td width="7%" height="35" align="center" class="td_bg">
							&quot;
						</td>
						<td width="46%" height="35" align="left" valign="bottom"
							class="td_bg">
							<input type="reset" name="reset" value="ȡ��">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>
