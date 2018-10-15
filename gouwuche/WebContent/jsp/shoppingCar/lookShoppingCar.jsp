<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedList"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>购物车</title>
      <jsp:useBean id="loginBean" class="lyons.entity.Login" scope="session"/>
      <% request.setCharacterEncoding("UTF-8"); %>
              <%   
             LinkedList<String> items = null;
              items = loginBean.getCar(); 
              if(items.size()==0)
              {%>
                    <font color=green> 购物车空空的，抓紧去 </font> 
                    <a href="/gouwuche/lyons.dao/GoodsDao?key=4"><font color=red size=6>购物</font></a> 
              <%
                return;
              }
        %>
<!-- For-Mobile-Apps -->
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="E Shop Cart Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Android Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps -->

<!-- Custom-Theme-Files -->
	<link rel="stylesheet" href="css/style2.css" type="text/css" media="all" />
<!-- //Custom-Theme-Files -->

<!-- Remove-Item-JavaScript -->
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script>$(document).ready(function(c) {
		$('.alert-close1').on('click', function(c){
			$('.close1').fadeOut('slow', function(c){
		  		$('.close1').remove();
			});
		});	  
	});
	</script>
	<script>$(document).ready(function(c) {
		$('.alert-close2').on('click', function(c){
			$('.close2').fadeOut('slow', function(c){
		  		$('.close2').remove();
			});
		});	  
	});
	</script>
	<script>$(document).ready(function(c) {
		$('.alert-close3').on('click', function(c){
			$('.close3').fadeOut('slow', function(c){
		  		$('.close3').remove();
			});
		});	  
	});
	</script>
<!-- //Remove-Item-JavaScript -->

</head>

<!-- Body-Starts-Here -->
<body>

	<h1>您的购物车</h1>

	<!-- Content-Starts-Here -->
	<div class="container">

		<!-- Mainbar-Starts-Here -->
		<div class="main-bar">
			<div class="product">
				<h3>产品</h3>
			</div>
			<div class="quantity">
				<h3>数量</h3>
			</div>
			<div class="price">
				<h3>价格</h3>
			</div>
			<div class="clear"></div>
		</div>
		<!-- //Mainbar-Ends-Here -->

		<!-- Items-Starts-Here -->
		<div class="items">

			<!-- Item1-Starts-Here -->

			          <%
        //String[] items = car.split("#");//将各条商品分割到数组中
        double totalPrice = 0.00;
              for(int j=0,m=items.size();j<m;++j)
              {
            %><tr bgcolor=#43CD80><% 
                   String[] item = items.get(j).split(",");//将数组中单个商品条目内容分割到数组中，如：价格，数量等
                   %>
            <%%>
			<div class="item3">
				<div class="close4">
				<a href='/gouwuche/lyons.goods/DeleteGoodsFromCar?ID=<%= j %>'><div class="alert-close3"> </div></a>

					<div class="image3">
						<img src="image/goods/<%= item[5] %>" alt="item3" width="75" height="50">
					</div>
					<div class="title3">
						<p><%= item[1]%></p>
					</div>
					<div class="quantity3">
						<form action="action_page.php">
							<p>1</p>
						</form>
					</div>
					<div class="price3">
						<p><%= item[3]%></p>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			 <%totalPrice += Double.parseDouble(item[3]); }
	            %>
			<!-- //Item3-Ends-Here -->

		</div>
		<!-- //Items-Ends-Here -->

		<!-- Total-Price-Starts-Here -->
		<div class="total">

		</div>
		<!-- //Total-Price-Ends-Here -->

		<!-- Checkout-Starts-Here -->
		<div class="checkout">
			<div class="discount">
				<span>Total Price: ￥ <%= totalPrice %></span>
			</div>
			<div class="add">
				<a href='/gouwuche/lyons.dao/GoodsDao?key=4'><b>继续购物</b></a>
			</div>
<%          
   String backPage = "<a href='/gouwuche/jsp/browse/showGoods.jsp'><b>继续购物</b></a>";
%>			<form name="checkout" action="/gouwuche/lyons.goods/BuyGoods" method="post">
			
			<div class="checkout-btn">
				<a href="javascript:checkout.submit();">Checkout</a>
			</div>
			</form>
			<div class="clear"></div>
		</div>
		
		<!-- //Checkout-Ends-Here -->

	</div>
	
	<!-- Content-Ends-Here -->


</body>
<!-- Body-Ends-Here -->

</html>