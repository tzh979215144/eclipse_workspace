/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.6
 * Generated at: 2018-10-03 05:18:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import org.zhoukan.dao.GetNOSP;

public final class login1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.zhoukan.dao.GetNOSP");
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
      response.setContentType("text/html;charset=UTF-8");
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

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String n = new GetNOSP().getNO("login_no");
if(!n.equals("-1"))pageContext.setAttribute("login_no",n);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<HEAD>\r\n");
      out.write("\t<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\t<TITLE>用户登录</TITLE>\r\n");
      out.write("\t<LINK href=\"images/Default.css\" type=text/css rel=stylesheet>\r\n");
      out.write("\t<LINK href=\"images/xtree.css\" type=text/css rel=stylesheet>\r\n");
      out.write("\t<LINK href=\"images/User_Login.css\" type=text/css rel=stylesheet>\r\n");
      out.write("    <META http-equiv=Content-Type content=\"text/html; charset=GBK\">\r\n");
      out.write("    <META content=\"MSHTML 6.00.6000.16809\" name=GENERATOR>\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t\r\n");
      out.write("<STYLE type=text/css>\r\n");
      out.write("BODY {\r\n");
      out.write("\tFONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体\r\n");
      out.write("}\r\n");
      out.write("TD {\r\n");
      out.write("\tFONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体\r\n");
      out.write("}\r\n");
      out.write("</STYLE>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write(" <BODY>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<SCRIPT type=text/javascript>\r\n");
      out.write("<!--\r\n");
      out.write("var theForm = document.forms['form1'];\r\n");
      out.write("if (!theForm) {\r\n");
      out.write("    theForm = document.form1;\r\n");
      out.write("}\r\n");
      out.write("function __doPostBack(eventTarget, eventArgument) {\r\n");
      out.write("    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {\r\n");
      out.write("        theForm.__EVENTTARGET.value = eventTarget;\r\n");
      out.write("        theForm.__EVENTARGUMENT.value = eventArgument;\r\n");
      out.write("        theForm.submit();\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// -->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<SCRIPT src=\"login_files/WebResource.axd\" type=text/javascript></SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<SCRIPT src=\"login_files/WebResource(1).axd\" type=text/javascript></SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<SCRIPT src=\"login_files/ScriptResource.axd\" type=text/javascript></SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<SCRIPT src=\"login_files/ScriptResource(1).axd\" type=text/javascript></SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<SCRIPT type=text/javascript>\r\n");
      out.write("<!--\r\n");
      out.write("function WebForm_OnSubmit() {\r\n");
      out.write("if (typeof(ValidatorOnSubmit) == \"function\" && ValidatorOnSubmit() == false) return false;\r\n");
      out.write("return true;\r\n");
      out.write("}\r\n");
      out.write("// -->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<SCRIPT type=text/javascript>\r\n");
      out.write("//<![CDATA[\r\n");
      out.write("Sys.WebForms.PageRequestManager._initialize('ScriptManager1', document.getElementById('form1'));\r\n");
      out.write("Sys.WebForms.PageRequestManager.getInstance()._updateControls(['tUpdatePanel1'], [], [], 90);\r\n");
      out.write("//]]>\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<DIV id=UpdatePanel1>\r\n");
      out.write("<DIV id=div1 \r\n");
      out.write("style=\"LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff\"></DIV>\r\n");
      out.write("<DIV id=div2 \r\n");
      out.write("style=\"LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff\"></DIV>\r\n");
      out.write("<SCRIPT language=JavaScript> \r\n");
      out.write("var speed=20;\r\n");
      out.write("var temp=new Array(); \r\n");
      out.write("var clipright=document.body.clientWidth/2,clipleft=0 \r\n");
      out.write("for (i=1;i<=2;i++){ \r\n");
      out.write("\ttemp[i]=eval(\"document.all.div\"+i+\".style\");\r\n");
      out.write("\ttemp[i].width=document.body.clientWidth/2;\r\n");
      out.write("\ttemp[i].height=document.body.clientHeight;\r\n");
      out.write("\ttemp[i].left=(i-1)*parseInt(temp[i].width);\r\n");
      out.write("} \r\n");
      out.write("function openit(){ \r\n");
      out.write("\tclipright-=speed;\r\n");
      out.write("\ttemp[1].clip=\"rect(0 \"+clipright+\" auto 0)\";\r\n");
      out.write("\tclipleft+=speed;\r\n");
      out.write("\ttemp[2].clip=\"rect(0 auto auto \"+clipleft+\")\";\r\n");
      out.write("\tif (clipright<=0)\r\n");
      out.write("\t\tclearInterval(tim);\r\n");
      out.write("} \r\n");
      out.write("tim=setInterval(\"openit()\",100);\r\n");
      out.write("                </SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<DIV>&nbsp;&nbsp; </dIv>\r\n");
      out.write("<DIV>\r\n");
      out.write("<TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0>\r\n");
      out.write("  <TBODY>\r\n");
      out.write("  <TR>\r\n");
      out.write("    <TD style=\"HEIGHT: 105px\"><IMG src=\"login_files/login_1.gif\" \r\n");
      out.write("  border=0></TD></TR>\r\n");
      out.write("  <TR>\r\n");
      out.write("    <TD background=login_files/login_2.jpg height=300>\r\n");
      out.write("    <FORM id=form1 name=form1 onSubmit=\"javascript:return WebForm_OnSubmit();\" action=\"login.do\" method=\"post\">\r\n");
      out.write("      <TABLE height=300 cellPadding=0 width=900 border=0>\r\n");
      out.write("        <TBODY>\r\n");
      out.write("        <TR>\r\n");
      out.write("          <TD colSpan=2 height=35></TD></TR>\r\n");
      out.write("        <TR>\r\n");
      out.write("          <TD width=360></TD>\r\n");
      out.write("          <TD>\r\n");
      out.write("            <TABLE cellSpacing=0 cellPadding=2 border=0>\r\n");
      out.write("              <TBODY>\r\n");
      out.write("            \r\n");
      out.write("              <TR>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\"></TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\">\r\n");
      out.write("                <INPUT id=txt style=\"WIDTH: 130px\" name=\"LOGIN_ID\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageScope.login_no }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly type=\"hidden\"></TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\">&nbsp;</TD>\r\n");
      out.write("              </TR>\r\n");
      out.write("               <TR>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\">机 构 号：</TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\">\r\n");
      out.write("                <INPUT id=txtOrg style=\"WIDTH: 130px\" name=\"ORG_ID\"></TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\" width=370>\r\n");
      out.write("                <SPAN id=RequiredFieldValidator1 \r\n");
      out.write("                  style=\"FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white\">请输入机构号</SPAN></TD>\r\n");
      out.write("              </TR>\r\n");
      out.write("              <TR>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\">网 点 号：</TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\">\r\n");
      out.write("                <INPUT id=txtCode style=\"WIDTH: 130px\" name=\"NET_ID\"></TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\" width=370>\r\n");
      out.write("                <SPAN id=RequiredFieldValidator2 \r\n");
      out.write("                  style=\"FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white\">请输入网点号</SPAN></TD>\r\n");
      out.write("              </TR>\r\n");
      out.write("              <TR>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\" width=80>登 录 名：</TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\" width=150>\r\n");
      out.write("                <INPUT id=txtName style=\"WIDTH: 130px\" name=\"USER_NAME\"></TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\" width=370>\r\n");
      out.write("                <SPAN id=RequiredFieldValidator3 \r\n");
      out.write("                  style=\"FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white\">请输入登录名</SPAN></TD>\r\n");
      out.write("              </TR>\r\n");
      out.write("              <TR>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\">登录密码：</TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\">\r\n");
      out.write("                <INPUT id=txtPwd style=\"WIDTH: 130px\" type=password name=\"USER_PASSWORD\"></TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\"><SPAN id=RequiredFieldValidator4 \r\n");
      out.write("                  style=\"FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white\">请输入密码</SPAN></TD>\r\n");
      out.write("              </TR>\r\n");
      out.write("             \r\n");
      out.write("              <TR>\r\n");
      out.write("                <TD style=\"HEIGHT: 18px\"></TD>\r\n");
      out.write("             \r\n");
      out.write("                  <TD style=\"HEIGHT: 18px\">\r\n");
      out.write("                  <SPAN \r\n");
      out.write("                  style=\"FONT-WEIGHT: bold;  COLOR: red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.loginErr}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</SPAN>\r\n");
      out.write("                  </TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 18px\"></TD></TR>\r\n");
      out.write("              <TR>\r\n");
      out.write("                <TD></TD>\r\n");
      out.write("                <TD>\r\n");
      out.write("                <INPUT id=btn \r\n");
      out.write("                  style=\"BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px\" \r\n");
      out.write("                  onclick='javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions(\"btn\", \"\", true, \"\", \"\", false, false))' \r\n");
      out.write("                  type=image src=\"login_files/login_button.gif\" name=\"btn\">\r\n");
      out.write("              </TD>\r\n");
      out.write("              </TR>\r\n");
      out.write("              </TBODY>\r\n");
      out.write("              </TABLE>\r\n");
      out.write("              </TD>\r\n");
      out.write("              </TR>\r\n");
      out.write("              </TBODY>\r\n");
      out.write("              </TABLE>\r\n");
      out.write("</FORM>\r\n");
      out.write("              </TD>\r\n");
      out.write("              </TR>\r\n");
      out.write("  \t\t<TR>\r\n");
      out.write("    \t\t<TD><IMG src=\"login_files/login_3.jpg\" border=0></TD>\r\n");
      out.write("    \t</TR>\r\n");
      out.write("    \t</TBODY>\r\n");
      out.write("    \t</TABLE>\r\n");
      out.write("    \t</DIV>\r\n");
      out.write("    \t</DIV>\r\n");
      out.write("<SCRIPT type=text/javascript>\r\n");
      out.write("<!--\r\n");
      out.write("var Page_Validators =  new Array(document.getElementById(\"RequiredFieldValidator1\"),document.getElementById(\"RequiredFieldValidator2\"),\r\n");
      out.write("document.getElementById(\"RequiredFieldValidator3\"), document.getElementById(\"RequiredFieldValidator4\"));\r\n");
      out.write("// -->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<SCRIPT type=text/javascript>\r\n");
      out.write("<!--\r\n");
      out.write("var RequiredFieldValidator3 = document.all ? document.all[\"RequiredFieldValidator1\"] : document.getElementById(\"RequiredFieldValidator3\");\r\n");
      out.write("RequiredFieldValidator3.controltovalidate = \"txtOrg\";\r\n");
      out.write("RequiredFieldValidator3.evaluationfunction = \"RequiredFieldValidatorEvaluateIsValid\";\r\n");
      out.write("RequiredFieldValidator3.initialvalue = \"\";\r\n");
      out.write("var RequiredFieldValidator3 = document.all ? document.all[\"RequiredFieldValidator2\"] : document.getElementById(\"RequiredFieldValidator3\");\r\n");
      out.write("RequiredFieldValidator3.controltovalidate = \"txtCode\";\r\n");
      out.write("RequiredFieldValidator3.evaluationfunction = \"RequiredFieldValidatorEvaluateIsValid\";\r\n");
      out.write("RequiredFieldValidator3.initialvalue = \"\";\r\n");
      out.write("var RequiredFieldValidator3 = document.all ? document.all[\"RequiredFieldValidator3\"] : document.getElementById(\"RequiredFieldValidator3\");\r\n");
      out.write("RequiredFieldValidator3.controltovalidate = \"txtName\";\r\n");
      out.write("RequiredFieldValidator3.evaluationfunction = \"RequiredFieldValidatorEvaluateIsValid\";\r\n");
      out.write("RequiredFieldValidator3.initialvalue = \"\";\r\n");
      out.write("var RequiredFieldValidator4 = document.all ? document.all[\"RequiredFieldValidator4\"] : document.getElementById(\"RequiredFieldValidator4\");\r\n");
      out.write("RequiredFieldValidator4.controltovalidate = \"txtPwd\";\r\n");
      out.write("RequiredFieldValidator4.evaluationfunction = \"RequiredFieldValidatorEvaluateIsValid\";\r\n");
      out.write("RequiredFieldValidator4.initialvalue = \"\";\r\n");
      out.write("// -->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<SCRIPT type=text/javascript>\r\n");
      out.write("<!--\r\n");
      out.write("var Page_ValidationActive = false;\r\n");
      out.write("if (typeof(ValidatorOnLoad) == \"function\") {\r\n");
      out.write("    ValidatorOnLoad();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function ValidatorOnSubmit() {\r\n");
      out.write("    if (Page_ValidationActive) {\r\n");
      out.write("        return ValidatorCommonOnSubmit();\r\n");
      out.write("    }\r\n");
      out.write("    else {\r\n");
      out.write("        return true;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("// -->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<SCRIPT type=text/javascript>\r\n");
      out.write("<!--\r\n");
      out.write("Sys.Application.initialize();\r\n");
      out.write("// -->\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("</BODY>\r\n");
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