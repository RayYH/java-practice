package com.rayyounghong.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author ray
 * @date 2020/7/3
 */
public class SelectionSortTest {

    @Test
    void testSort() {
        int[] arr = {3, 1, 2, 4, 6};
        SelectionSort.sort(arr);
        assertArrayEquals(new int[] {1, 2, 3, 4, 6}, arr);
    }
}
