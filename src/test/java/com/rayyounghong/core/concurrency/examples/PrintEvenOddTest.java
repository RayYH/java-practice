package com.rayyounghong.core.concurrency.examples;

import com.rayyounghong.StandardIOTest;
import com.rayyounghong.core.concurrency.examples.evenandodd.Printer;
import com.rayyounghong.core.concurrency.examples.evenandodd.TaskEvenOdd;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class PrintEvenOddTest extends StandardIOTest {
    @Test
    void testWaitNotify() {
        int maxNumber = 10;
        Printer printer = new Printer();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        TaskEvenOdd taskEven = new TaskEvenOdd(printer, maxNumber, true);
        TaskEvenOdd taskOdd = new TaskEvenOdd(printer, maxNumber, false);
        executorService.submit(taskEven);
        executorService.submit(taskOdd);
        try {
            // 7.5 s
            int MAX_TIME_OUT = 1500;
            executorService.awaitTermination(MAX_TIME_OUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals("pool-1-thread-2:1\n" + "pool-1-thread-1:2\n" + "pool-1-thread-2:3\n" + "pool-1-thread-1:4\n"
            + "pool-1-thread-2:5\n" + "pool-1-thread-1:6\n" + "pool-1-thread-2:7\n" + "pool-1-thread-1:8\n"
            + "pool-1-thread-2:9\n" + "pool-1-thread-1:10\n", outContent.toString());
    }
}
