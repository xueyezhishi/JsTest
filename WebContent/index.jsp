<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script src="<%=request.getContextPath()%>/asset_yw/_normal/jquery-1.9.1.js"></script>
<script>
//JQuery功能罗列展示

each();



function each(){//json遍历，如果返回的是page，则也能在page中获取对应的列表json，进行遍历读取
	var json = ['aaa','bbb','ccc']
         $.each(json,function(index,value){
        	console.log(index);
			console.log(value);
        })
}

</script>
<body>
<table>
<tr><td>100</td><td>101</td><td>102</td></tr>
<tr><td>200</td><td>201</td><td>202</td></tr>
</table>
</body>
</html>