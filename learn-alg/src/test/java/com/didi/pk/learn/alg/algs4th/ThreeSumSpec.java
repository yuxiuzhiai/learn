package com.didi.pk.learn.alg.algs4th;

import com.didi.pk.learn.alg.algs4th.ch01.ThreeSum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author pengkai
 * @date 2019-08-10
 */
@RunWith(MockitoJUnitRunner.class)
public class ThreeSumSpec {
    @Test
    public void test() {
        int a[] = new int[]{1, 2, 3, 4, 5, 9, -3, 0, -2, 4, -2, 1};
        ThreeSum.printAll(a);

    }
}
