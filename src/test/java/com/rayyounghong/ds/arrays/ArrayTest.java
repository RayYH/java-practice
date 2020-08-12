package com.rayyounghong.ds.arrays;

import com.rayyounghong.helper.DisableInspection;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author ray
 */
public class ArrayTest {
    @Test
    void testFindElement() {
        int[] arr = new int[] {12, 34, 10, 6, 40};
        int length = arr.length;
        assertThrows(IllegalArgumentException.class, () -> {
            int res = Array.findElement(arr, -1, 1);
            DisableInspection.doWhatEver(res);
        });
        assertEquals(-1, Array.findElement(arr, length, 100));
        assertEquals(-1, Array.findElement(arr, length, 200));
        assertEquals(0, Array.findElement(arr, length, 12));
        assertEquals(4, Array.findElement(arr, length, 40));
        assertEquals(-1, Array.findElement(arr, 100));
        assertEquals(-1, Array.findElement(arr, 200));
        assertEquals(0, Array.findElement(arr, 12));
        assertEquals(4, Array.findElement(arr, 40));
    }

    @Test
    void testBinarySearch() {
        int[] arr = new int[] {6, 12, 40, 88, 130};
        int length = arr.length;
        assertEquals(-1, Array.binarySearch(arr, 0, length - 1, 100));
        assertEquals(-1, Array.binarySearch(arr, 0, length - 1, 200));
        assertEquals(1, Array.binarySearch(arr, 0, length - 1, 12));
        assertEquals(2, Array.binarySearch(arr, 0, length - 1, 40));
        assertEquals(4, Array.binarySearch(arr, 0, length - 1, 130));
        assertEquals(-1, Array.binarySearch(arr, 100));
        assertEquals(-1, Array.binarySearch(arr, 200));
        assertEquals(1, Array.binarySearch(arr, 12));
        assertEquals(2, Array.binarySearch(arr, 40));
        assertEquals(4, Array.binarySearch(arr, 130));
    }

    @Test
    void testInsertElementAtEnd() {
        int capacity = 10;
        int[] arr = new int[capacity];
        arr[0] = 12;
        arr[1] = 34;
        int index = Array.insertElementAtEnd(arr, 2, 30, capacity);
        assertEquals(arr[index - 1], 30);
    }

    @Test
    void testDeleteElement() {
        int[] arr = {10, 50, 30, 40, 20};
        int n = arr.length;
        int key = 30;
        int res = Array.deleteElement(arr, n, key);
        assertEquals(res, n - 1);
        assertEquals(Arrays.toString(arr), "[10, 50, 40, 20, 0]");
    }

    @Test
    void testBasicMethodsOfArray() {
        int[] arr = {10, 50, 30, 40, 20};
        assertEquals(50, Array.max(arr));
        assertEquals(10, Array.min(arr));
        assertEquals(150, Array.sum(arr));
        assertEquals(30, Array.average(arr));
        assertArrayEquals(new int[] {10, 50, 30, 40, 20}, Array.copy(arr));
        Array.reverse(arr);
        assertArrayEquals(new int[] {20, 40, 30, 50, 10}, arr);
    }
}
