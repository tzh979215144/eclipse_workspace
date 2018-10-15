<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="css/bootstrap-theme.min.css"></script>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<table data-sort="sortDisabled">
    <tbody>
        <tr class="firstRow">
            <td width="171" valign="top" style="word-break: break-all;">
                记账/复核：<br/>
            </td>
            <td valign="top" rowspan="1" colspan="3">
                <span leipiplugins="select"><select name="leipiNewField" title="记账/复核" style="width: 150px;" size="1" leipiplugins="select" orgwidth="150"><option value="0  记账">
                    0 &nbsp;记账
                </option>
                <option value="1  复核">
                    1 &nbsp;复核
                </option></select>&nbsp;&nbsp;</span>
            </td>
        </tr>
        <tr>
            <td width="171" valign="top" style="word-break: break-all;">
                <p>
                    账号：<br/>
                </p>
            </td>
            <td valign="top" rowspan="1" colspan="3">
                <input name="leipiNewField" title="账号" style="width: 150px; text-align: left;" type="text" value="" orgtype="text" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150"/>
            </td>
        </tr>
        <tr>
            <td width="171" valign="top" style="word-break: break-all;">
                账户名称：<br/>
            </td>
            <td valign="top" rowspan="1" colspan="3">
                <input name="leipiNewField" title="账户名称" style="width: 150px; text-align: left;" type="text" value="" orgtype="text" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150"/>
            </td>
        </tr>
        <tr>
            <td width="171" valign="top" style="word-break: break-all;">
                科目：<br/>
            </td>
            <td width="171" valign="top">
                <input name="leipiNewField" title="科目" style="width: 150px; text-align: left;" type="text" value="" orgtype="text" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150"/>
            </td>
            <td width="171" valign="top" style="word-break: break-all;">
                账户网点：<br/>
            </td>
            <td width="171" valign="top">
                <input name="leipiNewField" title="账户网点" style="width: 150px; text-align: left;" type="text" value="" orgtype="text" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150"/>
            </td>
        </tr>
        <tr>
            <td width="171" valign="top"></td>
            <td width="171" valign="top"></td>
            <td width="171" valign="top" style="word-break: break-all;">
                客户经理：<br/>
            </td>
            <td width="171" valign="top">
                <input name="leipiNewField" title="客户经理" style="width: 150px; text-align: left;" type="text" value="" orgtype="text" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150"/>
            </td>
        </tr>
        <tr>
            <td width="171" valign="top" style="word-break: break-all;">
                账户性质：<br/>
            </td>
            <td width="171" valign="top" style="word-break: break-all;">
                <input name="leipiNewField" title="账户性质" style="width: 150px; text-align: left;" type="text" value="" orgtype="text" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150"/>
            </td>
            <td width="171" valign="top" style="word-break: break-all;">
                存期：<br/>
            </td>
            <td width="171" valign="top" style="word-break: break-all;">
                <input name="leipiNewField" title="存期" style="width: 150px; text-align: left;" type="text" value="" orgtype="text" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150"/>
            </td>
        </tr>
        <tr>
            <td width="171" valign="top" style="word-break: break-all;">
                可用余额：<br/>
            </td>
            <td width="171" valign="top" style="word-break: break-all;">
                <input name="leipiNewField" title="可用余额" style="width: 150px; text-align: left;" type="text" value="" orgtype="float" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150"/>
            </td>
            <td width="171" valign="top" style="word-break: break-all;">
                账户余额：<br/>
            </td>
            <td width="171" valign="top">
                <input name="leipiNewField" title="账户余额" style="width: 150px; text-align: left;" type="text" value="" orgtype="float" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150"/>
            </td>
        </tr>
        <tr>
            <td width="171" valign="top" style="word-break: break-all;">
                凭证号：<br/>
            </td>
            <td valign="top" rowspan="1" colspan="3">
                <input name="leipiNewField" title="凭证号" style="width: 150px; text-align: left;" type="text" value="" orgtype="text" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150"/>
            </td>
        </tr>
        <tr>
            <td width="171" valign="top" style="word-break: break-all;">
                币种：<br/>
            </td>
            <td width="171" valign="top" style="word-break: break-all;">
                <span leipiplugins="select"><select name="leipiNewField" title="币种" style="width: 150px;" size="1" leipiplugins="select" orgwidth="150"><option selected="selected" value="00  美元">
                    00 &nbsp;美元
                </option>
                <option value="01  欧元">
                    01 &nbsp;欧元
                </option>
                <option value="10  人民币">
                    10 &nbsp;人民币
                </option>
                <option value="11  日元">
                    11 &nbsp;日元
                </option></select>&nbsp;&nbsp;</span>
            </td>
            <td width="171" valign="top" style="word-break: break-all;">
                金额：<br/>
            </td>
            <td width="171" valign="top" style="word-break: break-all;">
                <input name="leipiNewField" title="金额" style="width: 150px; text-align: left;" type="text" value="" orgtype="float" leipiplugins="text" orghide="0" orgalign="left" orgwidth="150"/>
            </td>
        </tr>
        <tr>
            <td width="171" valign="top" style="word-break: break-all;">
                分析码：<br/>
            </td>
            <td valign="top" rowspan="1" colspan="3">
                <span leipiplugins="select"><select name="leipiNewField" title="分析码" style="width: 150px;" size="1" leipiplugins="select" orgwidth="150"><option value="000  销售收入">
                    000 &nbsp;销售收入
                </option>
                <option value="100  利息收入">
                    100 &nbsp;利息收入
                </option>
                <option value="010  金融企业往来收入">
                    010 &nbsp;金融企业往来收入
                </option>
                <option value="001  手续费及佣金收入">
                    001 &nbsp;手续费及佣金收入
                </option>
                <option value="110  汇兑损益">
                    110 &nbsp;汇兑损益
                </option>
                <option value="101  投资收益">
                    101 &nbsp;投资收益
                </option>
                <option value="011  公允价值变动损益">
                    011 &nbsp;公允价值变动损益
                </option>
                <option value="111  其他业务收入">
                    111 &nbsp;其他业务收入
                </option></select>&nbsp;&nbsp;</span>
            </td>
        </tr>
    </tbody>
</table>
<button id="submit">提交</button>
<p>
    <br/>
</p>
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
	        url:"deposit",//这是我在后台接受数据的文件名
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