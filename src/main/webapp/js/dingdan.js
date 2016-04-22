function xsphone(){
	 $("#Phone").show();//隐藏
	 $("#PhoneTip").hide();//隐藏 
}

function xsnickname(){
	 $("#nickname").show();//隐藏
	 $("#nicknameTip").hide();//隐藏 
}

function xsCredentialsCode(){
	 $("#CredentialsCode").show();//隐藏
	 $("#CredentialsCodeTip").hide();//隐藏 
}
//去掉前后空格  
function trim(str) {  
    var strnew = str.replace(/^\s*|\s*$/g, "");  
    return strnew;  
}  

// 姓名  
function checknickname() {  
    var nickname =$("#nickname").val();  
    if (trim(nickname) == "") {  
    	 $("#nickname").hide();//隐藏
    	 $("#nicknameTip").show();//隐藏 
    	 $("#nicknameTip").val("姓名不能为空"); 
        return false;  
    } else {   
        return true;  
    }  
}  

// 联系手机(ajax验证手机号码是否已经存在)  
function checkPhone() {  
    var Phone = $("#Phone").val();  
    var re= /(^1[3|5|8][0-9]{9}$)/;  
    if (trim(Phone) == "") {  
    	 $("#Phone").hide();//隐藏
    	 $("#PhoneTip").show();//隐藏 
    	$("#PhoneTip").val("手机号码不能为空"); 
        return false;  
    } else if(trim(Phone) != ""){  
        if(!re.test(Phone)){  
       	 $("#Phone").hide();//隐藏
    	 $("#PhoneTip").show();//隐藏 
    	$("#PhoneTip").val("请输入有效的手机号码"); 
            return false;  
        }else{
        	return true;  
        } 
        }  
    }  

// 证件号码  
function checkCredentialsCode() {  
    var CredentialsCode =$("#CredentialsCode").val();  
    var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;   
    if (trim(CredentialsCode) == "") {  
      	 $("#CredentialsCode").hide();//隐藏
    	 $("#CredentialsCodeTip").show();//隐藏
    	$("#CredentialsCodeTip").val("证件号码不能为空");
        return false;  
    } else if(trim(CredentialsCode) != ""){  
        if(!reg.test(CredentialsCode)){  
         	 $("#CredentialsCode").hide();//隐藏
        	 $("#CredentialsCodeTip").show();//隐藏
        	$("#CredentialsCodeTip").val("请输入合法的证件号码");
            return false;  
        }else{  
        	$("#CredentialsCodeTip").val("证件号码输入正确");
            // 向后台发送处理数据  
//            $.ajax({  
//                url : "CustomerAction_checkCredentialsCode.action",// 目标地址  
//                data : {CredentialsCode : CredentialsCode}, // 目标参数  
//                type : "POST", // 用POST方式传输  
//                dataType : "text", // 数据格式:text  
//                success : function(data) {  
//                    data = parseInt(data, 10);  
//                    if (data != 0) {  
//                        $("#CredentialsCodeTip").html("<font color='red'>× 该证件号码已经被注册，请重新输入</font>");  
//                    } else {  
//                        $("#CredentialsCodeTip").html("<font color='#339933'>√ 该证件号码可以注册，输入正确</font>");  
//                    }  
//                }  
//            });  
            return true;  
        }  
    }  
}  
