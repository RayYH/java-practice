package com.rayyounghong.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author ray
 */
public class QuickSortTest {
    @Test
    void testSort() {
        Quick quick = new Quick();
        Integer[] arr = {3, 1, 2, 4, 6};
        quick.sort(arr);
        assertArrayEquals(new Integer[] {1, 2, 3, 4, 6}, arr);
    }
}
