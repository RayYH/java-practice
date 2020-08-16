package com.rayyounghong.core.concurrency.threadmethods;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ray
 */
public class ThreadYield {
    static void yieldMethod() {
        int count = 5;
        Runnable runnable = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println("Inside run");
                Thread.yield();
            }
        };

        ThreadFactory namedThreadFactory = Executors.defaultThreadFactory();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        singleThreadPool.execute(runnable);
        singleThreadPool.shutdown();

        for (int i = 0; i < count; i++) {
            System.out.println("Inside yieldMethod");
        }
    }

    public static void main(String[] args) {
        yieldMethod();
    }
}
