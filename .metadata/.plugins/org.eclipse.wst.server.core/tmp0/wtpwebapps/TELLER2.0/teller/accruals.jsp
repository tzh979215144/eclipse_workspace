<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="org.zhoukan.bean.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
AccrualsBean reMess = (AccrualsBean)request.getAttribute("accrualsBean");
if(reMess != null){
	pageContext.setAttribute("reMess",reMess.getRecieveMess());
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>利息计提调整</title>
<link href="../mages/css1/css.css" rel="stylesheet" type="text/css">
</head>

<!--  <script type="text/javascript" src="/TELLER2.0/myjs/change.js"> </script>--> 
<script type="text/javascript">
function sele(){
  	form2.action="getAccrualsMes.do";
  	form2.submit;
}

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


<body onLoad="messRecieve(${pageScope.reMess });">
<form name="form2" method="POST" action="accruals.do" onSubmit="return check();">

<table class="table" cellspacing="1" cellpadding="2" width="99%" align="center" 
border="0">
  <tbody>
    <tr>
      <th class="bg_tr" align="center" colspan="2" height="25"> 计提信息</th>
    </tr>
    <tr>
      <td class="td_bg" width="50%" height="43">
      
          <label></label>
          <label>操作类型：
          <select name="select" onChange="findACT(this.value)">
            <option value='1'>1、查询</option>
            <option value='2'>2、修改</option>
          </select>
          </label>
          </td>
      <td class="td_bg" width="50%">贷款号：
        <label>
        <input name="LOAN_NO" type="text" size="38" maxlength="38" value="${requestScope.accrualsBean.LOAN_NO}"/>
      </label></td>
    </tr>
    <tr>
      <td class="td_bg" width="50%" height="46"><label>发放号：
          <input name="DD_NO" type="text" size="38" maxlength="38" value="${requestScope.accrualsBean.DD_NO}"/>
      </label></td>
      <td class="td_bg" width="50%"><label id=findACT>
     
	  <input type="submit" name="Submit3" value="查询" onclick="sele();"/>
              
      </label></td>
    </tr>
    
    
  
    <tr>
      <td  colspan="2" class="td_bg">&nbsp;</td>
    </tr>
  </tbody>
</table>
<table class="table" cellspacing="1" cellpadding="2" width="99%" align="center" 
border="0">
  <tbody>
    <tr>
      <th class="bg_tr" align="center" colspan="2" height="25">账户信息</th>
    </tr>
    <tr>
      <td class="td_bg" width="50%" height="47"><label>贷款人：
          <input name="LENDER" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.LENDER}"/>
      </label></td>
      <td width="50%" class="td_bg"><label>贷款状态：
          <input name="STATUS" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.STATUS}"/>
      </label></td>
    </tr>
    <tr>
      <td class="td_bg" width="50%" height="46"><label>合同金额：
      <input name="ORIG_LOAN_AMT" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.ORIG_LOAN_AMT}"/> </label></td>
		  
      <td class="td_bg" width="50%"><label>发放金额：
          <input name="DD_AMT" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.DD_AMT}"/>
      </label></td>
    </tr>
	
	<tr>
      <td class="td_bg" width="50%" height="42"><label>未发放金额：
      <input name="NOT_FOND" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.NOT_FOND}"/> </label></td>
		  
      <td class="td_bg" width="50%" height="42"><label>贷款类型：
      <input name="LOAN_TYPE" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.LOAN_TYPE}"/> </label>
      </td> 
    </tr>
	
	<tr>
      <td class="td_bg" width="50%" height="42"><label>贷款经办机构：
      <input name="BOOK_BRANCH" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.BOOK_BRANCH}"/> </label>
      </td> 
		  
       <td class="td_bg" width="50%" height="42"><label>贷款子类型：
      <input name="LOAN_SUB_TYPE" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.LOAN_SUB_TYPE}"/> </label>
      </td>
    </tr>
	
	<tr>
      <td class="td_bg" width="50%" height="38"><label>交易时间：
          <input name="DD_DATE" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.DD_DATE}"/>
      </label></td>
		  
      <td class="td_bg" width="50%"><label></label></td> 
    </tr>
	
  </tbody>
</table>
<table class="table" cellspacing="1" cellpadding="2" width="99%" align="center" 
border="0">
  <tbody>
    <tr>
      <th class="bg_tr" align="center" colspan="2" height="30">利息信息</th>
    </tr>
    <tr>
      <td class="td_bg" width="50%" height="39"><label>应收利息：
          <input name="INTEREST_AMT" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.INTEREST_AMT}"/>
      </label></td>
      <td width="50%" class="td_bg"><label>应收罚息：
          <input name="PENALTY_AMT_PRI" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.PENALTY_AMT_PRI}"/>
      </label></td>
    </tr>
    <tr>
      <td class="td_bg" height="37"><span class="TableRow2">
        <label>应收复利：
        <input name="PENALTY_AMT_INT" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.PENALTY_AMT_INT}"/>
        </label>
      </span></td>
      <td class="td_bg" height="37"><span class="TableRow2">
        <label>当前利率：
        <input name="INT_RATE" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.INT_RATE}"/>
        </label>
      </span></td>
    </tr>
    
    <tr>
      <td class="td_bg" height="37"><span class="TableRow2">
        <label>基准利率：
        <input name="INT_BASISRATE" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.INT_BASISRATE}"/>
        </label>
      </span></td>
      <td class="td_bg" height="37"><span class="TableRow2">
        <label>本金罚息率：
        <input name="PRI_PLTI_RATE" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.PRI_PLTI_RATE}"/>
        </label>
      </span></td>
    </tr>
    
    <tr>
      <td class="td_bg" height="37"><span class="TableRow2">
        <label>基准罚息率：
        <input name="PRI_PLTY_ABS" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.PRI_PLTY_ABS}"/>
        </label>
      </span></td>
      <td class="td_bg" width="50%" height="38"><label>复利利率：
          <input name="INT_PITY_RATE" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.INT_PITY_RATE}"/>
      </label></td>
    </tr>
    
    <tr>
      <td class="td_bg" height="37"><span class="TableRow2">
        <label>基准复利率：
        <input name="INT_PITY_ABS" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.INT_PITY_ABS}"/>
        </label>
      </span></td>
      <td class="td_bg" width="50%" height="38"></td>
    </tr>
    
  </tbody>
</table>

<table class="table" cellspacing="1" cellpadding="2" width="99%" align="center" 
border="0">
  <tbody>
    <tr>
      <th height="53" colspan="2" align="center" class="bg_tr"><label></label>
      <label></label></th>
	  
	  <td width="49%" height="53" align="center" class="td_bg"><label>
	  <input type="submit" name="Submit2" value="提交" onclick="messSend();"/>
	  </label></td>
      <td width="51%" align="center" class="td_bg"><label>
      <input type="reset" name="Submit3" value="取消">
      </label></td>
	  
    </tr>
  </tbody>
</table>

<table class="table" cellspacing="1" cellpadding="2" width="99%" align="center" 
border="0">
  
</table>
</form>
</body>
</html>
