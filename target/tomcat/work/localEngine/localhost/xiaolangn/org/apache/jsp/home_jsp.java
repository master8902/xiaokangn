package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/jquery-1.8.3.js\"></script>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script  type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("function checkisNULL(value,message){\r\n");
      out.write("\tif(value==\"\"|value==\"null\"){\r\n");
      out.write("\t\talert(message);\r\n");
      out.write("\t\t//$(\"#sub\").attr(\"disabled\",false); \r\n");
      out.write("\t\treturn false;\t\r\n");
      out.write("\t}\r\n");
      out.write("\treturn true;\t\r\n");
      out.write("} \r\n");
      out.write("\r\n");
      out.write("function check() {\r\n");
      out.write("\r\n");
      out.write("var textplan3 = $.trim($(\"#textplan3\").val());\r\n");
      out.write("\t\r\n");
      out.write("\tvar result = checkisNULL(textplan3,\"请填111\");\r\n");
      out.write("\tif(result==false){\r\n");
      out.write("\t//\t$(\"#sub\").attr(\"disabled\",false); \r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("var textplan4 = $.trim($(\"#textplan4\").val());\r\n");
      out.write("\t\r\n");
      out.write("\tvar result = checkisNULL(textplan4,\"请填写222\");\r\n");
      out.write("\tif(result==false){\r\n");
      out.write("\t//\t$(\"#sub\").attr(\"disabled\",false); \r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("var textplan5 =$.trim($(\"#textplan5\").val());\r\n");
      out.write("\t\r\n");
      out.write("\tvar result = checkisNULL(textplan5,\"请填写333\");\r\n");
      out.write("\tif(result==false){\r\n");
      out.write("\t//\t$(\"#sub\").attr(\"disabled\",false); \r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t//需要POST的值，把每个变量都通过&来联接  \r\n");
      out.write("var postdata   = \"textplan3=\"+ textplan3 +\"&textplan4=\"+ textplan4 +\"&textplan5=\"+ textplan5;  \r\n");
      out.write("\t\r\n");
      out.write("    $.ajax({\r\n");
      out.write("        url: '");
      out.print(basePath );
      out.write("postdata/post_demo.do',\r\n");
      out.write("         type: 'POST',\r\n");
      out.write("         data: postdata,\r\n");
      out.write("         success: function (returndata) {      \t\r\n");
      out.write(" \t\t\t\talert(\"上传成功\");\r\n");
      out.write(" \t\t\t\t//跳到新的页面 \t\t\t\r\n");
      out.write("         },\r\n");
      out.write("         error: function (returndata) {\r\n");
      out.write("        \t alert(returndata);\r\n");
      out.write("         }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<a>旅程</a>\r\n");
      out.write("<a> 票务</a>\r\n");
      out.write("<a href=\"");
      out.print(basePath );
      out.write("user/user_info.do?userid=1\"> 我的-直接返回数据</a>\r\n");
      out.write("<a href=\"");
      out.print(basePath );
      out.write("user/user_info2.do?userid=1\"> 我的-调到一个新的页面</a>\r\n");
      out.write("<a href=\"");
      out.print(basePath );
      out.write("product/product_info2.do?ishot=1\"> 我的-调到一个近期热门产品页面</a>\r\n");
      out.write("<a href=\"");
      out.print(basePath );
      out.write("schedule/schedule_info2.do?productId=1\"> 我的-调到一个日程安排页面</a>\r\n");
      out.write("\r\n");
      out.write("<a href=\"");
      out.print(basePath );
      out.write("pay/pay_apply.do?\"> 申请调用付款</a>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<textarea id=\"textplan3\" class=\"textplans\" name=\"textplan3\"></textarea>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<textarea id=\"textplan4\" class=\"textplans\" name=\"textplan4\"></textarea>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<textarea id=\"textplan5\" class=\"textplans\" name=\"textplan5\"></textarea>\r\n");
      out.write("<input type=\"button\" onclick=\"check()\" value=\"上传\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
