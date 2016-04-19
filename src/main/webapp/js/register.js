//去掉前后空格  
function trim(str) {  
    var strnew = str.replace(/^\s*|\s*$/g, "");  
    return strnew;  
}  
function xsphone(){
	 $("#Phone").show();//隐藏
	 $("#PhoneTip").hide();//隐藏 
}
function xspassword(){
	 $("#password").show();//隐藏
	 $("#passwordTip").hide();//隐藏 
}
function xspasswordb(){
	 $("#passwordRepeat").show();//隐藏
	 $("#passwordRepeatTip").hide();//隐藏 
}
// 手机校验
function checkjbPhone() {  
    var jbPhone = $("#Phone").val();  
    var re= /(^1[3|5|8][0-9]{9}$)/;  
    if (trim(jbPhone) == "") {  
    	 $("#Phone").hide();//隐藏
    	 $("#PhoneTip").show();//隐藏 
    	$("#PhoneTip").val("手机号码不能为空");
        return false;  
    } else if(trim(jbPhone) != ""){  
        if(!re.test(jbPhone)){  
        	 $("#Phone").hide();//隐藏
        	 $("#PhoneTip").show();//隐藏 
        	 $("#PhoneTip").val("请输入有效的手机号码");
            return false;  
        }else{   
        	$("#PhoneTip").val("手机号码输入正确");
            // 向后台发送处理数据  
//            $.ajax({  
//                url : "CustomerAction_checkPhone.action",// 目标地址  
//                data : {Phone : Phone}, // 目标参数  
//                type : "POST", // 用POST方式传输  
//                dataType : "text", // 数据格式:text  
//                success : function(data) {  
//                    data = parseInt(data, 10);  
//                    if (data != 0) {  
//                   	 $("#Phone").hide();//隐藏
//                	 $("#PhoneTip").show();//隐藏 
//                	 $("#PhoneTip").val("该手机号已经被注册");
//                    } else {   
//                    	$("#PhoneTip").val("该手机号码可以注册，输入正确");
//                    }  
//                }  
//            });  
            return true;  
        }  
    }       
}  



//登录密码  
function checkpassword() {  
    var password = $("#password").val();  
    if (password.length < 6 || password.length > 30) { 
   	 $("#password").hide();//隐藏
	 $("#passwordTip").show();//隐藏 
	$("#passwordTip").val("不能小于6位大于30位");
        return false;  
    } else if (!isNaN(password)) { 
    	 $("#password").hide();//隐藏
    	 $("#passwordTip").show();//隐藏 
    	$("#passwordTip").val("密码不能全是数字");
        return false;  
    } else {    
        return true;  
    }  
}  

// 确认密码  
function checkpasswrodb() {  
    var password = $("#password").val();  
    var passwordRepeat =  $("#passwordRepeat").val(); 
    if (trim(password) != trim(passwordRepeat)) {  
   	 $("#passwordRepeat").hide();//隐藏
	 $("#passwordRepeatTip").show();//隐藏 
	$("#passwordRepeatTip").val("密码必须一致");
        return false;  
    } else {  
        return true;  
    }  
}  
