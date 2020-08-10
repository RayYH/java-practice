package com.rayyounghong.algorithms.sorting;

import java.util.Arrays;
import java.util.List;

/**
 * @author ray
 */
public interface Sortable {
    /**
     * Main method arrays sorting algorithms
     *
     * @param unsorted
     *            - an array should be sorted
     */
    <T extends Comparable<T>> void sort(T[] unsorted);
}
