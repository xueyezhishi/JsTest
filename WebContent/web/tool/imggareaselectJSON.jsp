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
//功能：循环输出JSON内的内容到图层上
$(document).ready(function () {
/* 	$('#photo').imgAreaSelect({ x1: 120, y1: 90, x2: 280, y2: 210 }); */
     area();
     draw()
     $('img#photo').imgAreaSelect({
    	instance: true,
        handles: true,
        onSelectStart:aaa,
        onSelectEnd: ccc
    }); 

});


    function setArea(json) {
        var list = '';
        $.each(json,function(index,value){
       	 	list += ['<area shape ="rect" coords ="'+value.x1+','+value.y1+','+value.x2+','+value.y2+'" id = "'+value.id+'"  />'].join("");
     	})
		console.log(list);
   	
        var $list = $(list);
  //    $('.content>table>tbody').remove();
        $('.content').append( $list );     
    }


var json = [];
function area(){//120,90,280,210
	json.push(getPoi(1,120,90,280,210));
	json.push(getPoi(2,0,0,100,150));
	json.push(getPoi(3,200,200,300,300));
	json.push(getPoi(4,300,300,450,450));
	console.log(json)
	setArea(json);
}
function getPoi(id,x1,y1,x2,y2){
	var obj = {"id":id,"x1":x1,"y1":y1,"x2":x2,"y2":y2};
	return obj;
}
function draw(){//为选中区域附上颜色
    var arr=$('area');
/*     c(arr.filter("[id=1211]"),'C1C1C1')
    c(arr.filter("[id=1212]"),'ff0000')
    c(arr.filter("[id=1213]"),'99ff99')
    c(arr.filter("[id=1214]"),'ffff00') */
    $.each(json,function(index,value){
    	console.log(value.id)
    	c(arr.filter("[id="+value.id+"]"),'ff0000');
    })
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
//键盘按键
keypress();
function keypress(){
  $("*").keypress(function(event){
	  console.log("4444444444")
	  if(event.keyCode == 13){
		  console.log("this is keypress")
	  }
  });
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
	<map name="planetmap" class="content">
        
    </map>
    <div style="color:red"><p>adsad</p></div>>
</div>
</body>
</html>