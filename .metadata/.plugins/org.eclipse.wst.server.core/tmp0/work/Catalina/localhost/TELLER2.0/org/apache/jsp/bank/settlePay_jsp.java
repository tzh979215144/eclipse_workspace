/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.6
 * Generated at: 2018-09-28 10:02:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.bank;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import org.zhoukan.bean.*;

public final class settlePay_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("org.zhoukan.bean");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=GBK");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
settlePayBean reMess = (settlePayBean)request.getAttribute("settlePayBean");
if(reMess != null){
	pageContext.setAttribute("reMess",reMess.getRecieveMess());
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>发放结算</title>\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("body {\r\n");
      out.write("\tmargin-left: 0px;\r\n");
      out.write("\tmargin-top: 0px;\r\n");
      out.write("\tmargin-right: 0px;\r\n");
      out.write("\tmargin-bottom: 0px;\r\n");
      out.write("\tbackground-color: ;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write(".must{color: red ;font-size: 20px; margin-top: 10px}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<link href=\"images/skin.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"teller/css/form-field-tooltip.css\"  media=\"screen\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"teller/js/rounded-corners.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"teller/js/form-field-tooltip.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/TELLER2.0/My97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function messSend(){\r\n");
      out.write("  \tvar frameBottom = parent.document.getElementById(\"messFrame\");\r\n");
      out.write("  \tvar messageWin = frameBottom.contentWindow;\r\n");
      out.write("  \tvar sendMess = messageWin.document.getElementById(\"sendMess\");\r\n");
      out.write("  \tvar recieveMess = messageWin.document.getElementById(\"recieveMess\");\r\n");
      out.write("  \tsendMess.innerHTML='正在执行......';\r\n");
      out.write("  \trecieveMess.innerHTML='';\r\n");
      out.write("}\r\n");
      out.write("function messRecieve(mess){\r\n");
      out.write("\tvar frameBottom = parent.document.getElementById(\"messFrame\");\r\n");
      out.write("  \tvar messageWin = frameBottom.contentWindow;\r\n");
      out.write("  \tvar sendMess = messageWin.document.getElementById(\"sendMess\");\r\n");
      out.write("  \tvar recieveMess = messageWin.document.getElementById(\"recieveMess\");\r\n");
      out.write("  \tif(mess == null || mess==undefined){\r\n");
      out.write("  \t\tmess='';\r\n");
      out.write("  \t}\r\n");
      out.write("  \tsendMess.innerHTML='执行完成';\r\n");
      out.write("  \trecieveMess.innerHTML=mess;\r\n");
      out.write("  \t//alert(1);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  \t  \r\n");
      out.write("          function getSP()\r\n");
      out.write("         {\r\n");
      out.write("            var DD_NO=document.getElementById('dd_no').value;\r\n");
      out.write("            var LOAN_NO2=document.getElementById('loan_no').value;\r\n");
      out.write("    if(DD_NO == '' || DD_NO == null){\r\n");
      out.write("\t\talert('发放号不能为空！');\r\n");
      out.write("\t\tmessRecieve();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("     \t}\r\n");
      out.write("    if(LOAN_NO2 == '' || LOAN_NO2 == null){\r\n");
      out.write("\t\talert('贷款号不能为空！');\r\n");
      out.write("\t\tmessRecieve();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("     \t}\r\n");
      out.write("\t //ajax\r\n");
      out.write("\t var ajax = new AjaxApi('getMessage.do', 'LOAN_NO2='+LOAN_NO2+'&DD_NO='+DD_NO,doxml1,messSend);\r\n");
      out.write("\t //actionmessage中配置，页面传值，执行完成的js,先开始时执行的\r\n");
      out.write("\t \t ajax.send();\r\n");
      out.write("\t\t\r\n");
      out.write("\t //执行\r\n");
      out.write("         }\r\n");
      out.write("          function doxml1(xml){\r\n");
      out.write("         messRecieve();\t\r\n");
      out.write("\t     var LOAN_NO = xml.getElementsByTagName('LOAN_NO2')[0].text;\t\r\n");
      out.write("\t     var DD_NO = xml.getElementsByTagName('DD_NO')[0].text;\r\n");
      out.write("             var CLIENT = xml.getElementsByTagName('CLIENT')[0].text;\r\n");
      out.write("             var NAME = xml.getElementsByTagName('NAME')[0].text;\r\n");
      out.write("             var BRANCH = xml.getElementsByTagName('BRANCH')[0].text;\r\n");
      out.write("             var LOAN_TYPE = xml.getElementsByTagName('LOAN_TYPE')[0].text;\r\n");
      out.write("             var LOAN_SUB_TYPE = xml.getElementsByTagName('LOAN_SUB_TYPE')[0].text;\t\r\n");
      out.write("\t     var USER_ID = xml.getElementsByTagName('USER_ID')[0].text;\r\n");
      out.write("             var CCY = xml.getElementsByTagName('CCY')[0].text;\r\n");
      out.write("             var SETTLE_AMT = xml.getElementsByTagName('SETTLE_AMT')[0].text;\r\n");
      out.write("             var INT_RATE = xml.getElementsByTagName('INT_RATE')[0].text;\r\n");
      out.write("             var BASE_ACCT_NO = xml.getElementsByTagName('BASE_ACCT_NO')[0].text;\r\n");
      out.write("\t     document.getElementById('LOAN_NO').value = LOAN_NO;\r\n");
      out.write("\t     document.getElementById('DD_NO').value = DD_NO;\r\n");
      out.write("             document.getElementById('CLIENT').value = CLIENT;\r\n");
      out.write("             document.getElementById('NAME').value = NAME;\r\n");
      out.write("             document.getElementById('BRANCH').value = BRANCH;\r\n");
      out.write("             document.getElementById('LOAN_TYPE').value =LOAN_TYPE;\r\n");
      out.write("             document.getElementById('LOAN_SUB_TYPE').value = LOAN_SUB_TYPE;\r\n");
      out.write("\t     document.getElementById('USER_ID').value = USER_ID;\r\n");
      out.write("             document.getElementById('CCY').value = CCY;\r\n");
      out.write("             document.getElementById('SETTLE_AMT').value = SETTLE_AMT;\r\n");
      out.write("             document.getElementById('INT_RATE').value = INT_RATE;\r\n");
      out.write("\t     document.getElementById('BASE_ACCT_NO').value = BASE_ACCT_NO;\r\n");
      out.write("\t }\r\n");
      out.write("\t \r\n");
      out.write("\t function tgValue(xml,tgName){\r\n");
      out.write("\t \tvar val = xml.getElementsByTagName(tgName)[0];\r\n");
      out.write("\t \tif(val == '' || val == null){\r\n");
      out.write("\t \t\treturn '';\r\n");
      out.write("\t \t}\r\n");
      out.write("\t \treturn val.text;\r\n");
      out.write("\t}\r\n");
      out.write("  </script>\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("function AjaxApi(){\r\n");
      out.write("  \r\n");
      out.write("  \t\tvar debug = false;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(debug)alert(\"new AjaxApi()\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tthis.parameters = arguments;\t\t//参数列表\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tthis.param = null;\t\t\t//请求参数\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tthis.url = null;   \t\t\t//请求地址\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tAjaxApi.prototype.request = false;//Ajax 请求核心对象\r\n");
      out.write("\t\tAjaxApi.prototype.returnfunction = null; \r\n");
      out.write("\t\tAjaxApi.prototype.starfunction = null; \r\n");
      out.write("\t\t\r\n");
      out.write("\t\tthis.intiEngine=function(){//初始化Ajax引擎\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tif(window.XMLHttpRequest){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tAjaxApi.prototype.request = new XMLHttpRequest();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}else if (window.ActiveXObject) { // IE浏览器\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\ttry {\r\n");
      out.write("\t\t\t\t\tAjaxApi.prototype.request = new ActiveXObject(\"Msxml2.XMLHTTP\");\r\n");
      out.write("\t\t\t\t} catch (e) {\r\n");
      out.write("\t\t\t\t\ttry {\r\n");
      out.write("\t\t\t\t\t\tAjaxApi.prototype.request = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("\t\t\t\t\t} catch (e) {alert('初始化Ajax引擎失败！');}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tthis.iniParams=function(){//初始化参数\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tif(this.parameters.length == 4){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tthis.url = this.parameters[0]\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tthis.param = this.parameters[1];\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tAjaxApi.prototype.returnfunction = this.parameters[2];\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tAjaxApi.prototype.starfunction = this.parameters[3];\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tthis.send=function(){//主方法\r\n");
      out.write("\t\t\tvar url2 = this.url + \"?\" + this.param;\r\n");
      out.write("\t\t\tthis.request.open(\"GET\", url2 ,true);\r\n");
      out.write("\t\t\tthis.request.onreadystatechange=this.onChange;\r\n");
      out.write("\t\t\tthis.request.send(null);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tthis.onChange = function(){//调用方法\r\n");
      out.write("\t\t\tvar state = AjaxApi.prototype.request.readyState;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(state == 1){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tif(AjaxApi.prototype.starfunction!=null){\r\n");
      out.write("\t\t\t\t\tAjaxApi.prototype.starfunction();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(state == 4){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tif(AjaxApi.prototype.request.status==200){\r\n");
      out.write("\t\t\t\t\tvar xmlDoc = AjaxApi.prototype.request.responseXML;  \r\n");
      out.write("\t\t\t    \tAjaxApi.prototype.returnfunction(xmlDoc);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tthis.intiEngine();//执行初始化\r\n");
      out.write("\t\tthis.iniParams();//\r\n");
      out.write("\t\t\r\n");
      out.write("  }\r\n");
      out.write("</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body onLoad=\"messRecieve(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.reMess }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(");\">\r\n");
      out.write("  \r\n");
      out.write(" <form name=\"form1\" method=\"POST\" action=\"settlePay.do\" onSubmit=\"return check();\">\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <table width=\"100%\" height=\"31\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"left_topbg\" id=\"table2\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td height=\"31\"><div class=\"titlebt\">发放结算</div></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("    \r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("    \r\n");
      out.write("\t\t\t<table class=\"left_txt2\" cellspacing=\"1\" cellpadding=\"2\" width=\"99%\"\r\n");
      out.write("\t\t\t\talign=\"center\" border=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr class=\"left_txt\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t<th  height=\"25\">\r\n");
      out.write("\t\t\t\t\t\t\t发放结算\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t          <tr>\r\n");
      out.write("\t\t            <td height=\"20\"><table width=\"100%\" height=\"1\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#CCCCCC\">\r\n");
      out.write("\t\t              <tr>\r\n");
      out.write("\t\t                <td></td>\r\n");
      out.write("\t\t              </tr>\r\n");
      out.write("\t\t            </table></td>\r\n");
      out.write("\t\t          </tr>\t\r\n");
      out.write("\t\t    </table>      \r\n");
      out.write("    <table width=\"100%\" height= \"138\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td valign=\"top\"><table width=\"98%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>\r\n");
      out.write("            \r\n");
      out.write("            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><input name=\"OPER_ID\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginBean.USER_NAME }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t  <tr>\r\n");
      out.write("                <td height=\"30\" align=\"right\" class=\"left_txt2\">贷款号：</td>\r\n");
      out.write("                <td height=\"30\"><input name=\"LOAN_NO\" type=\"text\" size=\"30\"   maxlength=\"18\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.settlePayBean.LOAN_NO }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /></td>\r\n");
      out.write("                <td height=\"30\" align=\"right\" class=\"left_txt2\">发放号：</td>\r\n");
      out.write("                <td height=\"30\"><input name=\"DD_NO\" type=\"text\" size=\"30\"  maxlength=\"18\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.settlePayBean.DD_NO }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /><a class=\"must\">*</a></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("\t\t\t     \r\n");
      out.write("              \r\n");
      out.write("              <tr>\r\n");
      out.write("              <td height=\"30\" align=\"right\" class=\"left_txt2\"></td>\r\n");
      out.write("               <td width=\"15%\" height=\"30\" align=\"right\" class=\"left_txt2\"><input type=\"button\" value=\"获取相关信息\"  onclick=\"getSP();\"/></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("         </table>\r\n");
      out.write("         \r\n");
      out.write("\t\t\t<table class=\"left_txt2\" cellspacing=\"1\" cellpadding=\"2\" width=\"99%\"\r\n");
      out.write("\t\t\t\talign=\"center\" border=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr class=\"left_txt\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t<th  height=\"25\">\r\n");
      out.write("\t\t\t\t\t\t\t发放结算明细\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t          <tr>\r\n");
      out.write("\t\t            <td height=\"20\"><table width=\"100%\" height=\"1\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#CCCCCC\">\r\n");
      out.write("\t\t              <tr>\r\n");
      out.write("\t\t                <td></td>\r\n");
      out.write("\t\t              </tr>\r\n");
      out.write("\t\t            </table></td>\r\n");
      out.write("\t\t          </tr>\t\r\n");
      out.write("\t\t    </table>           \r\n");
      out.write("        \r\n");
      out.write("        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("        \r\n");
      out.write("                <tr>\r\n");
      out.write("                <td height=\"30\" align=\"right\" class=\"left_txt2\">贷款人编号：</td>\r\n");
      out.write("                <td height=\"30\"><input name=\"CLIENT\" type=\"text\" size=\"30\"   maxlength=\"18\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.settlePayBean.CLIENT }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /><a class=\"must\"></a></td>\r\n");
      out.write("                <td height=\"30\" align=\"right\" class=\"left_txt2\">贷款人姓名：</td>\r\n");
      out.write("                <td height=\"30\"><input name=\"NAME\" type=\"text\" size=\"30\"   maxlength=\"18\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.settlePayBean.NAME }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /><a class=\"must\"></a></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              \t\r\n");
      out.write("               <tr>\r\n");
      out.write("               <td height=\"30\" align=\"right\" class=\"left_txt2\">贷款发放银行：</td>\r\n");
      out.write("                <td height=\"30\"><input name=\"BRANCH\" type=\"text\" size=\"30\"   maxlength=\"18\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.settlePayBean.BRANCH }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /><a class=\"must\"></a></td>\r\n");
      out.write("\t\t\t \t<td height=\"30\" align=\"right\" class=\"left_txt2\">贷款类型：</td>\r\n");
      out.write("                <td height=\"30\"><input name=\"LOAN_TYPE\" type=\"text\" size=\"30\"   maxlength=\"18\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.settlePayBean.LOAN_TYPE }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /><a class=\"must\"></a></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("          \r\n");
      out.write("             \r\n");
      out.write("             <tr>      \r\n");
      out.write("                <td height=\"30\" align=\"right\" class=\"left_txt2\">贷款子类型：</td>\r\n");
      out.write("                <td height=\"30\"><input name=\"LOAN_SUB_TYPE\" type=\"text\" size=\"30\"   maxlength=\"18\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.settlePayBean.LOAN_SUB_TYPE }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /><a class=\"must\"></a></td>\r\n");
      out.write("\t\t\t \t<td width=\"15%\" height=\"30\" align=\"right\" class=\"left_txt2\">客户经理：</td>\r\n");
      out.write("                <td height=\"30\"><input name=\"USER_ID\" type=\"text\" size=\"30\"   maxlength=\"18\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.settlePayBean.USER_ID }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /><a class=\"must\"></a></td>\r\n");
      out.write("              </tr>\t\r\n");
      out.write("\r\n");
      out.write("             <tr>\r\n");
      out.write("                \r\n");
      out.write("                <td height=\"30\" align=\"right\" class=\"left_txt2\">发放币种：</td>\r\n");
      out.write("                <td height=\"30\"><input name=\"CCY\" type=\"text\" size=\"30\"   maxlength=\"18\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.settlePayBean.CCY }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /><a class=\"must\"></a></td>\r\n");
      out.write("              \t<td height=\"30\" align=\"right\" class=\"left_txt2\">发放金额：</td>\r\n");
      out.write("                <td height=\"30\"><input name=\"SETTLE_AMT\" type=\"text\" size=\"30\"   maxlength=\"18\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.settlePayBean.SETTLE_AMT }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /><a class=\"must\"></a></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td height=\"30\" align=\"right\" class=\"left_txt2\">贷款利率：</td>\r\n");
      out.write("                <td height=\"30\"><input name=\"INT_RATE\" type=\"text\" size=\"30\"   maxlength=\"18\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.settlePayBean.INT_RATE }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /></td>\r\n");
      out.write("                 <td height=\"30\" align=\"right\" class=\"left_txt2\">结算帐号：</td>\r\n");
      out.write("                <td height=\"30\"><input name=\"BASE_ACCT_NO\" type=\"text\" size=\"30\"   maxlength=\"18\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.settlePayBean.BASE_ACCT_NO }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" /><a class=\"must\"></a></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("                </table></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("        \r\n");
      out.write("            </table>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("          <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td width=\"50%\" height=\"30\" align=\"right\"><input type=\"submit\" value=\"提交\"  onclick=\"messSend();\"/></td>\r\n");
      out.write("              <td width=\"6%\" height=\"30\" align=\"right\">&nbsp;</td>\r\n");
      out.write("              <td width=\"44%\" height=\"30\"><input type=\"reset\" value=\"取消\"  /></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td height=\"30\" colspan=\"3\">&nbsp;</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          </table></td>\r\n");
      out.write("      </tr> \r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write(" </form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var tooltipObj = new DHTMLgoodies_formTooltip();\r\n");
      out.write("tooltipObj.setTooltipPosition('right');\r\n");
      out.write("tooltipObj.setPageBgColor('#f2f2f2');\r\n");
      out.write("tooltipObj.setTooltipCornerSize(10);\r\n");
      out.write("tooltipObj.initFormFieldTooltip();\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}