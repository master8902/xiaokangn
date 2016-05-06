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
    
    <title>行程详情</title>
    
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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/xingcheng.css">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
  </head>
 <script src="<%=request.getContextPath()%>/js/iscroll.js"  
    type="text/javascript"></script> 
  <script type="text/javascript">
 var myScroll;
  function loaded() { 
 	setTimeout(function () { 
 	myScroll = new iScroll('wrapper2',{ snap: true, momentum: false, hScrollbar: false, vScrollbar: false,hScroll:true}); }, 100); 
 } 
 window.addEventListener('load', loaded, false); 
 
 function login(){
	  var productId = $.trim($("#productId").val());	
		document.location.href="<%=basePath %>user/user_showlogin.do?productId="+productId;
	} 
 
 function clickback(){
	 var productId = $.trim($("#productId").val());	
	   window.location.href="<%=basePath%>schedule/schedule_info2.do?productId="+productId;
	   
 }
 </script>
  <body>
<div id="top">
<img  src="<%=request.getContextPath()%>/images/back.png" onclick="clickback()"></img>
<span >行程详情</span>
</div>
<div id="wrapper2" style="height:85%;">
<div class="row-fluid" id="row-fluid" style="height:100%">
		<div class="span12">
			<div class="carousel slide" id="carousel-58154">
				<ol class="carousel-indicators">
				
				<s:iterator value="#request.schedule" id="schedulebean" status="La">
				<s:if test="#La.index==0">
					<li class="active" data-target="#carousel-58154" data-slide-to="0">
					</li>
					
					</s:if>
					<s:else>
					<li data-target="#carousel-58154" data-slide-to="<s:property value="#La.index"/>">
					</li>
					
					 </s:else>
				</s:iterator>  
				
				</ol>
				<div class="carousel-inner">
				
				<s:iterator value="#request.schedule" id="schedulebean" status="La">
				<s:if test="#La.index==0">
					<div class="item active">
						<span>Day</span><span id="dtanum"><s:property value="#schedulebean.day"/></span><br/><span><s:property value="#schedulebean.scheduleName"/></span>
						<img alt="" src="<%=request.getContextPath()%><s:property value="#schedulebean.picture_url"/>"/>
						<span><s:property value="#schedulebean.scheduleDetails"/></span>
						<!--  
						<img alt="" src="<%=request.getContextPath()%>/images/4.jpg"/>
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
						-->
					</div>
					</s:if>
					<s:else>
				 <div class="item">
						<span>Day</span><span id="dtanum"><s:property value="#schedulebean.day"/></span><br/><span><s:property value="#schedulebean.scheduleName"/></span>
						<img alt="" src="<%=request.getContextPath()%><s:property value="#schedulebean.picture_url"/>"/>
						<span><s:property value="#schedulebean.scheduleDetails"/></span>
						<!--  
						<img alt="" src="<%=request.getContextPath()%>/images/4.jpg"/>
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
						-->
					</div>
				 </s:else>
				</s:iterator>      			
				</div> <a class="left carousel-control" href="#carousel-58154" data-slide="prev">‹</a> <a class="right carousel-control" href="#carousel-58154" data-slide="next">›</a>
					</div>
			</div>
		</div>
	</div>
</div>
	<div class="row-fluid" >
		<div class="span12">
			<div  style="height:5%;">
				<div>
			 		<input id="baoming" type="button" value="我要报名" onclick="login()"/>
				</div>
			</div>
		</div>
	</div>
	
	<input type="hidden" id="productId" value="${productId}"/>
  </body>
</html>
