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
    
    <title>还款计划</title>
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
	function getRepayMess(){
	var dd_no =document.getElementById('DD_NO').value;
	if(dd_no == null || dd_no ==''){
		alert('发放号不能为空');
		messRecieve();
		return false;
	}
	var ajax = new AjaxApi('getMessage.do', 'FAFANG='+dd_no,doxml,messSend);
	 //actionmessage中配置，页面传值，执行完成的js,先开始时执行的
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
        <td height="31"><div class="titlebt">还款计划</div></td>
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
            <td class="left_txt">当前位置：还款计划</td>
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
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;还款详细计划页面</td>
              </tr>
            </table>
            </td>
          </tr>
          <tr>
            
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
			  	<td height="30" align="left" class="left_txt2">贷款号：<input type="text" id="LOAN_NO" name="LOAN_NO" value="${requestScope.repayBean.LOAN_NO}"/></td>
               	<td height="30" align="center" class="left_txt2">发放号：<input type="text" id="DD_NO" name="DD_NO" value="${requestScope.repayBean.DD_NO}"/></td>
               </tr>
              <tr>
              	<td height="30" align="left" class="left_txt2"><input type="button" value="查询" onclick="getRepayMess()"/></td>
              </tr>
			  <tr>
                <td height="30" align="left" class="left_txt2">还款日：<input type="text" name="PRI_REPAY_DAY" value="${requestScope.repayBean.PRI_REPAY_DAY}"/></td>
               	<td height="30" align="center" class="left_txt2">发放日期：<input type="text" name="DD_DATE" ID="DD_DATE" value="${requestScope.repayBean.DD_DATE}"/></td>
               </tr>
              <tr>
                  <td height="30" align="left" class="left_txt2">还款日期：<input name="REPAY_DATE"  type="text" value="${requestScope.repayBean.REPAY_DATE}"/></td>
                  <td height="30" align="center" class="left_txt2">到期日期：<input name="END_DATE"  type="text" value="${requestScope.repayBean.END_DATE }"/></td>
              </tr>	
              <tr>
              	<td height="30" align="left" class="left_txt2">还款周期：<input type="text" name="PRI_REPAY_FREQ" value="${requestScope.repayBean.PRI_REPAY_FREQ}""/></td>
                <td height="30" align="center" class="left_txt2">交易日期：<input name="TRAN_DATE" type="text" value="${requestScope.repayBean.TRAN_DATE }"/></td>
              </tr>
               <tr>
              	<td height="30" align="left" class="left_txt2">发放金额：<input type="text" name="DD_AMT" id="DD_AMT" value="${requestScope.repayBean.DD_AMT}""/></td>
                <td height="30" align="center" class="left_txt2">实际利率：<input name="INT_RATE" id="INT_RATE" type="text" value="${requestScope.repayBean.INT_RATE }"/></td>
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
