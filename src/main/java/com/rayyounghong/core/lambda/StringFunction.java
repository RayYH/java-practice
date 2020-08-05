package com.rayyounghong.core.lambda;

/**
 * We can ignore the @FunctionalInterface annotation.
 *
 * @author ray
 */
interface StringFunction {
    /**
     * simple method.
     *
     * @param str
     *            string
     * @return string
     */
    String run(String str);
}
