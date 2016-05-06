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
    
	<title>小浪旅行</title>
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
	<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min1.css">
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
 
 
  function search(){
	  var search = $.trim($("#search").val());
	  if(search==""){
		  $("#search").val("直接搜索目的地");
		  return;
	  }
	 
	window.location.href="<%=basePath%>product/product_search.do?ishot=1&search="+encodeURI(encodeURI(search));
	        	
 }
 function clickimg(id){
	 window.location.href="<%=basePath%>schedule/schedule_info2.do?productId="+id;
 }
 
 function select(){
	var aa=  $('#select option:selected').val();//选中的文本
	var type="zhoubian";
	var type ;
	 if(aa=="0"){
		 type="zhoubian";
	 }else if(aa=="1"){
		 type="yuanzheng";
	 }else if(aa=="2"){
		 type="duantu";
	 }
	 
	 window.location.href="<%=basePath%>product/product_index.do?ishot=1&type="+type;
 }
 $(function (){
	 var select = document.getElementById("select");  
 	if("<%=request.getAttribute("type")%>"=="zhoubian"){
 		select.options[0].selected = true;  
 	}else if("<%=request.getAttribute("type")%>"=="yuanzheng"){
 		select.options[1].selected = true;
 	}else{
 		select.options[2].selected = true;
 	}
 	});
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

				//document.getElementById("carousel-58154").height="0%";

             }

         })
</script>
   
   
 </head> 
<body>

<div >
	<div class="row-fluid" id="row-fluid" style="height:30%">
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
				<s:iterator value="#request.productHot" id="hotbean" status="La">
				<s:if test="#La.index==0">
				<div class="item active">
						<img alt="" src="<%=request.getContextPath()%><s:property value="#hotbean.picture_url"/>"/>  
					</div>	
				</s:if>
				<s:else>
				 <div class="item">
						<img alt="" src="<%=request.getContextPath()%><s:property value="#hotbean.picture_url"/>"  />
					</div>
				 </s:else>
				</s:iterator>
				</div>
					<div style="position:relative;width:100%;margin-top:-10%">	
						<div style="width:100%;height:15%;position:absolute;bottom:0">
							<span id="jqrm">近期热门</span>
						</div>
						<a class="left carousel-control"href="#carousel-58154" data-slide="prev" style="margin-top:-20%;margin-left:-1%">‹</a>
						<a class="right carousel-control" href="#carousel-58154" data-slide="next" style="margin-top:-22%;margin-right:-2%">›</a>
						<div style="width:100%;height:15%;position:absolute;bottom:0">
							<span id="jianjie"><s:property value="#hotbean.title"/>
							</span>
						</div>
						<div style="width:100%;height:15%;position:absolute;bottom:0">
							<span id="databegin">初始</span>
							<span id="hx">—</span>
							<span id="datafinish">结束</span>
						</div>
					</div>
			</div>
		</div>
	</div>
	<div class="row-fluid" >
		<div class="span12">
			<div  style="height:5%;margin-top:2%;">
				<div>
					<select id="select" name="select" onchange="select()">   
     				 	<option value="0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;周边</option>
     				 	<option value="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;远征</option>
     				 	<option value="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;短途</option>
 					</select><input type="text" id="search" name="search" value="直接搜索目的地" onfocus="value=''" onblur="search()"/>  <!-- onblur=" if(!value)value='直接搜索目的地' " -->
				</div>
			</div>
		</div>
	</div>
	<div id="box" class="row-fluid" style="height:60%;">
		<div class="span12">
			<div id="wrapper" style="height:100%;">
				<div>
				<s:iterator value="#request.productzhoubian" id="bean" status="L">
				<!--<s:property value="#L.index+1"/>-->
					<div style="position:relative;width:100%;height:60%">				
						<img id="<s:property value="#L.index+1"/>" alt="" src="<%=request.getContextPath()%><s:property value="#bean.picture_url"/>" onclick="clickimg(<s:property value="#bean.id"/>)"/>
						<div style="width:100%;height:20%;position:absolute;bottom:0">
							<span id="price1">价格:<s:property value="#bean.price"/></span>
							<span id="xiwei1">席位:<s:property value="#bean.saleSeat"/></span>
							<span id="data1">日期:<s:property value="#bean.startDate"/></span>
						</div>
						<div style="width:100%;height:15%;position:absolute;bottom:40%">
							<span id="xiangmu2"> <s:property value="#bean.chineseName"/>  </span>
							<span id="xiangmu2y"><s:property value="#bean.englishName"/></span>
						</div>
					</div>
						
					</s:iterator>
				</div>
			</div>
		</div>
	</div>	
	<div  style="width:100%;height:6%;position:fixed;bottom:0;text-align:center" >
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