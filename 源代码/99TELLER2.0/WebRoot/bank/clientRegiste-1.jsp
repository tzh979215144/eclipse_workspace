<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>用户开户</title>
      <meta id="viewport" content="width=device-width, initial-scale=1.0">
      <!-- 引入 Bootstrap -->
 <!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="css/bootstrap.min.css" rel="stylesheet">
 
<!-- 可选的Bootstrap主题文件（一般不使用） -->
<script src="css/bootstrap-theme.min.css"></script>
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="js/jquery-3.2.1.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>
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
</head>  
  
<body>  
<div class="container">  
  <div class="row myCenter">  
    <div class="col-xs-6 col-md-4 col-center-block">  
      <form class="form-signin" id="RegForm" action="signupcheck.php" method="post" onsubmit="return InputCheck(this)">  
        <h2 class="form-signin-heading text-center">用户开户</h2>  <br>
        <label >用户号</label>  
        <input type="text" id="userid" class="form-control" placeholder="" required autofocus disabled="disabled">  <br>
		<label >姓名</label>  
        <input type="text" id="username" class="form-control" placeholder="" required autofocus>  <br>
		<div class="container" >
		
			<div class="col-md-2 col-sm-2 col-xs-2" >  
			<label  >性别</label>  
			<select class="form-control	" id="sex" style="width: 80%;"> 
				<option value="1" selected="selected">男</option>
				<option value="2">女</option>
				<option value="3">不详</option>
			</select>
			</div>
			<div class="col-md-2 col-sm-2 col-xs-2"> 
			<label  >证件类型</label>  
			<select  class="form-control" id="card_sort" style="width: 80%;"> 
				<option value="identity_card" selected="selected">身份证</option>
				<option value="military_card">军人证</option>
				<option value="passport">护照</option>
			</select>
			</div>
		</div>
		<br>
		<label >证件号</label>  
		<input type="text" id="card_number" class="form-control" placeholder="" required autofocus>  <br>

		<label >币种</label>  
		<select id="bj" class="form-control" style="width: ;">
			<option value="RMB" selected="selected">人民币</option>
			<option value="$">美元</option>
			<option value="OUY">欧元</option>
			<option value="POD">英镑</option>
		</select> <br>
        
		<label >储蓄类型</label>  
        <select  class="form-control" id="saving_sort" style="width: 80%;"> 
							<option value="HUO" selected="selected">活期</option>
							<option value="DING">定期</option>
		</select>
			<br>
        <button class="btn btn-lg btn-primary btn-block" type="button" id="submit" name="submit" value="signup" >提交申请</button>
		<hr>

      </form>  
    </div>  
  </div>  
</div> 
	<script type="text/javascript">

	$('#submit').click(function(){
		var object = {
				username:$("#username").val(),
				sex:$("#sex").val(),
				card_sort:$("#card_sort").val(),
				card_number:$("#card_number").val(),
				bj:$("#bj").val(),
				saving_sort:$("#saving_sort").val(),
				
				
			};
		
	    $.ajax({
	        cache:true,//保留缓存数据
	        type:"post",//为post请求
	        url:"ClientRegiste",//这是我在后台接受数据的文件名
	       // data:$('#loginForm').serialize(),//将该表单序列化
	       data:object,
	       dataType:'json',
	        async:false,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
	        error:function(request){//请求失败之后的操作
	            alert("系统繁忙，请稍候再试！");
	        },
	        success:function(data){//请求成功之后的操作 

	        	 
	        	 if(data.msg=="1"){
	        		 alert("登陆成功！"+data.userid);
	        		 $("#userid").attr("value",data.userid);
	        	 }else{
	        		 alert("用户名或密码错误！");
	        	 }
	        		 
	        	
	        	      //   $("#content-wrapper").html(data);
	        	document.getElementById("str").value=data.msg2;
	        //你要跳转的url路径 
	        //window.location.href="<%=request.getContextPath()%>/success.jsp?msg='成功跳转'";
	        // request.getContextPath()/success.jsp 
	           // console.log("success");
	        }
	    });
	});

</script> 
</body>  
</html>  