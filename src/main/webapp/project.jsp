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
    
    <title>My JSP 'project.jsp' starting page</title>
    
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
		document.location.href="<%=basePath %>user/user_showlogin.do";
	} 
 </script>
 
 
</head>
<body>
<div class="container-fluid">
<div class="row-fluid" style="height:37%">
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
						<img alt="" src="<%=request.getContextPath()%>/images/6.jpg" />
					</div>
				</div> <a class="left carousel-control" href="#carousel-58154" data-slide="prev">‹</a> <a class="right carousel-control" href="#carousel-58154" data-slide="next">›</a>
					<div style="position:relative;width:100%;margin-top:-65%">	
						<div style="width:100%;height:15%;position:absolute;bottom:-20">
							<span id="day">Day</span>
							<span id="daynum">1</span>
							<span id="neirong">交通：自行搭乘交通工具，前往小浪&Galantrip集合地点
							餐饮：推荐早午晚餐，费用自理
							唐克乡是四川省阿坝藏族羌族自治州若尔盖县辖乡。唐克是个新兴的旅游区。位于若尔盖县西南部，距若尔盖县城64公里。
							</span>
						</div>
						<div style="width:100%;height:15%;position:absolute;bottom:0">
							<span id="data1">初始</span>
							<span id="data2">结束</span>
							</div>
					</div>
			</div>
		</div>
	</div>
<div class="row-fluid" >
		<div class="span12">
			<div id="zhuyi" style="height:25% ;margin-top:0%;">
				<div>
				<div style="position:relative;width:100%;height:95%">
				<p>一些注意事项</p>
				<div style="width:100%;height:15%;position:absolute;bottom:0">
						    <span id="xiwei1">已售</span>
							<span id="xiwei2">剩余</span>
				</div>
				</div>
				</div>
			</div>
		</div>
	</div>
<div class="row-fluid" >
		<div class="span12">
			<div id="shuoming" style="height:25% ;margin-top:2%;">
				<div>
				<div style="position:relative;width:100%;height:95%">	
					<p>开团规则说明</p>
				</div>
				</div>
			</div>
		</div>
	</div>
<div class="row-fluid" >
		<div class="span12">
			<div  style="height:5% ;margin-top:2%;">
				<div>
			 			<input id="baoming" type="button" value="我要报名" onclick="login()"/><input id="shoucang" type="button" value="收藏"/>
				</div>
			</div>
		</div>
	</div>
<div style="width:93%;height:5%;position:fixed;bottom:0;text-align:center" >
		<div  style="text-align:cneter">
			<table id="foot">
				<tr>
					<td>
			 			<input id="lvchen" type="button" value="旅程"/><input id="piaowu" type="button" value="票务"/><input id="wo" type="button" value="我"/>
			 		</td>
			 	</tr>
			 </table>
		</div>
	</div>
</div>
</body>
</html>