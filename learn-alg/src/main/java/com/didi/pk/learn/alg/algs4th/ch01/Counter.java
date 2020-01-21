package com.didi.pk.learn.alg.algs4th.ch01;

import lombok.Data;

/**
 * @author pengkai
 * @date 2019-08-10
 */
@Data
public class Counter implements Comparable<Counter> {
    private String id;
    private int number;

    public Counter(String id) {
        this.id = id;
    }

    public void increment() {
        number++;
    }

    public int tally() {
        return number;
    }

    @Override
    public String toString() {
        return id + "(" + number + ")";
    }

    @Override
    public int compareTo(Counter o) {
        return number - o.number;
    }
}
