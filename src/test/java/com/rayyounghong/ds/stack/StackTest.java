package com.rayyounghong.ds.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class StackTest {
    @Test
    void testStackBasicOperations() {
        Stack s = new Stack();
        assertTrue(s.isEmpty());
        assertTrue(s.push(1));
        assertTrue(s.push(2));
        assertTrue(s.push(3));
        assertFalse(s.isEmpty());
        assertEquals(3, s.pop());
        assertEquals(2, s.peek());
        assertEquals(2, s.pop());
        assertEquals(1, s.pop());
        assertTrue(s.isEmpty());

        // add 1000 elements to stack
        for (int i = 0; i < 1000; i++) {
            s.push(1);
        }

        assertThrows(StackOverflowException.class, () -> s.push(1));

        for (int i = 0; i < 1000; i++) {
            s.pop();
        }

        assertThrows(StackUnderflowException.class, s::pop);
        assertThrows(StackUnderflowException.class, s::peek);
    }
}