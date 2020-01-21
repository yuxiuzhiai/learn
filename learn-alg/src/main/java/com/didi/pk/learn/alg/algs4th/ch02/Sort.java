package com.didi.pk.learn.alg.algs4th.ch02;

import java.util.Arrays;

/**
 * @author pengkai
 * @date 2019-12-20
 */
public class Sort {
    /**
     * 冒泡
     *
     * @param a
     */
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] < a[j - 1]) {
                    int t = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = t;
                }
            }
        }
    }

    /**
     * 选择
     *
     * @param a
     */
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int t = a[min];
            a[min] = a[i];
            a[i] = t;
        }
    }

    /**
     * 插入
     *
     * @param a
     */
    public static void insertionSort(int[] a) {
        for (int i = 01; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                int t = a[j];
                a[j] = a[j - 1];
                a[j - 1] = t;
            }

        }
    }

    /**
     * 归并
     *
     * @param a
     */
    public static void mergeSort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, 0, a.length - 1, aux);
    }

    private static void sort(int[] a, int low, int high, int[] aux) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        sort(a, low, mid, aux);
        sort(a, mid + 1, high, aux);
        merge(a, low, mid, high, aux);
    }

    private static void merge(int[] a, int low, int mid, int high, int[] aux) {
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void quickSort(int[] a) {
        quick(a, 0, a.length);
    }

    private static void quick(int[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = partition(a, low, high);
        quick(a, low, j - 1);
        quick(a, j + 1, high);
    }

    private static int partition(int[] a, int low, int high) {
        int val = a[low];
        int i = low;
        int j = high;
        while (true) {
            while (a[++i] < val){
                if(i==high)
                    break;
            }
            while (a[--j] > val){
                if(j==low) break;
            }
            if (i >= j) break;
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        int t = a[low];
        a[low] = a[j];
        a[j] = t;
        return j;
    }

    public static void main(String[] args) {
        int[] a = {3, 8, 7, 4, 5, 2, 6};
//        bubbleSort(a);
//        selectionSort(a);
//        insertionSort(a);
//        mergeSort(a);
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
