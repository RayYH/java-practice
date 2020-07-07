package com.rayyounghong.ds.arrays;

import com.rayyounghong.algorithms.mathematical.Gcd;

/**
 * Function to left rotate arr[] of size n by d.
 *
 * 将长度为 n 的数组 arr 中的元素整体向左移动 d 个位置。
 *
 * @author ray
 * @date 2020/6/22
 */
public class RotateArray {

    /**
     * 算法 1
     *
     * <ol>
     * <li>新建长度为 d 的临时数组并存入前 d 个元素</li>
     * <li>把 d 位置后面的所有元素整体前移 d 位</li>
     * <li>把临时数组中的元素依次放到后面 d 个位置上</li>
     * </ol>
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
     * 算法 2
     *
     * <ol>
     * <li>所有数组整体左移依次，即，arr[v1,v2,...vn] -> arr[v2,v3,...vn,v1]</li>
     * <li>对上面的步骤重复 d 次</li>
     * </ol>
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
     * 算法 3 - 算法 2 的改进，算法的一个思想是先分类，分类的原则很简单，求得 d 和 n 的最大公约数，设为 gcd。
     *
     * 我们需要分成 {0,0+gcd, 0+gcd*2, ...}, {1, 1+gcd, 1+gcd*2, ...}, {gcd-1, gcd-1+gcd*1, gcd-1+gcd*2, ...} 这几个列表
     *
     * 这里里面的值代表数组中的索引值。
     *
     * 对每个列表中的元素，依次左移 gcd 个偏移量即可达成目标。
     *
     * n = 12, d = 3, gcd = 3
     * <ol>
     * <li>{1 2 3 4 5 6 7 8 9 10 11 12}</li>
     * <li>{4 2 3 7 5 6 10 8 9 1 11 12}</li>
     * <li>{4 5 3 7 8 6 10 11 9 1 2 12}</li>
     * <li>{4 5 6 7 8 9 10 11 12 1 2 3}</li>
     * </ol>
     *
     * 其实仔细想一想，左移数组的算法的最终目标是：保证所有元素都在它门该在的位置上，所以这种算法更加容易理解了。
     *
     * 下面我们来讲实现。
     *
     * <ol>
     * <li>求出 gcd(d, n)</li>
     * </ol>
     *
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
        // 处理 d >=n 的情况，因为在我们的欧几里得算法实现下 gcd(36, 12) = 12 而 gcd(0, 12) = 0
        d = d % n;

        int i, j, k, temp;
        int gcd = Gcd.solutionEuclideanAlgorithmViaModuloOperator(d, n);

        // Let arr[] be {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12} and d is 3
        // then gcd = 3, i from 0 to 2.
        for (i = 0; i < gcd; i++) {
            /* move i-th values of blocks */
            // 临时变量存入 i 第一个元素
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                // 整个算法的难点便在下面的两个 if
                // k = k-n 其实就是下一个索引，即循环绕回来的索引，第一次看这个语句可能会陷入其中
                // 索引 >= n 之后的索引就是 0+(k-n) 仅此而已
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
     * 思想：数组块交换，以 d 为界限切割数组，长度为 d 和 n-d 中的最小值。
     *
     * 比如可能有 arr = A B1 B2 三块，其中 B2 长度和 A 长度相等，交换该两个数组块，得到 B2 B1 A
     *
     * 这里 A = arr[0,1,...d-1], [B1B2] = arr[d,d+1,...n]
     *
     * 此时 A 数组块已经在它该在的位置，这时我们需要处理 B2B1，处理的方式同理，还是取较短长度的数组块，两两交换。
     *
     * 其实问题已经变成了在 B2B1 块中移动左移 d 位。
     *
     * 注意，我们取的最小的块应始终为靠右的块。
     *
     * 这个算法理解起来简单但写起来复杂，而且没其他算法实用，不建议深入探讨。
     *
     *
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

        if (d == 0 || d % n == 0) {
            return;
        }

        int i, j, x;
        // last index of first block
        i = d;
        // first index of second block
        j = n - d;

        while (i != j) {
            /*A is shorter*/
            x = d - i;
            if (i < j) {
                swap(arr, x, d + j - i, i);
                j -= i;
            } else { /*B is shorter*/
                swap(arr, x, d, j);
                i -= j;
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
