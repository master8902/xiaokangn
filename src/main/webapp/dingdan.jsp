<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<title>订单填写</title>
  </head>
  <script src="<%=request.getContextPath()%>/js/jquery.min.js"  
    type="text/javascript"></script>
 <script src="<%=request.getContextPath()%>/js/dingdan.js"  
    type="text/javascript"></script>  
 <script src="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"  
    type="text/javascript"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/dingdan.css">

 <script  type="text/javascript">
 function pay11(){
		document.location.href="<%=basePath %>pay/test/pay_show.do";
	}
 function saveOrderInfo() {
	
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
	
var  myselect=document.getElementById("select"); //拿到select对象
var index = myselect.selectedIndex ; //拿到选中项的索引
var identificationType = myselect.options[index].text; //拿到选中项options的text
var productId = $.trim($("#productId").val());	
	//需要POST的值(前台到后台)，把每个变量都通过&来联接  
var postdata   = "identificationType="+ identificationType 
+"&CredentialsCode"+ CredentialsCode +"&nickname" +nickname +"&guoji" + guoji
+ "&Phone" + Phone + "&jiner" + jiner + "&lianxi" + lianxi+ "&productId" + productId;  
	
    $.ajax({
        url: '<%=basePath %>order/order_newAddOrder.do',
         type: 'POST',
         data: postdata,
         success: function (returndata) { 
        	 if(returndata=="success"){
        		 alert("保存成功");
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

  <body>
  <div class="page-container">
   <form  id="form2"  method="post">  
       <table style="width:100%;"> 
       <tr>
      	 <td style="font-size:1.2em">
      	${request.product.title}
       	</td>
       </tr>
       <tr>
       <tr>
      	 <td style="font-size:1.2em">
      	${request.product.startDate}
       	</td>
       </tr>
        <tr>
      	 <td style="font-size:1.2em">
       
       	</td>
       </tr>
       <tr>
       <tr>
      	 <td style="font-size:1.2em">
      	 出游人信息
       	</td>
       </tr>
       <tr>
        	<td align="left" width="100%">证件类型
        	<select style="text-align:center;" id="select" name="select" >   
      		<option value="0" >身份证</option>
      		<option value="1">护照</option>
  			</select>
  			</td>
		</tr> 
  		 <tr>  
            <td align="left" width="100%">姓名</td>  
		</tr>
		<tr>
			<td align="center" >  
             <input type="text" name="nickname" id="nickname"  onblur="checknickname()"/>  
             <input type="text" id="nicknameTip" style="display:none;" onfocus="xsnickname()"/>
            </td>  
		</tr>
		<tr>
        	<td align="left" width="100%">国籍</td> 
        </tr>
        <tr>
        	<td align="center" width="100%">  
             <input type="text" name="" id="guoji"  onblur=""/>  
             </td>
		</tr>
  		<tr>
             <td align="left" width="100%">证件号</td>  
        </tr>
        <tr>
             <td >  
                 <input type="text" name="CredentialsCode" id="CredentialsCode" onblur="checkCredentialsCode()"/>
                 <input type="text" id="CredentialsCodeTip" style="display:none;" onfocus="xsCredentialsCode()"/>  
             </td>
        </tr>
        <tr>
        	<td align="left" width="100%">联系人</td> 
        </tr>
        <tr>
        	<td align="center" width="100%">  
             <input type="text" name="" id="lianxi"  onblur=""/>  
             </td>
		</tr>
        <tr>
			<td align="left" width="100%">手机号</td>
			</tr>
       		 <tr>
			 <td align="center" width="100%">
				<input type="text" id="Phone" name="jbPhone"  onblur="checkPhone()"/>
				<input type="text" id="PhoneTip" style="display:none;" onfocus="xsphone()"/>
     		 </td>  		
			</tr>
			<tr>
				<td>
				<input id="check" type="checkbox"><a>我已阅读订单须知</a><input align="right" id="save" type="button"  value="保存" onclick="saveOrderInfo();"/>
				</td>
			</tr>
            </table>  
     </form>   
     </div>
     	<div  style="width:93%;height:5%;position:fixed;bottom:0" >
		<div >
			<table id="foot">
				<tr>
					<td>
			 			<input id="ddze" type="button"  value="订单总额："/><input id="jiner" type="button" value="${request.product.price}"/><input id="qrzf" type="button" value="确认支付" onclick="pay11();return false;"/>
			 		</td>
			 	</tr>
			 </table>
		</div>
		<input type="hidden" id="productId" value="${productId}"/>
	</div>                
  </body>
</html>
