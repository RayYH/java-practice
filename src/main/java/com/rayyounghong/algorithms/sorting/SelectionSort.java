package com.rayyounghong.algorithms.sorting;

/**
 * 选择排序，将数组分为已排序和未排序两部分，依次从未排序数组中找到最小值并放入已排序数组中。
 *
 * @author ray
 */
public class SelectionSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        int i, j, minIndex;

        for (i = 0; i < n - 1; i++) {
            // 找出该放在 i 位置的元素
            minIndex = i;
            for (j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            Helper.swap(arr, i, minIndex);
        }
    }

}
