/**
 * Ajax 框架
 * @author 何凯
 * @date 2011-11-18 16:04:45
 * @param URL
 * @param parameters
 */
function test2(){
	alert(2);
}
function AjaxApi(){
	
	function AjaxApi(){
		
		var debug = false;
		
		if(debug)alert("new AjaxApi()");
		
		//this.params = "";//参数
		
		AjaxApi.prototype.request = false;//Ajax 请求核心对象
		AjaxApi.prototype.returnfunction = null; 
		AjaxApi.prototype.starfunction = null; 
		//this.requestURL="";
		
		/**
		 * 初始化Ajax引擎
		 */
		this.setReturnfun=function(fuc){
		AjaxApi.prototype.returnfunction=fuc;
		}
		
		this.setStarfun=function(fuc){
		AjaxApi.prototype.starfunction=fuc;
		}
		
		this.initEngine = function(){
			if(debug)alert("AjaxApi().initEngine()");
			//alert("初始化Ajax引擎");
			if(window.XMLHttpRequest){
				AjaxApi.prototype.request = new XMLHttpRequest();
			}else if (window.ActiveXObject) { // IE浏览器
				try {
					AjaxApi.prototype.request = new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					try {
						AjaxApi.prototype.request = new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {alert('初始化Ajax引擎失败！');}
				}
			}
		}
		
		this.initEngine();
		
		this.send=function(url,params){
			//alert("Ajax发送！");
			this.request = AjaxApi.prototype.request;
			this.url = url + "?" + params;
			this.request.open("GET", this.url ,true);
			this.request.onreadystatechange=this.onChange
			this.request.send(null);
		}
		
		this.onChange = function(){
			var state = AjaxApi.prototype.request.readyState;
			if(state == 1){
				if(AjaxApi.prototype.starfunction!=null){
					AjaxApi.prototype.starfunction();
				}
			}
			if(state == 4){
			//alert("Ajax状态为4！");
				if(AjaxApi.prototype.request.status==200){
					var docXMl = AjaxApi.prototype.request.responseXML;
					//alert("Ajax接受完成！");
					AjaxApi.prototype.returnfunction(docXMl);
				}
			}
		}
	}
}
