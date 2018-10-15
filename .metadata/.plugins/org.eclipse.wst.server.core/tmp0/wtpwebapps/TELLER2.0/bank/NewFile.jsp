<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <form class="form-signin" onSubmit="javascript:return WebForm_OnSubmit();" action="login.do" method="post">
         <img src="./img/a.png" width="1140" height="150">
		<div class="form-group input-group">
       <span class="input-group-addon"><i class="fa fa-tag"  > <span class="glyphicon glyphicon-user"></span></i></span>
		<input type="text" id="zhanghao"  class="form-control" placeholder="账号" name="USER_NAME" required autofocus >
		</div>
		<div class="form-group input-group">
       <span class="input-group-addon"><i class="fa fa-tag"  > <span class="glyphicon glyphicon-lock"></span></i></span>
        <input type="password" id="inputPassword"  class="form-control" placeholder="密码" name	="USER_PASSWORD" required>
		</div>
		
		
		<div class="form-group input-group">
       <span class="input-group-addon"><i class="fa fa-tag"  > <span class="glyphicon glyphicon-lock"></span></i></span>
        <input type="TEXT" id="inputPassword"  class="form-control" placeholder="机构号" name	="ORG_ID" required>
		</div>
		<div class="form-group input-group">
       <span class="input-group-addon"><i class="fa fa-tag"  > <span class="glyphicon glyphicon-lock"></span></i></span>
        <input type="TEXT" id="inputPassword"  class="form-control" placeholder="网点号" name	="NET_ID" required>
		</div>
		
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住密码
          </label>
        </div>
       <input class="btn btn-lg btn-primary btn-block" type="submit"  name="submit" value="登陆"/>
		<br>
		  <span class="pull-right"><a href="*">忘记密码?</a> </span>  
		  <a href="./register.php" >新建账号</a>  
		  </br>
      </form> 

    </div> <!-- /container -->
                                                     

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>