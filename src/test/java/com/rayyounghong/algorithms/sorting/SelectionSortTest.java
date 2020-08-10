package com.rayyounghong.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author ray
 */
public class SelectionSortTest {

    @Test
    void testSort() {
        Selection selection = new Selection();
        Integer[] arr = {3, 1, 2, 4, 6};
        selection.sort(arr);
        assertArrayEquals(new Integer[] {1, 2, 3, 4, 6}, arr);
    }
}
