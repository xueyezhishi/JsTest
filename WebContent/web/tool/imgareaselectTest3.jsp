<!DOCTYPE html>
<html>
<head>
<title>可以画多个多边形</title>

<script src="<%=request.getContextPath()%>/js/ComJs/leaflet-src.js"></script>
</head>
<body>
<div id="map" style="width: 800px; height: 600px; border: 1px solid #ccc"></div>
<script src="route.js"></script>
<script>
var cloudmadeUrl = 'http://{s}.tile.cloudmade.com/BC9A493B41014CAABB98F0471D759707/997/256/{z}/{x}/{y}.png',
cloudmade = new L.TileLayer(cloudmadeUrl, {maxZoom: 18});

var poly_points = [];//区域
var poly_line=new L.Polyline([]);//折线
var map = new L.Map('map', {
layers: [cloudmade],
center: new L.LatLng(39.69596043694606, -104.95084762573242),
zoom: 12,
doubleClickZoom :false//不可以通过双击放大，因为双击的作用是添加矩形
});
map.on('click', addClickLatlng);//单击，添加点
map.on('dblclick', showPoly);//双击，显示面
//画矩形
function addClickLatlng(e){
//当前点
var clickLocation=[e.latlng.lat,e.latlng.lng];
poly_points.push(clickLocation);
//显示折线
poly_line.addLatLng(e.latlng);
map.addLayer(poly_line);
//var point=new L.Point(e.layerPoint.x,e.layerPoint.y);
}
//显示矩形
function showPoly(){
for (var i = 0, latlngs = [], len = poly_points.length; i < len; i++) {
latlngs.push(new L.LatLng(poly_points[i][0], poly_points[i][1]));
}
var poly = new L.Polygon(latlngs);
map.addLayer(poly);
//清空
poly_points=[];
poly_line=new L.Polyline([]);
}
</script>
</body>
</html>