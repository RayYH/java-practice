package com.rayyounghong.core.concurrency.threadlifecycle;

/**
 * @author ray
 */
public class DemoThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
