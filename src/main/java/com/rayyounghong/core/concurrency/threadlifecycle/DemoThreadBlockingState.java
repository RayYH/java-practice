package com.rayyounghong.core.concurrency.threadlifecycle;

/**
 * @author ray
 */
public class DemoThreadBlockingState implements Runnable {
    @Override
    public void run() {
        commonResource();
    }

    public static synchronized void commonResource() {
        while (true) {
            // Infinite loop to mimic heavy processing
            // Thread 't1' won't leave this method
            // when Thread 't2' enters this
        }
    }
}
