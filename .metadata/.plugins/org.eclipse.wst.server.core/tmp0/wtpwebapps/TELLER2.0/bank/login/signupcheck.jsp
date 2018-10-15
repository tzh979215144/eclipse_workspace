<%@ page language="java" import="java.sql.*" contentType="text/html;charset=utf-8"%>  
<!DOCTYPE html>
<html>  
  <head>  

      
    <title>检验注册页面</title>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!--  
    <link rel="stylesheet" type="text/css" href="styles.css">  
    -->  
  
  </head>  
    
  <body>  
    <br>  
   <%  
   request.setCharacterEncoding("utf-8");  
   String users=request.getParameter("username");  
   String pass=request.getParameter("password");  
   %>  
   <%
   try 
	{ 
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
	boolean isValid = false; 
	{PreparedStatement sql =conn.prepareStatement("select name from account where name = ?");  
    sql.setString(1,users);   
    ResultSet rs=sql.executeQuery();
		
	while(rs.next()) {   
	isValid = true; 	
	}
	sql.close();  
    
	}	
	if(!isValid){
		PreparedStatement sql =conn.prepareStatement("insert into account(name,password) values(?,?)");  
		sql.setString(1,users);  
		sql.setString(2,pass);   
		int rs=sql.executeUpdate();
		 
		if(rs!=0){
			out.print("<script>alert('注册成功！'); location.href='../me.html';</script>");
		}
		else{
			out.print("<script>alert('系统繁忙，请稍候再试！'); history.go(-1);</script>");
		}
		
		sql.close();  
		conn.close();
		}
	else{
		out.print("<script>alert('用户名已存在'); history.go(-1); </script>");
	}
	 
    
		
	}
	 catch (Exception e) 
		{ 
		 e.printStackTrace();
		 out.print("<script>alert('系统繁忙，请稍候再试！'); history.go(-1);</script>");
		} 
	
    %>  
      
  </body>  
</html>  