package com.rayyounghong.core.concurrency.threadmethods;

/**
 * @author ray
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        int count = 2;
        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(500);
                System.out.println("Current Thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
