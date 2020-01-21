package com.didi.pk.learn.alg.algs4th;

import com.didi.pk.learn.alg.algs4th.ch01.Accumulator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author pengkai
 * @date 2019-08-10
 */
@RunWith(MockitoJUnitRunner.class)
public class AccumulatorSpec {
    @Test
    public void test() {
        Accumulator stats = new Accumulator();
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            stats.addDataValue(x);
        }

        StdOut.printf("n      = %d\n", stats.count());
        StdOut.printf("mean   = %.5f\n", stats.mean());
        StdOut.println(stats);
    }
}
