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
<title>��Ϣ�������</title>
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


<body onLoad="messRecieve(${pageScope.reMess });">
<form name="form2" method="POST" action="accruals.do" onSubmit="return check();">

<table class="table" cellspacing="1" cellpadding="2" width="99%" align="center" 
border="0">
  <tbody>
    <tr>
      <th class="bg_tr" align="center" colspan="2" height="25"> ������Ϣ</th>
    </tr>
    <tr>
      <td class="td_bg" width="50%" height="43">
      
          <label></label>
          <label>�������ͣ�
          <select name="select" onChange="findACT(this.value)">
            <option value='1'>1����ѯ</option>
            <option value='2'>2���޸�</option>
          </select>
          </label>
          </td>
      <td class="td_bg" width="50%">����ţ�
        <label>
        <input name="LOAN_NO" type="text" size="38" maxlength="38" value="${requestScope.accrualsBean.LOAN_NO}"/>
      </label></td>
    </tr>
    <tr>
      <td class="td_bg" width="50%" height="46"><label>���źţ�
          <input name="DD_NO" type="text" size="38" maxlength="38" value="${requestScope.accrualsBean.DD_NO}"/>
      </label></td>
      <td class="td_bg" width="50%"><label id=findACT>
     
	  <input type="submit" name="Submit3" value="��ѯ" onclick="sele();"/>
              
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
      <th class="bg_tr" align="center" colspan="2" height="25">�˻���Ϣ</th>
    </tr>
    <tr>
      <td class="td_bg" width="50%" height="47"><label>�����ˣ�
          <input name="LENDER" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.LENDER}"/>
      </label></td>
      <td width="50%" class="td_bg"><label>����״̬��
          <input name="STATUS" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.STATUS}"/>
      </label></td>
    </tr>
    <tr>
      <td class="td_bg" width="50%" height="46"><label>��ͬ��
      <input name="ORIG_LOAN_AMT" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.ORIG_LOAN_AMT}"/> </label></td>
		  
      <td class="td_bg" width="50%"><label>���Ž�
          <input name="DD_AMT" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.DD_AMT}"/>
      </label></td>
    </tr>
	
	<tr>
      <td class="td_bg" width="50%" height="42"><label>δ���Ž�
      <input name="NOT_FOND" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.NOT_FOND}"/> </label></td>
		  
      <td class="td_bg" width="50%" height="42"><label>�������ͣ�
      <input name="LOAN_TYPE" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.LOAN_TYPE}"/> </label>
      </td> 
    </tr>
	
	<tr>
      <td class="td_bg" width="50%" height="42"><label>����������
      <input name="BOOK_BRANCH" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.BOOK_BRANCH}"/> </label>
      </td> 
		  
       <td class="td_bg" width="50%" height="42"><label>���������ͣ�
      <input name="LOAN_SUB_TYPE" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.LOAN_SUB_TYPE}"/> </label>
      </td>
    </tr>
	
	<tr>
      <td class="td_bg" width="50%" height="38"><label>����ʱ�䣺
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
      <th class="bg_tr" align="center" colspan="2" height="30">��Ϣ��Ϣ</th>
    </tr>
    <tr>
      <td class="td_bg" width="50%" height="39"><label>Ӧ����Ϣ��
          <input name="INTEREST_AMT" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.INTEREST_AMT}"/>
      </label></td>
      <td width="50%" class="td_bg"><label>Ӧ�շ�Ϣ��
          <input name="PENALTY_AMT_PRI" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.PENALTY_AMT_PRI}"/>
      </label></td>
    </tr>
    <tr>
      <td class="td_bg" height="37"><span class="TableRow2">
        <label>Ӧ�ո�����
        <input name="PENALTY_AMT_INT" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.PENALTY_AMT_INT}"/>
        </label>
      </span></td>
      <td class="td_bg" height="37"><span class="TableRow2">
        <label>��ǰ���ʣ�
        <input name="INT_RATE" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.INT_RATE}"/>
        </label>
      </span></td>
    </tr>
    
    <tr>
      <td class="td_bg" height="37"><span class="TableRow2">
        <label>��׼���ʣ�
        <input name="INT_BASISRATE" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.INT_BASISRATE}"/>
        </label>
      </span></td>
      <td class="td_bg" height="37"><span class="TableRow2">
        <label>����Ϣ�ʣ�
        <input name="PRI_PLTI_RATE" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.PRI_PLTI_RATE}"/>
        </label>
      </span></td>
    </tr>
    
    <tr>
      <td class="td_bg" height="37"><span class="TableRow2">
        <label>��׼��Ϣ�ʣ�
        <input name="PRI_PLTY_ABS" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.PRI_PLTY_ABS}"/>
        </label>
      </span></td>
      <td class="td_bg" width="50%" height="38"><label>�������ʣ�
          <input name="INT_PITY_RATE" type="text" size="40" maxlength="40" value="${requestScope.accrualsBean.INT_PITY_RATE}"/>
      </label></td>
    </tr>
    
    <tr>
      <td class="td_bg" height="37"><span class="TableRow2">
        <label>��׼�����ʣ�
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
	  <input type="submit" name="Submit2" value="�ύ" onclick="messSend();"/>
	  </label></td>
      <td width="51%" align="center" class="td_bg"><label>
      <input type="reset" name="Submit3" value="ȡ��">
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
