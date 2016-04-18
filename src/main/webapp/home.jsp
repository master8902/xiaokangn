<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<script type="text/javascript" src="<%=basePath %>js/jquery-1.8.3.js"></script>
<title>Insert title here</title>
<script  type="text/javascript">

function checkisNULL(value,message){
	if(value==""|value=="null"){
		alert(message);
		//$("#sub").attr("disabled",false); 
		return false;	
	}
	return true;	
} 

function check() {

var textplan3 = $.trim($("#textplan3").val());
	
	var result = checkisNULL(textplan3,"请填111");//出错提示
	if(result==false){
	//	$("#sub").attr("disabled",false); 
		return false;
	}
var textplan4 = $.trim($("#textplan4").val());
	
	var result = checkisNULL(textplan4,"请填写222");
	if(result==false){
	//	$("#sub").attr("disabled",false); 
		return false;
	}
var textplan5 =$.trim($("#textplan5").val());
	
	var result = checkisNULL(textplan5,"请填写333");
	if(result==false){
	//	$("#sub").attr("disabled",false); 
		return false;
	}
	
	
	//需要POST的值，把每个变量都通过&来联接  
var postdata   = "textplan3="+ textplan3 +"&textplan4="+ textplan4 +"&textplan5="+ textplan5;  
	
    $.ajax({
        url: '<%=basePath %>postdata/post_demo.do',
         type: 'POST',
         data: postdata,
         success: function (returndata) {      	
 				alert("上传成功");
 				//跳到新的页面 			
         },
         error: function (returndata) {
        	 alert(returndata);
         }
    });
}


</script>
</head>
<body>


<a>旅程</a>
<a> 票务</a>
<a href="<%=basePath %>user/user_info.do?userid=1"> 我的-直接返回数据</a>
<a href="<%=basePath %>user/user_info2.do?userid=1"> 我的-调到一个新的页面</a>
<a href="<%=basePath %>product/product_info2.do?ishot=1"> 我的-调到一个近期热门产品页面</a>
<a href="<%=basePath %>schedule/schedule_info2.do?productId=1"> 我的-调到一个日程安排页面</a>

<a href="<%=basePath %>pay/pay_apply.do?"> 申请调用付款</a>


<br>
<br>
<textarea id="textplan3" class="textplans" name="textplan3"></textarea>
<br>
<br>
<textarea id="textplan4" class="textplans" name="textplan4"></textarea>
<br>
<br>
<textarea id="textplan5" class="textplans" name="textplan5"></textarea>
<input type="button" onclick="check()" value="上传"/>


</body>
</html>
