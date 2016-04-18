<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

  
<body>
<h2>
这是scheduleinfo页面<br>

第几天: ${day}<br> 日程内容: ${content}<br>  日程背景图: ${picture_url}



</h2>
</body>
</html>
