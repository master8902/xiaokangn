<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<title>支付</title>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

	<script type="text/javascript">

	$(document).ready(function(){ 
	pay();
		}); 

	 wx.config({
	        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	        appId: "<%=request.getAttribute("appId")%>", // 必填，公众号的唯一标识
	        timestamp: "<%=request.getAttribute("timeStamp")%>", // 必填，生成签名的时间戳
	        nonceStr: "<%=request.getAttribute("nonceStr")%>", // 必填，生成签名的随机串
	        signature: "<%=request.getAttribute("paySign")%>", // 必填，签名，见附录1
	        jsApiList: ['chooseWXPay'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	    });
	
	function onBridgeReady(){
		   WeixinJSBridge.invoke(
		       'getBrandWCPayRequest', {
		    	   "appId": "<%=request.getAttribute("appId")%>",     //公众号名称，由商户传入    
		    	   "timeStamp": "<%=request.getAttribute("timeStamp")%>", // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
		    	    "nonceStr": "<%=request.getAttribute("nonceStr")%>", // 支付签名随机串，不长于 32 位
		    	    "package": "<%=request.getAttribute("package")%>", // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
		    	    "signType": "<%=request.getAttribute("signType")%>", // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
		    	    "paySign": "<%=request.getAttribute("paySign")%>", // 支付签名
		       },
		       function(res){     
		           if(res.err_msg == "get_brand_wcpay_request:ok" ) {
		        	   alert("支付成功");
		           }     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
		           else if(res.err_msg == "get_brand_wcpay_request:cancel" ) {
		        	   alert("支付取消");
		           }
		           else if(res.err_msg == "get_brand_wcpay_request:fail" ) {
		        	   alert("支付失败");
		           }		          
		       }
		   ); 
		}
		
	
function pay(){
	if (typeof WeixinJSBridge == "undefined"){
		   if( document.addEventListener ){
		       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
		   }else if (document.attachEvent){
		       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
		       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
		   }
		}else{
		   onBridgeReady();
		}
}
	</script>
</head>

<body>
	<div class="index_box">
		<div class="apply_name">商品</div>

		<div class="branch_con">
			<ul>
				<li><span class="name">日本三日游</span></li>
			</ul>
			<p class="cz_btn">
			支付状态
			<!--  
			<a href="javascript:pay();" class="btn_1">立即支付</a>
			-->
			</p>
		</div>
	</div>


</body>
</html>