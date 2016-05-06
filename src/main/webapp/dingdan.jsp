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
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1.0,user-scalable=no" />
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

    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"  
    type="text/javascript"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/dingdan.css">
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
 <script  type="text/javascript">
 function show(){
	 $("#setphonenum").val($.trim($("#Phone").val())) ;	
	
	 $('#myModal').modal({
		  keyboard: false
		});
		
		 var Height=document.getElementById("myModal").style.height;
	 document.getElementById("myModal").style.top = (document.body.scrollHeight-document.body.scrollHeight*0.6)+'px';
 }
 
 function checkisNULL(value,message){
		if(value==""|value=="null"){
			alert(message);
			//$("#sub").attr("disabled",false); 
			return false;	
		}
		return true;	
	} 
 function pay(){
	 $('#myModal').modal('hide');
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
	+"&CredentialsCode="+ CredentialsCode +"&nickname=" +nickname +"&guoji=" + guoji
	+ "&phoneNum=" + Phone + "&jiner=" + jiner + "&lianxi=" + lianxi+ "&productId=" + productId+"&userId=" + userId;  
		var resultid = -1;
	    $.ajax({
	        url: '<%=basePath %>order/order_newAddOrder.do',
	         type: 'POST',
	         data: postdata,
	         success: function (returndata) { 	        	 
	        	 resultid = returndata;	
	        	 var state = productId+"a"+userId+"a"+resultid;
	        	 document.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9ffc728a584dc255&redirect_uri=http%3a%2f%2fwww.sharlontrip.com%2fxiaolangn%2fpay%2ftest%2fpay_callback.do&response_type=code&scope=snsapi_base&state="+state+"#wechat_redirect";
	        		
	         }
	    });
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
 

	$(document).ready(function(){
		$('#myModal').modal('hide');
		if("<%=request.getAttribute("identificationType")%>"=="护照"){
			document.getElementById("select")[1].selected=true;
		}
		
		if("<%=request.getAttribute("topay")%>"=="1"){
			paywx();
		}
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
			    	//   $('#hiddeninput').show();
			           if(res.err_msg == "get_brand_wcpay_request:ok" ) {
			        	 //  alert("支付成功");
			        	   $("#hiddeninput").val("支付成功"); 
			           }     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
			           else if(res.err_msg == "get_brand_wcpay_request:cancel" ) {
			        	  // alert("支付取消");
			        	   $("#hiddeninput").val("支付取消"); 
			           }
			           else if(res.err_msg == "get_brand_wcpay_request:fail" ) {
			        	 //  alert("支付失败");
			        	   $("#hiddeninput").val("支付失败"); 
			           }		          
			       }
			   ); 
			}
			
		
	function paywx(){
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

  <body>
  <div class="page-container" id="page-container">
   <form  id="form2"  method="post">  
       <table style="width:100%;"> 
       <tr>
      	 <td style="font-size:1.2em;font-weight:600;font-family:Microsoft YaHei;color:#ff8800">
      	${request.product.title}
       	</td>
       </tr>
       <tr>
       <tr>
      	 <td style="font-size:0.9em;font-family:Microsoft YaHei">
      	${request.product.startDate}-${request.product.endDate}
       	</td>
       </tr>
        <tr>
      	 <td style="font-size:1.2em">
      	 
       	</td>
       </tr>
       <tr>
       <tr>
      	 <td style="font-size:0.9em;font-family:Microsoft YaHei">
      	 出游人信息
       	</td>
       </tr>
       <tr>
        	<td align="left" width="100%" style="font-size:0.9em;font-family:Microsoft YaHei;">证件类型
        	<select style="text-align:center;" id="select" name="select" >   
      		<option value="0" >身份证</option>
      		<option value="1">护照</option>
  			</select>
  			</td>
		</tr> 
  		 <tr>  
            <td align="left" width="100%" style="font-size:0.9em;font-family:Microsoft YaHei;font-weight:500">姓名</td>  
		</tr>
		<tr>
			<td align="center" >  
             <input type="text" name="nickname" id="nickname"  onblur="checknickname()" value="${realName}"/>  
             <input type="text" id="nicknameTip" style="display:none;" onfocus="xsnickname()"/>
            </td>  
		</tr>
		<tr>
        	<td align="left" width="100%" style="font-size:0.9em;font-family:Microsoft YaHei;font-weight:500">国籍</td> 
        </tr>
        <tr>
        	<td align="center" width="100%">  
             <input type="text" name="" id="guoji"  onblur="" value="${nationality}"/>  
             </td>
		</tr>
  		<tr>
             <td align="left" width="100%" style="font-size:0.9em;font-family:Microsoft YaHei;font-weight:500">证件号</td>  
        </tr>
        <tr>
             <td >  
                 <input type="text" name="CredentialsCode" id="CredentialsCode" onblur="checkCredentialsCode()" value="${identificationNumber}"/>
                 <input type="text" id="CredentialsCodeTip" style="display:none;" onfocus="xsCredentialsCode()"/>  
             </td>
        </tr>
        <tr>
        	<td align="left" width="100%" style="font-size:0.9em;font-family:Microsoft YaHei;font-weight:500">联系人</td> 
        </tr>
        <tr>
        	<td align="center" width="100%">  
             <input type="text" name="" id="lianxi"  onblur="" value="${contacts}"/>  
             </td>
		</tr>
        <tr>
			<td align="left" width="100%" style="font-size:0.9em;font-family:Microsoft YaHei;font-weight:500">手机号</td>
			</tr>
       		 <tr>
			 <td align="center" width="100%">
				<input type="text" id="Phone" name="jbPhone"  onblur="checkPhone()" value="${phoneNum}"/>
				<input type="text" id="PhoneTip" style="display:none;" onfocus="xsphone()"/>
     		 </td>  		
			</tr>
			<tr>
				<td>
				<a style="font-size:0.9em;font-family:Microsoft YaHei">请在提交前确定已阅读  </a><input id="ddxz" type="button" value="订单须知" style="font-size:0.9em;font-family:Microsoft YaHei;color:#FF8000;background:#fafafa;border:#fafafa;" onclick="queryOrderNotice();"/>
				<!--  <input align="right" id="save" type="button"  value="保存" onclick="saveOrderInfo();"/> -->
				</td>
			</tr>
            </table>  
     </form>
     
      <div  style="width:100%;height:7%;position:fixed;bottom:0" >
		<div >
			<table id="foot">
				<tr>
					<td width="30%">
			 			<input id="ddze" type="button"  value="订单总额："/>
			 		</td >
			 		<td width="30%">
			 			<input id="jiner" type="button" value="${request.product.price}"/>
			 		</td >
			 		<td width="40%" >
			 		<!--  	<input id="qrzf" type="button"  value="确认支付" onclick="paypre();return false;"/> 
			 		-->
			 		<button id="qrzf" class="qrzf" type="button" data-toggle="modal" onclick="show()">
  						确认支付
					</button>
			 		</td>

			 		</td>
			 	</tr>
			 </table>
		</div>
		<input type="hidden" id="productId" value="${productId}"/>
		<input type="hidden" id="userId" value="${userId}"/>
	</div>  
 </div>        
      		<!-- Modal -->
<div class="modal fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header" id="tianxiedingdan">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel" style="color:#ff8800">订单填写</h4>
      </div>
      <div class="modal-footer" id="dingdanxinxi">
      <span>
      <div style="float:left;">订单信息</div>  
      <div style="float:left;"> ：${request.product.title}</div> 
      </span>      	
      </div>
      
       <div class="modal-footer" id="shoujihao">
         <div style="float:left;">手机号码</div> 
         <div style="float:left;"> ：<input value="" id="setphonenum" readonly="readonly" style='border-left:0px;border-top:0px;border-right:0px;border-bottom:1px '/></div>  
      </div>
      
       <div class="modal-footer" id="zhifufangshi">
        <div style="float:left;">支付方式</div>
         <div style="float:right;">微信支付></div>
      </div>
        <div class="modal-footer" >
        <div style="float:left;">支付金额</div>
         <div style="float:right;">${request.product.price}元</div>
      </div>     
      <div class="modal-footer" id="qrzf3">
		<button class="qrzf2" type="button" id="querenzhifu" onclick="pay()">
       <font size="4">确认支付 </font>
      </button>
      </div>
    </div>
  </div>
</div>               
  </body>
</html>
