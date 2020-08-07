package com.rayyounghong.core.concurrency.examples.printsequence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ray
 */
public class PrintSequenceRunnable implements Runnable {
    public static int maxNumber = 100;
    static int number = 1;
    public static int base = 3;
    int remainder;
    static final Object LOCK = new Object();

    PrintSequenceRunnable(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while (number < maxNumber - 1) {
            synchronized (LOCK) {
                // wait for numbers other than remainder
                while (number % base != remainder) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                LOCK.notifyAll();
            }
        }
    }

    public static void startThreads() {
        ExecutorService executorService = Executors.newFixedThreadPool(base);
        for (int i = 0; i < base; i++) {
            PrintSequenceRunnable runnable = new PrintSequenceRunnable(i);
            executorService.submit(runnable);
        }
        try {
            int timeOut = 2000;
            executorService.awaitTermination(timeOut, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
