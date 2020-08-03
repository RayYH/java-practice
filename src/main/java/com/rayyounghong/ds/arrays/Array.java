package com.rayyounghong.ds.arrays;

/**
 * @author ray
 */
public class Array {
    public static int findElement(int[] arr, int length, int key) throws IllegalArgumentException {
        if (length < 0) {
            throw new IllegalArgumentException("length cannot be negative");
        }

        for (int i = 0; i < length; i++) {
            if (arr[i] == key) {
                // return index if founded
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (arr == null) {
            return -1;
        }

        if (high < low) {
            return -1;
        }

        // low + (high - low)/2
        int mid = (low + high) / 2;
        if (key == arr[mid]) {
            return mid;
        }

        if (key > arr[mid]) {
            return binarySearch(arr, mid + 1, high, key);
        }

        return binarySearch(arr, low, mid - 1, key);
    }

    public static int insertElementAtEnd(int[] arr, int n, int key, int capacity) {
        // Cannot insert more elements if n is already more than or equal to capacity
        if (n >= capacity) {
            return n;
        }

        arr[n] = key;

        return n + 1;
    }

    public static int deleteElement(int[] arr, int n, int key) {
        int pos = findElement(arr, n, key);
        if (pos == -1) {
            return n;
        }

        if (n - 1 - pos >= 0) {
            System.arraycopy(arr, pos + 1, arr, pos, n - 1 - pos);
        }

        // assign last element to 0
        arr[n - 1] = 0;

        return n - 1;
    }
}
