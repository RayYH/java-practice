package com.rayyounghong.core.concurrency.stopthread;

import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class StopThreadTest {
    @Test
    void testStopThreads() {
        StopRunnable stopRunnable = new StopRunnable();
        Thread thread = new Thread(stopRunnable, "This thread will be stopped");
        thread.start();
        try {
            Thread.sleep(10L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopRunnable.doStop();
    }
}
