package com.rayyounghong.algorithms.sorting;

/**
 * @author ray
 */
public interface Sortable {

    /**
     * Main method arrays sorting algorithms.
     *
     * @param unsorted
     *            an array should be sorted
     * @param <T>
     *            element type
     */
    <T extends Comparable<T>> void sort(T[] unsorted);

}
