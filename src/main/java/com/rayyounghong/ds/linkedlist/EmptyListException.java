package com.rayyounghong.ds.linkedlist;

import java.io.Serial;

/**
 * @author ray
 */
public class EmptyListException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1774307132060448366L;

    /**
     * Constructs an {@code EmptyListException} with no detail message.
     */
    public EmptyListException() {
        super();
    }

    /**
     * Constructs an {@code EmptyListException} with the specified detail message.
     *
     * @param s
     *            the detail message.
     */
    public EmptyListException(String s) {
        super(s);
    }

}
