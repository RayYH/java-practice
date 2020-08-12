package com.rayyounghong.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public abstract class SortingTest {
    private final Supplier<Sortable> sortingAlgorithm;

    public SortingTest(Supplier<Sortable> sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    @Test
    public void testSortingNumbers() {
        var sortingAlgorithm = this.sortingAlgorithm.get();
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        sortingAlgorithm.sort(integers);
        assertArrayEquals(new Integer[] {1, 4, 6, 9, 12, 23, 54, 78, 231}, integers);
    }

    @Test
    public void testSortingStrings() {
        var sortingAlgorithm = this.sortingAlgorithm.get();
        String[] strings = {"c", "a", "e", "b", "d"};
        sortingAlgorithm.sort(strings);
        assertArrayEquals(new String[] {"a", "b", "c", "d", "e"}, strings);
    }

    @Test
    public void testRandomInts() {
        var sortingAlgorithm = this.sortingAlgorithm.get();
        Random random = new Random();
        int elementCount = 1000;
        Integer[] integers = random.ints(elementCount).boxed().toArray(Integer[]::new);
        sortingAlgorithm.sort(integers);
        assertTrue(Utils.isSorted(integers));
    }
}
