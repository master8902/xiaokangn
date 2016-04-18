<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<body>


<a>旅程</a>
<a> 票务</a>
<a href="<%=basePath %>user/user_info.do?userid=1"> 我的-直接返回数据</a>
<a href="<%=basePath %>user/user_info2.do?userid=1"> 我的-调到一个新的页面</a>
<a href="<%=basePath %>product/product_info2.do?ishot=1"> 我的-调到一个近期热门产品页面</a>
<a href="<%=basePath %>schedule/schedule_info2.do?productId=1"> 我的-调到一个日程安排页面</a>

<a href="<%=basePath %>pay/pay_apply.do?"> 申请调用付款</a>

</body>
</html>
