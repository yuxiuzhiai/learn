package com.didi.pk.learn.alg.algs4th.ch01;

/**
 * @author pengkai
 * @date 2019-08-10
 */
public interface Queue<T> extends Iterable<T> {
    void enqueue();

    T dequeue();

    boolean isEmpty();

    int size();
}
