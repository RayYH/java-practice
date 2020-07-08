package com.rayyounghong.ds.queue;

/**
 * @author ray
 */
public class QueueOverflowException extends RuntimeException {
    private static final long serialVersionUID = -5714967393158963547L;

    /**
     * Constructs an {@code QueueOverflowException} with no detail message.
     */
    public QueueOverflowException() {
        super();
    }

    /**
     * Constructs an {@code QueueOverflowException} with the specified detail message.
     *
     * @param s
     *            the detail message.
     */
    public QueueOverflowException(String s) {
        super(s);
    }
}
