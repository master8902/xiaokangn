package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class wechatpay_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\" />\r\n");
      out.write("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\r\n");
      out.write("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\" />\r\n");
      out.write("<meta name=\"format-detection\" content=\"telephone=no\" />\r\n");
      out.write("<title>支付</title>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"http://res.wx.qq.com/open/js/jweixin-1.0.0.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\twx.config({\r\n");
      out.write("    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。\r\n");
      out.write("    appId: \"");
      out.print(request.getAttribute("appId"));
      out.write("\", // 必填，公众号的唯一标识\r\n");
      out.write("    timestamp: ");
      out.print(request.getAttribute("timeStamp"));
      out.write(", // 必填，生成签名的时间戳\r\n");
      out.write("    nonceStr: \"");
      out.print(request.getAttribute("nonceStr"));
      out.write("\", // 必填，生成签名的随机串\r\n");
      out.write("    signature: \"");
      out.print(request.getAttribute("paySign"));
      out.write("\",// 必填，签名，见附录1\r\n");
      out.write("    jsApiList: ['chooseWXPay'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2\r\n");
      out.write("});\r\n");
      out.write("\twx.ready(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t    // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。\r\n");
      out.write("\t});\r\n");
      out.write("\twx.error(function(res){\r\n");
      out.write("\t    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction pay(){\r\n");
      out.write("\twx.chooseWXPay({\r\n");
      out.write("    timestamp: ");
      out.print(request.getAttribute("timeStamp"));
      out.write(", // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符\r\n");
      out.write("    nonceStr: \"");
      out.print(request.getAttribute("nonceStr"));
      out.write("\", // 支付签名随机串，不长于 32 位\r\n");
      out.write("    package: \"");
      out.print(request.getAttribute("package"));
      out.write("\", // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）\r\n");
      out.write("    signType: \"");
      out.print(request.getAttribute("signType"));
      out.write("\", // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'\r\n");
      out.write("    paySign: \"");
      out.print(request.getAttribute("paySign"));
      out.write("\", // 支付签名\r\n");
      out.write("    success: function (res) {\r\n");
      out.write("        // 支付成功后的回调函数\r\n");
      out.write("        alert(\"支付成功\");\r\n");
      out.write("    },\r\n");
      out.write("    error:function(res){\r\n");
      out.write("     alert(\"失败\"+\"res\");\r\n");
      out.write("    }\r\n");
      out.write("});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"index_box\">\r\n");
      out.write("\t\t<div class=\"apply_name\">微信js支付测试</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"branch_con\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><span class=\"name\">测试支付信息</span></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<p class=\"cz_btn\"><a href=\"javascript:pay();\" class=\"btn_1\">立即支付</a></p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
