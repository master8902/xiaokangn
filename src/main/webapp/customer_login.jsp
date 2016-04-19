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
	
	 $.ajax({
	        url: '<%=basePath %>register/register_show.do',
	         type: 'POST'
	    });
} 


function checkisNULL(value,message){
	if(value==""|value=="null"){
		alert(message);
		//$("#sub").attr("disabled",false); 
		return false;	
	}
	return true;	
} 

function check() {

var textplan3 = $.trim($("#textplan3").val());
	
	var result = checkisNULL(textplan3,"请填111");//出错提示
	if(result==false){
	//	$("#sub").attr("disabled",false); 
		return false;
	}
var textplan4 = $.trim($("#textplan4").val());
	
	var result = checkisNULL(textplan4,"请填写222");
	if(result==false){
	//	$("#sub").attr("disabled",false); 
		return false;
	}
var textplan5 =$.trim($("#textplan5").val());
	
	var result = checkisNULL(textplan5,"请填写333");
	if(result==false){
	//	$("#sub").attr("disabled",false); 
		return false;
	}
	
	
	//需要POST的值，把每个变量都通过&来联接  
var postdata   = "textplan3="+ textplan3 +"&textplan4="+ textplan4 +"&textplan5="+ textplan5;  
	
    $.ajax({
        url: '<%=basePath %>postdata/post_demo.do',
         type: 'POST',
         data: postdata,
         success: function (returndata) {      	
 				alert("上传成功");
 				//跳到新的页面 			
         },
         error: function (returndata) {
        	 alert(returndata);
         }
    });
}

</script>
</head>

<body>
    <div id="denglu" class="page-container" >
    <img alt="" src="">
 
   			<s:textfield name="mobile"  id="username" class="username" placeholder="手机号码" size="18"></s:textfield>
            <s:password name="password" id="password" class="password" placeholder="密码" size="18"></s:password>
            <button type="submit" onclick="tocustomer_check()">登	 陆</button>　
            <button type="submit" onclick="tocustomer_reg()">注   册</button>　
 	
    </div>
</body>
</html>