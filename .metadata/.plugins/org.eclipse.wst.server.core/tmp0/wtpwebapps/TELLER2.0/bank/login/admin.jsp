<%@ page language="java" import="java.sql.*" contentType="text/html;charset=utf-8"%>  
<!DOCTYPE html>
<html>  
<html>
   <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
      <title>管理页面</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- 引入 Bootstrap -->
 <!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
 
<!-- 可选的Bootstrap主题文件（一般不使用） -->
<script src="../css/bootstrap-theme.min.css"></script>
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="../js/jquery-3.2.1.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="../js/bootstrap.min.js"></script>
      <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
      <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
      <!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
<style>  
.col-center-block {  
    float: none;  
    display: block;  
    margin-left: auto;  
    margin-right: auto;  
}  
</style> 
    
  <body>  
    <br>  
   <%  
   request.setCharacterEncoding("utf-8");  
   String users=request.getParameter("username");  
   String pass=request.getParameter("password");  
   %>  
   <%
	try{
   //加载驱动程序   
	String driverName="com.mysql.jdbc.Driver";   
	//数据库信息  
	String userName="root";   
	//密码   
	String userPasswd="snnu";   
	//数据库名   
	String dbName="JavaWeb";   
	//表名   
	String tableName="account";   
	//将数据库信息字符串连接成为一个完整的url（也可以直接写成url，分开写是明了可维护性强）   
	Class.forName("com.mysql.jdbc.Driver").newInstance();   	 
	String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;   
	Connection conn=DriverManager.getConnection(url);  
	
	Statement stmt = conn.createStatement();   
	String sql="select * from account";
	ResultSet rs = stmt.executeQuery(sql);
	out.print("<table border='1' width='%'>");
	out.print("<tr>");
	out.print("<th>用户名</th>");   
	out.print("<th>密码</th>"); 
	out.print("</tr>");
	while(rs.next()) {
	out.print("<tr>");
	out.print("<td>"+rs.getString(1)+"</td>");   
	out.print("<td>"+rs.getString(2)+"</td>");  
	out.print("</tr>");
		
	}
	out.print("</table>");
	rs.close();
    stmt.close();  
    conn.close();  
	}
	catch (Exception e) 
		{ 
		 e.printStackTrace();
		 out.print("<script>alert('系统繁忙，请稍候再试！'); history.go(-1);</script>");
		} 
	%>    
  </body>  
</html>  