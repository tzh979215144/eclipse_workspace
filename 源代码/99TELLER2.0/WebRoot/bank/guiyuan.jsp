<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="css/bootstrap-theme.min.css"></script>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>柜员权限管理</title>
</head>
<body>
<p style="text-align: left;">
    <span style="font-size: 20px;">&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="font-size: 24px;"> 用户信息</span></span>
</p>
<table data-sort="sortDisabled">
    <tbody>
        <tr class="firstRow">
            <td width="88" valign="top" style="word-break: break-all;">
                角色类别
            </td>
            <td valign="top" rowspan="1" colspan="2" width="4">
                <span leipiplugins="select"><select name="leipiNewField" title="ROLE_ID" id="ROLE_ID" leipiplugins="select" size="1" orgwidth="150" style="width: 150px;"><option value="1">
                    1
                </option>
                <option value="2">
                    2
                </option>
                <option value="3">
                    3
                </option></select>&nbsp;&nbsp;</span>
            </td>
            <td width="84" valign="top" style="word-break: break-all;">
                姓名
            </td>
            <td valign="top" rowspan="1" colspan="2">
                <input id="USER_NAME" name="leipiNewField" type="text" title="USER_NAME" value="" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150" orgtype="text" style="text-align: left; width: 150px;"/>
            </td>
        </tr>
        <tr>
            <td width="88" valign="top" style="word-break: break-all;">
                年龄
            </td>
            <td valign="top" rowspan="1" colspan="2" width="4">
                <input id="USER_AGE" name="leipiNewField" type="text" title="USER_AGE" value="" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150" orgtype="text" style="text-align: left; width: 150px;"/>
            </td>
            <td width="84" valign="top" style="word-break: break-all;">
                性别&nbsp;
            </td>
            <td valign="top" rowspan="1" colspan="2" style="word-break: break-all;">
                <span leipiplugins="select"><select id="USER_SEX" name="leipiNewField" title="USER_SEX" leipiplugins="select" size="1" orgwidth="150" style="width: 150px;"><option value="男">
                    男
                </option>
                <option value="女">
                    女
                </option></select></span>
            </td>
        </tr>
        <tr>
            <td width="88" valign="top" style="word-break: break-all;">
                身份证号码
            </td>
            <td valign="top" rowspan="1" colspan="2" width="4">
                <input id="USER_IDCARD" name="leipiNewField" type="text" title="USER_IDCARD" value="" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150" orgtype="text" style="text-align: left; width: 150px;"/>
            </td>
            <td width="84" valign="top" style="word-break: break-all;">
                手机号码
            </td>
            <td valign="top" rowspan="1" colspan="2">
                <input id="USER_PHONE"  name="leipiNewField" type="text" title="USER_PHONE" value="" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150" orgtype="text" style="text-align: left; width: 150px;"/>
            </td>
        </tr>
        <tr>
            <td width="88" valign="top" style="word-break: break-all;">
                通行号码<br/>
            </td>
            <td valign="top" rowspan="1" colspan="2" width="4">
                <input id="USER_PASSWORD" name="leipiNewField" type="text" title="USER_PASSWORD" value="" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150" orgtype="text" style="text-align: left; width: 150px;"/>
            </td>
            <td width="84" valign="top">
                城市<br/>
            </td>
            <td valign="top" rowspan="1" colspan="2">
                <input id="USER_CITY" name="leipiNewField" type="text" title="USER_CITY" value="" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150" orgtype="text" style="text-align: left; width: 150px;"/>
            </td>
        </tr>
        <tr>
            <td width="88" valign="top">
                详细地址<br/>
            </td>
            <td valign="top" rowspan="1" colspan="2" width="4">
                <input id="USER_ADDRESS" name="leipiNewField" type="text" title="USER_ADDRESS" value="" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150" orgtype="text" style="text-align: left; width: 150px;"/>
            </td>
            <td width="84" valign="top" style="word-break: break-all;">
                状态<br/>
            </td>
            <td valign="top" rowspan="1" colspan="2">
                <span leipiplugins="select"><select id="USER_STATUS" name="leipiNewField" title="USER_STATUS" leipiplugins="select" size="1" orgwidth="150" style="width: 150px;"><option value="0">
                    正常
                </option>
                <option value="1">
                    冻结
                </option></select>&nbsp;&nbsp;</span>
            </td>
        </tr>
        <tr>
            <td valign="top" colspan="1" rowspan="1" style="word-break: break-all;">
                网络号
            </td>
            <td valign="top" colspan="5" rowspan="1">
                <input id="NET" name="leipiNewField" type="text" title="NET" value="" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150" orgtype="text" style="text-align: left; width: 150px;"/>
            </td>
        </tr>
    </tbody>
</table>
<button id="submit"> 提交</button>
<p style="text-align: center;">
    <br/>
</p>
<p>
    <br/>
</p>
<p>
    <br/>
</p>
	<script type="text/javascript">

	$('#submit').click(function(){
		
		var object = {
				ROLE_ID:$("#ROLE_ID").val(),
				USER_NAME:$("#USER_NAME").val(),
				USER_SEX:$("#USER_SEX").val(),
				USER_AGE:$("#USER_AGE").val(),
				USER_IDCARD:$("#USER_IDCARD").val(),
			    USER_PHONE:$("#USER_PHONE").val(),
			    USER_PASSWORD:$("#USER_PASSWORD").val(),
			    USER_CITY:$("#USER_CITY").val(),
			    USER_ADDRESS:$("#USER_ADDRESS").val(),
			    USER_STATUS:$("#USER_STATUS").val(), 
			    NET:$("#NET").val(),
				
			};
		
	    $.ajax({
	        cache:true,//保留缓存数据
	        type:"post",//为post请求
	        url:"Guiyuan",//这是我在后台接受数据的文件名
	       // data:$('#loginForm').serialize(),//将该表单序列化
	       data:object,
	       dataType:'json',
	        async:false,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
	        error:function(request){//请求失败之后的操作
	            alert("系统繁忙，请稍候再试！");
	        },
	        success:function(data){//请求成功之后的操作 

	        	 
	        	 if(data.msg=="1"){
	        		 alert("申请贷款成功！");
	        		 //$("#userid").attr("value",data.userid);
	        	 }
	        		 
	        	
	        	      //   $("#content-wrapper").html(data);
	        	//document.getElementById("str").value=data.msg2;
	        }
	    });
	});

</script> 
</body>
</html>