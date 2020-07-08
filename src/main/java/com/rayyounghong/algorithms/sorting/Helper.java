package com.rayyounghong.algorithms.sorting;

/**
 * @author ray
 */
public class Helper {
    public static void swap(int[] arr, int fi, int si) {
        int temp = arr[fi];
        arr[fi] = arr[si];
        arr[si] = temp;
    }
}
