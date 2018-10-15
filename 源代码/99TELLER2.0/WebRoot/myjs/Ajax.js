/**
 * Ajax 框架
 * @author
 * @date 2011-11-18 16:04:45
 * @param URL
 * @param parameters
 */

	
	function AjaxApi(){
		
		var debug = false;
		
		if(debug)alert("new AjaxApi()");
		
		//this.params = params;//参数
		//this.url = url;
		
		this.parameters = arguments;
		
		this.param = null;
		
		this.url = null;
		
		AjaxApi.prototype.request = false;//Ajax 请求核心对象
		AjaxApi.prototype.returnfunction = null; 
		AjaxApi.prototype.starfunction = null; 
		//this.requestURL="";
		
		/**
		 * 初始化Ajax引擎
		 */
		
		this.iniParams=function(){
			alert('参数初始化');
			alert(this.parameters.length);
			if(this.parameters.length == 4){
				this.url = this.parameters[0]
				this.param = this.parameters[1];
				AjaxApi.prototype.returnfunction = this.parameters[2];
				AjaxApi.prototype.starfunction = this.parameters[3];
			}
		}
		
		this.initEngine = function(){
			if(debug)alert("AjaxApi().initEngine()");
			alert("初始化Ajax引擎");
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
		
		
		
		/**
		 * Ajax发送
		 *
		 */
		
		this.send=function(){
			alert("Ajax发送！");
			//this.request = AjaxApi.prototype.request;
			var url2 = this.url + "?" + this.param;
			alert(url2);
			alert("url2");
			this.request.open("GET", url2 ,true);
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
			alert("Ajax状态为4！");
				if(AjaxApi.prototype.request.status==200){
					var docXMl = AjaxApi.prototype.request.responseXML;
					alert("Ajax接受完成！");
					AjaxApi.prototype.returnfunction(docXMl);
				}
			}
		}
		
		this.init=function(){
			this.iniParams();
			this.initEngine();
		}
		 
		this.init();
	}
