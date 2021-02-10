package com.rayyounghong.ds.queue;

import java.io.Serial;

/**
 * @author ray
 */
public class QueueOverflowException extends RuntimeException {
    @Serial
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
