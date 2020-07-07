package com.rayyounghong.algorithms.sorting;

/**
 * @author ray
 * @date 2020/7/3
 */
public class Helper {
    public static void swap(int[] arr, int fi, int si) {
        int temp = arr[fi];
        arr[fi] = arr[si];
        arr[si] = temp;
    }
}
