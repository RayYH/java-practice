package com.rayyounghong.ds.linkedlist;

/**
 * @author ray
 */
public class NoSuchElementException extends RuntimeException {

    private static final long serialVersionUID = 7686294110884378769L;

    /**
     * Constructs an {@code NoSuchElementException} with no detail message.
     */
    public NoSuchElementException() {
        super();
    }

    /**
     * Constructs an {@code NoSuchElementException} with the specified detail message.
     *
     * @param s
     *            the detail message.
     */
    public NoSuchElementException(String s) {
        super(s);
    }

}
