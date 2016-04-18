//去掉前后空格  
function trim(str) {  
    var strnew = str.replace(/^\s*|\s*$/g, "");  
    return strnew;  
}  

// 手机校验
function checkjbPhone() {  
    var jbPhone = document.form1.Phone.value;  
    var re= /(^1[3|5|8][0-9]{9}$)/;  
    if (trim(jbPhone) == "") {  
        document.getElementById("jbPhoneTip").innerHTML = "<font color='red'>× 手机号码不能为空</font>";  
        return false;  
    } else if(trim(jbPhone) != ""){  
        if(!re.test(jbPhone)){  
            document.getElementById("jbPhoneTip").innerHTML = "<font color='red'>× 请输入有效的手机号码</font>";  
            return false;  
        }else{  
            document.getElementById("jbPhoneTip").innerHTML = "<font color='#339933'>√ 手机号码输入正确</font>";  
            // 向后台发送处理数据  
            $.ajax({  
                url : "CustomerAction_checkPhone.action",// 目标地址  
                data : {Phone : Phone}, // 目标参数  
                type : "POST", // 用POST方式传输  
                dataType : "text", // 数据格式:text  
                success : function(data) {  
                    data = parseInt(data, 10);  
                    if (data != 0) {  
                        $("#jbPhoneTip").html("<font color='red'>× 该手机号码已经被注册，请重新输入</font>");  
                    } else {  
                        $("#jbPhoneTip").html("<font color='#339933'>√ 该手机号码可以注册，输入正确</font>");  
                    }  
                }  
            });  
            return true;  
        }  
    }       
}  



//登录密码  
function checkpassword() {  
    var password = document.form1.password.value;  
    if (password.length < 6 || password.length > 30) {  
        document.getElementById("passwordTip").innerHTML = "<font color='red'>× 密码长度不能小于6位，大于30位</font>";  
        return false;  
    } else if (!isNaN(password)) {  
        document.getElementById("passwordTip").innerHTML = "<font color='red'>× 密码不能全是数字</font>";  
        return false;  
    } else {  
        document.getElementById("passwordTip").innerHTML = "<font color='#339933'>√ 密码合格</font>";  
        return true;  
    }  
}  

// 确认密码  
function checkpasswrodb() {  
    var password = document.form1.password.value;  
    var passwordRepeat = document.form1.passwordRepeat.value;  
    if (trim(password) != trim(passwordRepeat)) {  
        document.getElementById("passwordRepeatTip").innerHTML = "<font color='red'>× 两次密码输入必须一致</font>";  
        return false;  
    } else {  
        document.getElementById("passwordRepeatTip").innerHTML = "<font color='#339933'>√ 密码输入一致</font>";  
        return true;  
    }  
}  
