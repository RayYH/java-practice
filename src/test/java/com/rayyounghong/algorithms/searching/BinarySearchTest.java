package com.rayyounghong.algorithms.searching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class BinarySearchTest {
    @Test
    void testBinarySearch() {
        // sorted array
        int[] arr = {2, 3, 4, 10, 40};
        assertEquals(3, BinarySearch.search(arr, 0, arr.length - 1, 10));
        assertEquals(3, BinarySearch.search(arr, 10));
        assertEquals(-1, BinarySearch.search(arr, 0, arr.length - 1, 100));
        assertEquals(-1, BinarySearch.search(arr, 100));
    }
}
