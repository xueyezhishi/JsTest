<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 进行服务器校验，获取路径与账号信息 -->
<%@ include file="/headlibs.jsp"%>
<base href="<%=basePath%>"> 
</head>
<style type="text/css">  
table{ 
font-size:15px; 
} 
table{ 
table-layout:fixed; 
empty-cells:show; 
border-collapse: collapse; 
margin:0 auto; 
} 
td{ 
height:30px; 
} 
.table{ 
border:1px solid #cad9ea; 
color:#666; 
} 
.table td,.table th{ 
border:1px solid #cad9ea; 
padding:0 1em 0; 
} 
.table tr td:nth-child(odd){ 
font-weight:bold;
background-color:#f5fafe; 
} 
</style>  
<script src="<%=request.getContextPath()%>/dhtmlx/terrace/dhtmlx.js"></script> 
<script src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
<script src="<%=request.getContextPath()%>/css/tools.js"></script>
<script type="text/javascript">
var floorid = GetArgsFromHref("floorid",window.location.href);//floorid 

$(window).load(function(){//DOM结构渲染完成后加载
	getSummaryFloor();
});

function getSummaryFloor(){
	var url = "ajaxSummaryInfo.do?method=GetSummaryInfoFloor&floorid="+floorid+"&ect="+Math.random();
	var loaderinfo = dhtmlxAjax.getSync(url);
	if(loaderinfo.xmlDoc.responseText!="error"&&loaderinfo.xmlDoc.responseText!="no"){
		json = jQuery.parseJSON(loaderinfo.xmlDoc.responseText);	
		console.log(json);
	}
}



//ajaxSummaryInfo
// var url4="././ajaxRoom.do?method=UnitSum&id="+floorid;
</script>
<body>
<div>
	<div>
		<table  class="table">
			<tr>
				<td colspan ="7" style ="text-align:center">楼层信息汇总</td>
			</tr>
			<tr>
				<td>房屋名称</td><td colspan ="5">111</td>
			</tr>
			<tr>
				<td>地址</td><td colspan ="5">222</td>
			</tr>
			<tr>
				<td>房屋类型</td><td colspan ="3">333</td>
				<td>分配单位数量</td><td>111</td>
			</tr>
			<tr>
				<td>层次</td><td>111AAAAAAAAAa</td>
				<td>总建筑面积</td><td>222</td>
				<td>总使用面积</td><td>333</td>
			</tr>
			<tr>
				<td>总房间数量</td><td>111</td>
				<td>已分配房间数量</td><td>222</td>
				<td>未分配房间数量</td><td>333</td>
			</tr>
		</table>
	</div>

	<div>
		<table>
			<tr>
				<td colspan ="7">单位使用情况</td>
			</tr>
			<tr>
				<td>单位名称</td><td>使用面积</td><td>建筑面积</td><td>房间数量</td>
			</tr>

		</table>
	</div>

</div>
</body>
</html>