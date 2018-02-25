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
//each();
//objKey();
//setOpt();
//pushJson();
motifyJson();
//json遍历，如果返回的是page，则也能在page中获取对应的列表json，进行遍历读取
function each(){
	obj = {"key":"id","value":"name"};
	var json = ['aaa','bbb','ccc',obj]
         $.each(json,function(index,value){
        	console.log(index);
			console.log(value);
        })
}
//获取对象中的key和value
function objKey(){
	obj = {"key":"乱码keyafsafsafwfczfefewaf","value":"这是value"};
	//获取对象key
	 for (var p in obj){
		 console.log(p)//key
		 console.log(obj[p])//value
	 }
}

//添加/删除对象属性
function setOpt(){
	obj = {"key":"乱码keyafsafsafwfczfefewaf","value":"这是value"};
	//添加属性
	obj.name="1212";
	console.log(obj)
	//删除属性
	delete obj.value;
	console.log(obj)
}

//json中添加删除
function pushJson(){
	var obj = {"key":"乱码keyafsafsafwfczfefewaf","value":"这是value"};
	var obj1 = {"key":"乱码keyafsafsafwfczfefewaf222","value":"这是value222"};
	var json = [obj,obj1];
	//添加json
	var obj2 = {"key":"乱码22","value":"这是value22"};
	json.push(obj2);
	console.log(json);
	//修改JSON
	json[1].key = "改成乱码33";
	console.log(json);
	//删除json
//	delete json[0];  //删除第0个
	json.splice(0, 2);//从第0个起，删除2个
	console.log(json);
}

//循环替换json
function motifyJson(){
	var obj = {"key":"乱码keyafsafsafwfczfefewaf","value":"这是value"};
	var obj1 = {"key":"乱码keyafsafsafwfczfefewaf222","value":"这是value222"};
	var obj2 = {"key":"乱码22","value":"这是value22"};
	var json = [obj,obj1,obj2];
	console.log(json);
    $.each(json,function(index,value){
		value.value = "1111";
    })
    console.log(json);
}
</script>


<body>
<table>
<tr><td>100</td><td>101</td><td>102</td></tr>
<tr><td>200</td><td>201</td><td>202</td></tr>
</table>
</body>
</html>