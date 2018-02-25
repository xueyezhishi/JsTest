package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;



public class DBTest {
    static String oracleUserName = "cyrealty"; //replace with your Oracle account name
    static String password = "123456789"; //replace with your Oracle password
    static String dbname = "BD";//存储表格名字
    
    /**
     * 连接数据库
     */
    private static Connection getConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        } catch (InstantiationException | IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:oracle:thin:@192.168.221.160:1521:orcl", oracleUserName, password);
    }
    /**
     * 链接数据库测试(可用)
     */
    private static void search(){
    	try (Connection conn = getConnection()){
    		try(Statement stmt = conn.createStatement()){
    			String sql = "select * from BD_HOUSE ";
    			ResultSet rst = stmt.executeQuery(sql);
    			int colNum = rst.getMetaData().getColumnCount();//获取总列数
    			int j = 1;
    			while(rst.next()){
					System.out.println(j++);
    				for(int i=1;i<=colNum;i++){//输出该行中，每列的值
    					System.out.print(rst.getString(i)+",");
    				}
    				System.out.println("");
    			}
    		}
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    
    private static void aaa(){
    	try (Connection conn = getConnection()){
    		Session session = null;
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void main(String[] args)throws Exception {
    	search();
    }
}