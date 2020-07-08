package com.rayyounghong.algorithms.searching;

/**
 * @author ray
 */
public class BinarySearch {

    public static int search(int[] arr, int left, int right, int key) {
        if (right >= left) {
            int mid = (left + right) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                return search(arr, left, mid - 1, key);
            }
            return search(arr, mid + 1, right, key);
        }

        return -1;
    }
}
