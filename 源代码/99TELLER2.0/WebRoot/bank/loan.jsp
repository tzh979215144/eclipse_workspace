<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ page import="org.zhoukan.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	LoanBean reMess = (LoanBean) request.getAttribute("loanbean");
	if (reMess != null) {
		pageContext.setAttribute("reMess", reMess.getRecieveMess());
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<title>贷款开立</title>
		<link href="../mages/css1/css.css" rel="stylesheet" type="text/css">
		<script type="text/javascript"
			src="/TELLER2.0/My97DatePicker/WdatePicker.js"></script>
		<link href="images/skin.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="teller/css/form-field-tooltip.css"  media="screen" type="text/css">
		<script type="text/javascript" src="teller/js/rounded-corners.js"></script>
		<script type="text/javascript" src="teller/js/form-field-tooltip.js"></script>
		<script type="text/javascript" src="/TELLER2.0/My97DatePicker/WdatePicker.js"></script>
	</head>
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
</script>

	<body onLoad="messRecieve(${pageScope.reMess});">
		<form name="form1" action="loan.do" method="post">
    <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">贷款开立</div></td>
      </tr>
    </table>
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
					<tr class="left_txt" align="left">
						<th  height="25">
							账号信息
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
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>				
					<tr>
						<td class="left_txt2" width="50%" height="43">
							贷款号：
							<label>
								<input type="text" name="LOAN_NO" size="30" readonly="readonly"
									value="${requestScope.loanbean.LOAN_NO}" />
							</label>
						</td>
						<td class="left_txt2" width="50%">
							
						</td>
					</tr>
										<tr>
						<td class="left_txt2" width="50%" height="43" >
							贷款人编号：					
							<label>
								<input name="BORROWER" type="text" size="40" maxlength="40"
									value="${requestScope.loanbean.BORROWER}" />
							</label>
						</td>
						<td class="left_txt2" width="50%">
							还款类型：						
							<label>
								<select name="ROCESS_TYPE" style="width: ;">
							<option value="A" selected="selected">
								自定义
							</option>
							<option value="E">
								等额还款
							</option>
							<option value="G">
								担保
							</option>
							<option value="N">
								一般通用
							</option>
						</select>
							</label>
						</td>
					</tr>
					<tr>
						<td class="left_txt2" width="50%" height="46">
							借款人：
							<label>
								<input name="LENDER" type="text" size="38" maxlength="38"
									value="${requestScope.loanbean.LENDER}" />
							</label>
						</td>
						<td class="left_txt2" width="50%">
							<label>
								贷款子类型：
								<select name="LOAN_SUB_TYPE">
									<option value="101">
										101 商业贷
									</option>
									<option value="102">
										102 住房贷
									</option>
									<option value="201">
										201 购房贷
									</option>
									<option value="202">
										202 商业贷
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<td class="left_txt2" width="50%" height="46">
							<label>
								合同号：
								<input name="CONTRACT_NO" type="text" size="38" maxlength="38"
									value="${requestScope.loanbean.CONTRACT_NO}" />
							</label>
						</td>
						<td class="left_txt2" width="50%">
							<label></label>
							<label></label>
							贷款类型：
							<select name="LOAN_TYPE">
								<option value="1">
									1 个人
								</option>
								<option value="2">
									2 单位
								</option>
							</select>
							<label></label>
						</td>
					</tr>
				</tbody>
			</table>
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
					<tr class="left_txt" align="left">
						<th  height="25">
							贷款开立明细
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
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>				
					<tr>
						<td class="left_txt2" width="50%" height="43">
							<label>
								贷款开始时间：
								<input name="START_DATE" type="text" size="40" maxlength="40"
									onClick=WdatePicker();; class="Wdate"
									value="${requestScope.loanbean.START_DATE}" />
							</label>
						</td>
						<td width="50%" class="left_txt2">
							<label>
								贷款到期日期：
								<input name="MATURE_DATE" type="text" size="40" maxlength="40"
									onClick=WdatePicker();; class="Wdate"
									value="${requestScope.loanbean.MATURE_DATE}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="left_txt2" width="50%" height="43">
							<label>
								贷款金额：
								<input name="LOAN_AMT" type="text" size="40" maxlength="40"
									value="${requestScope.loanbean.LOAN_AMT}" />
							</label>
						</td>
						<td class="left_txt2" width="50%">
							<label>
								贷款签约银行：
								<input name="BOOK_BRANCH" type="text" size="40" maxlength="40"
									value="${requestScope.loanbean.BOOK_BRANCH}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="left_txt2" width="50%" height="43">
							<label>
								当前发放额：
								<input name="DRAWN_AMT" type="text" size="40" maxlength="40"
									value="${requestScope.loanbean.DRAWN_AMT}" />
							</label>
						</td>
						<td class="left_txt2" width="50%">
							<label>
								贷款当前利率：
								<input name="INT_RATE" type="text" size="40" maxlength="40"
									value="${requestScope.loanbean.INT_RATE}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="left_txt2" width="50%" height="43">
							<label>
								账户币种：
								<select name="CCY">
									<option value="rmb">
										rmb
									</option>
									<option value="usa">
										usa
									</option>
									<option value="jap">
										jap
									</option>
									<option value="pod">
										pod
									</option>
								</select>
							</label>
						</td>
						<td class="left_txt2" width="50%">
							<label>
								提前出单天数：
								<input name="BILLING_DAYS" type="text" size="40" maxlength="40"
									value="${requestScope.loanbean.BILLING_DAYS}" />
							</label>
						</td>
					</tr>
					<tr>
						<td class="left_txt2" width="50%" height="43">
							<label>
								基准月天数：
								<select name="MONTH_BASIS">
									<option value="30">
										1 30
									</option>
								</select>
							</label>
						</td>
						<td class="left_txt2" width="50%">
							<label></label>
							<label>
								基准年天数：
								<select name="YEAR_BASIS">
									<option value="360">
										1 360
									</option>
								</select>
							</label>
						</td>
					</tr>
				</tbody>
			</table>
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
					<tr class="left_txt" align="left">
						<th  height="25">
							发放贷款到默认的账户的信息
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
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
			
				<tr>
					<td class="left_txt2" align="center" height="30" width="6%">
						账户类型
					</td>
					<td class="left_txt2" align="center" width="6%">
						结算方式
					</td>
					<td class="left_txt2" align="center" width="16%">
						子产品类型
					</td>
					<td class="left_txt2" align="center" width="16%">
						利率
					</td>
					<td class="left_txt2" align="center" width="8%">
						发放币种
					</td>
					<td class="left_txt2" align="center" width="16%">
						发放账号
					</td>
					<td class="left_txt2" align="center" width="16%">
						发放机构
					</td>
					<td class="left_txt2" align="center" width="16%">
						账户持有者
					</td>
				</tr>
				<tr>
					<td align="center" class="left_txt2">
						<select name="ACCT_TYPE" style="width: ;">
							<option value="HUO" selected="selected">
								活期
							</option>
							<option value="DING">
								定期
							</option>
						</select>
					</td>
					<td align="center" class="left_txt2" height="30">
						<select name="SELLET_TYPE" style="width: ;">
							<option value="AUTO" selected="selected">
								自动
							</option>
							<option value="HAND">
								手动
							</option>
						</select>
					</td>

					<td align="center" class="left_txt2">
						<select name="SUB_TYPE" style="width: 99%;">
							<option value="101" selected="selected">
								3个月，每月还一次
							</option>
							<option value="102">
								1年，每月还一次
							</option>
							<option value="103">
								2年，每月还一次
							</option>
							<option value="104">
								10年，每月还一次
							</option>
							<option value="201">
								3个月，每月还一次
							</option>
							<option value="202">
								1年，每月还一次
							</option>
							<option value="203">
								2年，每月还一次
							</option>
							<option value="204">
								10年，每月还一次
							</option>
						</select>
					</td>
					<td align="center" class="left_txt2">
						<input name="INT_RATE" value="${requestScope.loanbean.INT_RATE}" />
					</td>
					<td align="center" class="left_txt2">
						<select name="CCY" style="width: ;">
							<option value="RMB" selected="selected">
								人民币
							</option>
							<option value="$">
								美元
							</option>
							<option value="ou">
								欧元
							</option>
							<option value="pod">
								英镑
							</option>
						</select>
					</td>
					<td align="center" class="left_txt2" >
						<input name="ACCT_59" value="${requestScope.loanbean.ACCT_59 }" />
					</td>
					<td align="center" class="left_txt2">
						<input name="BOOK_BRANCH"
							value="${requestScope.loanbean.BOOK_BRANCH }" />
					</td>
					<td align="center" class="left_txt2">
						<input name="NAME_56" value="${requestScope.loanbean.NAME_56}" />
					</td>
				</tr>
			</table>
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
					<tr class="left_txt" align="left">
						<th  height="25">
							自动回收结算路径
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
			<table  class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr>
					<td class="left_txt2" align="center"  height="30" width="10%">
						账户类型
					</td>
					<td class="left_txt2" align="center" height="30" width="10%">
						结算方式
					</td>
					<td class="left_txt2" align="center" height="30" width="10%">
						子产品类型
					</td>
					<td class="left_txt2" align="center" height="30" width="15%">
						利率
					</td>
					<td class="left_txt2" align="center" height="30" width="5%">
						结算币种
					</td>
					<td class="left_txt2" align="center" height="30" width="5%">
						结算金额类型
					</td>
					<td class="left_txt2" align="center" height="30" width="15%">
						结算账号
					</td>
					<td class="left_txt2" align="center" height="30" width="15%">
						结算机构
					</td>
					<td class="left_txt2" align="center" height="30" width="15%">
						账户持有者
					</td>
				</tr>
				<tr>
					<td height="30" class="left_txt2" align="center">
						<select name="ACCT_TYPE" style="width: ;">
							<option value="活期" selected="selected">
								活期
							</option>
							<option value="定期">
								定期
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<select name="SELLET_TYPE">
							<option value="AUTO" selected="selected">
								自动
							</option>
							<option value="HAND">
								手动
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<select name="SUB_TYPE">
							<option value="101" selected="selected">
								3个月，每月还一次
							</option>
							<option value="102">
								1年，每月还一次
							</option>
							<option value="103">
								2年，每月还一次
							</option>
							<option value="104">
								10年，每月还一次
							</option>
							<option value="201">
								3个月，每月还一次
							</option>
							<option value="202">
								1年，每月还一次
							</option>
							<option value="203">
								2年，每月还一次
							</option>
							<option value="204">
								10年，每月还一次
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<input name="INT_RATE" value="${requestScope.loanbean.INT_RATE}" />
					</td>
					<td  class="left_txt2" align="center">
						<select name="BJ_CCY" style="width: ;">
							<option value="RMB" selected="selected">
								人民币
							</option>
							<option value="$">
								美元
							</option>
							<option value="OUy">
								欧元
							</option>
							<option value="pod">
								英镑
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<input name="BJ" value="本金" size="5"/>
					</td>
					<td  class="left_txt2" align="center">
						<input name="BJ_ACCT_59"
							value="${requestScope.loanbean.BJ_ACCT_59 }" />
					</td>
					<td  class="left_txt2" align="center">
						<input name="BOOK_BRANCH"
							value="${requestScope.loanbean.BOOK_BRANCH }" />
					</td>
					<td  class="left_txt2" align="center">
						<input name="BJ_LENDER" value="${requestScope.loanbean.BJ_LENDER}" />
					</td>
				</tr>
				<tr>
					<td class="left_txt2" align="center">
						<select name="ACCT_TYPE" style="width: ;">
							<option value="HUO" selected="selected">
								活期
							</option>
							<option value="DING">
								定期
							</option>
						</select>
					</td>
					<td class="left_txt2" align="center">
						<select name="SELLET_TYPE" style="width: ;">
							<option value="AUTO" selected="selected">
								自动
							</option>
							<option value="HAND">
								手动
							</option>
						</select>
					</td>
					<td class="left_txt2" align="center">
						<select name="SUB_TYPE">
							<option value="101" selected="selected">
								3个月，每月还一次
							</option>
							<option value="102">
								1年，每月还一次
							</option>
							<option value="103">
								2年，每月还一次
							</option>
							<option value="104">
								10年，每月还一次
							</option>
							<option value="201">
								3个月，每月还一次
							</option>
							<option value="202">
								1年，每月还一次
							</option>
							<option value="203">
								2年，每月还一次
							</option>
							<option value="204">
								10年，每月还一次
							</option>
						</select>
					</td>
					<td class="left_txt2" align="center">
						<input name="INT_RATE" value="${requestScope.loanbean.INT_RATE }" />
					</td>
					<td  class="left_txt2" align="center">
						<select name="LX_CCY" style="width: ;">
							<option value="RMB" selected="selected">
								人民币
							</option>
							<option value="$">
								美元
							</option>
							<option value="OUY">
								欧元
							</option>
							<option value="pod">
								英镑
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<input name="LX" value="利息" readonly  size="5"/>
					</td>
					<td  class="left_txt2" align="center">
						<input name="LX_ACCT_59"
							value="${requestScope.loanbean.LX_ACCT_59 }" />
					</td>
					<td  class="left_txt2" align="center">
						<input name="BOOK_BRANCH"
							value="${requestScope.loanbean.BOOK_BRANCH }" />
					</td>
					<td class="left_txt2" align="center">
						<input name="LX_LENDER" value="${requestScope.loanbean.LX_LENDER}" />
					</td>
				</tr>
				<tr>
					<td height="30"  class="left_txt2" align="center">
						<select name="ACCT_TYPE" style="width: ;">
							<option value="活期" selected="selected">
								活期
							</option>
							<option value="定期">
								定期
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<select name="SELLET_TYPE" style="width: ;">
							<option value="" selected="selected">
								自动
							</option>
							<option value="手动">
								手动
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<select name="SUB_TYPE">
							<option value="101" selected="selected">
								3个月，每月还一次
							</option>
							<option value="102">
								1年，每月还一次
							</option>
							<option value="103">
								2年，每月还一次
							</option>
							<option value="104">
								10年，每月还一次
							</option>
							<option value="201">
								3个月，每月还一次
							</option>
							<option value="202">
								1年，每月还一次
							</option>
							<option value="203">
								2年，每月还一次
							</option>
							<option value="204">
								10年，每月还一次
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<input name="FX_INT_RATE"
							value="${requestScope.loanbean.FX_INT_RATE }" />
					</td>
					<td  class="left_txt2" align="center">
						<select name="FX_CCY" >
							<option value="RMB" selected="selected">
								人民币
							</option>
							<option value="$">
								美元
							</option>
							<option value="OUY">
								欧元
							</option>
							<option value="POD">
								英镑
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<input name="FX" value="罚息" readonly  size="5"/>
					</td>
					<td  class="left_txt2" align="center">
						<input name="FX_ACCT_59"
							value="${requestScope.loanbean.FX_ACCT_59 }" />
					</td>
					<td  class="left_txt2" align="center">
						<input name="BOOK_BRANCH"
							value="${requestScope.loanbean.BOOK_BRANCH }" />
					</td>
					<td  class="left_txt2" align="center">
						<input name="FX_LENDER" value="${requestScope.loanbean.FX_LENDER}" />
					</td>
				</tr>
				<tr>
					<td height="30" class="left_txt2" align="center">
						<select name="ACCT_TYPE" >
							<option value="活期" selected="selected">
								活期
							</option>
							<option value="定期">
								定期
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<select name="SELLET_TYPE">
							<option value="" selected="selected">
								自动
							</option>
							<option value="手动">
								手动
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<select name="SUB_TYPE">
							<option value="101" selected="selected">
								3个月，每月还一次
							</option>
							<option value="102">
								1年，每月还一次
							</option>
							<option value="103">
								2年，每月还一次
							</option>
							<option value="104">
								10年，每月还一次
							</option>
							<option value="201">
								3个月，每月还一次
							</option>
							<option value="202">
								1年，每月还一次
							</option>
							<option value="203">
								2年，每月还一次
							</option>
							<option value="204">
								10年，每月还一次
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<input name="FL_INT_RATE"
							value="${requestScope.loanbean.FL_INT_RATE }" />
					</td>
					<td  class="left_txt2" align="center">
						<select name="FL_CCY">
							<option value="RMB" selected="selected">
								人民币
							</option>
							<option value="$">
								美元
							</option>
							<option value="OUY">
								欧元
							</option>
							<option value="POD">
								英镑
							</option>
						</select>
					</td>
					<td class="left_txt2" align="center">
						<input name="FL" value="复利" readonly size="5" />
					</td>
					<td  class="left_txt2" align="center">
						<input name="FL_ACCT_59"
							value="${requestScope.loanbean.FL_ACCT_59 }" />
					</td>
					<td class="left_txt2" align="center">
						<input name="BOOK_BRANCH"
							value="${requestScope.loanbean.BOOK_BRANCH }" />
					</td>
					<td class="left_txt2" align="center">
						<input name="FL_LENDER" value="${requestScope.loanbean.FL_LENDER}" />
					</td>
				</tr>
				<tr>
					<td height="30" class="left_txt2" align="center">
						<select name="ACCT_TYPE">
							<option value="活期" selected="selected">
								活期
							</option>
							<option value="定期">
								定期
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<select name="SELLET_TYPE">
							<option value="" selected="selected">
								自动
							</option>
							<option value="手动">
								手动
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<select name="SUB_TYPE" >
							<option value="101" selected="selected">
								3个月，每月还一次
							</option>
							<option value="102">
								1年，每月还一次
							</option>
							<option value="103">
								2年，每月还一次
							</option>
							<option value="104">
								10年，每月还一次
							</option>
							<option value="201">
								3个月，每月还一次
							</option>
							<option value="202">
								1年，每月还一次
							</option>
							<option value="203">
								2年，每月还一次
							</option>
							<option value="204">
								10年，每月还一次
							</option>
						</select>
					</td>
					<td  class="left_txt2" align="center">
						<input name="FL_INT_RATE" />
					</td>
					<td  class="left_txt2" align="center">
						<select name="FY_CCY">
							<option value="RMB" selected="selected">
								人民币
							</option>
							<option value="$">
								美元
							</option>
							<option value="OUY">
								欧元
							</option>
							<option value="POD">
								英镑
							</option>
						</select>
					</td>
					<td class="left_txt2" align="center">
						<input name="FY" value="费用" readonly  size="5"/>
					</td>
					<td class="left_txt2" align="center">
						<input name="FY_ACCT_59"
							value="${requestScope.loanbean.FY_ACCT_59 }" />
					</td>
					<td class="left_txt2" align="center">
						<input name="BOOK_BRANCH"
							value="${requestScope.loanbean.BOOK_BRANCH }" />
					</td>
					<td class="left_txt2" align="center">
						<input name="FY_LENDER" value="${requestScope.loanbean.FY_LENDER}" />
					</td>
				</tr>
			</table>
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
					<tr class="left_txt" align="left">
						<th  height="25">
							备用回收结算路径
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
			<table class="left_txt2" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">

				<tr>
					<td height="30" class="left_txt2" align="center" width="11%">
						账户类型
					</td>
					<td height="30" class="left_txt2" align="center" width="13%">
						结算方式
					</td>
					<td height="30" class="left_txt2" align="center" width="14%">
						子产品类型
					</td>
					<td height="30" class="left_txt2" align="center" width="5%">
						利率
					</td>
					<td height="30" class="left_txt2" align="center" width="11%">
						结算币种
					</td>
					<td height="30" class="left_txt2" align="center" width="17%">
						结算账号
					</td>
					<td height="30" class="left_txt2" align="center" width="17%">
						结算机构
					</td>
					<td height="30" class="left_txt2" align="center" width="17%">
						账户持有者
					</td>
				</tr>
				<tr>
					<td height="30"class="left_txt2" align="center">
						<select name="ACCT_TYPE" >
							<option value="活期" selected="selected">
								活期
							</option>
							<option value="定期">
								定期
							</option>
						</select>
					</td>
					<td class="left_txt2" align="center">
						<select name="SELLET_TYPE">
							<option value="" selected="selected">
								自动
							</option>
							<option value="手动">
								手动
							</option>
						</select>
					</td>
					<td class="left_txt2" align="center">
						<select name="SUB_TYPE">
							<option value="101" selected="selected">
								3个月，每月还一次
							</option>
							<option value="102">
								1年，每月还一次
							</option>
							<option value="103">
								2年，每月还一次
							</option>
							<option value="104">
								10年，每月还一次
							</option>
							<option value="201">
								3个月，每月还一次
							</option>
							<option value="202">
								1年，每月还一次
							</option>
							<option value="203">
								2年，每月还一次
							</option>
							<option value="204">
								10年，每月还一次
							</option>
						</select>
					</td>
					<td class="left_txt2" align="center">
						<input name="BY_INT_RATE"
							value="${requestScope.loanbean.BY_INT_RATE }" />
					</td>
					<td class="left_txt2" align="center">
						<select name="BY_CCY">
							<option value="RMB" selected="selected">
								rmb
							</option>
							<option value="$">
								美元
							</option>
							<option value="OUY">
								欧元
							</option>
							<option value="POD">
								英镑
							</option>
						</select>
					</td>

					<td class="left_txt2" align="center">
						<input name="BY_ACCT_NO"
							value="${requestScope.loanbean.BY_ACCT_NO }" />
					</td>
					<td class="left_txt2" align="center">
						<input name="BOOK_BRANCH"
							value="${requestScope.loanbean.BOOK_BRANCH }" />
					</td>
					<td class="left_txt2" align="center">
						<input name="BY_LENDER" value="${requestScope.loanbean.BY_LENDER}" />
					</td>
				</tr>
				<tr>
				<td class="left_txt2" width="50%" colspan="4" align="right">
					<label>
						<input type="submit" value="提交" onClick="messSend();" />
					</label>
				</td>
				<td class="left_txt2" width="50%" colspan="4" align="left">
					<label>
						<input type="reset" value="取消" />
					</label>
				</td>
				</tr>
			</table>
		</form>
	</body>
</html>
