package com.rayyounghong.core.advanced;

import com.rayyounghong.StandardIOTest;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class VolatileTest {
    private final static int noOfThreads = 2;

    @Test
    void testVolatile() throws InterruptedException {
        System.out.println("Below are std output from VolatileTest: ");
        // object of VolatileData class
        VolatileData volatileData = new VolatileData();
        // creating Thread array
        Thread[] threads = new Thread[noOfThreads];
        for (int i = 0; i < noOfThreads; ++i) {
            threads[i] = new VolatileThread(volatileData);
        }
        // starts all reader threads
        for (int i = 0; i < noOfThreads; ++i) {
            threads[i].start();
        }
        // wait for all threads
        for (int i = 0; i < noOfThreads; ++i) {
            threads[i].join();
        }
    }
}
