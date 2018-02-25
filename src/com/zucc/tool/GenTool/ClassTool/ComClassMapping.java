package com.zucc.tool.GenTool.ClassTool;

import java.lang.reflect.Field;  
import java.lang.reflect.Method;

public class ComClassMapping {
	//类作用描述：类映射工具类，提供工具接口，以便类映射的处理
	/**
	 * 通过类名和方法名获取Class的get方法
	 * @param c Class类  如：AssetDepartment.class
	 * @param str 方法名   如：uuid
	 * @return get的Method方法
	 */
	public static Method m_get(Class c,String str){
		//Class 转译，获取方法
		try{
			String ms_name = str.substring(0, 1).toUpperCase() + str.substring(1);//首字母大写
			Field prop_f=c.getDeclaredField(str);
			String prop_type=prop_f.getType().getName();
			Method m_get = c.getMethod("get" + ms_name);
			return m_get;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static Method m_set(Class c,String str){
		//Class 转译，获取方法
		try{
			String ms_name = str.substring(0, 1).toUpperCase() + str.substring(1);//首字母大写
			Field prop_f=c.getDeclaredField(str);
			String prop_type=prop_f.getType().getName();
			Method m_set = c.getMethod("set" + ms_name);
			return m_set;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 用Method方法获取内容，并转为String
	 * @param m Method方法  
	 * @param one 包含内容的对象 
	 * @return 对象的String内容
	 */
	public static String m_invoke(Method m,Object one){
		String str = null;
		try{
			Object oneStr = m.invoke(one);
			str = oneStr==null?null:oneStr.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}
	public static String m_set_invoke(Method m,Object one,String newStr){
		String str = null;
		try{
			Object oneStr = m.invoke(one,newStr);
			str = oneStr==null?null:oneStr.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}

}