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
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        selection.sort(integers);
        assertArrayEquals(new Integer[] {1, 4, 6, 9, 12, 23, 54, 78, 231}, integers);
        String[] strings = {"c", "a", "e", "b", "d"};
        selection.sort(strings);
        assertArrayEquals(new String[] {"a", "b", "c", "d", "e"}, strings);
    }
}
