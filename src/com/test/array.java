package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;



public class array {
    public static void main(String[] args)throws Exception {
    	String a = "   fhshgsgks（fafaf)f   afsdf）flsajf，，，，       ";
    	a = ReplaceSymbol(a);
    	System.out.println(a);
    }
	public static String ReplaceSymbol(String s){
		if(null!=s && !"".equals(s)){ 
			s = s.replaceAll("^[　*| *]*","").replaceAll("[　*| *]*$","");
			s = s.replaceAll(" ","");
			s = s.replaceAll("（","(");
			s = s.replaceAll("）",")");
			s = s.replaceAll("，",",");
		} 
		return s;
	}
    public static boolean isNotEmpty(Object[] array) {
        return (array != null && array.length > 0);
    }
    /**
     * 找出a2有,而a1没有的元素，并拼成数组返回
     * @param a1 数组a1
     * @param a2 数组a2
     * @return
     */
    public static String[] getNotSameArray(String[] a1,String[] a2){
    	String[] notSameArray = null;
    	if(a1!=null&&a2!=null){
	    	Set<String> set = new TreeSet<String>();
	    	Set<String> notSameSet = new TreeSet<String>();
	    	for(int i =0;i<a1.length;i++){
	    		set.add(a1[i]);
	    	}
	    	for(int j=0;j<a2.length;j++){
	    		if(!set.contains(a2[j])){
	    			notSameSet.add(a2[j]);
	    		}
	    	}
	    	
	    	notSameArray = new String[notSameSet.size()]; 
	    	Iterator<String> it = notSameSet.iterator();
	    	int num = 0;
	    	while(it.hasNext()){//判断是否有下一个
	    		String str = it.next();
	    		notSameArray[num] = str;
	    		num++;
	    	}
    	}
    	return notSameArray;
    }
    /**
     * 判断str是否是allstr中的元素
     * @param allstr 以逗号分割的字符串集
     * @param str 要查的字符串
     * @return allstr包含str时，返回true
     */
    public static boolean isSameStrSpilt(String allstr,String str){
    	boolean flag = false;
    	if(StringUtils.isNotEmpty(allstr)&&StringUtils.isNotEmpty(str)){
    		String[] array=allstr.split(",");
	    	Set<String> set = new TreeSet<String>();
	    	for(int i =0;i<array.length;i++){
	    		set.add(array[i]);
	    	}
    		if(set.contains(str)){
    			flag = true;
    		}
    	}
    	return flag;
    }
    public void splitStr(){
    	String[] header =null;
    	String csvHeader = "aaaa";
    	header=csvHeader.split(",");
    	System.out.println(header);
    }
}