package com.rayyounghong.algorithms.searching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class LinearSearchTest {

    @Test
    void testLinearSearch() {
        int[] arr = {2, 3, 1, 15, 89};
        assertEquals(0, LinearSearch.search(arr, 2));
        assertEquals(1, LinearSearch.search(arr, 3));
        assertEquals(4, LinearSearch.search(arr, 89));
        assertEquals(-1, LinearSearch.search(arr, 1000));
    }
}
