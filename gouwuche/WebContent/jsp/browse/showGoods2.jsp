<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
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
  <br/><br/>
  <center>		
  	<table border="1" bordercolor="#00ff00" cellpadding="1" cellspacing="12" width="100" height="80">
  		  <caption><b>商品简略信息表</b><br></caption>
  		    <tr>
  		        <th>序号</th>
  		        <th>商品名称</th>
  		        <th>商品价格</th>
  		        <th>删除商品	</th>
  		        <th>id,name,made,price,number</th>
  		    </tr>
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
  			       
  			       String shopCarButton = "<form action='lyons.control/HandleGood?key=1' method='post' >"+
  			                       "<input type='text' name='GoodsControl' value="+commodity+">"+
  			                       "       <input type='submit' value='修改商品信息'></form>";
  			       String detail = "<form action='lyons.control/HandleGood?key=2' method='post'>"+
  			                       "<input type='hidden' name='id' value="+ID+">"+
  			                       "<input type='submit' value='删除商品'></form>";
  			       %>
  			           <tr <% if(i%2 == 0){%> bgcolor="#FFE4B5" <%}else{%> bgcolor="#FFFACD" <%};//隔行换颜色%>>
  			               <td><%= i %></td>
  			               <td><%= name %></td>
  			               <td><%= price %>￥</td>
  			               <td><%= detail %></td>
  			               <td nowrap="nowrap" ><%= shopCarButton %></td>
  			           </tr>
  			       <%
                  flag = rowSet.next(); //查看是否还有值 	
  			   }
  			 %>
  			           <tr  bgcolor="#FFE4B5"  bgcolor="#FFFACD" >
  			              <form action='lyons.control/HandleGood?key=3' method='post' >
  			               <td><input type='text' name='name' placeholder="商品名称"></td>
  			               <td><input type='text' name='made' placeholder="商品产地"></td>
  			               <td><input type='text' name='price' placeholder="商品价格"></td>
  			                </tr>
		                 <tr  bgcolor="#FFE4B5"  bgcolor="#FFFACD" >	
  			               <td><input type='text' name='pic' placeholder="商品图片路径"></td>
  			               <td><input type='text' name='number' placeholder="商品数量"></td>
  			               <td><input type='text' name='type' placeholder="商品类型">  </br>
  			               <td><input type='submit' value='添加新的商品'></td>
  			               </form>
  			           </tr>
	       <%
  			}
  		%> 
  	</table>
  	
  	<br><%= goods.getCurrentPage() %>/<%= goods.getTotalPage() %> 页
  	
  	<table>
  	 <tr>
  	     <td>
  	         <form action="" method="post">
  	             <input type="hidden" name=currentPage value="<%= (currentPage-1) %>">
  	             <input type="submit" value="上一页">
  	         </form>
  	     </td>
  	     <td>
  	         <form action="" method="post">
  	             <input type="hidden" name=currentPage value="<%= (currentPage+1) %>">
  	             <input type="submit" value="下一页">
  	         </form>
  	     </td>
  	 </tr>
  	 
  	 <tr>
  	     <td><BR>
  	         <form action="" method="post">
  	            总计：<%= totalRecord %>条记录.每页显示<input type="text" name="newPageSize" value="<%= PageSize %>" size="2">条.
  	                 <input type="submit" value="确定">
  	         </form>
  	     </td>
  	 </tr>
  	 
  	</table>
  	
   </center>
  </body>
</html>