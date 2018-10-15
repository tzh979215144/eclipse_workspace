<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedList"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>
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
<title>订单</title>
      <jsp:useBean id="loginBean" class="lyons.entity.Login" scope="session"/>

<!-- For-Mobile-Apps -->
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="E Shop Cart Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Android Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps -->

<!-- Custom-Theme-Files -->
	<link rel="stylesheet" href="css/style5.css" type="text/css" media="all" />
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
<jsp:useBean id="goods" class="lyons.entity.Goods" scope="session"/>
	<h1>您的订单</h1>

	<!-- Content-Starts-Here -->
	<div class="container">

		<!-- Mainbar-Starts-Here -->
		<div class="main-bar">
			<div class="product">
				<h3>产品</h3>
			</div>
			<div class="quantity">
				<h3>购买数量</h3>
			</div>
			<div class="price">
				<h3>订单状态</h3>
			</div>
			<div class="clear"></div>
		</div>
		<!-- //Mainbar-Ends-Here -->

		<!-- Items-Starts-Here -->
		<div class="items">

			<!-- Item1-Starts-Here -->
		<% 
            CachedRowSetImpl rowSet = goods.getRowSet();// 获取储存在模型中的行信息
            if(rowSet==null)
            {
                out.print("商品数据库中没有哦");
                return;
            }
            rowSet.last();
            int totalRecord = rowSet.getRow();             //所查询的商品全部记录
            int PageSize = goods.getPageSize();            //每页显示的记录数
            int totalPages = goods.getTotalPage();         //总页数
            int currentPage = goods.getCurrentPage();      //当前页码数
            
            
            //检查是否用户自定义了页数
            if(request.getParameter("newPageSize")!=null)
            {
               PageSize = Integer.parseInt(request.getParameter("newPageSize"));
               currentPage = 1;//从第一页开始显示
            }
            //检查是否用户点击了下、上一页操作
            if(request.getParameter("currentPage") != null)
            {
               int newCurrentPageInt = Integer.parseInt(request.getParameter("currentPage"));
               if(newCurrentPageInt <= totalPages && newCurrentPageInt>0)//下一页必须小于总页数，大于0
               {
                   currentPage = newCurrentPageInt;
               }else
                   {
                       currentPage = goods.getCurrentPage();//页数大于总页数或者小于零后，还原数据
                   }
            }
            
            //分页
            if(totalRecord % PageSize == 0)
            {
               totalPages = totalRecord/PageSize;
            }else
                 {
                   totalPages = totalRecord/PageSize+1;
                 }
            goods.setCurrentPage(currentPage);
            goods.setPageSize(PageSize);
            goods.setTotalPage(totalPages);
            
            if(totalPages >= 1)
            {
               if(goods.getCurrentPage()<1)
               {
                   goods.setCurrentPage(goods.getTotalPage());//点击上一页提交时CurrentPage+1，但当前页面已经是最后一页，会出现此表达式会成立
               }
               
               if(goods.getCurrentPage()>goods.getTotalPage()) //点击下一页提交时CurrentPage+1，但当前页面已经是最后一页，会出现此表达式会成立
               {
                   goods.setCurrentPage(1);
               }
               
               int index = ((goods.getCurrentPage()-1)*PageSize)+1;
               rowSet.absolute(index);//查询位置移动到currentPage页起始位置
               
               boolean flag = true;
               for(int i=1,j=goods.getPageSize();i<=j&&flag;i++)
               {
                   String commodity_name = rowSet.getString(1);
                   String orderNumber = rowSet.getString(2);

                   
                   %>
			<tr bgcolor=#43CD80>
 
			<div class="item3">
				<div class="close4">
				<div class="image3">
						<img src="image/goods/00<%= orderNumber %>.jpg" alt="item3" width="75" height="50">
					</div>


					<div class="title3">
						<p><%= commodity_name %></p>
					</div>
					<div class="quantity3">
						<form action="action_page.php">
							<p><%= orderNumber %></p>
						</form>
					</div>
					<div class="price3">
						<p>已完成</p>
					</div>
					<div class="clear"></div>
				</div>
			</div>
                   <%
                  flag = rowSet.next(); //查看是否还有值   
               }
            }
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
				<span>祝你购物愉快! </span>
			</div>
			<div class="add">
				
			</div>
		<form name="checkout" action="/gouwuche/lyons.goods/BuyGoods" method="post">
			
			<div class="checkout-btn">
				<a href='/gouwuche/lyons.dao/GoodsDao?key=4'><b>继续购物</b></a>
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