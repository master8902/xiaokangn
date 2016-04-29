<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>小浪旅行</title>
    
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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/project.css">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/iscroll.js"  
    type="text/javascript"></script>  
<script type="text/javascript">
 var myScroll;
  function loaded() { 
 	setTimeout(function () { 
 	myScroll = new iScroll('wrapper1',{ snap: true, momentum: false, hScrollbar: false, vScrollbar: false,hScroll:false}); }, 100); 
 } 
 window.addEventListener('load', loaded, false); 
 
  function login(){
	  var productId = $.trim($("#productId").val());	
		document.location.href="<%=basePath %>user/user_showlogin.do?productId="+productId;
	} 
 </script>
   <script type="text/javascript">
          $(function() {
              var startX, startY, endX, endY;
             var showADID = 1;
            document.getElementById("carousel-58154").addEventListener("touchstart", touchStart, false);
            document.getElementById("carousel-58154").addEventListener("touchmove", touchMove, false);
            document.getElementById("carousel-58154").addEventListener("touchend", touchEnd, false);
             function touchStart(event) {
                 var touch = event.touches[0];
                 startY = touch.pageY;
                 startX = touch.pageX;
            }
             function touchMove(event) {
            	// alert("aaaaaa");
				document.getElementById("row-fluid").style.display="none";//隐藏
				document.getElementById("box").style.height="80%";
             }
             function touchEnd(event){
             }

         })
</script>
</head>
<body>
<div class="container-fluid">
<div class="row-fluid" id="row-fluid" style="height:35%">
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
						<img alt="" src="<%=request.getContextPath()%>/images/4.jpg"/>
					</div>
					<div class="item">
						<img alt="" src="<%=request.getContextPath()%>/images/5.jpg"  />
					</div>
					<div class="item">
						<img alt="" src="<%=request.getContextPath()%>/images/6.jpg"/>
					</div>
				</div> <a class="left carousel-control" href="#carousel-58154" data-slide="prev">‹</a> <a class="right carousel-control" href="#carousel-58154" data-slide="next">›</a>
					</div>
			</div>
		</div>
	</div>
	<div>
	<span>旅行名称</span> <span>日期</span>
	<span>价格</span>
	<input type="image" src="<%=request.getContextPath()%>/images/collection.png" style="width:5%;height:5%"/>
	<span>收藏</span>
	</div>
	<div id="box" class="row-fluid" style="height:60%;">
		<div class="span12">
			<div id="wrapper1" style="height:100%;">
				<div>
					<div>
     					<div style="float:left;height:20%;width:20%;background-color:#F36;"><span>Day</span><span id="datanum">1</span>
     					<span>行程安排</span>
     					</div>
      					<div  style="background-color:#F60;height:20%; width:80%;float:left">
      					<span>行程安排行程安排行程安排行程安排行程安排行程安排行程安排行程安排行程安排</span>
      					<span>行程详情</span>
      					</div>
     					<div style="float:left;height:20%;width:20%;background-color:#F36;"><span>Day</span><span id="datanum">1</span>
     					<span>行程安排</span>
     					</div>
      					<div style="background-color:#F60;height:20%; width:80%;float:left">
      					<span>行程安排行程安排行程安排行程安排行程安排行程安排行程安排行程安排行程安排</span>
      					<span>行程详情</span>
      					</div>
      					<div style="float:left;height:20%;width:20%;background-color:#F36;"><span>Day</span><span id="datanum">1</span>
     					<span>行程安排</span>
     					</div>
      					<div  style="background-color:#F60;height:20%; width:80%;float:left">
      					<span>行程安排行程安排行程安排行程安排行程安排行程安排行程安排行程安排行程安排</span>
      					<span>行程详情</span>
      					</div>
      					<div style="float:left;height:20%;width:20%;background-color:#F36;"><span>Day</span><span id="datanum">1</span>
     					<span>行程安排</span>
     					</div>
      					<div  style="background-color:#F60;height:20%; width:80%;float:left">
      					<span>行程安排行程安排行程安排行程安排行程安排行程安排行程安排行程安排行程安排</span>
      					<span>行程详情</span>
      					</div>
      					<div style="float:left;height:20%;width:20%;background-color:#F36;"><span>Day</span><span id="datanum">1</span>
     					<span>行程安排</span>
     					</div>
      					<div  style="background-color:#F60;height:20%; width:80%;float:left">
      					<span>行程安排行程安排行程安排行程安排行程安排行程安排行程安排行程安排行程安排</span>
      					<span>行程详情</span>
      					</div>	
					</div>
					<div >费用包含</div>
					<span>1、一些说明与注意事项</span>
					<span>2、一些说明与注意事项</span>
					<span>3、一些说明与注意事项</span>
					<span>4、一些说明与注意事项</span>
					<span>5、一些说明与注意事项</span>
					<div>费用不包含</div>
					<span>1、一些说明与注意事项</span>
					<span>2、一些说明与注意事项</span>
					<span>3、一些说明与注意事项</span>
					<span>4、一些说明与注意事项</span>
					<span>5、一些说明与注意事项</span>
					<div>开团规则</div>
					<span>1、一些说明与注意事项</span>
					<span>2、一些说明与注意事项</span>
					<span>3、一些说明与注意事项</span>
					<span>4、一些说明与注意事项</span>
					<span>5、一些说明与注意事项</span>
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
</div>

<input type="hidden" id="productId" value="${productId}"/>
</body>
</html>