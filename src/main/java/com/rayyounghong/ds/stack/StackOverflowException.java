package com.rayyounghong.ds.stack;

/**
 * @author ray
 * @date 2020/7/5
 */
public class StackOverflowException extends RuntimeException {
    private static final long serialVersionUID = 1123440597410968370L;

    /**
     * Constructs an {@code StackOverflowException} with no detail message.
     */
    public StackOverflowException() {
        super();
    }

    /**
     * Constructs an {@code StackOverflowException} with the specified detail message.
     *
     * @param s
     *            the detail message.
     */
    public StackOverflowException(String s) {
        super(s);
    }
}
