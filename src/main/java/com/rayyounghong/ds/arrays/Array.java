package com.rayyounghong.ds.arrays;

import com.rayyounghong.algorithms.searching.BinarySearch;

/**
 * 数组常见的一些操作。
 *
 * @author ray
 */
public class Array {
    /**
     * 在数组中查找给定的元素，返回第一个匹配给定 key 的元素的索引值。
     *
     * @param arr
     *            给定的数组
     * @param length
     *            数组的长度
     * @param key
     *            待查找元素的 key 值
     * @return 如果查找到给定的元素，则返回该元素的索引值，否则返回 -1
     * @throws IllegalArgumentException
     *             如果传入的长度非法，则抛出一个异常
     */
    public static int findElement(int[] arr, int length, int key) throws IllegalArgumentException {
        if (length < 0) {
            throw new IllegalArgumentException("length cannot be negative");
        }

        for (int i = 0; i < length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 判断给定的数组是否是升序的。
     *
     * @param arr
     *            给定的数组
     * @return 如果数组升序，则返回 true，否则返回 false
     */
    public static boolean isSorted(int[] arr) {
        if (arr.length >= 1) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 在数组中查找给定的元素，返回第一个匹配给定 key 的元素的索引值。
     *
     * @param arr
     *            数组
     * @param key
     *            待查找元素的 key 值
     * @return 如果查找到给定的元素，则返回该元素的索引值，否则返回 -1
     */
    public static int findElement(int[] arr, int key) {
        return Array.findElement(arr, arr.length, key);
    }

    /**
     * 二分查找元素，数组必须为有序数组。
     *
     * @param arr
     *            数组
     * @param low
     *            左边界
     * @param high
     *            右边界
     * @param key
     *            key 值
     * @return 存在指定的元素则返回索引值，否则返回 -1
     */
    public static int binarySearch(int[] arr, int low, int high, int key) {
        assert Array.isSorted(arr);
        return BinarySearch.search(arr, low, high, key);
    }

    /**
     * 二分查找元素，数组必须为有序数组。
     *
     * @param arr
     *            数组
     * @param key
     *            key 值
     * @return 存在指定的元素则返回索引值，否则返回 -1
     */
    public static int binarySearch(int[] arr, int key) {
        assert Array.isSorted(arr);
        return BinarySearch.search(arr, key);
    }

    /**
     * 在数组尾部插入一个新的元素。
     *
     * @param arr
     *            数组
     * @param n
     *            元素当前长度
     * @param key
     *            元素的 key 值
     * @param capacity
     *            数组的容量
     * @return 返回数组的新长度
     */
    public static int insertElementAtEnd(int[] arr, int n, int key, int capacity) {
        if (n >= capacity) {
            return n;
        }
        arr[n] = key;

        return n + 1;
    }

    /**
     * 移除指定元素，返回新数组的长度。
     *
     * @param arr
     *            数组
     * @param n
     *            数组长度
     * @param key
     *            元素的 key 值
     * @return 返回新数组的长度
     */
    public static int deleteElement(int[] arr, int n, int key) {
        int pos = findElement(arr, n, key);
        // 未查找到元素则不进行任何操作
        if (pos == -1) {
            return n;
        }
        // 此时 arr[pos] == key，我们需要令 arr[pos:] = arr[pos+1:]
        if (n - 1 - pos >= 0) {
            System.arraycopy(arr, pos + 1, arr, pos, n - 1 - pos);
        }
        arr[n - 1] = 0;

        return n - 1;
    }

    /**
     * 获取数组的最大值。
     *
     * @param arr
     *            数组
     * @return 最大值
     */
    public static int max(int[] arr) throws IllegalArgumentException {
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

    /**
     * 获取数组的最小值。
     *
     * @param arr
     *            数组
     * @return 最小值
     */
    public static int min(int[] arr) throws IllegalArgumentException {
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

    /**
     * 求给定数组中所有元素的和。
     *
     * @param arr
     *            数组
     * @return 和
     */
    public static int sum(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        return sum;
    }

    /**
     * 求给定数组中所有元素的平均值。
     *
     * @param arr
     *            数组
     * @return 平均值
     */
    public static int average(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        return sum(arr) / (arr.length);
    }

    /**
     * 复制一个数组。
     *
     * @param arr
     *            数组
     * @return 复制后的新数组
     */
    public static int[] copy(int[] arr) {
        int[] copied = new int[arr.length];
        System.arraycopy(arr, 0, copied, 0, arr.length);
        return copied;
    }

    /**
     * 逆序一个数组。
     *
     * @param arr
     *            数组
     */
    public static void reverse(int[] arr) {
        int length = arr.length;
        int mid = length / 2;
        int temp;
        for (int i = 0; i < mid; i++) {
            temp = arr[i];
            arr[i] = arr[length - 1 - i];
            arr[length - 1 - i] = temp;
        }
    }
}
