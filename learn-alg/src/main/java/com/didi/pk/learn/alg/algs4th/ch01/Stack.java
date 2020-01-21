package com.didi.pk.learn.alg.algs4th.ch01;

/**
 * @author pengkai
 * @date 2019-08-10
 */
public interface Stack<T> extends Iterable<T> {
    void push(T t);

    T pop();

    boolean isEmpty();

    int size();
}
