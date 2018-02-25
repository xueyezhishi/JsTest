//工具方法
//版本1.2


//赋值方法，排除Undefined
function setOutUndefined(str,value){
	if(value!=null&&typeof(value)!="undefined"){
		myForm.setItemValue(str,value);
	}else{
		myForm.setItemValue(str,null);
	}
}
//赋值方法，为Undefined设定一个值
function setValueMissing(str){
	if(str == null||str == ""||str == "undefined"){
		str = "未填";
	}
	return str;
}
//赋值方法，为Undefined设定一个值
function setValueMissing2(str){
	if(str == null||str == ""||str == "undefined"){
		str = "";
	}
	return str;
}
//判断字符串是否为空
function isNull(str){
	if(str==null||str==""){
		return true;
	}else{
		return false;
	}
}






