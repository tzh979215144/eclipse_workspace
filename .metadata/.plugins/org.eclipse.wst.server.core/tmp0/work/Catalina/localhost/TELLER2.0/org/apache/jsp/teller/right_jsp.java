/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.6
 * Generated at: 2018-09-21 01:54:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.teller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class right_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <link href=\"images/skin.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("body {\r\n");
      out.write("\tmargin-left: 0px;\r\n");
      out.write("\tmargin-top: 0px;\r\n");
      out.write("\tmargin-right: 0px;\r\n");
      out.write("\tmargin-bottom: 0px;  \r\n");
      out.write("\t background:url(teller/images/bg_17.jpg)\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("<body> \r\n");
      out.write("\r\n");
      out.write(" <script Language=\"javascript\">\r\n");
      out.write("function a(x,y,color)\r\n");
      out.write("{document.write(\"<img border='0' style='position: absolute; left: \"+(x+100)+\"; top: \"+(y+200)+\";background-color: \"+color+\"' src='px.gif' width=1 height=1>\")}\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("for(t=1;t<=360;t++){\r\n");
      out.write("lo=200 * Math.sin(2 * (Math.PI / 180) * t);\r\n");
      out.write("x = lo * Math.cos((Math.PI / 180) * t);\r\n");
      out.write("y = lo * Math.sin((Math.PI / 180) * t); \r\n");
      out.write("a(x,y,\"#000000\");\r\n");
      out.write("lo=200 * Math.cos(2 * (Math.PI / 180) * t);\r\n");
      out.write("x = lo * Math.cos((Math.PI / 180) * t);\r\n");
      out.write("y = lo * Math.sin((Math.PI / 180) * t); \r\n");
      out.write("a(x,y,\"#ff0000\");\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write(".drop { position: absolute; width: 3;  filter: flipV(), flipH(); font-size: 40; color:white}\r\n");
      out.write("</style>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("snow = true;    // false-rain;   true-snow\r\n");
      out.write("snowsym = \" * \"  //These are the symbols for each\r\n");
      out.write("rainsym = \" * \"  //You can put images here.\r\n");
      out.write("howmany = 22     //How many drops/snowflakes?\r\n");
      out.write("\r\n");
      out.write("/**************Do not need to change anything below***********/\r\n");
      out.write("if(snow){sym = snowsym; speed=1; angle=10; drops=howmany}\r\n");
      out.write("else{sym = rainsym; speed=50; drops=howmany; angle=6}\r\n");
      out.write("movex = -speed/angle; movey = speed; count = 0;   \r\n");
      out.write("\r\n");
      out.write("function moverain(){\r\n");
      out.write("for(move = 0; move < drops; move++){\r\n");
      out.write("xx[move]+=movex;  yy[move]+=mv[move];\r\n");
      out.write("hmm = Math.round(Math.random()*1);\r\n");
      out.write("if(xx[move] < 0){xx[move] = maxx+10;}\r\n");
      out.write("if(yy[move] > maxy){yy[move] = 10;}\r\n");
      out.write("drop[move].left = xx[move]\r\n");
      out.write("drop[move].top = yy[move]+document.body.scrollTop;\r\n");
      out.write("}setTimeout('moverain()','1')}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("if (document.all){\r\n");
      out.write("drop = new Array(); xx = new Array(); yy = new Array(); mv = new Array()\r\n");
      out.write("ly = \"document.all[\\'\"; st = \"\\'].style\"\r\n");
      out.write("for(make = 0; make < drops; make++){\r\n");
      out.write("document.write('<div id=\"drop'+make+'\" class=drop>'+sym+'</div>');\r\n");
      out.write("drop[make] = eval(ly+'drop'+make+st);\r\n");
      out.write("maxx = document.body.clientWidth-40\r\n");
      out.write("maxy = document.body.clientHeight-40\r\n");
      out.write("xx[make] = Math.random()*maxx;\r\n");
      out.write("yy[make] = -100-Math.random()*maxy;\r\n");
      out.write("drop[make].left = xx[make]\r\n");
      out.write("drop[make].top = yy[make]\r\n");
      out.write("mv[make] = (Math.random()*5)+speed/16;\r\n");
      out.write("drop[make].fontSize = (Math.random()*10)+20;\r\n");
      out.write("if(snow){col = 'white'}else{col = 'blue'}\r\n");
      out.write("drop[make].color = col;\r\n");
      out.write("}\r\n");
      out.write("window.onload=moverain\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<div style=\"margin-top:150px; margin-bottom:150px;\">\r\n");
      out.write("  <h1>\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h2 align=\"center\"><font color=\"#800000\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;  &nbsp;&nbsp;    &nbsp;  &nbsp;&nbsp;&nbsp; 欢迎光临!!</font>&nbsp;</h2>\r\n");
      out.write("<p align=\"center\">&nbsp;</p>\r\n");
      out.write("  </h1>   \r\n");
      out.write("</div>\r\n");
      out.write("</center>\r\n");
      out.write("        <td width=\"51%\" class=\"left_txt\" align=\"center\">  \r\n");
      out.write("\t\t<div style=\" text-align:center; font-size:12px; font-style:inherit; margin:0px; font:'宋体'\"> \r\n");
      out.write("        \r\n");
      out.write("         <span id=\"theText\" style=\"width:100%\">\r\n");
      out.write("\t\t&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &copy;版权所有：Object项目开发小组<br>\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"images/icon-phone.gif\" width=\"17\" height=\"14\">&nbsp; 联系我们：QQ12345678 </span>\r\n");
      out.write("         <script>\r\n");
      out.write("<!--\r\n");
      out.write("var from = 5;\r\n");
      out.write("var to = 50;\r\n");
      out.write("var delay = 5;\r\n");
      out.write("var glowColor = \"lime\";\r\n");
      out.write("var i = to;\r\n");
      out.write("var j = 0;\r\n");
      out.write("textPulseDown();\r\n");
      out.write("\r\n");
      out.write("function textPulseUp()\r\n");
      out.write("{\r\n");
      out.write("if (!document.all)\r\n");
      out.write("return   \r\n");
      out.write("if (i < to)\r\n");
      out.write("{\r\n");
      out.write("theText.style.filter = \"Glow(Color=\" + glowColor + \", Strength=\" + i + \")\";\r\n");
      out.write("i++;\r\n");
      out.write("theTimeout = setTimeout('textPulseUp()',delay);\r\n");
      out.write("return 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("if (i = to)\r\n");
      out.write("{\r\n");
      out.write("theTimeout = setTimeout('textPulseDown()',delay);\r\n");
      out.write("return 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function textPulseDown()\r\n");
      out.write("{\r\n");
      out.write("if (!document.all)\r\n");
      out.write("return\r\n");
      out.write("if (i > from)\r\n");
      out.write("{\r\n");
      out.write("theText.style.filter = \"Glow(Color=\" + glowColor + \", Strength=\" + i + \")\";\r\n");
      out.write("i--;\r\n");
      out.write("theTimeout = setTimeout('textPulseDown()',delay);\r\n");
      out.write("return 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("if (i = from)\r\n");
      out.write("{\r\n");
      out.write("theTimeout = setTimeout('textPulseUp()',delay);\r\n");
      out.write("return 0;\r\n");
      out.write("}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("        \r\n");
      out.write("</div>\r\n");
      out.write("             </td>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("        <td>&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("    <td background=\"images/mail_rightbg.gif\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
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
