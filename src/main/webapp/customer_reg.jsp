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

<title>用户注册</title>
</head>
<script src="<%=request.getContextPath()%>/js/jquery-1.4.4.min.js"  
    type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/formValidator-4.1.3.js"  
    type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/formValidatorRegex.js"  
    type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/register.js"  
    type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/sms.js"  
    type="text/javascript"></script>    
<body>
<div>
    <div id="zhuce">
	<s:form id="form1" name="form1"  method="post" > 
	<table width="80%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<s:textfield id="Phone" name="Phone" cssStyle="width:160px;height:24px;" placeholder="请输入手机" onblur="checkjbPhone()"/>
			</td>
			<td align="left" width="30%">  
	       		<span id="jbPhoneTip"  name="jbPhoneTip">  
                        <s:fielderror cssStyle="color:red;padding-left:10px;">  
                            <s:param>jbPhone</s:param>  
                        </s:fielderror>  
            	</span>  
     		 </td>  		
			</tr>
			<tr>  
                 <td align="left" colspan="2" style="padding-left: 112px;" placeholder="短信验证码">  
                     <s:textfield id="SmsCheckCode" name="SmsCheckCode" cssStyle="width:80px;height:24px;" maxLength="4" />  
                      <span><input type="button" id="btnSendCode" name="btnSendCode" value="免费获取验证码" onclick="sendMessage()" /></span>  
                       <span id="SmsCheckCodeTip">  
                           <s:fielderror cssStyle="color:red;padding-left:10px;">  
                               <s:param>SmsCheckCodeTip</s:param>  
                          </s:fielderror>  
                     </span>  
                </td>  
           </tr>  			
		<tr>
			<td>
				<s:password id="password" name="password" placeholder="请输入密码" onblur="checkpassword()"></s:password>
			</td>
			 <td align="left" width="30%">  
                            <span id="passwordTip">  
                                <s:fielderror cssStyle="color:red;padding-left:10px;">  
                                    <s:param>password</s:param>  
                                </s:fielderror>  
                            </span>  
                        </td>  
			
		</tr>
		<tr>
			<td>
				<s:password name="repassword"  id="passwordRepeat" placeholder="请确认密码" onblur="checkpasswrodb()"></s:password>
			</td>
			 <td align="left" width="30%">  
                            <span id="passwordRepeatTip">  
                                <s:fielderror cssStyle="color:red;padding-left:10px;">  
                                    <s:param>passwordRepeat</s:param>  
                                </s:fielderror>  
                            </span>  
                        </td>  
			
		</tr>
		<tr>
		  <td><input type="submit" name="submit" value="注册"></td>
		 </tr>
	</table>
	</s:form>
</div>
</body>
</html>