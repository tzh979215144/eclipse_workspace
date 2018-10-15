<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder"%>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>商品</title>
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

      </head>
      <body>

    	<jsp:useBean id="goods" class="lyons.entity.Goods" scope="session"/>
  		<% request.setCharacterEncoding("UTF-8"); %>

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
         <div class="templatemo-welcome">
          <div class="container">
            <div class="row">
              <div class="col-lg-7 col-md-7 col-sm-6 col-xs-12">
                <img src="img/welcome-img.png" class="img-responsive welcome-img" alt="Welcome">
              </div>
              <div class="col-lg-5 col-md-5 col-sm-6 col-xs-12">
                <h2 class="text-uppercase">
                  <span class="welcome-title-1">We love your</span>
                  <span class="welcome-title-2">satisfaction</span>
                </h2>
                <p class="welcome-message">Mercedes-Benz (German: [mɛʁˈtseːdəsˌbɛnts]) is a global automobile marque and a division of the German company Daimler AG. The brand is known for luxury vehicles, buses, coaches, and lorries. The headquarters is in Stuttgart, Baden-Württemberg. The name first appeared in 1926 under Daimler-Benz.</p>
                <a href="#" class="welcome-read-more">Read More</a>
              </div>
            </div>    
          </div>
        </div>
      </section>
      <section class="container margin-bottom-50">
       <div class="row">
        <h2 class="col-lg-12 text-center text-uppercase margin-bottom-30">请选购您的商品</h2>
        <p class="col-lg-12 text-center margin-bottom-30">梅赛德斯-奔驰全新购车捷径已经上线，只需一台智能手机，通过电子商务平台，便可随时随地预定心仪座驾，先睹为快。</p>

      </div>
    </section>    

    <!--Main content-->
    <section class="container margin-bottom-50">
      <div class="tm-overflow-hidden row">
        <div class="tm-gallery col-lg-9 col-md-9 col-sm-8 col-xs-12">
          <h3 class="tm-gallery-title">梅德赛斯 奔驰</h3>          
          
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
  			       int ID = rowSet.getInt(1);
  			       String name = rowSet.getString(2);
  			       String made = rowSet.getString(3);
  			       String price = rowSet.getString(4);
  			       String number = rowSet.getString(5);
  			       String pic = rowSet.getString(6);
  			       String category = rowSet.getString(7);
  			       
  			       String commodity = null;
  			       commodity = ID+","+name+","+made+","+price+","+number+","+pic+","+category;//尾缀#，便于计算购物车价格
  			       commodity = commodity.replaceAll("\\p{Blank}",""); //正则匹配，将符合的字符替换
  			       
  			       String shopCarButton = "<form name='form"+ID+"' action='lyons.goods/PutGoodsToCar' method='post'>"+
  			                       "<input type='hidden' name='GoodsCar' value="+commodity+">"+
  			                    		 "<a href='javascript:form"+ID+".submit();' class='tm-item-link'>"+
  	  					                "<span class='tm-item-action'>Add to Cart</span>"+
  	  					                "<img src='img/plus.png' class='tm-item-add-icon' alt='Image'> </a> </form>";
  			       String detail = "<form name='form_detail"+ID+"' action='jsp/browse/showDetail.jsp' method='post'>"+
  			                       "<input type='hidden' name='detail' value="+commodity+">"+
  		  			                       " </form>";
  			       %>
			          <div class="tm-item-container">
			          <%= detail%>
			          <a href='javascript:form_detail<%= ID%>.submit();'>
			            <img src="image/goods/<%= pic %>" alt="Image" width="200" height="129"></a>
			            <p class="tm-item-description"><%= name %></p><hr>
			            
			            <div class="tm-item-price-container">
			              <span class="tm-item-price">￥ <%= price %></span>
			           
			              <%= shopCarButton %>
			            </div>   
			          </div>

  			       <%
                  flag = rowSet.next(); //查看是否还有值 	
  			   }
  			}
  		%>         
	<div>
          
  	         <form action="" method="post" style="float:left;">
  	             <input type="hidden" name=currentPage value="<%= (currentPage-1) %>">
  	             <input type="submit" value="上一页">
  	         </form>

  	         <form action="" method="post" style="float:left;">
  	             <input type="hidden" name=currentPage value="<%= (currentPage+1) %>">
  	             <input type="submit" value="下一页">
  	         </form>
  	         <form action="" method="post" style="float:right;">
  	            总计：<%= totalRecord %>条记录.每页显示<input type="text" name="newPageSize" value="<%= PageSize %>" size="2">条.
  	                 <input type="submit" value="确定">
  	         </form></div>
        </div>
        
        <aside class="tm-gallery-aside col-lg-3 col-md-3 col-sm-4 col-xs-12">
          <nav class="tm-gallery-nav">
            <h2 class="tm-gallery-nav-title">Category <i class="fa fa-caret-up"></i></h2>
            <ul>
              <li class="active">
                <a href="lyons.dao/GoodsDao?key=4">
                  <img src="img/gallery-list-icon.png" class="tm-gallery-list-img" alt="Image">所有商品
                  <i class="fa fa-caret-right tm-gallery-list-fa"></i>
                </a>
              </li>        
              <li >
                <a href="lyons.dao/GoodsDao?key=2&keyWord=A">
                  <img src="img/gallery-list-icon.png" class="tm-gallery-list-img" alt="Image">A
                  <i class="fa fa-caret-right tm-gallery-list-fa"></i>
                </a>
              </li>
              <li>
                <a href="lyons.dao/GoodsDao?key=2&keyWord=B">
                  <img src="img/gallery-list-icon.png" class="tm-gallery-list-img" alt="Image">B
                  <i class="fa fa-caret-right tm-gallery-list-fa"></i>
                </a>
              </li>
              <li>
                <a href="lyons.dao/GoodsDao?key=2&keyWord=C">
                  <img src="img/gallery-list-icon.png" class="tm-gallery-list-img" alt="Image">C
                  <i class="fa fa-caret-right tm-gallery-list-fa"></i>
                </a>
              </li>
              <li>
                <a href="lyons.dao/GoodsDao?key=2&keyWord=E">
                  <img src="img/gallery-list-icon.png" class="tm-gallery-list-img" alt="Image">E
                  <i class="fa fa-caret-right tm-gallery-list-fa"></i>
                </a>
              </li>
              <li>
                <a href="lyons.dao/GoodsDao?key=2&keyWord=S">
                  <img src="img/gallery-list-icon.png" class="tm-gallery-list-img" alt="Image">S
                  <i class="fa fa-caret-right tm-gallery-list-fa"></i>
                </a>
              </li>
              <li>
                <a href="lyons.dao/GoodsDao?key=2&keyWord=CLA">
                  <img src="img/gallery-list-icon.png" class="tm-gallery-list-img" alt="Image">CLA
                  <i class="fa fa-caret-right tm-gallery-list-fa"></i>
                </a>
              </li>
              <li>
                <a href="lyons.dao/GoodsDao?key=2&keyWord=GLA">
                  <img src="img/gallery-list-icon.png" class="tm-gallery-list-img" alt="Image">GLA
                  <i class="fa fa-caret-right tm-gallery-list-fa"></i>
                </a>
              </li>
              <li>
                <a href="lyons.dao/GoodsDao?key=2&keyWord=GLC">
                  <img src="img/gallery-list-icon.png" class="tm-gallery-list-img" alt="Image">GLC
                  <i class="fa fa-caret-right tm-gallery-list-fa"></i>
                </a>
              </li>
              <li>
                <a href="lyons.dao/GoodsDao?key=2&keyWord=GLE">
                  <img src="img/gallery-list-icon.png" class="tm-gallery-list-img" alt="Image">GLE
                  <i class="fa fa-caret-right tm-gallery-list-fa"></i>
                </a>
              </li>
              <li>
                <a href="lyons.dao/GoodsDao?key=2&keyWord=GLS">
                  <img src="img/gallery-list-icon.png" class="tm-gallery-list-img" alt="Image">GLS
                  <i class="fa fa-caret-right tm-gallery-list-fa"></i>
                </a>
              </li>
              <li>
                <a href="lyons.dao/GoodsDao?key=2&keyWord=R">
                  <img src="img/gallery-list-icon.png" class="tm-gallery-list-img" alt="Image">R
                  <i class="fa fa-caret-right tm-gallery-list-fa"></i>
                </a>
              </li>
              <li>
                <a href="lyons.dao/GoodsDao?key=2&keyWord=V">
                  <img src="img/gallery-list-icon.png" class="tm-gallery-list-img" alt="Image">V
                  <i class="fa fa-caret-right tm-gallery-list-fa"></i>
                </a>
              </li>
              <li>
                <a href="lyons.dao/GoodsDao?key=2&keyWord="Vito>
                  <img src="img/gallery-list-icon.png" class="tm-gallery-list-img" alt="Image">Vito
                  <i class="fa fa-caret-right tm-gallery-list-fa"></i>
                </a>
              </li>
            </ul>
          </nav>
          <div class="tm-call-us">
            <h3 class="text-uppercase tm-call-us-title">Call us</h3>
            <a href="tel:" class="tm-call-us-link">+11 565 789 57</a>
          </div>    
        </aside>
      </div>

      <!--banner-->
      <div class="tm-banner">
        <h2 class="tm-banner-title">Maecenas</h2>
        <p class="tm-banner-description">Mercedes-Benz traces its origins to Daimler-Motoren-Gesellschaft's 1901 Mercedes and Karl Benz's 1886 Benz Patent-Motorwagen, which is widely regarded as the first gasoline-powered automobile. The slogan for the brand is "the best or nothing".</p>
        <a href="#" class="tm-banner-link"><i class="fa fa-play"></i></a>
      </div>
    </section> <!-- Main content -->
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
            <p class="margin-top-15">小组成员有谭智恒、张嘉森、焦云瑞和魏靖原。</p>
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

  </body>
  </html>