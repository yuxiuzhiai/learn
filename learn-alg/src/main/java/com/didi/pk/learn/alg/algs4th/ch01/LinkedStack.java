package com.didi.pk.learn.alg.algs4th.ch01;

import lombok.Data;

import java.util.Iterator;

/**
 * @author pengkai
 * @date 2019-08-10
 */
@Data
public class LinkedStack<T> implements Stack<T> {

    private Node<T> first;
    private int n;

    @Override
    public void push(T t) {
        Node<T> oldFirst = first;
        first = new Node<>(t, oldFirst);
        n++;
    }

    @Override
    public T pop() {
        T item = first.item;
        first = first.next;
        n--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Data
    private static class Node<T> {
        T item;
        Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
