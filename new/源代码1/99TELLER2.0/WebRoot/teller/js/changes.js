function cc(){
	alert(1);
} 
function $(name){
 return document.getElementById(name).value;
 }
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
  	//alert(1);
}
