package com.rayyounghong.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 求给定正整数 n 的所有因数，solutionOne 从 1 遍历至 n，solutionTwo 从 1 遍历至 sqrt(n).
 *
 * solutionOne 使用 LinkedHashSort 保证了从 1 到 n，所有满足条件的因数递增加入到 set 中。
 *
 * solutionTwo 加入的因数是无序的，因为如果 x*y=n，则会同时将 x 和 y 都加入到 set，从而是无序的。
 *
 * solutionThree 基于 solutionTwo，但是保证了返回的 List 是排序后的。
 *
 * @author ray
 * @date 2020/6/22
 */
public class Divisor {

    /**
     * Time Complexity : O(n) Auxiliary Space : O(1)
     *
     * @param n
     *            given number
     * @return set
     */
    public static Set<Integer> solutionOne(int n) {
        // 使用 LinkedHashSet 为了保证有序
        Set<Integer> set = new LinkedHashSet<>();

        if (n == 0) {
            return set;
        }

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
            }
        }

        return set;
    }

    /**
     * Time Complexity : O(sqrt(n)) Auxiliary Space : O(1)
     *
     * @param n
     *            given number
     * @return set
     */
    public static Set<Integer> solutionTwo(int n) {
        Set<Integer> set = new HashSet<>();

        if (n == 0) {
            return set;
        }

        addDivisors(set, n);

        return set;
    }

    /**
     * Time Complexity : O(sqrt(n)) Auxiliary Space : O(1)
     *
     * @param n
     *            given number
     * @return list
     */
    public static List<Integer> solutionThree(int n) {
        List<Integer> list = new ArrayList<>();

        if (n == 0) {
            return list;
        }

        addDivisors(list, n);
        Collections.sort(list);

        return list;
    }

    /**
     * Add divisors to set or list.
     *
     * @param collection
     *            given collection
     * @param n
     *            given number
     */
    private static void addDivisors(Collection<Integer> collection, int n) {
        // Note that this loop runs till square root
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    collection.add(i);
                } else {
                    collection.add(i);
                    collection.add(n / i);
                }
            }
        }
    }
}
