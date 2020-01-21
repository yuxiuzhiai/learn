package com.didi.pk.learn.alg.sort;

import java.util.Arrays;

/**
 * @author pengkai
 * @date 2019-10-27
 */
public class Sorts {
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j = i;
            for (; j > 0 && tmp < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    public static void shellSort(int[] a) {
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                int j = i;
                for (; j > 0 && tmp < a[j - 1]; j--) {
                    a[j] = a[j - 1];
                }
                a[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 25, 8, 10, 0, 29, 7};
//        insertionSort(a);
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }
}
