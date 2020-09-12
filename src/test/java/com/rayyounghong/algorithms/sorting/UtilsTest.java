package com.rayyounghong.algorithms.sorting;

import com.rayyounghong.StandardIOTest;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author ray
 */
public class UtilsTest extends StandardIOTest {

    @Test
    void testLessThan() {
        Integer arr[] = {1, 2, 3, 4, 5};
        assertTrue(Utils.lessThan(arr[0], arr[1]));
        assertTrue(Utils.lessThan(arr, 0, 1));
        assertEquals(1, Utils.min(arr, 0, 1));
        assertEquals(2, Utils.max(arr, 0, 1));
        Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);
        assertTrue(Utils.lessThan(comparator, arr[0], arr[1]));
        assertTrue(Utils.isSorted(arr));
        assertTrue(Utils.isSorted(arr, comparator));
        Utils.exchange(arr, 0, 1);
        assertFalse(Utils.isSorted(arr));
        assertTrue(Utils.isSorted(arr, 2, 4));
        assertTrue(Utils.isSorted(arr, comparator, 2, 4));
        Utils.show(arr);
        assertEquals("21345", outContent.toString());
    }

}
