package com.rayyounghong.core.concurrency.runvsstart;

import java.util.concurrent.TimeUnit;

/**
 * @author ray
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("My Thread");
        }
    }
}
