<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户开户</title>
</head>
<body>
	<form action="/TELLER2.0/OpenAcc" method="post">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>

					<tr>
						<th height="25" colspan="2" align="left" bgcolor="#006633"
							class="bg_tr">
							开户
						</th>
					</tr>
				</tbody>
			</table>
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>
					<tr>
						<td class="td_bg" width="50%" height="35">
							客户编号：
							<%int num=(int)(Math.random()*10000000);%>
							<label for="disabledTextInput">
								<input name="CLIENT_NO" type="text" size="40"
									readonly="readonly"
									value=<%=num %> />
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							国籍：
							<label>
								<input name="country" id="client_no" type="text" size="40"
									maxlength="38" onblur="getClient(this.value);"
									value="${requestScope.openAccountBean.country}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								客户类型：
								<select name="CLIENT_TYPE">
									<option value="COM" selected="selected">
										普通客户
									</option>
									<option value="VIP">
										VIP客户
									</option>
									<option value="INT">
										银行员工
									</option>
								</select>
							</label>
						</td>
					</tr>

					<tr>
						<td class="td_bg" width="50%" height="46">
							证件号码：
							<label>
								<input name="GLOBAL_ID" id="global_id" type="text" size="38"
									maxlength="38"
									value="${requestScope.openAccountBean.GLOBAL_ID}" />
							</label>
						</td>
						<td class="td_bg" width="50%">
							证件类型：
							<label>
								<select name="GLOBAL_ID_TYPE">
									<option value="identity_card" selected="selected">
										身份证
									</option>
									<option value="military_card">
										军人证
									</option>
									<option value="passport">
										护照
									</option>
								</select>
								<a class="must">*</a>
							</label>
						</td>
					</tr>

				</tbody>
			</table>
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tbody>
					<tr>
						<td class="td_bg" width="50%" height="35">
							用户名：
							<label>
								<input name="name" type="text" size="40" maxlength="40"/>
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								客户分类类型：
								<select name="FM_CLIENT_TYPE">
									<option value="1" selected="selected">
										存款
									</option>
									<option value="2">
										贷款
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							电话：
							<label>
								<input name="CLIENT_TEL" type="text" size="40" maxlength="40"
									value="${requestScope.openAccountBean.CLIENT_TEL}" />
							</label>
						</td>
						<td class="td_bg" width="50%" height="35">
							<label>
								性别：
								<select name="sex">
									<option value="1" selected="selected">
										男
									</option>
									<option value="2">
										女
									</option>
								</select>
							</label>
						</td>
					</tr>
					<tr>
						<td class="td_bg" width="50%" height="35">
							地址：
							<label>
								<input name="LOCATION" type="text" size="40" maxlength="40"
									value="${requestScope.openAccountBean.LOCATION}" />
							</label>
						</td>
						<td>
					<input  class="class="btn btn-default"" type="submit"  name="submit"   value="提交"/>
						</td>
					</tr>
				</tbody>
			</table>
			</form>
	</body>
</html>