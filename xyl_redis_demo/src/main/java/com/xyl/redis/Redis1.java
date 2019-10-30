package com.xyl.redis;

import com.google.gson.Gson;

import domain.Student;
import redis.clients.jedis.Jedis;

/**
 * Created by meridian on 2019/8/9.
 */
public class Redis1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.1.1.68",6379);
        jedis.auth("WudiHX0Q3A98eVqy");
        Student stu = new Student("张三","男");
        Gson gson = new Gson();
        String stuStr = gson.toJson(stu);
        jedis.set("stu",stuStr);

        Student s = gson.fromJson(jedis.get("stu"),Student.class);
        System.out.println(s.toString());
    }
}
