/**
 * Ajax ���
 * @author �ο�
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
		
		//this.params = "";//����
		
		AjaxApi.prototype.request = false;//Ajax ������Ķ���
		AjaxApi.prototype.returnfunction = null; 
		AjaxApi.prototype.starfunction = null; 
		//this.requestURL="";
		
		/**
		 * ��ʼ��Ajax����
		 */
		this.setReturnfun=function(fuc){
		AjaxApi.prototype.returnfunction=fuc;
		}
		
		this.setStarfun=function(fuc){
		AjaxApi.prototype.starfunction=fuc;
		}
		
		this.initEngine = function(){
			if(debug)alert("AjaxApi().initEngine()");
			//alert("��ʼ��Ajax����");
			if(window.XMLHttpRequest){
				AjaxApi.prototype.request = new XMLHttpRequest();
			}else if (window.ActiveXObject) { // IE�����
				try {
					AjaxApi.prototype.request = new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					try {
						AjaxApi.prototype.request = new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {alert('��ʼ��Ajax����ʧ�ܣ�');}
				}
			}
		}
		
		this.initEngine();
		
		this.send=function(url,params){
			//alert("Ajax���ͣ�");
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
			//alert("Ajax״̬Ϊ4��");
				if(AjaxApi.prototype.request.status==200){
					var docXMl = AjaxApi.prototype.request.responseXML;
					//alert("Ajax������ɣ�");
					AjaxApi.prototype.returnfunction(docXMl);
				}
			}
		}
	}
}