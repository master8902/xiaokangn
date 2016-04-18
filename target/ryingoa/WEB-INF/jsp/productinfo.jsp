<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

  
<body>
<h2>
这是productinfo页面<br>

产品主题: ${title}<br> 旅行开始时间: ${startDateString}<br> 旅行结束时间: ${endDateString}<br> 产品背景图: ${picture_url}<br>



</h2>
</body>
</html>
