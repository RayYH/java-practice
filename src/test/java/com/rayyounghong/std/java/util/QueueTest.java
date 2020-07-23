package com.rayyounghong.std.java.util;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class QueueTest {

    @Test
    void testQueue() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            q.add(i);
        }

        assertEquals("[0, 1, 2, 3, 4]", q.toString());
        assertEquals(0, q.peek());
        assertEquals(5, q.size());
        q.remove();
        assertEquals(4, q.size());
        assertEquals(1, q.peek());
    }
}
