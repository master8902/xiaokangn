function trim(str) {  
    var strnew = str.replace(/^\s*|\s*$/g, "");  
    return strnew;  
}  

function checkjbPhone() {  
    var jbPhone = $("#phoneNum").val();  
    var re= /(^1[3|5|8][0-9]{9}$)/;  
    if (trim(jbPhone) == "") {  
    	 $("#phoneNum").hide();//隐藏
    	 $("#PhonelTip").show();//隐藏 
    	$("#PhonelTip").val("手机号码不能为空");
        return false;  
    } else if(trim(jbPhone) != ""){  
        if(!re.test(jbPhone)){  
        	 $("#phoneNum").hide();//隐藏
        	 $("#PhonelTip").show();//隐藏 
        	 $("#PhonelTip").val("请输入有效的手机号码");
            return false;  
        }else{   
        	$("#PhonelTip").val("手机号码输入正确");
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
//去掉前后空格  

function xsphone(){
	 $("#phoneNum").show();//隐藏
	 $("#PhonelTip").hide();//隐藏 
}