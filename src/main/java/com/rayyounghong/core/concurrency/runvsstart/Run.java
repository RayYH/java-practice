package com.rayyounghong.core.concurrency.runvsstart;

import java.util.concurrent.TimeUnit;

/**
 * @author ray
 */
public class Run {
    public static void main(String[] args) {
        new MyThread().run();
        int limit = 10;
        for (int i = 0; i < limit; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Main");
        }
    }
}
