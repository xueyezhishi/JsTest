/*
	设置图片
	通用接口，可供任意模块调用
*/
 

function getPhoto(pkId,fileTypeCode){//获取png格式的图片信息
	var url = "ajaxGraph.do?method=GetPhoto&pkId="+pkId+"&fileTypeCode="+fileTypeCode+"&ect="+Math.random();
	var loaderinfo = dhtmlxAjax.getSync(url);
	var json = null;
	if(loaderinfo.xmlDoc.responseText!="error"&&loaderinfo.xmlDoc.responseText!="no---"){
		var json = jQuery.parseJSON(loaderinfo.xmlDoc.responseText);	
	}
	return json;
}

//上传建筑图片(将图片转为png进行存储)
function open_windows_upfile(pkId,fileTypeCode){
	$.upload({
		url: "ajaxGraph.do?method=addPhoto&ect="+Math.random(),
        fileName: 'file1', 
        params: {uuid: "1",pkId:pkId,fileDesc:"",def2:"1",def3:"pohot",fileTypeCode:fileTypeCode,fileStatus:"未审核"},
        dataType: 'text',
        onSend: function() {return true;},
        onComplate: function(data) {
        	url="ajaxGraph.do?method=findfile&pkId="+pkId+"&fileTypeCode="+fileTypeCode+"&ect="+Math.random();
        	loader = dhtmlxAjax.getSync(url);
        	if(loader.xmlDoc.responseText=="ok---"){
        		window.location.reload();//刷新
        		alert("文件上传成功！");
        	}else if(loader.xmlDoc.responseText=="photo"){
        		alert("文件未成功上传！请检查图片格式，只能上传以下格式：png、jpg、jpeg");
        	}else if(loader.xmlDoc.responseText=="no---"){
        		alert("文件未成功上传！");
        	}else if(loader.xmlDoc.responseText=="error"){
        		alert("文件上传失败，系统异常，请检查网络连接或联系管理员！");
        	}else {
        		alert("操作失败！");
        	}
        } 
	});
}










