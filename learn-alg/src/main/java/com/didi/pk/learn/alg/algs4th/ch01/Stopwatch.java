package com.didi.pk.learn.alg.algs4th.ch01;

/**
 * @author pengkai
 * @date 2019-08-10
 */
public class Stopwatch {

    private long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapseTime() {
        return (System.currentTimeMillis() - start) / 1000.0;
    }
}
