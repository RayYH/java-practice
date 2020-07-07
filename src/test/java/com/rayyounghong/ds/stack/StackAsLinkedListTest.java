package com.rayyounghong.ds.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author ray
 * @date 2020/7/6
 */
public class StackAsLinkedListTest {

    @Test
    void testBasicOperations() {
        StackAsLinkedList s = new StackAsLinkedList();
        assertTrue(s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);
        assertFalse(s.isEmpty());
        assertEquals(3, s.pop());
        assertEquals(2, s.peek());
        assertEquals(2, s.pop());
        assertEquals(1, s.pop());
        assertTrue(s.isEmpty());

        // add 1000 elements to stack will not throws an exception
        for (int i = 0; i < 1000; i++) {
            s.push(1);
        }

        for (int i = 0; i < 1000; i++) {
            s.pop();
        }

        assertThrows(StackUnderflowException.class, s::pop);
        assertThrows(StackUnderflowException.class, s::peek);
    }
}
