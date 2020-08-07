package com.rayyounghong.algorithms.mathematical;

/**
 * @author ray
 */
public class Absolute {
    /**
     * If value is less than zero, make value positive.
     *
     * @param value
     *            a number
     * @return the absolute value of a number
     */
    public static int absValue(int value) {
        return value < 0 ? -value : value;
    }

    /**
     * get the value, return the absolute max value.
     *
     * @param numbers
     *            elements
     * @return the absolute max value
     */
    public static int absMax(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
        int absMaxValue = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (Math.abs(absMaxValue) < Math.abs(numbers[i])) {
                absMaxValue = numbers[i];
            }
        }

        return absMaxValue;
    }

    /**
     * get the value, returns the absolute min value.
     *
     * @param numbers
     *            elements
     * @return the absolute min value
     */
    public static int absMin(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
        int absMinValue = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (Math.abs(absMinValue) > Math.abs(numbers[i])) {
                absMinValue = numbers[i];
            }
        }

        return absMinValue;
    }
}
