package com.didi.pk.learn.java.concurrent;

/**
 * @author pengkai
 * @date 2020-01-20
 */
public class WaitNotify2 {
    static Object obj1 = new Object();
    static Object obj2 = new Object();

    static class Task1 implements Runnable{

        @Override
        public void run() {
            System.out.println("task1 start");
            synchronized (obj1){
                obj1.notify();
            }

            try {
                obj2.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task1 end");
        }
    }
    static class Task2 implements Runnable{

        @Override
        public void run() {
            System.out.println("task2 start");
            synchronized (obj2){
                obj2.notify();
            }
            try {
                obj1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task1 end");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->new Task1());
        Thread t2 = new Thread(()->new Task2());
        t1.start();
        t2.start();
        Thread.sleep(10000);
    }

}
