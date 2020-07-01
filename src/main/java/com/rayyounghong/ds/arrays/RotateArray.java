package com.rayyounghong.ds.arrays;

import com.rayyounghong.algorithms.Gcd;

/**
 * @author ray
 * @date 2020/6/22
 */
public class RotateArray {

    /**
     * Function to left rotate arr[] of size n by d.
     *
     * Time complexity : O(n); Auxiliary Space : O(d)
     *
     * @param arr
     *            given array
     * @param d
     *            d
     * @param n
     *            size
     */
    public static void leftRotateSolutionOne(int[] arr, int d, int n) {
        d = d % n;

        int[] temp = new int[d];

        // arr[0...] --> temp[0...]
        if (d >= 0) {
            System.arraycopy(arr, 0, temp, 0, d);
        }

        // arr[d...] --> arr[0...]
        if (n - d >= 0) {
            System.arraycopy(arr, d, arr, 0, n - d);
        }

        // temp[0...] --> arr[0...]
        if (d >= 0) {
            System.arraycopy(temp, 0, arr, n - d, d);
        }
    }

    /**
     * Function to left rotate arr[] of size n by d.
     *
     * Time complexity : O(n*d); Auxiliary Space : O(1)
     *
     * @param arr
     *            given array
     * @param d
     *            d
     * @param n
     *            size
     */
    public static void leftRotateSolutionTwo(int[] arr, int d, int n) {
        for (int i = 0; i < d; i++) {
            // left rotate by one
            leftRotateByOne(arr, n);
        }
    }

    public static void leftRotateByOne(int[] arr, int n) {
        int i, temp = arr[0];
        for (i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[i] = temp;
    }

    /**
     * Time complexity : O(n) Auxiliary Space : O(1)
     *
     * @param arr
     *            given array
     * @param d
     *            d
     * @param n
     *            size
     */
    public static void leftRotateSolutionThree(int[] arr, int d, int n) {
        d = d % n;

        int i, j, k, temp;
        int gcd = Gcd.solutionEuclideanAlgorithmViaModuloOperator(d, n);

        // Let arr[] be {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12} and d is 3
        // then gcd = 3, i from 0 to 2.
        for (i = 0; i < gcd; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n) {
                    k = k - n;
                }
                // 这里就已经 break 了，最后一个 arr[j] 并没有赋值，退出循环后需要与第一个值进行交换
                // 因此才有 temp=arr[i]; arr[j] = temp; 这两行语句
                if (k == i) {
                    break;
                }

                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    /**
     * Time complexity : O(n)
     *
     * @param arr
     *            given array
     * @param d
     *            d
     */
    public static void leftRotateSolutionFour(int[] arr, int d) {
        if (d != 0) {
            int n = arr.length;
            reverseArray(arr, 0, d - 1);
            reverseArray(arr, d, n - 1);
            reverseArray(arr, 0, n - 1);
        }
    }

    /**
     * reverse array.
     *
     * @param arr
     *            arr
     * @param start
     *            start
     * @param end
     *            end
     */
    private static void reverseArray(int[] arr, int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Time complexity : O(n)
     *
     * @param arr
     *            given array
     * @param d
     *            d
     * @param n
     *            size
     */
    public static void leftRotateSolutionFive(int[] arr, int d, int n) {

        int i, j;
        // last index of first block
        i = d;
        // first index of second block
        j = n - d;

        if (d != 0 && d != n) {
            while (i != j) {
                /*A is shorter*/
                if (i < j) {
                    swap(arr, d - i, d + j - i, i);
                    j -= i;
                } else { /*B is shorter*/
                    swap(arr, d - i, d, j);
                    i -= j;
                }
            }
        }

        swap(arr, d - i, d, i);

    }

    /**
     * Swap d elements starting at index fi with d elements starting at index si.
     *
     * @param arr
     *            given array
     * @param fi
     *            first index
     * @param si
     *            second index
     * @param d
     *            d
     */
    private static void swap(int[] arr, int fi, int si, int d) {
        int i, temp;
        for (i = 0; i < d; i++) {
            temp = arr[fi + i];
            arr[fi + i] = arr[si + i];
            arr[si + i] = temp;
        }
    }
}
