package com.rayyounghong.algorithms.mathematical;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Get all divisors of given number n.
 *
 * @author ray
 */
public class Divisor {
    /**
     * Time Complexity : O(sqrt(n)) Auxiliary Space : O(1)
     *
     * @param n
     *            given number
     * @return set
     */
    public static Set<Integer> disorderedDivisors(int n) {
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
    public static List<Integer> orderedDivisors(int n) {
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
                    // only add once when n = i*i
                    collection.add(i);
                } else {
                    collection.add(i);
                    collection.add(n / i);
                }
            }
        }
    }
}
