//去掉前后空格  
function trim(str) {  
    var strnew = str.replace(/^\s*|\s*$/g, "");  
    return strnew;  
}  

// 姓名  
function checknickname() {  
    var nickname = document.form2.nickname.value;  
    if (trim(nickname) == "") {  
        document.getElementById("nicknameTip").innerHTML = "<font color='red'>× 姓名不能为空</font>";  
        return false;  
    } else {  
        document.getElementById("nicknameTip").innerHTML = "<font color='#339933'>√ 姓名输入正确</font>";  
        return true;  
    }  
}  

// 联系手机(ajax验证手机号码是否已经存在)  
function checkjbPhone() {  
    var jbPhone = document.form2.jbPhone.value;  
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

            };  
            return true;  
        }  
    }  

// 证件号码  
function checkjbCredentialsCode() {  
    var jbCredentialsCode = document.form2.jbCredentialsCode.value;  
    var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;   
    if (trim(jbCredentialsCode) == "") {  
        document.getElementById("jbCredentialsCodeTip").innerHTML = "<font color='red'>× 证件号码不能为空</font>";  
        return false;  
    } else if(trim(jbCredentialsCode) != ""){  
        if(!reg.test(jbCredentialsCode)){  
            document.getElementById("jbCredentialsCodeTip").innerHTML = "<font color='red'>× 请输入合法的证件号码</font>";  
            return false;  
        }else{  
            document.getElementById("jbCredentialsCodeTip").innerHTML = "<font color='#339933'>√ 证件号码输入正确</font>";  
            // 向后台发送处理数据  
            $.ajax({  
                url : "CustomerAction_checkCredentialsCode.action",// 目标地址  
                data : {jbCredentialsCode : jbCredentialsCode}, // 目标参数  
                type : "POST", // 用POST方式传输  
                dataType : "text", // 数据格式:text  
                success : function(data) {  
                    data = parseInt(data, 10);  
                    if (data != 0) {  
                        $("#jbCredentialsCodeTip").html("<font color='red'>× 该证件号码已经被注册，请重新输入</font>");  
                    } else {  
                        $("#jbCredentialsCodeTip").html("<font color='#339933'>√ 该证件号码可以注册，输入正确</font>");  
                    }  
                }  
            });  
            return true;  
        }  
    }  
}  
