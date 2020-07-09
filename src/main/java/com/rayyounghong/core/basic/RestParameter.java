package com.rayyounghong.core.basic;

/**
 * @author ray
 */
public class RestParameter {

    public static double max(double... values) {
        double largest = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            largest = Math.max(largest, v);
        }

        return largest;
    }
}
