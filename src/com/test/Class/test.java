package com.test.Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zucc.tool.GenTool.ClassTool.BeanRefUtil;
import com.zucc.tool.GenTool.ClassTool.User;



public class test {
    public static void main(String[] args)throws Exception {
    	test t =new test();
    	t.aaa();
    }
    public void aaa(){
    	Map<String,String> map = new HashMap<String, String>();
    	map.put("username","joe");
    	map.put("userpassword","123456");
    	User   user = new User();
    	BeanRefUtil.setFieldValue(user, map);
    	System.out.print(user);
    }
}