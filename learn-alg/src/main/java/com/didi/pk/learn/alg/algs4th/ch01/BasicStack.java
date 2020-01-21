package com.didi.pk.learn.alg.algs4th.ch01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author pengkai
 * @date 2019-08-10
 */
public class BasicStack<T> implements Stack<T> {

    private List<T> list;

    public BasicStack() {
        list = new ArrayList<>();
    }

    @Override
    public void push(T t) {
        list.add(t);
    }

    @Override
    public T pop() {
        T t = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return t;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
