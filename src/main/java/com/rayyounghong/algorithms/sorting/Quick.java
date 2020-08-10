package com.rayyounghong.algorithms.sorting;

/**
 * @author ray
 */
public class Quick implements Sortable {
    @Override
    public <T extends Comparable<T>> void sort(T[] unsorted) {
        sort(unsorted, 0, unsorted.length - 1);
    }

    public <T extends Comparable<T>> void sort(T[] unsorted, int low, int high) {
        if (high <= low) {
            return;
        }
        int partition = partition(unsorted, low, high);
        sort(unsorted, low, partition - 1);
        sort(unsorted, partition + 1, high);
    }

    public <T extends Comparable<T>> int partition(T[] unsorted, int low, int high) {
        int i = low;
        int j = high + 1;
        T pivot = unsorted[i];

        while (true) {
            while (Utils.less(unsorted[++i], pivot)) {
                if (i == high) {
                    break;
                }
            }

            while (Utils.less(pivot, unsorted[--j])) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            Utils.exchange(unsorted, i, j);
        }

        Utils.exchange(unsorted, low, j);

        return j;
    }
}
