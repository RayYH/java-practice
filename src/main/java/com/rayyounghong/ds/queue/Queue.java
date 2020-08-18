package com.rayyounghong.ds.queue;

import java.lang.reflect.Array;

/**
 * Queue is a linear structure which follows a particular order in which the operations are performed. The order is
 * First In First Out (FIFO).
 *
 * @author ray
 */
public class Queue<E> {
    int front, rear, size;
    int capacity;
    E[] array;

    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = this.capacity - 1;
        this.array = (E[])Array.newInstance(Object.class, capacity);
    }

    public Queue() {
        this(1024);
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Add an item to the queue, it changes rear and size.
     *
     * @param item
     *            added value
     */
    public void enqueue(E item) {
        if (this.isFull()) {
            throw new QueueOverflowException("Queue Overflow");
        }

        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size++;
    }

    /**
     * Remove an item from queue, it changes front and size.
     *
     * @return the item at front.
     */
    public E dequeue() {
        if (this.isEmpty()) {
            throw new EmptyQueueException("Empty queue");
        }

        E item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }

    /**
     * Get front of queue.
     *
     * @return item at front.
     */
    public E front() {
        if (this.isEmpty()) {
            throw new EmptyQueueException("Empty queue");
        }

        return this.array[this.front];
    }

    /**
     * Get rear of queue.
     *
     * @return item at rear.
     */
    public E rear() {
        if (this.isEmpty()) {
            throw new EmptyQueueException("Empty queue");
        }

        return this.array[this.rear];
    }
}
