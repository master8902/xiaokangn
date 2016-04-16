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

</body>
</html>
