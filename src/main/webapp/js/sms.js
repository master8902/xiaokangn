var InterValObj; //timer变量，控制时间  
var count = 120; //间隔函数，1秒执行  
var curCount;//当前剩余秒数  
var code = ""; //验证码  
var codeLength = 4;//验证码长度  

function sendMessage(){  
    curCount = count;  
    var jbPhone = document.form1.Phone.value; 
    var jbPhoneTip = $("#jbPhoneTip").text();  
    if (jbPhone != "") {  
        if(jbPhoneTip == "√ 该手机号码可以注册，输入正确" || jbPhoneTip == "√ 手机号码输入正确"){  
            // 产生验证码  
            for ( var i = 0; i < codeLength; i++) {  
                code += parseInt(Math.random() * 9).toString();  
            }  
            // 设置button效果，开始计时 
            document.getElementById("btnSendCode").disabled=true;
            document.getElementById("btnSendCode").value="请在" + curCount + "秒内输入验证码";  
            InterValObj = window.setInterval(SetRemainTime, 1000); // 启动计时器，1秒执行一次  
            // 向后台发送处理数据  
        }
        else{  
            $("#jbPhoneTip").html("<font color='red'>× 手机号码不能为空</font>");  
        }  
    }
}
  
//timer处理函数  
function SetRemainTime() {  
    if (curCount == 0) {                  
        window.clearInterval(InterValObj);// 停止计时器  
        document.getElementById("btnSendCode").disabled=false;// 启用按钮  
        document.getElementById("btnSendCode").value="重新发送验证码";  
        code = ""; // 清除验证码。如果不清除，过时间后，输入收到的验证码依然有效  
    }else {  
        curCount--;  
        document.getElementById("btnSendCode").value="请在" + curCount + "秒内输入验证码"; 
    }  
}  
  
$(document).ready(function() {  
    $("#SmsCheckCode").blur(function() {  
        var SmsCheckCodeVal = $("#SmsCheckCode").val();  
        // 向后台发送处理数据  
        $.ajax({  
            url : "CustomerAction_checkCode.action",   
            data : {SmsCheckCode : SmsCheckCodeVal},   
            type : "POST",   
            dataType : "text",   
            success : function(data) {  
                data = parseInt(data, 10);  
                if (data == 1) {  
                    $("#SmsCheckCodeTip").html("<font color='#339933'>√ 短信验证码正确，请继续</font>");  
                } else {  
                    $("#SmsCheckCodeTip").html("<font color='red'>× 短信验证码有误，请核实后重新填写</font>");  
                }  
            }  
        });  
    });  
});  
