<%@page language="java" import="java.util.*" pageEncoding="GBK" isELIgnored="false"%>
<%@page import="org.zhoukan.bean.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
RepayBean reMess = (RepayBean)request.getAttribute("repayBean");
if(reMess != null){
	pageContext.setAttribute("reMess",reMess.getRecieveMess());
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>����ƻ�</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #F8F9FA;
}
-->
.must{color: red ;font-size: 20px; margin-top: 10px}
</style>

<link href="images/skin.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="teller/css/form-field-tooltip.css"  media="screen" type="text/css">
<script type="text/javascript" src="teller/js/rounded-corners.js"></script>
<script type="text/javascript" src="teller/js/form-field-tooltip.js"></script>
<script type="text/javascript" src="/TELLER2.0/My97DatePicker/WdatePicker.js"></script>
  </head>
 <!--  <script type="text/javascript" src="/TELLER2.0/myjs/change.js"> </script>--> 
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
	function getRepayMess(){
	var dd_no =document.getElementById('DD_NO').value;
	if(dd_no == null || dd_no ==''){
		alert('���źŲ���Ϊ��');
		messRecieve();
		return false;
	}
	var ajax = new AjaxApi('getMessage.do', 'FAFANG='+dd_no,doxml,messSend);
	 //actionmessage�����ã�ҳ�洫ֵ��ִ����ɵ�js,�ȿ�ʼʱִ�е�
	 	 ajax.send();
	}
	 function doxml(xml){
		   messRecieve();	
	 var LOAN_NO = xml.getElementsByTagName('LOAN_NO')[0].text;	
	 var DD_DATE = xml.getElementsByTagName('DD_DATE')[0].text;
	 var DD_AMT = xml.getElementsByTagName('DD_AMT')[0].text;
	 var INT_RATE = xml.getElementsByTagName('INT_RATE')[0].text;
	 
	 document.getElementById('LOAN_NO').value = LOAN_NO;
	 document.getElementById('DD_DATE').value = DD_DATE;
	 document.getElementById('DD_AMT').value = DD_AMT;
	 document.getElementById('INT_RATE').value = INT_RATE;	 
	 }
	</script>
  <body onLoad="messRecieve(${pageScope.reMess });">
 <form name="form1" method="POST" action="rePay.do" >
 <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" height="29" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td width="935" height="29" valign="top" background="images/content-bg.gif">
    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">����ƻ�</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td height="71" valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
    <table width="100%" height= "138" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="13" valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td class="left_txt">��ǰλ�ã�����ƻ�</td>
          </tr>
          <tr>
            <td height="20"><table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
              <tr>
                <td></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td>
            <table width="100%" height="55" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="10%" height="55" valign="middle"><img src="images/title.gif" width="54" height="55"></td>
                <td width="90%" valign="top"><span class="left_txt2">����������Ը���
				�ͻ���Ϣ����</span><span class="left_txt3">��������</span><span class="left_txt2">��</span><br>
                          <span class="left_txt2">����</span><span class="left_txt3">�û���ţ��û��������û��Ա��û�סַ���û��绰���û���ͥ���û����䣬��ע���û����գ�����</span>
                          <span class="left_txt2">�Լ�������</span><span class="left_txt3">��Ա���ȼ���������</span><span class="left_txt2">�� </span></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>
            <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
              <tr>
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;������ϸ�ƻ�ҳ��</td>
              </tr>
            </table>
            </td>
          </tr>
          <tr>
            
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
			  	<td height="30" align="left" class="left_txt2">����ţ�<input type="text" id="LOAN_NO" name="LOAN_NO" value="${requestScope.repayBean.LOAN_NO}"/></td>
               	<td height="30" align="center" class="left_txt2">���źţ�<input type="text" id="DD_NO" name="DD_NO" value="${requestScope.repayBean.DD_NO}"/></td>
               </tr>
              <tr>
              	<td height="30" align="left" class="left_txt2"><input type="button" value="��ѯ" onclick="getRepayMess()"/></td>
              </tr>
			  <tr>
                <td height="30" align="left" class="left_txt2">�����գ�<input type="text" name="PRI_REPAY_DAY" value="${requestScope.repayBean.PRI_REPAY_DAY}"/></td>
               	<td height="30" align="center" class="left_txt2">�������ڣ�<input type="text" name="DD_DATE" ID="DD_DATE" value="${requestScope.repayBean.DD_DATE}"/></td>
               </tr>
              <tr>
                  <td height="30" align="left" class="left_txt2">�������ڣ�<input name="REPAY_DATE"  type="text" value="${requestScope.repayBean.REPAY_DATE}"/></td>
                  <td height="30" align="center" class="left_txt2">�������ڣ�<input name="END_DATE"  type="text" value="${requestScope.repayBean.END_DATE }"/></td>
              </tr>	
              <tr>
              	<td height="30" align="left" class="left_txt2">�������ڣ�<input type="text" name="PRI_REPAY_FREQ" value="${requestScope.repayBean.PRI_REPAY_FREQ}""/></td>
                <td height="30" align="center" class="left_txt2">�������ڣ�<input name="TRAN_DATE" type="text" value="${requestScope.repayBean.TRAN_DATE }"/></td>
              </tr>
               <tr>
              	<td height="30" align="left" class="left_txt2">���Ž�<input type="text" name="DD_AMT" id="DD_AMT" value="${requestScope.repayBean.DD_AMT}""/></td>
                <td height="30" align="center" class="left_txt2">ʵ�����ʣ�<input name="INT_RATE" id="INT_RATE" type="text" value="${requestScope.repayBean.INT_RATE }"/></td>
              </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="50%" height="30" align="right"><input type="submit" value="�ύ"  onclick="messSend();"/></td>
              <td width="6%" height="30" align="right">&nbsp;</td>
              <td width="44%" height="30"><input type="reset" value="ȡ��"  /></td>
            </tr>
            <tr>
              <td height="30" colspan="3">&nbsp;</td>
            </tr>
        </table>
      </tr>
     
    </table></td>
   
  </tr>
  
</table>
 
</td>
</tr>
</table>
</form>
</body>
<script type="text/javascript">
var tooltipObj = new DHTMLgoodies_formTooltip();
tooltipObj.setTooltipPosition('right');
tooltipObj.setPageBgColor('#f2f2f2');
tooltipObj.setTooltipCornerSize(10);
tooltipObj.initFormFieldTooltip();
</script>
</html>
