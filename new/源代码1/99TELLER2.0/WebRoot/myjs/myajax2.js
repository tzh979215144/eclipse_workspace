/**
 * Ajax 框架
 * @author 何凯
 * @date 2011-12-01 22:49:24
 * @param URL
 * @param param
 */  

  function AjaxApi(){
  
  		var debug = false;
		
		if(debug)alert("new AjaxApi()");
		
		this.parameters = arguments;		//参数列表
		
		this.param = null;			//请求参数
		
		this.url = null;   			//请求地址
		
		AjaxApi.prototype.request = false;//Ajax 请求核心对象
		AjaxApi.prototype.returnfunction = null; 
		AjaxApi.prototype.starfunction = null; 
		
		this.intiEngine=function(){//初始化Ajax引擎
		
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
		
		
		this.iniParams=function(){//初始化参数
		
			if(this.parameters.length == 4){
			
				this.url = this.parameters[0]
				
				this.param = this.parameters[1];
				
				AjaxApi.prototype.returnfunction = this.parameters[2];
				
				AjaxApi.prototype.starfunction = this.parameters[3];
			}
		}
		
		
		this.send=function(){//主方法
			var url2 = this.url + "?" + this.param;
			this.request.open("GET", url2 ,true);
			this.request.onreadystatechange=this.onChange;
			this.request.send(null);
		}
		
		
		this.onChange = function(){//调用方法
			var state = AjaxApi.prototype.request.readyState;
			
			if(state == 1){
			
				if(AjaxApi.prototype.starfunction!=null){
					AjaxApi.prototype.starfunction();
				}
			}
			if(state == 4){
			
				if(AjaxApi.prototype.request.status==200){
					var xmlDoc = AjaxApi.prototype.request.responseXML;  
			    	AjaxApi.prototype.returnfunction(xmlDoc);
				}
			}
		}
		
		this.intiEngine();//执行初始化
		this.iniParams();//
		
  }
