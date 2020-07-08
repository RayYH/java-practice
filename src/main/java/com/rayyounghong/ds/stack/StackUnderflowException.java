package com.rayyounghong.ds.stack;

/**
 * @author ray
 */
public class StackUnderflowException extends RuntimeException {
    private static final long serialVersionUID = 832722668838220326L;

    /**
     * Constructs an {@code StackUnderflowException} with no detail message.
     */
    public StackUnderflowException() {
        super();
    }

    /**
     * Constructs an {@code StackUnderflowException} with the specified detail message.
     *
     * @param s
     *            the detail message.
     */
    public StackUnderflowException(String s) {
        super(s);
    }
}
