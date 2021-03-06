package com.rayyounghong.core.synchronization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class SynchronizedTest {

    static final int MAX_TIME_OUT = 2000;

    /*
     * see: https://stackoverflow.com/questions/21812396/what-is-the-use-of-static-synchronized-method-in-java
     *
     * When a resource that is being accessed concurrently belongs to each instance of your class,
     * you use a synchronized instance method;
     *
     * when the resource belongs to all instances (i.e. when it is in a static variable) then you
     * use a synchronized static method to access it.
     */

    /**
     * 不使用 synchronized 方法
     */
    @Test
    public void givenMultiThreadWhenNonSyncMethod() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SynchronizedDemo summation = new SynchronizedDemo();
        IntStream.range(0, MAX_TIME_OUT).forEach(count -> service.submit(summation::calculate));
        try {
            service.awaitTermination(MAX_TIME_OUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 并不是任何时候都会小于 MAX_TIME_OUT，比如 github 的 actions 就会等于
        assertTrue(summation.getSum() <= MAX_TIME_OUT);
    }

    /**
     * 使用 synchronized 方法
     */
    @Test
    public void givenMultiThreadWhenSyncMethod() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SynchronizedDemo summation = new SynchronizedDemo();
        IntStream.range(0, MAX_TIME_OUT).forEach(count -> service.submit(summation::synchronizedCalculate));
        try {
            service.awaitTermination(MAX_TIME_OUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(MAX_TIME_OUT, summation.getSum());
    }

    /**
     * 使用 synchronized 静态方法
     */
    @Test
    public void givenMultiThreadWhenSyncStaticMethod() {
        SynchronizedDemo.staticSum = 0;
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, MAX_TIME_OUT)
            .forEach(count -> service.submit(SynchronizedDemo::staticSynchronizedCalculate));
        try {
            service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(MAX_TIME_OUT, SynchronizedDemo.staticSum);
    }

    /**
     * synchronized 块
     */
    @Test
    public void givenMultiThreadWhenSyncBlock() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        IntStream.range(0, MAX_TIME_OUT).forEach(count -> service.submit(synchronizedDemo::performSynchronizedTask));
        try {
            service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(MAX_TIME_OUT, synchronizedDemo.getSum());
    }

    /**
     * 静态方法中的 synchronized 块
     */
    @Test
    public void givenMultiThreadWhenSyncStaticBlock() {
        SynchronizedDemo.staticSum = 0;
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, MAX_TIME_OUT)
            .forEach(count -> service.submit(SynchronizedDemo::performStaticSynchronizedTask));
        try {
            // github actions - windows os is too slow.
            service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(MAX_TIME_OUT, SynchronizedDemo.staticSum);
    }
}
