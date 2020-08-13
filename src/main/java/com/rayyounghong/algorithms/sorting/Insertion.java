package com.rayyounghong.algorithms.sorting;

/**
 * <p>
 * Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is
 * much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.
 * </p>
 *
 * @author ray
 */
public class Insertion implements Sortable {
    @Override
    public <T extends Comparable<T>> void sort(T[] unsorted) {
        int i = 1;
        while (i < unsorted.length) {
            T key = unsorted[i];
            int j = i - 1;
            while (j >= 0 && Utils.lessThan(key, unsorted[j])) {
                unsorted[j + 1] = unsorted[j];
                j--;
            }
            unsorted[j + 1] = key;
            i++;
        }
    }
}
