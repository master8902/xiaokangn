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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="description" content="">
	<meta name="author" content="">
	<title>浪旅行</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/buttons.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/iscroll.js"  
    type="text/javascript"></script>   
    
<script type="text/javascript">
 var myScroll;
  function loaded() { 
 	setTimeout(function () { 
 	myScroll = new iScroll('wrapper',{ snap: true, momentum: false, hScrollbar: false, vScrollbar: false,hScroll:false}); }, 100); 
 } 
 window.addEventListener('load', loaded, false); 
 </script>
   
 </head> 
<body>





<div class="container-fluid">
	<div class="row-fluid" style="height:30%">
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
						<img alt="" src="<%=request.getContextPath()%>/images/1.jpg"/>
					</div>
					
					<div class="item">
						<img alt="" src="<%=request.getContextPath()%>/images/2.jpg"  />
					</div>
					<div class="item">
						<img alt="" src="<%=request.getContextPath()%>/images/3.jpg" />
					</div>
					 
				</div> <a class="left carousel-control" href="#carousel-58154" data-slide="prev">‹</a> <a class="right carousel-control" href="#carousel-58154" data-slide="next">›</a>
			</div>
		</div>
	</div>
	<div class="row-fluid" >
		<div class="span12">
			<div  style="height:5% ;text-align:center;margin-top:-2%;">
				<div>
					<select  id="select" name="select" onblur="jbPhone()">   
     				 	<option >周边</option>
     				 	<option value="0" >远征</option>
     				 	<option value="1">短途</option>
 					</select><input type="text" id="search" name="search" value="直接搜索目的地" onfocus="value=''" onblur=" if(!value)value='直接搜索目的地' "/>
				</div>
			</div>
		</div>
	</div>
	
	







	<div class="row-fluid">
		<div class="span12">
			<div id="wrapper" style="height:60%">
				<div>
				<s:iterator value="#request.product" id="bean" status="L">
				<!--<s:property value="#L.index+1"/>-->
					<div style="position:relative;width:100%;height:216px">				
						<img alt="" src="<%=request.getContextPath()%>/images/1.jpg" />
						<div style="width:100%;height:15%;position:absolute;bottom:0">
							<span id="price1">价格:<s:property value="#bean.price"/></span>
							<span id="xiwei1">席位:<s:property value="#bean.saleSeat"/></span>
							<span id="data1">日期:<s:property value="#bean.startDate"/></span>
							<input type="hidden" id="<s:property value="#L.index+1"/>">
						</div>
					</div>
					</s:iterator>
					<!--  
					<div style="position:relative;width:100%;height:216px">	
						<img alt="" src="<%=request.getContextPath()%>/images/2.jpg" style="margin-top:1.5%"/>
						<div style="width:100%;height:15%;position:absolute;bottom:0">
							<span id="price2">价格</span>
							<span id="xiwei2">席位</span>
							<span id="data2">日期</span>
						</div>
					</div>
					<div style="position:relative;width:100%;height:216px">
						<img alt="" src="<%=request.getContextPath()%>/images/3.jpg" style="margin-top:1.5%"/>
						<div style="width:100%;height:15%;position:absolute;bottom:0">
							<span id="price3">价格</span>
							<span id="xiwei3">席位</span>
							<span id="data3">日期</span>
						</div>
					</div>
					-->
				</div>
			</div>
		</div>
	</div>
	
	<div  style="width:93%;height:5%;position:fixed;bottom:0;text-align:center" >
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