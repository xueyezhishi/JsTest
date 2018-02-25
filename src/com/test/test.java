package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class test {
    public static void main(String[] args)throws Exception {
    	String str = "";
    	char s = '';
    	System.out.println(Integer.valueOf(s));
    	System.out.println(Integer.toHexString(s));
    	
    }
    public static boolean isInteger(String str) {    
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");    
        return pattern.matcher(str).matches();    
      }
    public static String isSpance(String str) {    
        str = str.replace("", "");
        return str;    
      }
    private static void strMatch() {
    //	String str= "{"4028abd257ac8e9f0157ac9973290002":"主管部门单位权限","8ac29b4e56440e6a015645189f340025":"商务局","8ac29b4e56440e6a01564514d5bf0023":"机关事务管理局","297e9acd5d060e8b015d0641e2bb0030":"主管部门"}";
    }
    private static void map1() {
    	Double dd1 = 12.12131415;
    	Double dd2 = 12.12131416;
    	Double dd3 = 12.12131417;
    	Double[] dd = {dd1,dd2,dd3};

    	System.out.println(dd1);
    	System.out.println(dd2);
    	System.out.println(dd3);
    	System.out.println(Arrays.toString(dd));
    }
}