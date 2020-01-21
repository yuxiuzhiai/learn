package com.didi.pk.learn.alg.algs4th.ch02;

import java.util.Arrays;

/**
 * @author pengkai
 * @date 2019-08-10
 */
public class Selection {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    public static void main(String[] args) {
        int[] a = {-1, 1, 3, 5, 2, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
