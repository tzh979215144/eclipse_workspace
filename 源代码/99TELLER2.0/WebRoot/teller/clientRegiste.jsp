<%@page language="java" import="java.util.*" pageEncoding="GBK" isELIgnored="false"%>
<%@page import="org.zhoukan.bean.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ClientRegisterBean_TE reMess = (ClientRegisterBean_TE)request.getAttribute("clientBean");
if(reMess != null){
	pageContext.setAttribute("reMess",reMess.getRecieveMess());
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�ͻ�����</title>
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
  </head>
 <!--  <script type="text/javascript" src="/TELLER2.0/myjs/change.js"> </script>--> 
<script type="text/javascript">
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
	 var CLIENT_NAME = $("CLIENT_NAME");
	if(CLIENT_NAME == '' || CLIENT_NAME == null){
		alert("Ӣ��������Ϊ�գ�");
		messRecieve();
		return false;
	}
	 /*var tel_txt = /(^[a-z][A-Z]$/;
	if(!tel_txt.test(CLIENT_NAME)){
		alert("Ӣ������ʽ���ԣ�");
		messRecieve();
		return false;
	}*/
	
 var CLIENT_TEL_TYPE = $("CLIENT_TEL_TYPE");
	if(CLIENT_TEL_TYPE == '' || CLIENT_TEL_TYPE == null){
		alert("��ϵ��ʽ����Ϊ�գ�");
		messRecieve();
		return false;
	}
	
	 var CLIENT_PROVINCE = $("CLIENT_PROVINCE");
	if(CLIENT_PROVINCE == '' || CLIENT_PROVINCE == null){
		alert("ʡ�ݲ���Ϊ�գ�");
		messRecieve();
		return false;
	}
	var CLIENT_CITY = $("CLIENT_CITY"); 
	if(CLIENT_CITY == '' || CLIENT_CITY == null){
		alert("���в���Ϊ�գ�");
		messRecieve();
		return false;
	}
	
	var CLIENT_ADDR = $("CLIENT_ADDR");
	if(CLIENT_ADDR == '' || CLIENT_ADDR == null){
		alert("��ַ����Ϊ�գ�");
		messRecieve();
		return false;
	}
	
	var CLIENT_TEL = $("CLIENT_TEL");
	if(CLIENT_TEL == '' || CLIENT_TEL == null){
		alert("�绰����Ϊ�գ�");
		messRecieve();
		return false;
	}
	var tel_txt = /(^[0-9][0-9]{3,4}[0-9]{8}$)|^[0-9]{11}/;
	if(!tel_txt.test(CLIENT_TEL)){
		alert("�绰��ʽ���ԣ�");
		messRecieve();
		return false;
	}
	
	var CLIENT_ADDR_ZONE_CODE = $("CLIENT_ADDR_ZONE_CODE");
	var tel_txt = /(^[0-9]{3,4}$)/;
	if(!tel_txt.test(CLIENT_ADDR_ZONE_CODE)){
		alert("�������Ÿ�ʽ���ԣ�Ӧ��3-4λ��");
		messRecieve();
		return false;
	}



	var CITY_POSTCODE = $("CITY_POSTCODE");
	var tel_txt = /(^[0-9]{6}$)/;
	if(!tel_txt.test(CITY_POSTCODE)){
		alert("�ʱ��ʽ���ԣ�Ӧ��6λ���֣�");
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
  <body onLoad="messRecieve(${pageScope.reMess });">
 <form name="form1" method="POST" action="clientRegister.do" onSubmit="return check();">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" height="29" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td width="935" height="29" valign="top" background="images/content-bg.gif">
    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">��������</div></td>
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
            <td class="left_txt">��ǰλ�ã��ͻ�ע��</td>
          </tr>
          <tr>
            <td height="20"><table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
              <tr>
                <td></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" height="55" border="0" cellpadding="0" cellspacing="0">
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
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;ע��ҳ��</td>
              </tr>
            </table>
            </td>
          </tr>
          <tr>
            <td>
            
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
<td><input name="OPER_ID" type="hidden" value="${sessionScope.loginBean.USER_NAME }"/></td>
				</tr>
    
			  <tr>
                <td height="30" align="right" class="left_txt2">�ͻ���ţ�</td>
                <td height="30"><input type="text" name="CLIENT_NO" size="30"  readonly="readonly" value="${requestScope.clientBean.CLIENT_NO }"/></td>
                <td height="30" align="right" class="left_txt2">֤�����ͣ�</td>
                <td height="30"><select name="GLOBAL_ID_TYPE" style="width: 40%;"> <option value="identity_card" selected="selected">���֤</option>
			 										<option value="military_card">����֤</option>
			 										<option value="passport">����</option></select><a class="must">*</a></td>
              </tr>	
              	
              <tr>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">֤�����룺</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><input name="GLOBAL_ID" type="text" size="30"   maxlength="18" value="${requestScope.clientBean.GLOBAL_ID }" tooltipText="it must be a number"/><a class="must">*</a></td>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">��֤���ң�</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><select name="COUNTRY_LICENCE" style="width: 40%;"> <option value="china" selected="selected">�й�</option>
			 										<option value="USA">����</option>
			 										<option value="Canada">���ô�</option>
			 										<option value="England">Ӣ��</option>
			 										<option value="Italy">�����</option>
			 										<option value="Japan">�ձ�</option>
			 										<option value="Korea">����</option>
			 										<option value="Singapore">�¼���</option>
			 										</select><a class="must">*</a></td>
              </tr>
              
                <tr>
                <td height="30" align="right" class="left_txt2">��������֤���ţ�</td>
                <td height="30"><input type="text" name="GLOBAL_ID_AGAIN" size="30"  maxlength="18" value="${requestScope.clientBean.GLOBAL_ID_AGAIN }"/><a class="must">*</a></td>
                <td height="30" align="right" class="left_txt2">�Ա�</td>
                <td height="30"><select name="SEX" style="width: 40%;"> <option value="1" selected="selected">1 ��</option>
			 										<option value="2">2 Ů</option>
			 										<option value="3">3 ����</option></select></td>
              </tr>	
              	
              <tr>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">�ͻ����ͣ�</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><select name="CATEGORY_TYPE" style="width: 40%;"> <option value="1" selected="selected">1 һ���û�</option>
			 										<option value="2">2 VIP</option></select><a class="must">*</a></td>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">�ͻ����ࣺ</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><select name="CLIENT_TYPE" style="width: 40%;"> <option value="1" selected="selected">1 ����ͻ�</option>
			 										<option value="2">2 ����ͻ�</option></select><a class="must">*</a></td>
              </tr>
              
                <tr>
                <td height="30" align="right" class="left_txt2">��������</td>
                <td height="30"><input type="text" name="CH_CLIENT_NAME" size="30"  value="${requestScope.clientBean.CH_CLIENT_NAME }"/><a class="must">*</a></td>
                <td height="30" align="right" class="left_txt2">Ӣ������</td>
                <td height="30"><input type="text" name="CLIENT_NAME" size="30"  value="${requestScope.clientBean.CLIENT_NAME }" tooltipText="it must be an Englishname"/><a class="must">*</a></td>
              </tr>	
              	
              <tr>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">��ϵ��ʽ��</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><input name="CLIENT_TEL_TYPE" type="text"  size="30" value="${requestScope.clientBean.CLIENT_TEL_TYPE }"/><a class="must">*</a></td>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2"></td>
                <td width="35%" height="30" bgcolor="#f2f2f2"></td>
              </tr>
              
                <tr>
                <td height="30" align="right" class="left_txt2">���ң�</td>
                <td height="30"><select name="COUNTRY_LOC" style="width: 40%;"> <option value="china" selected="selected">�й�</option>
			 										<option value="USA">����</option>
			 										<option value="Canada">���ô�</option>
			 										<option value="England">Ӣ��</option>
			 										<option value="Italy">�����</option>
			 										<option value="Japan">�ձ�</option>
			 										<option value="Korea">����</option>
			 										<option value="Singapore">�¼���</option>
			 										</select><a class="must">*</a></td>
                <td height="30" align="right" class="left_txt2">ʡ�ݣ�</td>
                <td height="30"><input type="text" name="CLIENT_PROVINCE" size="30" value="${requestScope.clientBean.CLIENT_PROVINCE }" /><a class="must">*</a></td>
              </tr>	
              	
              <tr>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">���У�</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><input name="CLIENT_CITY" type="text"  size="30" value="${requestScope.clientBean.CLIENT_CITY }"/><a class="must">*</a></td>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">�ʱࣺ</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><input name="CITY_POSTCODE" type="text"   value="${requestScope.clientBean.CITY_POSTCODE }"size="30" /></td>
              </tr>
              
                <tr>
                <td height="30" align="right" class="left_txt2">��ַ��Ϣ��</td>
                <td height="30"><input type="text" name="CLIENT_ADDR" size="30"  value="${requestScope.clientBean.CLIENT_TEL_TYPE }"/><a class="must">*</a></td>
                <td height="30" align="right" class="left_txt2">�������룺</td>
                <td height="30"><input type="text" name="CLIENT_ADDR_ZONE_CODE" size="30" value="${requestScope.clientBean.CLIENT_ADDR_ZONE_CODE }"  maxlength="8" tooltipText="it must be a number"/></td>
              </tr>	
              	
              <tr>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">�绰��</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><input name="CLIENT_TEL" type="text"  size="30" value="${requestScope.clientBean.CLIENT_TEL }" maxlength="11" tooltipText="it must be a number"/><a class="must">*</a></td>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">�ͻ���ƣ�</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><input name="CLIENT_SHORT" type="text"  size="30" value="${requestScope.clientBean.CLIENT_SHORT }" maxlength="50"/><a class="must">*</a></td>
              </tr>
                 
              <tr>
                <td height="17" colspan="4" align="right" >&nbsp;</td>
              </tr>
              <tr>
                <td height="30" colspan="4" align="right" class="left_txt2"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
                  <tr>
                    <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                  </tr>
                </table></td>
              </tr>
        
            </table>
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
          </table></td>
      </tr>
     
    </table></td>
   
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
