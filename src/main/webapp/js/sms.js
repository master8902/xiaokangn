var InterValObj; //timer变量，控制时间  
var count = 60; //间隔函数，1秒执行  
var curCount;//当前剩余秒数  
var code = ""; //验证码  
var codeLength = 4;//验证码长度  
function changeCode(){
	var a=createCode();
	document.getElementById('tpyzm').value=a;

}
function xssmscode(){
	 $("#SmsCheckCode").show();//隐藏
	 $("#SmsCheckCodeTip").hide();//隐藏 
}
function checkisNULL(value,message){
	if(value==""|value=="null"){
		alert(message);
		//$("#sub").attr("disabled",false); 
		return false;	
	}
	return true;	
} 

function checkForm(path){
	
	    if(checkjbPhone()==false){
	    	alert("请正确填写手机号");
	    	return false;
	    }
		if(checktypz()==false){
	    	alert("请正确输入图形验证码");
	    	return false;
	    }
	   if( checkpasswrodb()==false){
		   alert("请正确输入密码，且两次的密码要一致");
	    	return false;
	   }
	 
	 var Phone = $("#Phone").val(); 
	 var SmsCheckCode = $("#SmsCheckCode").val(); 
	 var repassword = $("#passwordRepeat").val(); 
	 var productId = $.trim($("#productId").val());
	 var aa   = "Phone="+ Phone+"&SmsCheckCode="+ SmsCheckCode+"&repassword="+ repassword+"&productId="+productId ;  
	 $.ajax({
	        url: path+'register/register_insert.do',
	         type: 'POST',
	         data: aa,
	         success: function (returndata) { 
	        	 var models = eval("("+returndata+")");
	        	 if(models.msg=="success"){
	        		 window.location.href=path+"order/order_info.do?productId="+productId+"&Phone="+Phone;
	        	 }    else{
	        		 alert(models.msg);
	        	 }
	        	 
	         }
	    });
	 
	 return false;
}
function sendMessage(basepath){  
    curCount = count;  
    var jbPhone = $("#Phone").val(); 
    
    if(checkjbPhone()==false){
    	alert("请正确填写手机号");
    	return ;
    }
    	
	var tpyz = $("#tpyz").val(); 
	if(checktypz()==false){
    	alert("请正确输入图形验证码");
    	return ;
    }
    
	
    var jbPhoneTip = $("#PhoneTip").val();  
    if (jbPhone != "") {  
        if(jbPhoneTip == "该手机号码可以注册，输入正确" || jbPhoneTip == "手机号码输入正确"){  
            // 产生验证码  
            for ( var i = 0; i < codeLength; i++) {  
                code += parseInt(Math.random() * 9).toString();  
            }  
            // 设置button效果，开始计时 
            $("#btnSendCode").attr("disabled", "true");  
            $("#btnSendCode").val(curCount+"秒内输入");  
            InterValObj = window.setInterval(SetRemainTime, 1000); // 启动计时器，1秒执行一次  
            // 向后台发送处理数据  
        }
        else{  
        $("#Phone").hide();//隐藏
       	$("#PhoneTip").show();//隐藏 
        $("#PhoneTip").val("手机号码不能为空");  
        }  
    }
    var phoneNum   = "phoneNum="+ jbPhone;  
    	 $.ajax({
    	        url: basepath+'register/register_sendSMS.do',
    	         type: 'POST',
    	         data: phoneNum,
    	         success: function (returndata) { 
    	        	 var models = eval("("+returndata+")");
    	        	 if(models.msg=="success"){
    	        		alert("发送成功");
    	        	 }    else{
    	        		 alert(models.msg);
    	        	 }
    	        	 
    	         }
    	    });
 
}
  
//timer处理函数  
function SetRemainTime() {  
    if (curCount == 0) {                  
        window.clearInterval(InterValObj);// 停止计时器  
        $("#btnSendCode").removeAttr("disabled");// 启用按钮  
        $("#btnSendCode").val("重新发送验证码");  
        code = ""; // 清除验证码。如果不清除，过时间后，输入收到的验证码依然有效  
    }else {  
        curCount--;  
        $("#btnSendCode").val(curCount+"秒内输入");  
    }  
}  
  
$(document).ready(function() {  
    $("#SmsCheckCode").blur(function() {  
        var SmsCheckCodeVal = $("#SmsCheckCode").val();  
        // 向后台发送处理数据  
        /*
        $.ajax({  
            url : "CustomerAction_checkCode.action",   
            data : {SmsCheckCode : SmsCheckCodeVal},   
            type : "POST",   
            dataType : "text",   
            success : function(data) {  
                data = parseInt(data, 10);  
                if (data == 1) {  
               	$("#SmsCheckCodeTip").val("验证正确");
                } else {  
                	$("#SmsCheckCode").hide();//隐藏
               	 $("#SmsCheckCodeTip").show();//隐藏 
               	$("#SmsCheckCodeTip").val("验证有误"); 
                }  
            }  
        });  
        */
    });  
});