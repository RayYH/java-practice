package com.rayyounghong.ds.queue;

/**
 * @author ray
 */
public class EmptyQueueException extends RuntimeException {
    private static final long serialVersionUID = -2707033849922874618L;

    /**
     * Constructs an {@code EmptyQueueException} with no detail message.
     */
    public EmptyQueueException() {
        super();
    }

    /**
     * Constructs an {@code EmptyQueueException} with the specified detail message.
     *
     * @param s
     *            the detail message.
     */
    public EmptyQueueException(String s) {
        super(s);
    }
}
