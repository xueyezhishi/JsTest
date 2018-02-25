<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script src="<%=request.getContextPath()%>/js/ComJs/jquery-1.9.1.js"></script>
<script>
//JQuery功能罗列展示
//功能：配置图片路径、设定鼠标移动事件、
function changeImg(url)
{
 var bigimg = document.getElementById("myimg");
 bigimg.src="<%=request.getContextPath()%>/img/test/ping.jpg";
}
function changeBack()
{
 var bigimg = document.getElementById("myimg");
 bigimg.src="";
}
</script>
<body>
<div><img id="myimg" src="" alter="此处为大图片" width="300" height="300"></div>
<div>
<img src="<%=request.getContextPath()%>/img/test/3.jpg" onmouseover="changeImg(this.src)" onmouseout="changeBack()">
</div>
</body>
</html>