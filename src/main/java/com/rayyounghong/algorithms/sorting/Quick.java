package com.rayyounghong.algorithms.sorting;

/**
 * <p>
 * Quicksort is an efficient sorting algorithm, and it is still a commonly used algorithm for sorting.
 *
 * Quicksort is a divide-and-conquer algorithm. It works by selecting a 'pivot' element from the array and partitioning
 * the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The
 * sub-arrays are then sorted recursively. This can be done in-place, requiring small additional amounts of memory to
 * perform the sorting.
 *
 * Efficient implementations of Quicksort are not a stable sort, meaning that the relative order of equal sort items is
 * not preserved.
 *
 * Mathematical analysis of quicksort shows that, on average, the algorithm takes O(n log n) comparisons to sort n
 * items. In the worst case, it makes O(n^2) comparisons, though this behavior is rare.
 * </p>
 *
 * <p>
 * The steps for in-place Quicksort are:
 * <ol>
 * <li>Pick an element, called a <i>pivot</i>, from the array.</li>
 * <li><i>Partitioning</i>: reorder the array so that all elements with values less than the <i>pivot</i> come before
 * the <i>pivot</i>, while all elements with values greater than the <i>pivot</i> come after it (equal values can go
 * either way). After this partitioning, the <i>pivot</i> is in its final position. This is called the partition
 * operation.</li>
 * <li>Recursively apply the above steps to the sub-array of elements with smaller values and separately to the
 * sub-array of elements with greater values.</li>
 * </ol>
 * </p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Quicksort">Quick Sort</a>
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
            while (Utils.lessThan(unsorted[++i], pivot)) {
                if (i == high) {
                    break;
                }
            }

            while (Utils.lessThan(pivot, unsorted[--j])) {
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
