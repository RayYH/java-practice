package com.rayyounghong.core.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class VariableTest {

    String instanceVariable = "one";

    public static String staticVariable = "one";

    @Test
    void testArray() {
        // allocate the space then initialize it
        int[] firstArray = new int[3];
        firstArray[0] = 10;
        firstArray[1] = 20;
        firstArray[2] = 30;
        for (int i = 0; i < firstArray.length; i++) {
            assertEquals(firstArray[i], 10 * (i + 1));
        }
        // use literal to initialize an array
        int[] secondArray = {
            10, 20, 30
        };
        for (int i = 0; i < secondArray.length; i++) {
            assertEquals(secondArray[i], 10 * (i + 1));
        }
        // use new int[]
        int[] thirdArray = new int[]{
            10, 20, 30
        };
        for (int i = 0; i < thirdArray.length; i++) {
            assertEquals(thirdArray[i], 10 * (i + 1));
        }
    }

    @Test
    void testMultipleArray() {
        // initialize a tow-dimensional array
        int[][] multipleArray = {
            {10},
            {20, 21},
            {30, 31, 32}
        };
        for (int i = 0; i < multipleArray.length; i++) {
            for (int j = 0; j < multipleArray[i].length; j++) {
                assertEquals(multipleArray[i][j], 10 * (i + 1) + j);
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
}
