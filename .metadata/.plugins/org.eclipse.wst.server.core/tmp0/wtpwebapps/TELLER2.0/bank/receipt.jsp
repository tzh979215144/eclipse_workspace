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
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>�������</title>
		<link href="../mages/css1/css.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="myjs/Ajax.js"></script>
		<link href="images/skin.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="teller/css/form-field-tooltip.css"  media="screen" type="text/css">
		<script type="text/javascript" src="teller/js/rounded-corners.js"></script>
		<script type="text/javascript" src="teller/js/form-field-tooltip.js"></script>
		<script type="text/javascript" src="/TELLER2.0/My97DatePicker/WdatePicker.js"></script>

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
	
	function getReceiptMess(value){  
		  var DEBIT_NOTE_NO = value;
	if(DEBIT_NOTE_NO == '' || DEBIT_NOTE_NO == null){
		alert('֪ͨ���Ų���Ϊ�գ�');
		messRecieve();
		return false;
     	}
	 //ajax
	 var ajax = new AjaxApi('getMessage.do', 'DEBIT_NOTE_NO='+DEBIT_NOTE_NO,doxml,messSend);
	 //actionmessage�����ã�ҳ�洫ֵ��ִ����ɵ�js,�ȿ�ʼʱִ�е�
	 	 ajax.send();
		
	 //ִ��
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
    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">�������</div></td>
      </tr>
    </table>
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
					<tr class="left_txt" align="left">
						<th  height="25">
							������Ϣ
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
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>
					<tr>
						<td class="left_txt2" width="50%" colspan="2" height="35">
							֪ͨ���ţ�
							<label>
								<input name="DEBIT_NOTE_NO" type="text" size="35" maxlength="38"
									onblur="getReceiptMess(this.value);"
									value="${requestScope.receiptBean.DEBIT_NOTE_NO}">
							</label>
						</td>
					</tr>
					<tr>
						<td class="left_txt2" width="50%" height="35">
							����ţ�
							<label>
								<input name="LOAN_KEY" id="loan_key" type="text" size="35"
									maxlength="38" value="${requestScope.receiptBean.LOAN_KEY}">
							</label>
						</td>
						<td class="left_txt2" width="50%">
							���źţ�
							<label>
								<input name="DD_KEY" id="dd_key" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.DD_KEY}">
							</label>
						</td>
					</tr>

					<tr>
						<td class="left_txt2" width="50%" height="35">
							���պţ�

							<label>
								${requestScope.receiptBean.RECEIPT_KEY}
							</label>
						</td>
						<td width="50%" align="center" class="left_txt2">
							<label>
								<input type="submit" name="Submit" value="��ѯ">
							</label>
						</td>
					</tr>
				</tbody>
			</table>
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
					<tr class="left_txt" align="left">
						<th  height="25">
							������Ϣ
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
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>
					<tr>
						<td width="12%" height="35" align="right" class="left_txt2">
							����˱�ţ�
						</td>
						<td class="left_txt2" width="38%" height="35">
							<label>
								<input name="BORROWER" id="borrower" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.BORROWER}">
							</label>
						</td>
						<td width="12%" align="right" class="left_txt2">
							����״̬��
						</td>
						<td width="38%" class="left_txt2">
							<label>

								<select name="STATUS">
									<option>
										1 �
									</option>
									<option>
										2 ����
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="left_txt2">
							����������
						</td>
						<td class="left_txt2" width="38%" height="35">
							<label>
								<input name="BOOK_BRANCH" id="book_branch" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.BOOK_BRANCH}">
							</label>
						</td>
						<td width="12%" align="right" class="left_txt2">
							��������ƣ�
						</td>
						<td width="38%" class="left_txt2">
							<label>
								<input name="LENDER" id="lender" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.LENDER}">
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="left_txt2">
							���֣�
						</td>
						<td class="left_txt2" width="38%" height="35">

							<label>
								<select name="CCY">
									<option value="rmb">
										1 �����
									</option value="my">
									<option>
										2 ��Ԫ
									</option>
									<option value="oy">
										3 ŷԪ
									</option>
								</select>
							</label>
							<label></label>
						</td>
						<td width="12%" align="right" class="left_txt2">
							��������У�
						</td>
						<td width="38%" class="left_txt2">
							<label>
								<input name="LOAN_MANAGER" id="loan_manager" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.LOAN_MANAGER}">
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="left_txt2">
							�������ͣ�
						</td>
						<td class="left_txt2" width="38%" height="35">
							<label>
								<select name=BORROWER_TYPE>
									<option>
										1 ���˴���
									</option>
									<option>
										2 ��˾����
									</option>
									<option>
										3 �������
									</option>
								</select>
							</label>
						</td>
						<td width="12%" align="right" class="left_txt2">
							���������ͣ�
						</td>
						<td width="38%" class="left_txt2">
							<label>

								<select name="LOAN_SUB_TYPE">
									<option>
										101 ���˴���
									</option>
									<option>
										102 �����Ӵ���
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="left_txt2">
							�������ͣ�
						</td>
						<td class="left_txt2" width="38%" height="35">
							<label>
								<select name="RECEIPT">
									<option value="1">
										1 �ȶ��
									</option>
									<option value="2">
										2 �ȶϢ
									</option>
									<option value="3">
										3 ���汾��
									</option>
								</select>
							</label>
						</td>
						<td width="12%" align="right" class="left_txt2">
							�Ƿ�ѭ�����
						</td>
						<td width="38%" class="left_txt2">
							<label>

								<select name="REVOLVE_VN">
									<option>
										1 ��
									</option>
									<option>
										2 ��
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="left_txt2">
							�����ˣ�
						</td>
						<td class="left_txt2" width="38%" height="35">
							<label>
								<input name="PAYER" id="payer" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.PAYER}">
							</label>
						</td>
						<td width="12%" align="right" class="left_txt2">
							�������ڣ�
						</td>
						<td width="38%" class="left_txt2">
							<label>
								<input name="RECEIPT_DATE" id="receipt_date" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.RECEIPT_DATE}">
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="left_txt2">
							������
						</td>
						<td class="left_txt2" width="38%" height="35">
							<label>
								<input name="NARRATIVE" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.NARRATIVE}">
							</label>
						</td>
						<td width="12%" align="right" class="left_txt2">
							���շ�ʽ��
						</td>
						<td width="38%" class="left_txt2">
							<label>

								<select name="select5">
									<option>
										1 �ֶ�
									</option>
									<option>
										2 �Զ�
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<td width="12%" height="35" align="right" class="left_txt2">
							�����
						</td>
						<td class="left_txt2" width="38%" height="35">
							<label>
								<input name="REPAY_AMT" id="repay_amt" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.REPAY_AMT}">
							</label>
						</td>
						<td width="12%" align="right" class="left_txt2">
							������
						</td>
						<td width="38%" class="left_txt2">
							<label>
								<input name="OUTSTANDING" id="outstanding" type="text" size="35" maxlength="38"
									value="${requestScope.receiptBean.OUTSTANDING}">
							</label>
						</td>
					</tr>
				</tbody>
			</table>
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
					<tr class="left_txt" align="left">
						<th  height="25">
							������ղ�ѯ
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
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>
					<tr>
						<td class="left_txt2" width="16%" height="35" align="center" class="table">
							������
						</td>
						<td class="left_txt2" width="20%" height="35" align="center" class="table">
							��������
						</td>
						<td class="left_txt2" width="16%" height="35" align="center" class="table">
							�������
						</td>
						<td class="left_txt2" width="16%" height="35" align="center" class="table">
							Ӧ�����
						</td>
						<td class="left_txt2" width="16%" height="35" align="center" class="table">
							���ź�
						</td>
						<td class="left_txt2" width="16%" height="35" align="center" class="table">
							����(%)
						</td>
					</tr>
					<tr>
						<td width="16%" height="35" align="center" class="left_txt2">
							<input name="textfield34" type="text" size="18" maxlength="38">
						</td>
						<td width="20%" height="35" align="center" class="left_txt2">
							<input name="textfield342" type="text" size="25" maxlength="38">
						</td>
						<td width="16%" height="35" align="center" class="left_txt2">
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
						<td width="16%" height="35" align="center" class="left_txt2">
							<input name="textfield343" type="text" size="18" maxlength="38">
						</td>
						<td width="16%" height="35" align="center" class="left_txt2">
							<input name="textfield344" type="text" size="18" maxlength="38">
						</td>
						<td width="16%" height="35" align="center" class="left_txt2">
							<input name="textfield345" type="text" size="18" maxlength="38">
						</td>
					</tr>
					<tr>
						<td width="68%" height="35" align="center" class="left_txt2"
							colspan="4"></td>
						<td width="16%" height="35" align="center" class="left_txt2">
							<input type="submit" name="Submit2" value="���">
						</td>
						<td width="16%" height="35" align="center" class="left_txt2">
							<input type="submit" name="Submit2" value="ɾ��">
						</td>
					</tr>
				</tbody>
			</table>
			<table width="99%" height="50" border="0" align="center"
				cellpadding="0" cellspacing="1">
				<tbody>
					<tr>
						<td width="46%" height="35" align="right" valign="bottom"
							class="left_txt2">
							<input type="submit" value="�ύ" onclick="messSend();" />
						</td>
						<td width="7%" height="35" align="center" class="left_txt2"></td>
						<td width="46%" height="35" align="left" valign="bottom"
							class="left_txt2">
							<input type="reset" value="ȡ��"/>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>
