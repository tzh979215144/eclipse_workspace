<%@page language="java" import="java.util.*" pageEncoding="GBK" isELIgnored="false"%>
<%@page import="org.zhoukan.bean.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
settlePayBean reMess = (settlePayBean)request.getAttribute("settlePayBean");
if(reMess != null){
	pageContext.setAttribute("reMess",reMess.getRecieveMess());
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发放结算</title>
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
  		mess='';
  	}
  	sendMess.innerHTML='执行完成';
  	recieveMess.innerHTML=mess;
  	//alert(1);
}

</script>

<script type="text/javascript">
  	  
          function getSP()
         {
            var DD_NO=document.getElementById('dd_no').value;
            var LOAN_NO2=document.getElementById('loan_no').value;
    if(DD_NO == '' || DD_NO == null){
		alert('发放号不能为空！');
		messRecieve();
		return false;
     	}
    if(LOAN_NO2 == '' || LOAN_NO2 == null){
		alert('贷款号不能为空！');
		messRecieve();
		return false;
     	}
	 //ajax
	 var ajax = new AjaxApi('getMessage.do', 'LOAN_NO2='+LOAN_NO2+'&DD_NO='+DD_NO,doxml1,messSend);
	 //actionmessage中配置，页面传值，执行完成的js,先开始时执行的
	 	 ajax.send();
		
	 //执行
         }
          function doxml1(xml){
         messRecieve();	
	     var LOAN_NO = xml.getElementsByTagName('LOAN_NO2')[0].text;	
	     var DD_NO = xml.getElementsByTagName('DD_NO')[0].text;
             var CLIENT = xml.getElementsByTagName('CLIENT')[0].text;
             var NAME = xml.getElementsByTagName('NAME')[0].text;
             var BRANCH = xml.getElementsByTagName('BRANCH')[0].text;
             var LOAN_TYPE = xml.getElementsByTagName('LOAN_TYPE')[0].text;
             var LOAN_SUB_TYPE = xml.getElementsByTagName('LOAN_SUB_TYPE')[0].text;	
	     var USER_ID = xml.getElementsByTagName('USER_ID')[0].text;
             var CCY = xml.getElementsByTagName('CCY')[0].text;
             var SETTLE_AMT = xml.getElementsByTagName('SETTLE_AMT')[0].text;
             var INT_RATE = xml.getElementsByTagName('INT_RATE')[0].text;
             var BASE_ACCT_NO = xml.getElementsByTagName('BASE_ACCT_NO')[0].text;
	     document.getElementById('LOAN_NO').value = LOAN_NO;
	     document.getElementById('DD_NO').value = DD_NO;
             document.getElementById('CLIENT').value = CLIENT;
             document.getElementById('NAME').value = NAME;
             document.getElementById('BRANCH').value = BRANCH;
             document.getElementById('LOAN_TYPE').value =LOAN_TYPE;
             document.getElementById('LOAN_SUB_TYPE').value = LOAN_SUB_TYPE;
	     document.getElementById('USER_ID').value = USER_ID;
             document.getElementById('CCY').value = CCY;
             document.getElementById('SETTLE_AMT').value = SETTLE_AMT;
             document.getElementById('INT_RATE').value = INT_RATE;
	     document.getElementById('BASE_ACCT_NO').value = BASE_ACCT_NO;
	 }
	 
	 function tgValue(xml,tgName){
	 	var val = xml.getElementsByTagName(tgName)[0];
	 	if(val == '' || val == null){
	 		return '';
	 	}
	 	return val.text;
	}
  </script>
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
  </head>
  <body onLoad="messRecieve(${pageScope.reMess });">
  
 <form name="form1" method="POST" action="settlePay.do" onSubmit="return check();">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" height="29" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td width="935" height="29" valign="top" background="images/content-bg.gif">
    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">发放结算</div></td>
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
            <td class="left_txt">当前位置：发放结算</td>
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
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;发放结算</td>
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
                <td height="30" align="right" class="left_txt2">贷款号：</td>
                <td height="30"><input name="LOAN_NO" type="text" size="30"   maxlength="18" value="${requestScope.settlePayBean.LOAN_NO }" /></td>
                <td height="30" align="right" class="left_txt2">发放号：</td>
                <td height="30"><input name="DD_NO" type="text" size="30"  maxlength="18" value="${requestScope.settlePayBean.DD_NO }" /><a class="must">*</a></td>
              </tr>
			     
              
              <tr>
              <td height="30" align="right" class="left_txt2"></td>
               <td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2"><input type="button" value="获取相关信息"  onclick="getSP();"/></td>
              </tr>
         </table>
         
         
            <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
              <tr>
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;发放结算明细</td>
              </tr>
            </table>
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        
                <tr>
                <td height="30" align="right" class="left_txt2">贷款人编号：</td>
                <td height="30"><input name="CLIENT" type="text" size="30"   maxlength="18" value="${requestScope.settlePayBean.CLIENT }" /><a class="must"></a></td>
                <td height="30" align="right" class="left_txt2">贷款人姓名：</td>
                <td height="30"><input name="NAME" type="text" size="30"   maxlength="18" value="${requestScope.settlePayBean.NAME }" /><a class="must"></a></td>
              </tr>
              	
               <tr>
               <td height="30" align="right" class="left_txt2">贷款发放银行：</td>
                <td height="30"><input name="BRANCH" type="text" size="30"   maxlength="18" value="${requestScope.settlePayBean.BRANCH }" /><a class="must"></a></td>
			 	<td height="30" align="right" class="left_txt2">贷款类型：</td>
                <td height="30"><input name="LOAN_TYPE" type="text" size="30"   maxlength="18" value="${requestScope.settlePayBean.LOAN_TYPE }" /><a class="must"></a></td>
              </tr>
          
             
             <tr>      
                <td height="30" align="right" class="left_txt2">贷款子类型：</td>
                <td height="30"><input name="LOAN_SUB_TYPE" type="text" size="30"   maxlength="18" value="${requestScope.settlePayBean.LOAN_SUB_TYPE }" /><a class="must"></a></td>
			 	<td width="15%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">客户经理：</td>
                <td height="30"><input name="USER_ID" type="text" size="30"   maxlength="18" value="${requestScope.settlePayBean.USER_ID }" /><a class="must"></a></td>
              </tr>	

             <tr>
                
                <td height="30" align="right" class="left_txt2">发放币种：</td>
                <td height="30"><input name="CCY" type="text" size="30"   maxlength="18" value="${requestScope.settlePayBean.CCY }" /><a class="must"></a></td>
              	<td height="30" align="right" class="left_txt2">发放金额：</td>
                <td height="30"><input name="SETTLE_AMT" type="text" size="30"   maxlength="18" value="${requestScope.settlePayBean.SETTLE_AMT }" /><a class="must"></a></td>
              </tr>
              <tr>
                <td height="30" align="right" class="left_txt2">贷款利率：</td>
                <td height="30"><input name="INT_RATE" type="text" size="30"   maxlength="18" value="${requestScope.settlePayBean.INT_RATE }" /></td>
                 <td height="30" align="right" class="left_txt2">结算帐号：</td>
                <td height="30"><input name="BASE_ACCT_NO" type="text" size="30"   maxlength="18" value="${requestScope.settlePayBean.BASE_ACCT_NO }" /><a class="must"></a></td>
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
