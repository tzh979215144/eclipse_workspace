	function $(name){
		var text = document.getElementById(name);
		
		if(text == '' || text == null){
			alert('id不存在！');
	 		return '';
	 	}
	 	return text.value;
	}	
//发送消息的下面框框
	function tgValue(xml,tgName){
	 	var val = xml.getElementsByTagName(tgName)[0];
	 	if(val == '' || val == null){
	 		return '';
	 	}
	 	return val.text;
	}
	//执行完成，传返回码
	function messSend(){
	  	var frameBottom = parent.document.getElementById("messFrame");
	  	var messageWin = frameBottom.contentWindow;
	  	var sendMess = messageWin.document.getElementById("sendMess");
	  	var recieveMess = messageWin.document.getElementById("recieveMess");
	  	sendMess.innerHTML='正在执行......';
	  	recieveMess.innerHTML='';
	}
	function messRecieve(mess){
		var frameBottom = parent.document.getElementById("messFrame");
	  	var messageWin = frameBottom.contentWindow;
	  	var sendMess = messageWin.document.getElementById("sendMess");
	  	var recieveMess = messageWin.document.getElementById("recieveMess");
	  	if(mess == null || mess==undefined){
	  		mess='0000';
	  	}
	  	sendMess.innerHTML='执行完成';
	  	recieveMess.innerHTML=mess;
	}
