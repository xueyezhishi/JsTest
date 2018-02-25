<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<%-- <script src="<%=request.getContextPath()%>/js/ComJs/jquery-1.9.1.js"></script> --%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/imgareaselect/imgareaselect-animated.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/imgareaselect/imgareaselect-default.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/imgareaselect/imgareaselect-deprecated.css" />
<script src="<%=request.getContextPath()%>/js/ComJs/jquery-1.7.2.min.js"></script>
<script src="<%=request.getContextPath()%>/js/ComJs/imgAreaSelect/jquery.imgareaselect.pack.js"></script>
<script src="<%=request.getContextPath()%>/js/ComJs/imgAreaSelect/jquery.imgareaselect.min.js"></script>
<script src="<%=request.getContextPath()%>/js/ComJs/imgAreaSelect/jquery.maphilight.min.js"></script>
<script type="text/javascript">
//功能：area标签显示矩形、圆形、多边形；控件的框选区域；filter过滤id；area图层赋色
$(document).ready(function () {
/* 	$('#photo').imgAreaSelect({ x1: 120, y1: 90, x2: 280, y2: 210 }); */
     draw()
     $('img#photo').imgAreaSelect({
    	instance: true,
        handles: true,
        onSelectStart:aaa,
        onSelectEnd: ccc
    }); 

});
function draw(){//为选中区域附上颜色
    var arr=$('area');
    console.log(arr)
    console.log(arr.filter("[id=1211]"))
    c(arr.filter("[id=1211]"),'C1C1C1')
    c(arr.filter("[id=1212]"),'ff0000')
    c(arr.filter("[id=1213]"),'99ff99')
    c(arr.filter("[id=1214]"),'ffff00')
}
//通过maphilight为area附上颜色
function c(v,color){//颜色赋值方法
    var data = $(v).data('maphilight') || {};
      data={
        fill: true,
        fillColor: color,
        fillOpacity: 0.4,
        stroke: true,
        strokeColor: 'C1C1C1',
        strokeOpacity: 1,
        strokeWidth: 1,
        fade: false,
        alwaysOn: true,
        neverOn: false,
        groupBy: false,
        wrapClass: true,
        shadow: false,
        shadowX: 0,
        shadowY: 0,
        shadowRadius: 6,
        shadowColor: 'C1C1C1',
        shadowOpacity: 0.8,
        shadowPosition: 'outside',
        shadowFrom: false
      }
        $(v).data('maphilight', data);
        $('img#photo').maphilight();

}


function aaa(){
	console.log("111")
}
function ccc(){
	console.log("333")
}


</script>
<body>
<div>
	<img id="photo" src="<%=request.getContextPath()%>/img/test/5.jpg" usemap ="#planetmap">
	<map name="planetmap">
<!--         <area shape ="rect" coords ="120,90,280,210" id = "1211"  /> -->
<!--         <area shape ="rect" coords ="0,0,100,150" id = "1212"  />
        <area shape ="rect" coords ="20,20,80,130" id = "1212"  /> -->
<!--         <area shape ="circle" coords ="300,300,100" id = "1213"  /> -->
<!--         <area shape ="polygon" coords ="400,400,500,400,600,450" id = "1214"  /> -->
       <!--  <area shape ="polygon" coords ="0,0,0,100,150,100,150,0,0,0,20,20,20,80,130,80,130,20,20,20" id = "1214"  /> -->
        <area shape ="polygon" nohref=false coords ="0,0,500,0,500,50,50,50,50,300,500,300,500,350,50,350,0,350" id = "1214"  />
    </map>
    <div style="color:red"><p>adsad</p></div>
</div>
</body>
</html>