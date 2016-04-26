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
 <script src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"  
    type="text/javascript"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/dingdan.css">

 <script  type="text/javascript">
 function checkisNULL(value,message){
		if(value==""|value=="null"){
			alert(message);
			//$("#sub").attr("disabled",false); 
			return false;	
		}
		return true;	
	} 
 function pay(){
	 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  var identificationType =  $('#select option:selected').val();//选中的文本
	 var nickname = $.trim($("#nickname").val());//姓名
	 var guoji = $.trim($("#guoji").val());//姓名
	 var CredentialsCode = $.trim($("#CredentialsCode").val());//姓名
	 var lianxi = $.trim($("#lianxi").val());//姓名
	 var Phone = $.trim($("#Phone").val());//姓名
	
	
	 var productId = $.trim($("#productId").val());	
	 var userId = $.trim($("#userId").val());
	 var jiner = $.trim($("#jiner").val());
	 
	 
		var result = checkisNULL(nickname,"姓名不能为空");//出错提示
		if(result==false){
			return false;
		}		
		var result = checkisNULL(guoji,"国籍不能为空");
		if(result==false){
			return false;
		}
		var result = checkisNULL(CredentialsCode,"证件号不能为空");
		if(result==false){
			return false;
		}
		var result = checkisNULL(lianxi,"联系人不能为空");
		if(result==false){
			return false;
		}
		var result = checkisNULL(Phone,"手机号不能为空");
		if(result==false){
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
		var resultid = -1;
	    $.ajax({
	        url: '<%=basePath %>order/order_newAddOrder.do',
	         type: 'POST',
	         data: postdata,
	         success: function (returndata) { 	        	 
	        	 resultid = returndata;		
	         }
	    });
	 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	 var state = productId+"_"+userId+"_"+resultid;
	 document.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ffc728a584dc255&redirect_uri=http%3a%2f%2fwww.sharlontrip.com%2fxiaolangn%2fpay%2ftest%2fpay_callback.do&response_type=code&scope=snsapi_base&state="+"123"+"#wechat_redirect";
		
	}

 function queryOrderNotice() {
	 var productId = $.trim($("#productId").val());	
	 $.ajax({
	        url: '<%=basePath %>order/order_queryOrderById.do?productId='+productId,
	         type: 'POST',
	       
	         success: function (returndata) { 	        	
	        		 alert(returndata);	
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
				<a>请在提交前确定已阅读  </a><input id="ddxz" type="button" value="订单须知" style="color:#FF8000" onclick="queryOrderNotice();"/>
				<!--  <input align="right" id="save" type="button"  value="保存" onclick="saveOrderInfo();"/> -->
				</td>
			</tr>
            </table>  
     </form>   
     <input type="hidden" id="productId" value="${productId}"/>
     </div>
     	<div  style="width:93%;height:5%;position:fixed;bottom:0" >
		<div >
			<table id="foot">
				<tr>
					<td>
			 			<input id="ddze" type="button"  value="订单总额："/><input id="jiner" type="button" value="${request.product.price}"/><input id="qrzf" type="button" value="确认支付" onclick="pay();return false;"/>
			 		</td>
			 	</tr>
			 </table>
		</div>
		<input type="hidden" id="productId" value="${productId}"/>
		<input type="hidden" id="userId" value="${userId}"/>
	</div>                
  </body>
</html>
