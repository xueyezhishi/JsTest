package com.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
 
public class RedisJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
		try {
	        Jedis jedis = new Jedis("localhost");
	        System.out.println("连接成功");
	 
	        // 获取存储的数据并输出
	        List<String> list = jedis.lrange("site-list", 0 ,2);
	        for(int i=0; i<list.size(); i++) {
	            System.out.println("列表项为: "+list.get(i));
	        }
		} catch (Exception e) {
			e.printStackTrace();
	        System.out.println("连接失败");
		}
    }
}