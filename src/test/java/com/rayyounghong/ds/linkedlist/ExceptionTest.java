package com.rayyounghong.ds.linkedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author ray
 */
public class ExceptionTest {

    private void throwsEmptyListExceptionWithMessage() {
        throw new EmptyListException("Empty list");
    }

    @Test
    void testThrowsEmptyListException() {
        assertThrows(EmptyListException.class, this::throwsEmptyListExceptionWithMessage);
        assertThrows(EmptyListException.class, this::throwsEmptyListExceptionWithMessage, "Empty list");
    }

    private void throwsNoSuchElementExceptionWithMessage() {
        throw new NoSuchElementException("No such element");
    }

    private void throwsNoSuchElementException() {
        throw new NoSuchElementException();
    }

    @Test
    void testThrowsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, this::throwsNoSuchElementException);
        assertThrows(NoSuchElementException.class, this::throwsNoSuchElementExceptionWithMessage);
        assertThrows(NoSuchElementException.class, this::throwsNoSuchElementExceptionWithMessage, "No such element");
    }

}
