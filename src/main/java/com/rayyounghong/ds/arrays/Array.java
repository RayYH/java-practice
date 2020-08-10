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

    public static int max(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static int min(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        return sum;
    }

    public static int average(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        return sum(arr) / (arr.length);
    }

    public static int[] copy(int[] arr) {
        int[] copied = new int[arr.length];

        // here used system provided array copy method
        System.arraycopy(arr, 0, copied, 0, arr.length);
        // for (int i = 0; i < arr.length; i++) {
        // copied[i] = arr[i];
        // }

        return copied;
    }

    public static void reverse(int[] arr) {
        int length = arr.length;
        int halfLength = length / 2;
        int temp;
        for (int i = 0; i < halfLength; i++) {
            temp = arr[i];
            arr[i] = arr[length - 1 - i];
            arr[length - 1 - i] = temp;
        }
    }
}
