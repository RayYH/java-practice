package com.rayyounghong.ds.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author ray
 */
public class QueueTest {

    @Test
    void testQueueBasicOperations() {
        Queue<Integer> queue = new Queue<>(5);
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertEquals(1, queue.front());
        assertEquals(1, queue.rear());
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertEquals(1, queue.front());
        assertEquals(5, queue.rear());
        assertThrows(QueueOverflowException.class, () -> queue.enqueue(6));
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.front());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertThrows(EmptyQueueException.class, queue::dequeue);
    }
}
