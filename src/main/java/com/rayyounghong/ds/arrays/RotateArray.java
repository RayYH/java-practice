package com.rayyounghong.ds.arrays;

import com.rayyounghong.algorithms.mathematical.Gcd;

/**
 * Function to left rotate arr[] of size n by d.
 *
 * @author ray
 */
public class RotateArray {
    /**
     * Divide the array in different sets where number of sets is equal to {@code GCD} of {@code n} and {@code d} and
     * move the elements within sets.
     *
     * For the example array ({@code n = 7} and {@code d =2}), the {@code GCD} is {@code 1}, then elements will be moved
     * within one set only, we just start with {@code temp = arr[0]} and keep moving {@code arr[I+d]} to {@code arr[I]}
     * and finally store temp at the right place.
     *
     * Here is an example array of {@code n = 12, d = 3}, so {@code gcd = 3}, then:
     * <ol>
     * <li>{1 2 3 4 5 6 7 8 9 10 11 12}</li>
     * <li>{4 2 3 7 5 6 10 8 9 1 11 12}</li>
     * <li>{4 5 3 7 8 6 10 11 9 1 2 12}</li>
     * <li>{4 5 6 7 8 9 10 11 12 1 2 3}</li>
     * </ol>
     *
     * Time complexity: {@code O(n)}, Auxiliary Space: {@code O(1)}.
     *
     * @param arr
     *            given array
     * @param d
     *            d
     * @param n
     *            size
     */
    public static void leftRotateSolutionViaGcd(int[] arr, int d, int n) {
        // To handle if d >= n
        d = d % n;

        int i, j, k, temp;
        int gcd = Gcd.solutionEuclideanAlgorithm(d, n);

        // Let arr[] be {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12} and d is 3
        // then gcd = 3, i from 0 to 2.
        for (i = 0; i < gcd; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                // if k >= n, which means k are outer right boundary of the array,
                // so we should count from the beginning, (k - n) is the remaining count.
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

    /**
     * Time complexity : O(n)
     *
     * @param arr
     *            given array
     * @param d
     *            d
     */
    public static void leftRotateSolutionViaReverseArray(int[] arr, int d) {
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
}
