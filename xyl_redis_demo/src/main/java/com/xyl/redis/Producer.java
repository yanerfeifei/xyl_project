package com.xyl.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by meridian on 2019/8/9.
 */
public class Producer {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.1.1.68",6379);
        jedis.auth("WudiHX0Q3A98eVqy");
        /**
         * 生产者就是不听的往task_queue中追加任务
         */
        int  counter = 0;
        while(true){
            counter ++;
            try{
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            jedis.lpush("task_queue",counter+"");
        }
    }

}
