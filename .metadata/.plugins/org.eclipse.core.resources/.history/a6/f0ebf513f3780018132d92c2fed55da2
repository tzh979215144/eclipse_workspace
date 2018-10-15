
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>查询商品</title>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">


    <link href="css/style1.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="Flat Search Box Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <!--Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <!--Google Fonts-->
  </head>

 
  <body>
			<% request.setCharacterEncoding("UTF-8"); %>

			 <div class="search">
			 <i></i>
			    <div class="s-bar">			    
			        <form action="/gouwuche/lyons.dao/GoodsDao?key=2" target="_self" id="search-form" method="post">
			            <input type="text"  placeholder="查询商品" name="keyWord" id="search_input" autocomplete="off"/>
			            <input type="hidden" name="key" value="2" />
			            <input type="submit"  value="搜索"/>
			        </form>
			
			    </div>
			 </div>
 </body>
 <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
</html>
