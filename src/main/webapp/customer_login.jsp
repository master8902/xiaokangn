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
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
        <script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
        <script type="text/javascript" src="<%=basePath %>js/login.js"></script>
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        
        
        <script  type="text/javascript">

function tocustomer_reg(){
	window.location.href="<%=basePath %>register/register_show.do";
} 


function checkisNULL(value,message){
	if(value==""|value=="null"){
		alert(message);
		//$("#sub").attr("disabled",false); 
		return false;	
	}
	return true;	
} 

function tocustomer_check() {

var phoneNum = $.trim($("#phoneNum").val());
	
	var result = checkisNULL(phoneNum,"手机号码不能为空");//出错提示
	if(result==false){
	//	$("#sub").attr("disabled",false); 
		return false;
	}
var password = $.trim($("#password").val());
	
	var result = checkisNULL(password,"密码不能为空");
	if(result==false){
	//	$("#sub").attr("disabled",false); 
		return false;
	}
	
	
	//需要POST的值，把每个变量都通过&来联接  
var postdata   = "phoneNum="+ phoneNum +"&password="+ password ;  
	
    $.ajax({
        url: '<%=basePath %>user/user_login.do',
         type: 'POST',
         data: postdata,
         success: function (returndata) { 
        	 if(returndata=="success"){
        		//登录成功，这边先暂时跳转到注册页面
        		 window.location.href="<%=basePath %>register/register_show.do";
        	 }
        	 else{
        		 alert("帐号或者密码错误");
        	 }
 				
 				//跳到新的页面 			
         },
         error: function (returndata) {
        	 //alert(returndata);
             alert("请输入正确的手机号和密码");
         }
    });
}

</script>
</head>

<body>
    <div id="denglu" class="page-container" >
   	<form action="" method="post">
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<input id="phoneNum" name="phoneNum"  placeholder="请输入手机" onblur="checkjbPhone()"/>
				<input id="PhonelTip" style="display:none;" onfocus="xsphone()"/>
			</td>		
		</tr>
		<tr>
			<td>
            <input id="password" type="password"  class="password" placeholder="密码" size="18"/>
            </td>
         </tr>
         <tr>
        	 <td>
            <button id="denglu" type="submit" onclick="tocustomer_check()">登	 录</button>　
            </td>
          </tr>
          <tr>
         	 <td>
            <button id="zhuce" type="submit" onclick="tocustomer_reg()">立即注册</button>　
            </td>
            </tr>
    </table>
 	</form>
    </div>
</body>
</html>