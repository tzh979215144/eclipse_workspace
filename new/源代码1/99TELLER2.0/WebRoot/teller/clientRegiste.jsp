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
    
    <title>客户开户</title>
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
	 var CLIENT_NAME = $("CLIENT_NAME");
	if(CLIENT_NAME == '' || CLIENT_NAME == null){
		alert("英文名不能为空！");
		messRecieve();
		return false;
	}
	 /*var tel_txt = /(^[a-z][A-Z]$/;
	if(!tel_txt.test(CLIENT_NAME)){
		alert("英文名格式不对！");
		messRecieve();
		return false;
	}*/
	
 var CLIENT_TEL_TYPE = $("CLIENT_TEL_TYPE");
	if(CLIENT_TEL_TYPE == '' || CLIENT_TEL_TYPE == null){
		alert("联系方式不能为空！");
		messRecieve();
		return false;
	}
	
	 var CLIENT_PROVINCE = $("CLIENT_PROVINCE");
	if(CLIENT_PROVINCE == '' || CLIENT_PROVINCE == null){
		alert("省份不能为空！");
		messRecieve();
		return false;
	}
	var CLIENT_CITY = $("CLIENT_CITY"); 
	if(CLIENT_CITY == '' || CLIENT_CITY == null){
		alert("城市不能为空！");
		messRecieve();
		return false;
	}
	
	var CLIENT_ADDR = $("CLIENT_ADDR");
	if(CLIENT_ADDR == '' || CLIENT_ADDR == null){
		alert("地址不能为空！");
		messRecieve();
		return false;
	}
	
	var CLIENT_TEL = $("CLIENT_TEL");
	if(CLIENT_TEL == '' || CLIENT_TEL == null){
		alert("电话不能为空！");
		messRecieve();
		return false;
	}
	var tel_txt = /(^[0-9][0-9]{3,4}[0-9]{8}$)|^[0-9]{11}/;
	if(!tel_txt.test(CLIENT_TEL)){
		alert("电话格式不对！");
		messRecieve();
		return false;
	}
	
	var CLIENT_ADDR_ZONE_CODE = $("CLIENT_ADDR_ZONE_CODE");
	var tel_txt = /(^[0-9]{3,4}$)/;
	if(!tel_txt.test(CLIENT_ADDR_ZONE_CODE)){
		alert("地区区号格式不对，应该3-4位！");
		messRecieve();
		return false;
	}



	var CITY_POSTCODE = $("CITY_POSTCODE");
	var tel_txt = /(^[0-9]{6}$)/;
	if(!tel_txt.test(CITY_POSTCODE)){
		alert("邮编格式不对，应该6位数字！");
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
  <body onLoad="messRecieve(${pageScope.reMess });">
 <form name="form1" method="POST" action="clientRegister.do" onSubmit="return check();">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" height="29" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td width="935" height="29" valign="top" background="images/content-bg.gif">
    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">开户设置</div></td>
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
            <td class="left_txt">当前位置：客户注册</td>
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
                <td width="90%" valign="top"><span class="left_txt2">在这里，您可以根据
				客户信息填入</span><span class="left_txt3">基本参数</span><span class="left_txt2">！</span><br>
                          <span class="left_txt2">包括</span><span class="left_txt3">用户编号，用户姓名，用户性别，用户住址，用户电话，用户家庭，用户年龄，备注，用户生日，卡号</span>
                          <span class="left_txt2">以及卡密码</span><span class="left_txt3">会员及等级积分设置</span><span class="left_txt2">。 </span></td>
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
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;注册页面</td>
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
                <td height="30" align="right" class="left_txt2">客户编号：</td>
                <td height="30"><input type="text" name="CLIENT_NO" size="30"  readonly="readonly" value="${requestScope.clientBean.CLIENT_NO }"/></td>
                <td height="30" align="right" class="left_txt2">证件类型：</td>
                <td height="30"><select name="GLOBAL_ID_TYPE" style="width: 40%;"> <option value="identity_card" selected="selected">身份证</option>
			 										<option value="military_card">军人证</option>
			 										<option value="passport">护照</option></select><a class="must">*</a></td>
              </tr>	
              	
              <tr>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">证件号码：</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><input name="GLOBAL_ID" type="text" size="30"   maxlength="18" value="${requestScope.clientBean.GLOBAL_ID }" tooltipText="it must be a number"/><a class="must">*</a></td>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">发证国家：</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><select name="COUNTRY_LICENCE" style="width: 40%;"> <option value="china" selected="selected">中国</option>
			 										<option value="USA">美国</option>
			 										<option value="Canada">加拿大</option>
			 										<option value="England">英国</option>
			 										<option value="Italy">意大利</option>
			 										<option value="Japan">日本</option>
			 										<option value="Korea">韩国</option>
			 										<option value="Singapore">新加坡</option>
			 										</select><a class="must">*</a></td>
              </tr>
              
                <tr>
                <td height="30" align="right" class="left_txt2">重新输入证件号：</td>
                <td height="30"><input type="text" name="GLOBAL_ID_AGAIN" size="30"  maxlength="18" value="${requestScope.clientBean.GLOBAL_ID_AGAIN }"/><a class="must">*</a></td>
                <td height="30" align="right" class="left_txt2">性别：</td>
                <td height="30"><select name="SEX" style="width: 40%;"> <option value="1" selected="selected">1 男</option>
			 										<option value="2">2 女</option>
			 										<option value="3">3 不详</option></select></td>
              </tr>	
              	
              <tr>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">客户类型：</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><select name="CATEGORY_TYPE" style="width: 40%;"> <option value="1" selected="selected">1 一般用户</option>
			 										<option value="2">2 VIP</option></select><a class="must">*</a></td>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">客户分类：</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><select name="CLIENT_TYPE" style="width: 40%;"> <option value="1" selected="selected">1 贷款客户</option>
			 										<option value="2">2 储蓄客户</option></select><a class="must">*</a></td>
              </tr>
              
                <tr>
                <td height="30" align="right" class="left_txt2">中文名：</td>
                <td height="30"><input type="text" name="CH_CLIENT_NAME" size="30"  value="${requestScope.clientBean.CH_CLIENT_NAME }"/><a class="must">*</a></td>
                <td height="30" align="right" class="left_txt2">英文名：</td>
                <td height="30"><input type="text" name="CLIENT_NAME" size="30"  value="${requestScope.clientBean.CLIENT_NAME }" tooltipText="it must be an Englishname"/><a class="must">*</a></td>
              </tr>	
              	
              <tr>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">联系方式：</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><input name="CLIENT_TEL_TYPE" type="text"  size="30" value="${requestScope.clientBean.CLIENT_TEL_TYPE }"/><a class="must">*</a></td>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2"></td>
                <td width="35%" height="30" bgcolor="#f2f2f2"></td>
              </tr>
              
                <tr>
                <td height="30" align="right" class="left_txt2">国家：</td>
                <td height="30"><select name="COUNTRY_LOC" style="width: 40%;"> <option value="china" selected="selected">中国</option>
			 										<option value="USA">美国</option>
			 										<option value="Canada">加拿大</option>
			 										<option value="England">英国</option>
			 										<option value="Italy">意大利</option>
			 										<option value="Japan">日本</option>
			 										<option value="Korea">韩国</option>
			 										<option value="Singapore">新加坡</option>
			 										</select><a class="must">*</a></td>
                <td height="30" align="right" class="left_txt2">省份：</td>
                <td height="30"><input type="text" name="CLIENT_PROVINCE" size="30" value="${requestScope.clientBean.CLIENT_PROVINCE }" /><a class="must">*</a></td>
              </tr>	
              	
              <tr>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">城市：</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><input name="CLIENT_CITY" type="text"  size="30" value="${requestScope.clientBean.CLIENT_CITY }"/><a class="must">*</a></td>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">邮编：</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><input name="CITY_POSTCODE" type="text"   value="${requestScope.clientBean.CITY_POSTCODE }"size="30" /></td>
              </tr>
              
                <tr>
                <td height="30" align="right" class="left_txt2">地址信息：</td>
                <td height="30"><input type="text" name="CLIENT_ADDR" size="30"  value="${requestScope.clientBean.CLIENT_TEL_TYPE }"/><a class="must">*</a></td>
                <td height="30" align="right" class="left_txt2">地区号码：</td>
                <td height="30"><input type="text" name="CLIENT_ADDR_ZONE_CODE" size="30" value="${requestScope.clientBean.CLIENT_ADDR_ZONE_CODE }"  maxlength="8" tooltipText="it must be a number"/></td>
              </tr>	
              	
              <tr>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">电话：</td>
                <td width="35%" height="30" bgcolor="#f2f2f2"><input name="CLIENT_TEL" type="text"  size="30" value="${requestScope.clientBean.CLIENT_TEL }" maxlength="11" tooltipText="it must be a number"/><a class="must">*</a></td>
                <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">客户简称：</td>
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
              <td width="50%" height="30" align="right"><input type="submit" value="提交"  onclick="messSend();"/></td>
              <td width="6%" height="30" align="right">&nbsp;</td>
              <td width="44%" height="30"><input type="reset" value="取消"  /></td>
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
