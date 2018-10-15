<%@ page language="java" contentType="text/html; charset=UTF-8" import="org.zhoukan.bean.user_info" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>账户销户-确认信息</title>
</head>
<body>
<table class="table table-hover">
  <tr>
  		<td>
  		用户号：<%=((user_info)session.getAttribute("user")).getCLIENT_NO() %>
  		</td>
  		<td>
  		证件类型：<%=((user_info)session.getAttribute("user")).getGLOBAL_ID_TYPE() %>
  		</td>
  		<td>
  		证件号码：<%=((user_info)session.getAttribute("user")).getGLOBAL_ID() %>
  		</td>
  		<td>
  		国籍：<%=((user_info)session.getAttribute("user")).getCountry() %>
  		</td>
  </tr>
  <tr>
  		<td>
  		客户类型：<%=((user_info)session.getAttribute("user")).getCLIENT_TYPE() %>
  		</td>
  		<td>
  		客户分类：<%=((user_info)session.getAttribute("user")).getFM_CLIENT_TYPE() %>
  		</td>
  		<td>
  		姓名：<%=((user_info)session.getAttribute("user")).getName() %>
  		</td>
  		<td>
  		性别：<%=((user_info)session.getAttribute("user")).getSex() %>
  		</td>
  </tr>
 <tr>
  		<td>
  		电话：<%=((user_info)session.getAttribute("user")).getCLIENT_TEL() %>
  		</td>
  		<td>
  		地址：<%=((user_info)session.getAttribute("user")).getLOCATION() %>
  		</td>
  </tr>
</form>
<form class="form-inline" action="/TELLER2.0/dropAcc" method="post">
	<br><br>
  <div class="form-group has-success has-feedback" >
  <label class="control-label" for="inputGroupSuccess1">请确定销户账户信息！</label>
  <div class="input-group">
    <span class="input-group-addon">客户编号：</span>
    <input   readonly="readonly" value=<%=((user_info)session.getAttribute("user")).getCLIENT_NO() %> type="text" name="CLIENT_NO" class="form-control" id="inputGroupSuccess1" aria-describedby="inputGroupSuccess1Status">
  </div>
  <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
  <span id="inputGroupSuccess1Status" class="sr-only">(success)</span>
</div>
 <input type="hidden" name="flag" value="2"></input>
  <input type="submit" class="btn btn-lg btn-success" value="确认删除"></input>
</form>
</body>
</html>