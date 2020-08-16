package com.rayyounghong.core.concurrency.threadmethods;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

/**
 * @author ray
 */
public class ThreadSleep {
    static void sleep() {
        Runnable runnable = () -> {
            int limit = 100;
            for (int i = 0; i < limit; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("demo-pool-%d").daemon(true).build());
        executorService.submit(runnable);
        try {
            int timeOut = 2000;
            executorService.awaitTermination(timeOut, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sleep();
    }
}
