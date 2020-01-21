package com.didi.pk.learn.alg.algs4th.ch02;

import java.util.Arrays;

/**
 * @author pengkai
 * @date 2019-08-10
 */
public class Insertion {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0 && a[j] < a[j - 1]; j--) {
                int tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-1, 1, 3, 5, 2, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
