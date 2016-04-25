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


	wx.config({
    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    appId: "<%=request.getAttribute("appId")%>", // 必填，公众号的唯一标识
    timestamp: <%=request.getAttribute("timeStamp")%>, // 必填，生成签名的时间戳
    nonceStr: "<%=request.getAttribute("nonceStr")%>", // 必填，生成签名的随机串
    signature: "<%=request.getAttribute("paySign")%>",// 必填，签名，见附录1
    jsApiList: ['chooseWXPay'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
});
	wx.ready(function(){
		
	    // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
	});
	wx.error(function(res){
	    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
	});

	function pay(){
	wx.chooseWXPay({
    timestamp: <%=request.getAttribute("timeStamp")%>, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
    nonceStr: "<%=request.getAttribute("nonceStr")%>", // 支付签名随机串，不长于 32 位
    package: "<%=request.getAttribute("package")%>", // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
    signType: "<%=request.getAttribute("signType")%>", // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
    paySign: "<%=request.getAttribute("paySign")%>", // 支付签名
    success: function (res) {
        // 支付成功后的回调函数
        alert("支付成功");
    },
    error:function(res){
     alert("失败"+"res");
    }
});
}

	</script>
</head>

<body>
	<div class="index_box">
		<div class="apply_name">微信js支付测试</div>

		<div class="branch_con">
			<ul>
				<li><span class="name">测试支付信息</span></li>
			</ul>
			<p class="cz_btn"><a href="javascript:pay();" class="btn_1">立即支付</a></p>
		</div>
	</div>


</body>
</html>