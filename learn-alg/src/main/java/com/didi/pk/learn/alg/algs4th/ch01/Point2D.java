package com.didi.pk.learn.alg.algs4th.ch01;

import com.didi.pk.learn.alg.algs4th.StdDraw;
import lombok.Data;

/**
 * @author pengkai
 * @date 2019-08-10
 */
@Data
public class Point2D implements Comparable<Point2D> {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double r() {
        return Math.sqrt(x * x + y * y);
    }

    public double theta() {
        return Math.atan2(y, x);
    }

    public double distanceTo(Point2D that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point2D that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    @Override
    public int compareTo(Point2D o) {
        return (int) (x - o.x);
    }
}
