/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.6
 * Generated at: 2018-09-28 10:13:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.bank;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class withdrawing_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<table data-sort=\"sortDisabled\">\r\n");
      out.write("    <tbody>\r\n");
      out.write("        <tr class=\"firstRow\">\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                记账/复核：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td valign=\"top\" rowspan=\"1\" colspan=\"3\">\r\n");
      out.write("                <span leipiplugins=\"select\"><select name=\"leipiNewField\" title=\"记账/复核\" style=\"width: 150px;\" size=\"1\" leipiplugins=\"select\" orgwidth=\"150\"><option value=\"0  记账\">\r\n");
      out.write("                    0 &nbsp;记账\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"1  复核\">\r\n");
      out.write("                    1 &nbsp;复核\r\n");
      out.write("                </option></select>&nbsp;&nbsp;</span>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                凭证类型：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"171\" valign=\"top\">\r\n");
      out.write("                <span leipiplugins=\"select\"><select name=\"leipiNewField\" title=\"凭证类型\" style=\"width: 150px;\" size=\"1\" leipiplugins=\"select\" orgwidth=\"150\"><option value=\"70201  普通存折\">\r\n");
      out.write("                    70201 &nbsp;普通存折\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"70202  借记卡\">\r\n");
      out.write("                    70202 &nbsp;借记卡\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"70102  双整存单\">\r\n");
      out.write("                    70102 &nbsp;双整存单\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"70101  定活存单\">\r\n");
      out.write("                    70101 &nbsp;定活存单\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"70301  银行承兑汇票\">\r\n");
      out.write("                    70301 &nbsp;银行承兑汇票\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"70304  单位定期存款开户证实书\">\r\n");
      out.write("                    70304 &nbsp;单位定期存款开户证实书\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"70402  现金支票\">\r\n");
      out.write("                    70402 &nbsp;现金支票\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"70403  转账支票\">\r\n");
      out.write("                    70403 &nbsp;转账支票\r\n");
      out.write("                </option></select>&nbsp;&nbsp;</span>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                挂失标志：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"171\" valign=\"top\">\r\n");
      out.write("                <input name=\"leipiNewField\" title=\"挂失标志\" style=\"width: 150px; text-align: left;\" type=\"text\" value=\"\" orgtype=\"text\" leipiplugins=\"text\" orghide=\"0\" orgalign=\"left\" orgwidth=\"150\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                账号：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td valign=\"top\" rowspan=\"1\" colspan=\"3\">\r\n");
      out.write("                <input name=\"leipiNewField\" title=\"账号\" style=\"width: 150px; text-align: left;\" type=\"text\" value=\"\" orgtype=\"text\" leipiplugins=\"text\" orghide=\"0\" orgalign=\"left\" orgwidth=\"150\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                账户名称：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td valign=\"top\" rowspan=\"1\" colspan=\"3\">\r\n");
      out.write("                <input name=\"leipiNewField\" title=\"账户名称\" style=\"width: 150px; text-align: left;\" type=\"text\" value=\"\" orgtype=\"text\" leipiplugins=\"text\" orghide=\"0\" orgalign=\"left\" orgwidth=\"150\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                地址：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td valign=\"top\" rowspan=\"1\" colspan=\"3\">\r\n");
      out.write("                <input name=\"leipiNewField\" title=\"地址\" style=\"width: 150px; text-align: left;\" type=\"text\" value=\"\" orgtype=\"text\" leipiplugins=\"text\" orghide=\"0\" orgalign=\"left\" orgwidth=\"150\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                科目：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td valign=\"top\" rowspan=\"1\" colspan=\"3\">\r\n");
      out.write("                <input name=\"leipiNewField\" title=\"科目\" style=\"width: 150px; text-align: left;\" type=\"text\" value=\"\" orgtype=\"text\" leipiplugins=\"text\" orghide=\"0\" orgalign=\"left\" orgwidth=\"150\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                通存通兑：\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                <input name=\"leipiNewField\" title=\"通存通兑\" style=\"width: 150px; text-align: left;\" type=\"text\" value=\"\" orgtype=\"text\" leipiplugins=\"text\" orghide=\"0\" orgalign=\"left\" orgwidth=\"150\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                客户经理：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"171\" valign=\"top\">\r\n");
      out.write("                <input name=\"leipiNewField\" title=\"客户经理\" style=\"width: 150px; text-align: left;\" type=\"text\" value=\"\" orgtype=\"text\" leipiplugins=\"text\" orghide=\"0\" orgalign=\"left\" orgwidth=\"150\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                账户性质：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"171\" valign=\"top\">\r\n");
      out.write("                <input name=\"leipiNewField\" title=\"账户性质\" style=\"width: 150px; text-align: left;\" type=\"text\" value=\"\" orgtype=\"text\" leipiplugins=\"text\" orghide=\"0\" orgalign=\"left\" orgwidth=\"150\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                支取方式：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"171\" valign=\"top\">\r\n");
      out.write("                <input name=\"leipiNewField\" title=\"支取方式\" style=\"width: 150px; text-align: left;\" type=\"text\" value=\"\" orgtype=\"text\" leipiplugins=\"text\" orghide=\"0\" orgalign=\"left\" orgwidth=\"150\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                可用余额：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"171\" valign=\"top\">\r\n");
      out.write("                <input name=\"leipiNewField\" title=\"可用余额\" style=\"width: 150px; text-align: left;\" type=\"text\" value=\"\" orgtype=\"float\" leipiplugins=\"text\" orghide=\"0\" orgalign=\"left\" orgwidth=\"150\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                账户余额：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td width=\"171\" valign=\"top\">\r\n");
      out.write("                <input name=\"leipiNewField\" title=\"账户余额\" style=\"width: 150px; text-align: left;\" type=\"text\" value=\"\" orgtype=\"float\" leipiplugins=\"text\" orghide=\"0\" orgalign=\"left\" orgwidth=\"150\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td width=\"171\" valign=\"top\" style=\"word-break: break-all;\">\r\n");
      out.write("                凭证号：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td valign=\"top\" rowspan=\"1\" colspan=\"3\">\r\n");
      out.write("                <input name=\"leipiNewField\" title=\"凭证号\" style=\"width: 150px; text-align: left;\" type=\"text\" value=\"\" orgtype=\"text\" leipiplugins=\"text\" orghide=\"0\" orgalign=\"left\" orgwidth=\"150\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td valign=\"top\" style=\"word-break: break-all;\" rowspan=\"1\" colspan=\"1\">\r\n");
      out.write("                币种：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td valign=\"top\" rowspan=\"1\" colspan=\"1\">\r\n");
      out.write("                <span leipiplugins=\"select\"><select name=\"leipiNewField\" title=\"币种\" style=\"width: 150px;\" size=\"1\" leipiplugins=\"select\" orgwidth=\"150\"><option value=\"00  美元\">\r\n");
      out.write("                    00 &nbsp;美元\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"01  欧元\">\r\n");
      out.write("                    01 &nbsp;欧元\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"10  人民币\">\r\n");
      out.write("                    10 &nbsp;人民币\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"11  日元\">\r\n");
      out.write("                    11 &nbsp;日元\r\n");
      out.write("                </option></select>&nbsp;&nbsp;</span>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td valign=\"top\" style=\"word-break: break-all;\" rowspan=\"1\" colspan=\"1\">\r\n");
      out.write("                金额：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td valign=\"top\" rowspan=\"1\" colspan=\"1\">\r\n");
      out.write("                <input name=\"leipiNewField\" title=\"金额\" style=\"width: 150px; text-align: left;\" type=\"text\" value=\"\" orgtype=\"float\" leipiplugins=\"text\" orghide=\"0\" orgalign=\"left\" orgwidth=\"150\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td valign=\"top\" style=\"word-break: break-all;\" rowspan=\"1\" colspan=\"1\">\r\n");
      out.write("                分析码：<br/>\r\n");
      out.write("            </td>\r\n");
      out.write("            <td valign=\"top\" rowspan=\"1\" colspan=\"3\">\r\n");
      out.write("                <span leipiplugins=\"select\"><select name=\"leipiNewField\" title=\"分析码\" style=\"width: 150px;\" size=\"1\" leipiplugins=\"select\" orgwidth=\"150\"><option value=\"000  销售收入\">\r\n");
      out.write("                    000 &nbsp;销售收入\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"100  利息收入\">\r\n");
      out.write("                    100 &nbsp;利息收入\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"010  金融企业往来收入\">\r\n");
      out.write("                    010 &nbsp;金融企业往来收入\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"001  手续费及佣金收入\">\r\n");
      out.write("                    001 &nbsp;手续费及佣金收入\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"011  汇兑损益\">\r\n");
      out.write("                    011 &nbsp;汇兑损益\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"101  投资收益\">\r\n");
      out.write("                    101 &nbsp;投资收益\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"110  公允价值变动损益\">\r\n");
      out.write("                    110 &nbsp;公允价值变动损益\r\n");
      out.write("                </option>\r\n");
      out.write("                <option value=\"111  其他业务收入\">\r\n");
      out.write("                    111 &nbsp;其他业务收入\r\n");
      out.write("                </option></select>&nbsp;&nbsp;</span>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </tbody>\r\n");
      out.write("</table>\r\n");
      out.write("<p>\r\n");
      out.write("    <br/>\r\n");
      out.write("</p>");
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
