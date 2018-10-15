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
		<title>�˻�����</title>
		<link href="../mages/css1/css.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="js/calendar.js" ></script>  
		<script type="text/javascript" src="js/calendar-zh.js" ></script>
		<script type="text/javascript" src="js/calendar-setup.js"></script>
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
  	sendMess.innerHTML='����ִ��......';
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
  	sendMess.innerHTML='ִ�����';
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
		alert('֤���Ų���Ϊ��');
		messRecieve();
		return false;
	}
	var glTxt =/^[0-9][0-9]{16}.{1}$/;
	if(!glTxt.test(GLOBAL_ID)){
		alert('֤���Ÿ�ʽ���ԣ�������18λ');
		messRecieve();
		return false;
	}
	var GLOBAL_ID_AGAIN = $("GLOBAL_ID_AGAIN");
	if(GLOBAL_ID_AGAIN != GLOBAL_ID){
		alert('��������֤���Ų�һ�£�');
		messRecieve();
		return false;
	}
	
	var CH_CLIENT_NAME = $("CH_CLIENT_NAME");
	if(CH_CLIENT_NAME == '' || CH_CLIENT_NAME == null){
		alert("����������Ϊ��");
		messRecieve();
		return false;
	}
	 
	var CLIENT_SHORT = $('CLIENT_SHORT');
	if(CLIENT_SHORT == '' || CLIENT_SHORT == null){
		alert("�ͻ���Ʋ���Ϊ�գ�");
		messRecieve();
		return false;
	}
	var CLIENT_NO = $("CLIENT_NO");
	if(!(CLIENT_NO =='' || CLIENT_NO == null)){
		alert("�ͻ��Ų������룡");
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
		alert('�ͻ��Ų���Ϊ�գ�');
		messRecieve();
		return false;
     	}
	 //ajax
	 var ajax = new AjaxApi('getMessage.do', 'CLIENT_NO='+CLIENT_NO,doxml,messSend);
	 //actionmessage�����ã�ҳ�洫ֵ��ִ����ɵ�js,�ȿ�ʼʱִ�е�
	 	 ajax.send();
		
	 //ִ��
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
							�����˻�ҳ��
						</th>
					</tr>
				</tbody>
			</table>
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>

					<tr>
						<th class="bg_tr" align="center" colspan="2" height="25">
							�˺���Ϣ
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							�� �ţ�
							<label>
								<input name="BASE_ACCT_NO" type="text" size="40"
									readonly="readonly"
									value="${requestScope.openAccountBean.BASE_ACCT_NO}" />
							</label>
						</td>
						<td class="td_bg" width="50%">
							�˻����ͣ�
							<label>
								<select name="ACCT_TYPE">
									<option value="1" selected="selected">
										����
									</option>
									<option value="2">
										��λ
									</option>
								</select>
								<a class="must">*</a>
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							�ͻ��ţ�
							<label>
								<input name="CLIENT_NO" id="client_no" type="text" size="40"
									maxlength="38" onblur="getClient(this.value);"
									value="${requestScope.openAccountBean.CLIENT_NO}" />
							</label>
						</td>
						<td class="td_bg" width="50%">
							֤�����ͣ�
							<label>
								<select name="GLOBAL_ID_TYPE">
									<option value="identity_card" selected="selected">
										���֤
									</option>
									<option value="military_card">
										����֤
									</option>
									<option value="passport">
										����
									</option>
								</select>
								<a class="must">*</a>
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="46">
							֤�����룺
							<label>
								<input name="GLOBAL_ID" id="global_id" type="text" size="38"
									maxlength="38"
									value="${requestScope.openAccountBean.GLOBAL_ID}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="46">
							�ͻ���ƣ�
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
								<input type="button" name="Submit" value="�����ͻ���Ϣ"
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
							�˻���ϸ
						</th>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							��������
							<label>
								<input name="CH_ACCT_NAME" type="text" size="40" maxlength="40"
									value="${requestScope.openAccountBean.CH_ACCT_NAME}" />
							</label>
						</td>
						<td width="50%" class="td_bg">
							<label>
								Ӣ������
								<input name="ALT_ACCT_NAME" type="text" size="40" maxlength="40"
									value="${requestScope.openAccountBean.ALT_ACCT_NAME}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								�ͻ����ͣ�
								<select name="CLIENT_TYPE">
									<option value="COM" selected="selected">
										��ͨ�ͻ�
									</option>
									<option value="VIP">
										VIP�ͻ�
									</option>
									<option value="INT">
										����Ա��
									</option>
								</select>
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label>
								�ͻ������ţ�
								<input name="OFFICER_ID" type="text" size="40" maxlength="40"
									value="${requestScope.openAccountBean.OFFICER_ID}" />
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								����ʱ�䣺<input type="text" id="EntTime" name="ACCT_OPEN_DATE" onclick="return showCalendar('EntTime', 'y-mm-dd');" value="${requestScope.openAccountBean.ACCT_OPEN_DATE}" />
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label>
								�˻�״̬��
								<select name="ACCT_STATUS">
									<option value="A" selected="selected">
										�
									</option>
									<option value="B">
										����
									</option>
									<option value="C">
										˯�߻�
									</option>
									<option value="D">
										�乫��
									</option>
									<option value="E">
										���
									</option>
									<option value="F">
										�½�
									</option>
									<option value="G">
										�����
									</option>
									<option value="H">
										������
									</option>
								</select>
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								�˻����֣�
								<select name="CCY">
									<option value="CNY" selected="selected">
										�����
									</option>
									<option value="MY">
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
								������ͣ�
								<select name="ACTUAL_OR_LEDGER_BAL">
									<option value="A" selected="selected">
										����
									</option>
									<option value="L">
										����
									</option>
								</select>
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								֧ȡ��ʽ��
								<select name="STMT_PBK">
									<option value="P" selected="selected">
										����
									</option>
									<option value="S">
										���յ�
									</option>
								</select>
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label></label>
							<label>
								�˻����ԣ�
								<select name="ACCT_NATURE">
									<option value="B" selected="selected">
										������
									</option>
									<option value="C">
										һ�㻧
									</option>
									<option value="S">
										ר�û�
									</option>
									<option value="T">
										��ʱ��
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							<label>
								�˻����Ʊ�־��
								<select name="RESTRAINT_PRESENT">
									<option value="N" selected="selected">
										��
									</option>
									<option value="Y">
										��
									</option>
								</select>
							</label>
						</td>

						<td class="td_bg" width="50%">
							<label></label>
							<label>
								������ͣ�
								<select name="DEPOSIT_TYPE">
									<option value="T" selected="selected">
										�����˻�
									</option>
									<option value="C">
										�����˻�
									</option>
									<option value="S">
										�����˻�
									</option>
									<option value="A">
										AIO�˻�
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
