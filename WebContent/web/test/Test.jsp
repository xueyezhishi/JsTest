<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

<script src="<%=request.getContextPath()%>/js/ComJs/jquery-1.9.1.js"></script>
<script>
//JQuery功能罗列展示
//具有以下功能： json遍历、对象取key和value、添加/删除对象属性、循环替换json

$(document).ready(function () {
	changeColor4();
	
	
});

function changeColor(){
//	var aaa = $("table tr:eq(2) td:eq(1)");
	var aaa = $("table tr:eq(2) td:eq(1)");
	console.log(aaa.style);
	if(aaa.text()!="102"){
		aaa.css('color','red');
	}
}
function changeColor2(){
	var aaa = $("#a2 tr:eq(2) td:eq(1)");
	console.log(aaa.style);
	aaa.css('color','red');
}
function changeColor3(){
	var aaa = $("#my_tabbar table tbody tr:eq(2) td:eq(1)");
	console.log(aaa);
	aaa.css('color','red');
}
function changeColor4(){
	var aaa = $("#a2 tr");
	console.log(aaa);
	aaa.css('color','red');
}

</script>


<body>
<table id = "a1">
<tr><td>100</td><td>101</td><td>102</td></tr>
<tr><td>200</td><td>201</td><td>202</td></tr>
<tr><td>300</td><td>301</td><td>302</td></tr>
<tr><td>400</td><td>401</td><td>402</td></tr>
</table>
<table id = "a2">
<tr><td>100</td><td>101</td><td>102</td></tr>
<tr><td>200</td><td>201</td><td>202</td></tr>
<tr><td>300</td><td>301</td><td>302</td></tr>
<tr><td>400</td><td>401</td><td>402</td></tr>
</table>
<table id = "a3">
<tr><td>100</td><td>101</td><td>102</td></tr>
<tr><td>200</td><td>
	<div id="my_tabbar">
		<table>
			<tr><td>100</td><td>101</td><td>102</td></tr>
			<tr><td>200</td><td>201</td><td>202</td></tr>
			<tr><td>300</td><td>301</td><td>302</td></tr>
			<tr><td>400</td><td>401</td><td>402</td></tr>
		</table>
	</div>
</td><td>202</td></tr>
<tr><td>300</td><td>301</td><td>302</td></tr>
<tr><td>400</td><td>401</td><td>402</td></tr>
</table>
</body>
</html>