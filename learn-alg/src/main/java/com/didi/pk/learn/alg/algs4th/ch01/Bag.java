package com.didi.pk.learn.alg.algs4th.ch01;

/**
 * @author pengkai
 * @date 2019-08-10
 */
public interface Bag<T> extends Iterable<T> {
    void add(T t);

    boolean isEmpty();

    int size();
}
