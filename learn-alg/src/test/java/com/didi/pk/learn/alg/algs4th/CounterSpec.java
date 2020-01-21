package com.didi.pk.learn.alg.algs4th;

import com.didi.pk.learn.alg.algs4th.ch01.Counter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author pengkai
 * @date 2019-08-10
 */
@RunWith(MockitoJUnitRunner.class)
public class CounterSpec {
    @Test
    public void flips() {
        int t = 10;
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        for (int i = 0; i < t; i++) {
            if (StdRandom.bernoulli(0.5)) {
                heads.increment();
            } else {
                tails.increment();
            }
        }
        StdOut.println(heads);
        StdOut.println(tails);

        int d = heads.tally() - tails.tally();
        StdOut.println("delta:" + Math.abs(d));
    }
}
