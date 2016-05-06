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
   
   function clickimage(obj){
	   var id = obj.id;
	   var productId = $.trim($("#productId").val());	
	   window.location.href="<%=basePath%>schedule/schedule_showdetail.do?scheduleId="+id+"&productId="+productId;
	   
   }
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
<div class="row-fluid" id="row-fluid" style="height:38%">
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
				
				
				<s:iterator value="#request.schedule" id="schedulebean1" status="La">
				<s:if test="#La.index==0">
				<div class="item active">
						<img alt="" src="<%=request.getContextPath()%><s:property value="#schedulebean1.picture_url"/>"/>  
					</div>	
				</s:if>
				<s:elseif test="#La.index<3">
				 <div class="item">
						<img alt="" src="<%=request.getContextPath()%><s:property value="#schedulebean1.picture_url"/>"  />
					</div>
				 </s:elseif>
				</s:iterator>				
				</div> <a class="left carousel-control" href="#carousel-58154" data-slide="prev">?</a> <a class="right carousel-control" href="#carousel-58154" data-slide="next">?</a>
					</div>
			</div>
		</div>
	</div>
	<div style="height:7%;width:100%">
		<span id="lxmc">旅行名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<span id="databegin">初始</span>
		<span id="hx">—</span>
		<span id="datafinish">结束</span>
		<span id="price">价格</span>
		<span id="shoucang">收藏</span>
		<input style="float:right" type="image" src="<%=request.getContextPath()%>/images/collection.png" />
	</div>
	<div id="box" class="row-fluid" style="height:50%;">
		<div class="span12">
			<div id="wrapper1" style="height:100%;">
				<div>
					<div>
					<s:iterator value="#request.schedule" id="schedulebean" status="La">
     					 <div style="float:left;height:40%;width:25%;padding-top:5%;border-right: 3px solid #ff8800; ">
     					<span style="float:left;font-family:Microsoft YaHei;font-size:1em;margin-left:20%;">Day</span>
     					<span style="float:left;" id="datanum"><s:property value="#schedulebean.day"/>
     					</span>
     					<span style="float:left;font-family:Microsoft YaHei;font-size:0.9em;margin-left:12%;">行程安排</span>
     					</div>
      					<div  style="height:40%; width:75%;float:left;font-family:Microsoft YaHei;font-size:0.9em;padding-top:10%;padding-left:5%;">
      					<span><s:property value="#schedulebean.content"/></span>
      					<span style="float:left;font-family:Microsoft YaHei;font-size:0.9em;margin-top:5%;">
      					<a id="<s:property value="#schedulebean.scheduleId"/>"  href="javascript:void(0)" onclick="clickimage(this)">
      					行程详情
      					</a>
      					</span>
      					</div>
      				</s:iterator>      			
					</div>
					<div style="float:none">
					<span>费用包含<br></br></span>
					<span>
						<s:property value="#request.product.costContain"/>
						</span>
					</div>
					<div style="margin-top:5%;float:none">
					<span>费用不包含<br></br></span>
					<span><s:property value="#request.product.costUncomtain"/></span>
					</div>
					<div style="margin-top:5%;float:none">
					<span>费用不包含<br></br></span>
					<span><s:property value="#request.product.groupRule"/></span>
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
</div>

<input type="hidden" id="productId" value="${productId}"/>
</body>
</html>