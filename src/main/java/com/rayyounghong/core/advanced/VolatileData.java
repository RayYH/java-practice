package com.rayyounghong.core.advanced;

/**
 * @author ray
 * @date 2020/7/7
 */
public class VolatileData {
    private volatile int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void changeCounter(int counter) {
        // cannot use counter++ -> must be atomic
        this.counter = counter;
    }
}
