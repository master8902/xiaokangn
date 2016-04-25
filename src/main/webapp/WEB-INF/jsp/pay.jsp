<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<script type="text/javascript" src="<%=basePath %>js/jquery-1.8.3.js"></script>
<title>Insert title here</title>
<script  type="text/javascript">
function pay11(){
//	document.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx520c15f417810387&redirect_uri=https%3A%2F%2Fchong.qq.com%2Fphp%2Findex.php%3Fd%3D%26c%3DwxAdapter%26m%3DmobileDeal%26showwxpaytitle%3D1%26vb2ctag%3D4_2030_5_1194_60&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
	document.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ffc728a584dc255&redirect_uri=http%3a%2f%2fwww.sharlontrip.com%2fxiaolangn%2fpay%2ftest%2fpay_callback.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
	//document.location.href="<%=basePath %>pay/test/pay_oauth2.do";
//	var str = "https://open.weixin.qq.com/connect/oauth2/authorize?"+"appid="+"wx9ffc728a584dc255"+"&redirect_uri=http://www.sharlontrip.com:8080/xiaolangn/pay/pay_test.do&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";	
//	document.location.href==str;
}
</script>
</head>
<body>


<a>旅程</a>
<a> 票务</a>

	
	
	<button onclick="pay11();return false;" > 申请调用付款</button>
	
<br>
<br>
<textarea id="textplan3" class="textplans" name="textplan3"></textarea>
<br>
<br>
<textarea id="textplan4" class="textplans" name="textplan4"></textarea>
<br>
<br>
<textarea id="textplan5" class="textplans" name="textplan5"></textarea>
<input type="button" onclick="check()" value="上传"/>


</body>
</html>
