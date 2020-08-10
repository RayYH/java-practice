package com.rayyounghong.algorithms.sorting;

import java.util.Comparator;

/**
 * @author ray
 */
public class Base {
    /**
     * Is v < w ?
     *
     * @param v
     *            object v
     * @param w
     *            object w
     * @return true if v < w, otherwise false.
     */
    public static boolean less(Comparable<Object> v, Comparable<Object> w) {
        return v.compareTo(w) < 0;
    }

    /**
     * Is v < w ?
     *
     * @param comparator
     *            given specified comparator
     * @param v
     *            object v
     * @param w
     *            object w
     * @return true if v < w, otherwise false.
     */
    public static boolean less(Comparator<Object> comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }

    /**
     * exchange a[i] and a[j]
     *
     * @param a
     *            given array
     * @param i
     *            the first index
     * @param j
     *            the second index
     */
    public static void exchange(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * Is the array a[] sorted?
     *
     * @param a
     *            given array
     * @return true if sorted, otherwise false
     */
    public static boolean isSorted(Comparable<Object>[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    /**
     * Is the array sorted from a[lo] to a[hi]
     *
     * @param a
     *            given array
     * @param lo
     *            low index
     * @param hi
     *            high index
     * @return true if sorted, otherwise false
     */
    public static boolean isSorted(Comparable<Object>[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Is the array a[] sorted?
     *
     * @param a
     *            given array
     * @param comparator
     *            given comparator
     * @return true if sorted, otherwise false
     */
    public static boolean isSorted(Object[] a, Comparator<Object> comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }

    /**
     * Is the array sorted from a[lo] to a[hi]
     *
     * @param a
     *            given array
     * @param comparator
     *            given comparator
     * @param lo
     *            low index
     * @param hi
     *            high index
     * @return true if sorted, otherwise false
     */
    public static boolean isSorted(Object[] a, Comparator<Object> comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(comparator, a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}

/*
 *****************************************************************************
 *  Copyright 2002-2018, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 *****************************************************************************
 */
