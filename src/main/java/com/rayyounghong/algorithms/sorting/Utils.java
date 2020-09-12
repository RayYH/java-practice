package com.rayyounghong.algorithms.sorting;

import java.util.Comparator;

/**
 * See licenses/algs4-license.txt file for more detailed info about license.
 *
 * @author ray
 */
public final class Utils {

    /**
     * Determine whether v is less than w.
     *
     * @param v
     *            object v
     * @param w
     *            object w
     * @param <T>
     *            Type
     * @return true if v < w, otherwise false.
     */
    public static <T extends Comparable<T>> boolean lessThan(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * Get min value of two values.
     *
     * @param a
     *            given array
     *
     * @param i
     *            index i
     * @param j
     *            index j
     * @param <T>
     *            Type
     * @return true if a[i] < a[j], otherwise false.
     */
    public static <T extends Comparable<T>> T min(T[] a, int i, int j) {
        return lessThan(a[i], a[j]) ? a[i] : a[j];
    }

    /**
     * get max value.
     *
     * @param a
     *            given array
     *
     * @param i
     *            index i
     * @param j
     *            index j
     * @param <T>
     *            Type
     * @return true if a[i] < a[j], otherwise false.
     */
    public static <T extends Comparable<T>> T max(T[] a, int i, int j) {
        return lessThan(a[i], a[j]) ? a[j] : a[i];
    }

    /**
     * Is a[i] < a[j] ?
     *
     * @param a
     *            given array
     *
     * @param i
     *            index i
     * @param j
     *            index j
     * @param <T>
     *            Type
     * @return true if a[i] < a[j], otherwise false.
     */
    public static <T extends Comparable<T>> boolean lessThan(T[] a, int i, int j) {
        return lessThan(a[i], a[j]);
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
     * @param <T>
     *            Type
     * @return true if v < w, otherwise false.
     */
    public static <T extends Comparable<T>> boolean lessThan(Comparator<T> comparator, T v, T w) {
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
     * @param <T>
     *            Type
     */
    public static <T extends Comparable<T>> void exchange(T[] a, int i, int j) {
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * Is the array a[] sorted?
     *
     * @param a
     *            given array
     * @param <T>
     *            Type
     * @return true if sorted, otherwise false
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
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
     * @param <T>
     *            Type
     * @return true if sorted, otherwise false
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (lessThan(a[i], a[i - 1])) {
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
     * @param <T>
     *            Type
     * @return true if sorted, otherwise false
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] a, Comparator<T> comparator) {
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
     * @param <T>
     *            Type
     * @return true if sorted, otherwise false
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] a, Comparator<T> comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (lessThan(comparator, a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Print elements.
     *
     * @param a
     *            given array.
     * @param <T>
     *            Type
     */
    public static <T extends Comparable<T>> void show(T[] a) {
        for (T objectComparable : a) {
            System.out.print(objectComparable);
        }
    }

}
