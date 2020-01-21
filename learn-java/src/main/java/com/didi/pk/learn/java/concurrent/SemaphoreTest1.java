package com.didi.pk.learn.java.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author pengkai
 * @date 2019-09-12
 */
public class SemaphoreTest1 {
    private Semaphore semaphore = new Semaphore(1);

    public void testMethod(){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+" begin timer="+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+" end timer="+System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
