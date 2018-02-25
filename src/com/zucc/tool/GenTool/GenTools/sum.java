package com.zucc.tool.GenTool.GenTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class sum {
    public static void main(String[] args)throws Exception {
    	getSumComma("select t1.pk_house,t1.address,t1.addresspath,t1.house_usage,t1.structurearea,t1.usearea,a4.dataname as housesource,t1.filenum,a3.dataname as housestructure,t1.buildyear,t1.status,t1.prostatus,t1.propervalue,t1.vnote,t1.property_owner,t1.licenseno,t1.fieldno,t1.impropertyno,t1.cert_status,t1.code,a5.dataname as a5,a6.dataname as a6,a7.dataname as a7,t1.levels,t1.year_Built,t1.house_Right,t1.asset_No,t1.enable,t1.bureauunit,t1.is_Dangerous_House,t1.is_Basement");
    }
    /**
     * 计算逗号分割了多少字段
     * @param str
     */
    private static void getSumComma(String str){
        String[] strs = str.split(",");
        int sum = 0;
        for (String s : strs){
            System.out.println(s);
            sum++;
        }   
        System.out.println(sum);
    }

    private static String toLowerCaseFirstOne(String s)
    {
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}