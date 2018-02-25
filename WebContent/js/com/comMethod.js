/*
 * 公共方法
 * 版本1.1
 * 将本系统中调用频繁的JS方法集中此处
 * */

function initBaseInfo(str,typeId){//初始化基础数据:str字段名,typeId基础数据类型
	widget = myForm.getCombo(str);
	url="././ajaxBaserefdata.do?method=ListCombo&type_id="+typeId+"&ect="+Math.random();
	loader = dhtmlxAjax.getSync(url);
	result = jQuery.parseJSON(loader.xmlDoc.responseText);//ajax获取json
	arr=new Array(); //定义js数组，并在循环体中将json的id，name加入
    for(var i=0;i<result.length;i++){
        var a=[result[i].baserefdata_id,result[i].dataname];
        arr.push(a);
    }
    widget.addOption(arr);//添加下拉选项
}

function setCommonComboValue(str,id,value){//对combo赋值:str字段名,id字段主键,value字段值
	myForm.setItemValue(str,null);
	if(id != null && typeof(id)!="undefined"){
		widget = myForm.getCombo(str);
		widget.clearAll();
		myForm.setItemValue(str,null);
		var arr=new Array();
		arr.push([id,value]);
		widget.addOption(arr);//添加下拉选项
		widget.setComboValue(id);
	}
}
function setCommonComboValue2(str,id,value){//对combo赋值:str字段名,id字段主键,value字段值
	myAddForm.setItemValue(str,null);
	if(id != null && typeof(id)!="undefined"){
		widget = myAddForm.getCombo(str);
		widget.clearAll();
		var arr=new Array();
		arr.push([id,value]);
		widget.addOption(arr);//添加下拉选项
		widget.setComboValue(id);
	}
}
