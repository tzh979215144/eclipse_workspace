<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
  <base href="<%=basePath%>">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Motor</title>
  <meta name="description" content="">

  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/font-awesome.min.css" rel="stylesheet">
  <link href="css/templatemo-style.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<!-- jQuery (necessary JavaScript plugins) -->
<script src="js/bootstrap.js"></script>
<!-- Custom Theme files -->
<link href="css/style3.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Widget Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="js/jquery-1.11.1.min.js"></script>
<link href='//fonts.googleapis.com/css?family=Josefin+Sans:400,600,700' rel='stylesheet' type='text/css'>
<!--//theme-style-->
      </head>
  </head>
  
  <body class="about-page">
       
        <!-- End Preloader -->
       <section class="templatemo-top-section">
         <div class="templatemo-header">
            <img class="templatemo-header-img" src="img/header.png" alt="Header">
            <h1 class="templatemo-site-name">Motor</h1>
            <div class="mobile-menu-icon">
              <i class="fa fa-bars"></i>
          </div>
   		<div class="templatemo-nav-container">
   		    <nav class="templatemo-nav">
  			<ul class="nav">
    			<li><a class="on" href="index.jsp?first=FP">首  页</a></li>
    			<li><a href="lyons.dao/GoodsDao?key=4">商品</a></li>
    			<li><a href="jsp/shoppingCar/lookShoppingCar.jsp"> 购物车</a></li>
    			<li><a href="lyons.dao/GoodsDao?key=3">订单</a></li>
    			<li><a href="jsp/browse/searchByKeyWord.jsp">查询</a></li>
    	    </nav> 
    		</ul>
   		</div>
   	  </div>
    

 <%
            String detail = request.getParameter("detail");
            String shopCarButton = "<form action='lyons.goods/PutGoodsToCar' method='post'>"+
                                   "<input type='hidden' name='GoodsCar' value="+detail+">"+
                                   "<input type='submit' value='加入购物车'></form>";
            String[] details = detail.split(",");
            %>

<div class="container">
	<div class="row">
		<div class="span6">
			<div class="panel panel-success">
    <div class="panel-heading">
        <h3 class="panel-title">商品详情</h3>
    </div>
    <div class="panel-body">
              <img src="image/goods/<%= details[5] %>"/>
    </div>
    </div>
	</div>
		<div class="span6">
	<ul class="list-group">
        <li class="list-group-item">商品名称 <%= details[1]%></li>
        <li class="list-group-item">产地 <%= details[2]%></li>
        <li class="list-group-item">余量 <%= details[4]%></li>
        <li class="list-group-item">价格 <%= details[3]%></li>
									<div class="btn_form button item_add item_1">
									   <form action='lyons.goods/PutGoodsToCar' method='post'>
									   <input type='hidden' name='GoodsCar' value="<%= detail%>">
										 <input type="submit" value="加入购物车">
									  </form>
									</div>        
    </ul>
		</div>
	</div>
</div>

		<!--End Calender-->

        
    <!--Footer content-->
    <footer class="tm-footer">
      <div class="container">
        <div class="row margin-bottom-60">
          <nav class="col-lg-3 col-md-3 tm-footer-nav tm-footer-div">
            <h3 class="tm-footer-div-title">主菜单</h3>
            <ul>
              <li><a href="index.jsp?first=FP">主页</a></li>
              <!-- <li><a href="about.jsp">关于我们</a></li>  -->
              <!-- <li><a href="gallery.html">Directory</a></li> -->
              <!-- <li><a href="#">Blog</a></li> -->
              <li><a href="services.jsp">服务</a></li>
            </ul>
          </nav>
          <div class="col-lg-5 col-md-5 tm-footer-div">
            <h3 class="tm-footer-div-title">关于我们</h3>
            <p class="margin-top-15">我们是第三小组。</p>
            <p class="margin-top-15">小组成员有谭智恒、张嘉森和焦云瑞。</p>
          </div>
          <div class="col-lg-4 col-md-4 tm-footer-div">
            <h3 class="tm-footer-div-title">联系我们</h3>
            <p>欢迎您通过以下方式联系我们。</p>
            <div class="tm-social-icons-container">
              <a href="https://www.facebook.com/" class="tm-social-icon"><i class="fa fa-facebook"></i></a>
              <a href="https://www.twitter.com/" class="tm-social-icon"><i class="fa fa-twitter"></i></a>
              <a href="https://www.instagram.com/" class="tm-social-icon"><i class="fa fa-linkedin"></i></a>
              <a href="https://www.youtube.com/" class="tm-social-icon"><i class="fa fa-youtube"></i></a>
              <a href="https://www.behance.net/" class="tm-social-icon"><i class="fa fa-behance"></i></a>
            </div>
          </div>
        </div>
        
      </div>
    </footer> <!-- Footer content-->
    
    <!-- JS -->
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->
    <script defer src="js/jquery.flexslider-min.js"></script><!-- FlexSlider -->
    <script>
      $(window).load(function() {
        $('.flexslider').flexslider({
          animation: "slide",
          slideshow: false,
          prevText: "&#xf104;",
          nextText: "&#xf105;"
        });

        // Remove preloader
        // https://ihatetomatoes.net/create-custom-preloading-screen/
        $('body').addClass('loaded');
      });
    </script>
  </body>
</html>
