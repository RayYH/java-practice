package com.rayyounghong.algorithms.sorting;

/**
 * <b>Bubble sort</b>, sometimes referred to as <b>sinking sort</b>, is a simple sorting algorithm that repeatedly steps
 * through the list, compares adjacent elements and swaps them if they are in the wrong order. The pass through the list
 * is repeated until the list is sorted.
 *
 * <a href="https://stackoverflow.com/questions/16195092/optimized-bubble-sort-java">Optimized Bubble Sort (Java)</a>
 *
 * @author ray
 */
public class Bubble implements Sortable {

    @Override
    public <T extends Comparable<T>> void sort(T[] unsorted) {
        int lastSwappedIndex = unsorted.length - 1;
        for (int i = 0; i < unsorted.length - 1; i++) {
            boolean swapped = false;
            int currentSwappedIndex = -1;
            for (int j = 0; j < lastSwappedIndex; j++) {
                if (Utils.lessThan(unsorted, j + 1, j)) {
                    swapped = true;
                    currentSwappedIndex = j;
                    Utils.exchange(unsorted, j + 1, j);
                }
            }

            if (!swapped) {
                break;
            }

            lastSwappedIndex = currentSwappedIndex;
        }
    }

}
