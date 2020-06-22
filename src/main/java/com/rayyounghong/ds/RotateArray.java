package com.rayyounghong.ds;

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

    public static void leftRotateSolutionThree(int[] arr, int d, int n) {
        d = d % n;

        int i, j, k, temp;
        int gcd = Gcd.solutionEuclideanAlgorithmViaModuloOperator(d, n);

        for (i = 0; i < gcd; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n) {
                    k = k - n;
                }

                if (k == i) {
                    break;
                }

                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }
}
