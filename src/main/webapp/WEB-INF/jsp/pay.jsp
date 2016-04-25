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
	document.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ffc728a584dc255&redirect_uri=http%3a%2f%2fwww.sharlontrip.com%2fxiaolangn%2fpay%2ftest%2fpay_callback.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
	
}
</script>
</head>
<body>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
	<button onclick="pay11();return false;" > 申请调用付款</button>
	



</body>
</html>
