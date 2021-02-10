package com.rayyounghong.ds.queue;

import java.lang.reflect.Array;

/**
 * 队列是一个线性的数据结构，元素的操作顺序遵循 FIFO，即『先进先出』的顺序。本类是 Queue 的一个简单实现，采用了 Array 作为底层存储结构。
 *
 * @param <E>
 *            队列中的元素类型
 * @author ray
 */
public class Queue<E> {
    /** front 队头 rear 队尾 */
    int front, rear;

    /** 队列中已有元素的总数 */
    int size;

    /** 队列所能包含的元素最大数目 */
    int capacity;

    /** 存储队列中元素的底层存储结构 */
    E[] array;

    /**
     * 初始化一个容量为给定值的队列。
     *
     * @param capacity
     *            容量
     */
    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = this.capacity - 1;
        this.array = (E[])Array.newInstance(Object.class, capacity);
    }

    /**
     * 初始化一个容量为 1024 的队列。
     */
    public Queue() {
        this(1024);
    }

    /**
     * 当队列的容量和已经包含的元素数目相等，则队列已满。
     *
     * @return 队列满了返回 true 否则返回 false
     */
    public boolean isFull() {
        return this.size == this.capacity;
    }

    /**
     * 当队列中的元素数目为 0 时，则代表队列已空。
     *
     * @return 队列空了则返回 true 否则返回 false
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 添加一个元素到队列中，如果队列满了会抛出异常。添加队列到元素会改变队列的大小和队尾元素。
     *
     * @param item
     *            待添加的值
     */
    public void enqueue(E item) throws QueueOverflowException {
        if (this.isFull()) {
            throw new QueueOverflowException("Queue Overflow");
        }

        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size++;
    }

    /**
     * 从队列中移除一个元素，如果队列空了会抛出异常。从队列中移除元素会改变队列的大小和队头元素。
     *
     * @return 位于队头的元素
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
     * 获取队头的值，队列不发生变化。
     *
     * @return 位于队头的元素
     */
    public E front() {
        if (this.isEmpty()) {
            throw new EmptyQueueException("Empty queue");
        }

        return this.array[this.front];
    }

    /**
     * 获取队尾的值，队列不发生变化。
     *
     * @return 位于队尾的元素
     */
    public E rear() {
        if (this.isEmpty()) {
            throw new EmptyQueueException("Empty queue");
        }

        return this.array[this.rear];
    }

    /**
     * 获取队列的大小。
     *
     * @return 队列大小
     */
    public int size() {
        return this.size;
    }

    /**
     * 获取队列的容量。
     *
     * @return 队列容量
     */
    public int getCapacity() {
        return this.capacity;
    }
}
