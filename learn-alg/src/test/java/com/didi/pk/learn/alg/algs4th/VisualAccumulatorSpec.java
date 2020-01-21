package com.didi.pk.learn.alg.algs4th;

import com.didi.pk.learn.alg.algs4th.ch01.VisualAccumulator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author pengkai
 * @date 2019-08-10
 */
@RunWith(MockitoJUnitRunner.class)
public class VisualAccumulatorSpec {
    @Test
    public void test(){
        VisualAccumulator accumulator = new VisualAccumulator(10000,1.0);
        for (int i = 0; i < 10000; i++) {
            accumulator.addDataValue(StdRandom.random());
        }
        StdOut.print(accumulator);
    }
}
