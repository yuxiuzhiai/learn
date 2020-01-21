package com.didi.pk.learn.java;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

/**
 * @author pengkai
 * @date 2019-10-03
 */
public class RedisDemo {
    public static void main(String[] args) throws InterruptedException {
        JedisPool pool = new JedisPool();
        pool.getResource().subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                System.out.println(message);
            }
        },"mypubsub");

        Thread.sleep(1000000);
    }
}
