package com.rayyounghong.algorithms.sorting;

/**
 * In computer science, selection sort is an in-place comparison sorting algorithm.
 *
 * <p>
 * The algorithm divides the input list into two parts: a sorted sublist of items which is built up from left to right
 * at the front (left) of the list and a sublist of the remaining unsorted items that occupy the rest of the list.
 * Initially, the sorted sublist is empty and the unsorted sublist is the entire input list. The algorithm proceeds by
 * finding the smallest (or largest, depending on sorting order) element in the unsorted sublist, exchanging (swapping)
 * it with the leftmost unsorted element (putting it in sorted order), and moving the sublist boundaries one element to
 * the right.
 * </p>
 *
 * @author ray
 */
public class Selection implements Sortable {
    @Override
    public <T extends Comparable<T>> void sort(T[] unsorted) {
        int length = unsorted.length;
        int i, j, minIndex;
        for (i = 0; i < length; i++) {
            minIndex = i;
            for (j = i + 1; j < length; j++) {
                if (Utils.less(unsorted[j], unsorted[minIndex])) {
                    minIndex = j;
                }
            }
            Utils.exchange(unsorted, i, minIndex);
        }
    }
}
