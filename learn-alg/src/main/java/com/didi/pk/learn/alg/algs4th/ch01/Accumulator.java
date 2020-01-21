package com.didi.pk.learn.alg.algs4th.ch01;

import lombok.Data;

/**
 * @author pengkai
 * @date 2019-08-10
 */
@Data
public class Accumulator {
    private int n;
    private double total;

    public void addDataValue(double val) {
        this.total += val;
    }

    public double mean() {
        return total / n;
    }

    public int count() {
        return n;
    }
}
