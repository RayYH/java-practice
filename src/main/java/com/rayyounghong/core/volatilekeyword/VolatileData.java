package com.rayyounghong.core.volatilekeyword;

/**
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
