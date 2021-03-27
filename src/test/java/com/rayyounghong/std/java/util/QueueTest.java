package com.rayyounghong.std.java.util;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author ray
 */
public class QueueTest {

    private Queue<Integer> makeQueue() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }

        return queue;
    }

    private Queue<Integer> makeEmptyQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.remove();
        return queue;
    }

    @Test
    void testAdd() {
        // add(E e): Inserts the specified element into this queue if it is possible
        // to do so immediately without violating capacity restrictions, returning
        // true upon success and throwing an IllegalStateException if no space
        // is currently available.

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        assertEquals(queue.toString(), "[1]");
    }

    @Test
    void testElement() {
        // element(): Retrieves, but does not remove, the head of this queue.

        Queue<Integer> queue = makeQueue();
        Integer item = queue.element();
        assertEquals(item, 0);

        // element() will throw an exception when queue is empty
        assertThrows(NoSuchElementException.class, () -> {
            Queue<Integer> emptyQueue = makeEmptyQueue();
            emptyQueue.element();
        });
    }

    @Test
    void testOffer() {
        // offer(E e): Inserts the specified element into this queue if it is possible
        // to do so immediately without violating capacity restrictions.

        Queue<Integer> queue = makeQueue();
        queue.offer(5);
        assertEquals(queue.toString(), "[0, 1, 2, 3, 4, 5]");
    }

    @Test
    void testPeek() {
        // peek(): Retrieves, but does not remove, the head of this queue,
        // or returns null if this queue is empty.

        Queue<Integer> queue = makeQueue();

        Integer item = queue.peek();
        assertEquals(item, 0);
        item = queue.peek();
        assertEquals(item, 0);

        Queue<Integer> emptyQueue = makeEmptyQueue();
        item = emptyQueue.peek();
        assertNull(item);
    }

    @Test
    void testPoll() {
        // poll(): Retrieves and removes the head of this queue,
        // or returns null if this queue is empty.

        Queue<Integer> queue = makeQueue();
        Integer item = queue.poll();
        assertEquals(item, 0);
        assertEquals(queue.toString(), "[1, 2, 3, 4]");

        for (int i = 1; i <= 4; i++) {
            assertEquals(i, queue.poll());
        }

        assertNull(queue.poll());
    }

    @Test
    void testRemove() {
        // remove(): Retrieves and removes the head of this queue.

        Queue<Integer> queue = makeQueue();
        Integer item = queue.remove();
        assertEquals(item, 0);

        Queue<Integer> emptyQueue = makeEmptyQueue();
        assertThrows(NoSuchElementException.class, emptyQueue::remove);
    }
}
