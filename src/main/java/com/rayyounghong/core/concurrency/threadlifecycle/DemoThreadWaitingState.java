package com.rayyounghong.core.concurrency.threadlifecycle;

/**
 * @author ray
 */
public class DemoThreadWaitingState implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        System.out.println(WaitingState.t1.getState());
    }
}
