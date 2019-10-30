package com.xyl.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by meridian on 2019/8/9.
 */
public class Consumer {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.1.1.68",6379);
        jedis.auth("WudiHX0Q3A98eVqy");
        /**
         * 从task_queue当中去除一个任务，来进行消费
         *
         * 同时要把这个任务放置在temp_queue中
         *
         * 判断消费行为是否成功过：
         *
         *
         *  1、如果成功，则从temp_queue直接把这个任务删除掉
         *
         *  2、如果不成功，则从temp_queue中把这个当前任务追加回task_queue
         */

        /*jedis.rpoplpush("task_queue",)*/
    }
}
