package com.rayyounghong.core.concurrency.volatilekeyword;

/**
 * Every read of a {@code volatile} variable will be read from <strong>the computer's main memory</strong>, and not from
 * the CPU cache, and that every write to a {@code volatile} variable will be written to main memory, and not just to
 * the CPU cache.
 *
 * Reading from and writing to main memory is <strong>more expensive than accessing the CPU cache</strong>. Accessing
 * volatile variables also prevent instruction reordering which is a normal performance enhancement technique. Thus, you
 * should only use volatile variables when you really need to enforce visibility of variables.
 *
 * @author ray
 */
public class VolatileData {
    private volatile int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void changeCounter(int counter) {
        System.out.println("counter will be assigned to: " + counter);
        // cannot use counter++ -> must be atomic
        this.counter = counter;
    }
}
