<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<link href="images/login.css" rel="stylesheet" type="text/css" />
<script src="jquery/jquery-2.1.1.js"></script>
<script src="jquery/jquery.easyui.min.js"></script>
<script src="jquery/jquery.js"></script>
</head>
<script>
function check(){
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
    alert("username"+username);
    if(username==null||username==""){
    	return false;
    }else if(password==null||passowrd==""){
    	return false;
    }else{
    	return true;
    }}

    
</script>
<body>

    <div id="login">
	
	     <div id="top">
		      <div id="top_left"><img src="images/login_03.gif" /></div>
			  <div id="top_center"></div>
		 </div>
		 
		 <div id="center">
		      <div id="center_left"></div>
			  <div id="center_middle">
			  <form  id="loginForm" name="loginForm">
        <table>
            <tr>
                <td><div align="right" >User Name</div></td>
                <td><input type="text" id="username" name="username"/></td>
            </tr>
            <tr>
                <td><div align="right">Password</div></td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="button" id="btn1" name="submit" value="提交"/></td>
                <td><input type="reset" id="btn2" name="reset" value="重置"/></td>
            </tr>
        </table>
    </form>
			  </div>
			  <div id="center_right"></div>		 
		 </div>
		 <div id="down">
		      <div id="down_left">
			      <div id="inf">
                       <span class="inf_text">版本信息</span>
					   <span class="copyright">管理信息系统 2008 v2.0</span>
			      </div>
			  </div>
			  <div id="down_center"></div>		 
		 </div>

	</div>
	<script type="text/javascript">

	$('#btn1').click(function(){
		var user = {
				username:$("#username").val(),
			     password:$("input[name='password']").val(),
				
			};
		
	    $.ajax({
	        cache:true,//保留缓存数据
	        type:"POST",//为post请求
	        url:"login",//这是我在后台接受数据的文件名
	       // data:$('#loginForm').serialize(),//将该表单序列化
	       data:user,
	       dataType:'json',
	        async:false,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
	        error:function(request){//请求失败之后的操作
	            alert("请求失败！");
	        },
	        success:function(data){//请求成功之后的操作 

	        	 alert("请求成功！"+data.username);
	        	 alert("请求成功！"+data.password);
	        	
	        	      //   $("#content-wrapper").html(data);
	        	document.getElementById("str").value=data.msg2;
	        //你要跳转的url路径 
	        window.location.href="<%=request.getContextPath()%>/success.jsp?msg='成功跳转'";
	        // request.getContextPath()/success.jsp 
	           // console.log("success");
	        }
	    });
	});

</script>
</body>

</html>
