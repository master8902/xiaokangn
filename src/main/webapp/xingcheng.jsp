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
 </script>
  <body>
<div id="top">
<input type="image" src="<%=request.getContextPath()%>/images/back.png"></input>
<span>行程详情</span>
</div>
<div id="wrapper2" style="height:85%;">
<div class="row-fluid" id="row-fluid" style="height:100%">
		<div class="span12">
			<div class="carousel slide" id="carousel-58154">
				<ol class="carousel-indicators">
					<li class="active" data-target="#carousel-58154" data-slide-to="0">
					</li>
					<li data-target="#carousel-58154" data-slide-to="1">
					</li>
					<li data-target="#carousel-58154" data-slide-to="2">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<span>Day</span><span id="dtanum">1</span><span>抵达爱丁堡</span>
						<img alt="" src="<%=request.getContextPath()%>/images/4.jpg"/>
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
						<img alt="" src="<%=request.getContextPath()%>/images/4.jpg"/>
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
					</div>
					<div class="item">
						<span>Day</span><span id="dtanum">2</span><span>抵达爱丁堡</span>
						<img alt="" src="<%=request.getContextPath()%>/images/5.jpg"  />
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
						<img alt="" src="<%=request.getContextPath()%>/images/5.jpg"  />
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
					</div>
					<div class="item">
						<span>Day</span><span id="dtanum">3</span><span>抵达爱丁堡</span>
						<img alt="" src="<%=request.getContextPath()%>/images/6.jpg"/>
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
						<img alt="" src="<%=request.getContextPath()%>/images/6.jpg"/>
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
					</div>
					<div class="item">
						<span>Day</span><span id="dtanum">4</span><span>抵达爱丁堡</span>
						<img alt="" src="<%=request.getContextPath()%>/images/4.jpg"/>
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
						<img alt="" src="<%=request.getContextPath()%>/images/4.jpg"/>
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
					</div>
					<div class="item">
						<span>Day</span><span id="dtanum">5</span><span>抵达爱丁堡</span>
						<img alt="" src="<%=request.getContextPath()%>/images/5.jpg"/>
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
						<img alt="" src="<%=request.getContextPath()%>/images/4.jpg"/>
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
					</div>
					<div class="item">
						<span>Day</span><span id="dtanum">6</span><span>抵达爱丁堡</span>
						<img alt="" src="<%=request.getContextPath()%>/images/6.jpg"/>
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
						<img alt="" src="<%=request.getContextPath()%>/images/6.jpg"/>
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
					</div>
					<div class="item">
						<span>Day</span><span id="dtanum">7</span><span>抵达爱丁堡</span>
						<img alt="" src="<%=request.getContextPath()%>/images/4.jpg"/>
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
						<img alt="" src="<%=request.getContextPath()%>/images/6.jpg"/>
						<span>文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍文字介绍</span>
					</div>
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
  </body>
</html>
