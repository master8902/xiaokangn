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
<base href="<%=basePath%>">  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page"> 

	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="description" content="">
	<meta name="author" content="">


<title>用户注册</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style1.css">
           <script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
           
    <script  type="text/javascript">
    	function pay11(){
    	
    		
    		document.location.href="<%=basePath %>pay/test/pay_show.do";
    	//	var str = "https://open.weixin.qq.com/connect/oauth2/authorize?"+"appid="+"wx9ffc728a584dc255"+"&redirect_uri=http://www.sharlontrip.com:8080/xiaolangn/pay/pay_test.do&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";	
    	//	document.location.href==str;
    	}
    	

    	</script>
</head>
<body>
<div id="zhuce" class="page-container">
	<div id="form1"   > 
	 
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<input id="Phone" name="Phone"  placeholder="请输入手机" onblur="checkjbPhone()"/>
				<input id="PhoneTip" style="display:none;" onfocus="xsphone()"/>
			</td>		
		</tr>
		<tr>
			<td>
			<input id="tpyz"   placeholder="请输入验证码" onblur="checktypz()"/>
			<input id="tpyzTip" style="display:none;" onfocus="xstypz()"/>
			<input type="button" id="tpyzm"  onclick="changeCode()"/>
    <script type="text/javascript">
    	$(function(){
    	a=createCode();
    	document.getElementById('tpyzm').value=a;
    	});
    </script>
			 </td>
		</tr>
		<tr>  
             <td>  
                  <input id="SmsCheckCode" name="SmsCheckCode" placeholder="短信验证码" maxLength="4" />  
                  <input id="SmsCheckCodeTip" style="display:none;" onfocus="xssmscode()"/>
                  <input type="button" id="btnSendCode" name="btnSendCode" value="获取验证码" onclick="sendMessage('<%=basePath %>')"/>
                </td>  
           </tr>  			
		<tr>
			<td>
				<input type="password" id="password" name="password" placeholder="请输入密码" onblur="checkpassword()"/>
				<input  id="passwordTip" style="display:none;" onfocus="xspassword()"/>
			</td>	
		</tr>
		<tr>
			<td>
				<input type="password" name="repassword"  id="passwordRepeat" placeholder="请确认密码" onblur="checkpasswrodb()"/>
				<input  id="passwordRepeatTip" style="display:none;" onfocus="xspasswordb()"/>
			</td>
		</tr>
		
		<tr>
		  <td>
		  <button onclick="checkForm('<%=basePath %>')">注   册</button>　
		  </td>
		 </tr>
	</table>

	
	</div>
	  
	<button  onclick="pay11();return false;">支付</button>　
	

</div>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"  
    type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/formValidator-4.1.3.js"  
    type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/formValidatorRegex.js"  
    type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/register.js"  
    type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/sms.js"  
    type="text/javascript"></script>    
</body>
</html>