package com.rayyounghong.core.variables;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rayyounghong.helper.DisableInspection;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
class VariableTest {

    String instanceVariable = "one";

    public static String staticVariable = "one";

    /*
     * There are 4 types of variables in Java programming language:
     *
     * 1. Instance Variables (Non-Static Fields)
     * 2. Class Variables (Static Fields)
     * 3. Local Variables
     * 4. Parameters
     */

    @Test
    void testArray() {
        // allocate the space then initialize it
        int[] firstArray = new int[3];
        // default value is zero
        for (int value : firstArray) {
            assertEquals(0, value);
        }
        firstArray[0] = 10;
        firstArray[1] = 20;
        firstArray[2] = 30;
        for (int i = 0; i < firstArray.length; i++) {
            assertEquals(10 * (i + 1), firstArray[i]);
        }
        assertEquals("[10, 20, 30]", Arrays.toString(firstArray));
        // use literal to initialize an array
        int[] secondArray = {10, 20, 30};
        for (int i = 0; i < secondArray.length; i++) {
            assertEquals(10 * (i + 1), secondArray[i]);
        }
        // use new int[]
        int[] thirdArray = new int[] {10, 20, 30};
        for (int i = 0; i < thirdArray.length; i++) {
            assertEquals(10 * (i + 1), thirdArray[i]);
        }
    }

    @Test
    void testArraySort() {
        int[] arr = new int[] {4, 9, 1, 35, 12};
        // optimized quick sort
        Arrays.sort(arr);
        assertEquals("[1, 4, 9, 12, 35]", Arrays.toString(arr));
    }

    @Test
    void testMultipleArray() {
        // initialize a tow-dimensional array
        int[][] multipleArray = {{10}, {20, 21}, {30, 31, 32}};
        for (int i = 0; i < multipleArray.length; i++) {
            for (int j = 0; j < multipleArray[i].length; j++) {
                assertEquals(10 * (i + 1) + j, multipleArray[i][j]);
            }
        }

        // for in loop
        for (int[] row : multipleArray) {
            for (int value : row) {
                DisableInspection.doWhatEver(value);
            }
        }
    }

    @Test
    void testArrayCopy() {
        char[] copyFrom = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] copyTo = new char[3];
        /*
         * arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
         *
         * @param      src      the source array.
         * @param      srcPos   starting position in the source array.
         * @param      dest     the destination array.
         * @param      destPos  starting position in the destination data.
         * @param      length   the number of array elements to be copied.
         */
        System.arraycopy(copyFrom, 2, copyTo, 0, 3);
        assertEquals("cde", new String(copyTo));

        // you can also use copyOfRange method of Arrays class.
        copyTo = Arrays.copyOfRange(copyFrom, 2, 5);
        assertEquals("cde", new String(copyTo));
    }

    @Test
    void testLocalVariable() {
        // variables inside function are called local variables
        // local variable must be initialized before using it
        int a = 1;
        assertEquals(1, a);
    }

    @Test
    void testInstanceVariable() {
        assertEquals(instanceVariable, "one");
        this.instanceVariable = "two";
        assertEquals(instanceVariable, "two");
    }

    @Test
    void testStaticVariable() {
        // use class to access a static variable is recommended.
        assertEquals(staticVariable, VariableTest.staticVariable);
    }

    @Test
    void testCast() {
        assertEquals(9, (int)9.997);
        assertEquals(10, (int)Math.round(9.997));
        char c = 'A';
        int n = c + 1;
        assertEquals(66, n);
        byte b = (byte)n;
        assertEquals(66, b);
    }
}
