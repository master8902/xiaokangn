<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>用户登录</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/supersized.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        
        
        <script  type="text/javascript">

function tocustomer_reg(){
	window.location.href="<%=basePath %>register/register_show.do";
} 

</script>
</head>

<body>
    <div id="denglu" class="page-container" >
    <img alt="" src="">
   <form action="" method="post">
   			<s:textfield name="mobile"  class="username" placeholder="手机号码" size="18"></s:textfield>
            <s:password name="password"  class="password" placeholder="密码" size="18"></s:password>
            <button type="submit">登	 陆</button>　
            <button type="submit" onclick="tocustomer_reg()">注   册</button>　
 	</form>
    </div>
</body>
</html>