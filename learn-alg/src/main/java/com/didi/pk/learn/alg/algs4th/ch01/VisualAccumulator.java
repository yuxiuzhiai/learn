package com.didi.pk.learn.alg.algs4th.ch01;

import com.didi.pk.learn.alg.algs4th.StdDraw;

/**
 * @author pengkai
 * @date 2019-08-10
 */
public class VisualAccumulator {
    private int n;
    private double total;

    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double val) {
        n++;
        this.total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(n, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(n, total / n);
    }

    public double mean() {
        return total / n;
    }

    public int count() {
        return n;
    }
}
