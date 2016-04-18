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

      out.write('\n');
      out.write('\n');

    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\" />\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\" />\n");
      out.write("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n");
      out.write("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\" />\n");
      out.write("<meta name=\"format-detection\" content=\"telephone=no\" />\n");
      out.write("<title>支付</title>\n");
      out.write("\t<script type=\"text/javascript\" src=\"../js/jquery-1.8.3.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"http://res.wx.qq.com/open/js/jweixin-1.0.0.js\"></script>\n");
      out.write("\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\twx.config({\n");
      out.write("    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。\n");
      out.write("    appId: \"");
      out.print(request.getAttribute("appId"));
      out.write("\", // 必填，公众号的唯一标识\n");
      out.write("    timestamp: ");
      out.print(request.getAttribute("timeStamp"));
      out.write(", // 必填，生成签名的时间戳\n");
      out.write("    nonceStr: \"");
      out.print(request.getAttribute("nonceStr"));
      out.write("\", // 必填，生成签名的随机串\n");
      out.write("    signature: \"");
      out.print(request.getAttribute("paySign"));
      out.write("\",// 必填，签名，见附录1\n");
      out.write("    jsApiList: ['chooseWXPay'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2\n");
      out.write("});\n");
      out.write("\twx.ready(function(){\n");
      out.write("\t\t\n");
      out.write("\t    // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。\n");
      out.write("\t});\n");
      out.write("\twx.error(function(res){\n");
      out.write("\t    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。\n");
      out.write("\t});\n");
      out.write("\n");
      out.write("\t function onBridgeReady(){\n");
      out.write(" \t  WeixinJSBridge.invoke(\n");
      out.write("       'getBrandWCPayRequest', {\n");
      out.write("           \"appId\" : \"");
      out.print(request.getAttribute("appId"));
      out.write("\",     //公众号名称，由商户传入     \n");
      out.write("           \"timeStamp\": ");
      out.print(request.getAttribute("timeStamp"));
      out.write(",         //时间戳，自1970年以来的秒数     \n");
      out.write("           \"nonceStr\" : \"");
      out.print(request.getAttribute("nonceStr"));
      out.write("\", //随机串     \n");
      out.write("           \"package\" : \"");
      out.print(request.getAttribute("package"));
      out.write("\",     \n");
      out.write("           \"signType\" : \"");
      out.print(request.getAttribute("signType"));
      out.write("\",         //微信签名方式：     \n");
      out.write("           \"paySign\" : \"");
      out.print(request.getAttribute("paySign"));
      out.write("\" //微信签名 \n");
      out.write("       },\n");
      out.write("       function(res){     \n");
      out.write("           if(res.err_msg == \"get_brand_wcpay_request：ok\" ) {}     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 \n");
      out.write("       }\n");
      out.write("   ); \n");
      out.write("}\n");
      out.write("\tfunction pay(){\n");
      out.write("\twx.chooseWXPay({\n");
      out.write("    timestamp: ");
      out.print(request.getAttribute("timeStamp"));
      out.write(", // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符\n");
      out.write("    nonceStr: \"");
      out.print(request.getAttribute("nonceStr"));
      out.write("\", // 支付签名随机串，不长于 32 位\n");
      out.write("    package: \"");
      out.print(request.getAttribute("package"));
      out.write("\", // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）\n");
      out.write("    signType: \"");
      out.print(request.getAttribute("signType"));
      out.write("\", // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'\n");
      out.write("    paySign: \"");
      out.print(request.getAttribute("paySign"));
      out.write("\", // 支付签名\n");
      out.write("    success: function (res) {\n");
      out.write("        // 支付成功后的回调函数\n");
      out.write("        alert(\"支付成功\");\n");
      out.write("    }\n");
      out.write("});\n");
      out.write("\t/*\n");
      out.write("\t\t    \t\n");
      out.write("\t\t\tif (typeof WeixinJSBridge == \"undefined\"){\n");
      out.write("\t\t\t   if( document.addEventListener ){\n");
      out.write("\t\t\t       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);\n");
      out.write("\t\t\t   }else if (document.attachEvent){\n");
      out.write("\t\t\t       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); \n");
      out.write("\t\t\t       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);\n");
      out.write("\t\t\t   }\n");
      out.write("\t\t\t}else{\n");
      out.write("\t\t\t   onBridgeReady();\n");
      out.write("\t\t\t} \n");
      out.write("\t\t\t*/\n");
      out.write("}\n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<div class=\"index_box\">\n");
      out.write("\t\t<div class=\"apply_name\">微信js支付测试</div>\n");
      out.write("\n");
      out.write("\t\t<div class=\"branch_con\">\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li><span class=\"name\">测试支付信息</span></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t<p class=\"cz_btn\"><a href=\"javascript:pay();\" class=\"btn_1\">立即支付</a></p>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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
