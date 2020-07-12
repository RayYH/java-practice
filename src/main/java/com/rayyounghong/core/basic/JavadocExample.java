package com.rayyounghong.core.basic;

/**
 * {@link JavadocExample} class.
 *
 * @author ray
 * @version 0.1
 * @since 0.1
 */
public class JavadocExample {

    /**
     * static number.
     */
    public static int staticNumber = 1;

    /**
     * Get value.
     *
     * @param value
     *            given value.
     * @throws IllegalArgumentException
     *             throws an{@link IllegalArgumentException} when {@code value < 0}
     * @return returned value.
     */
    public int validMethod(int value) throws IllegalArgumentException {
        if (value < 0) {
            throw new IllegalArgumentException("Illegal argument");
        }

        return value;
    }

    /**
     * Get value.
     *
     * @deprecated Use {@code validMethod(int value)} instead.
     * @see com.rayyounghong.core.basic.JavadocExample#validMethod(int value)
     * @see <a href="google.com">Google</a>
     * @return returned value.
     */
    @Deprecated
    public int deprecatedMethod() {
        return 0;
    }
}
