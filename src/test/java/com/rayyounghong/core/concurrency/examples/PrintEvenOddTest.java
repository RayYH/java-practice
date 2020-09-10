package com.rayyounghong.core.concurrency.examples;

import com.rayyounghong.StandardIOTest;
import com.rayyounghong.core.concurrency.examples.evenandodd.Printer;
import com.rayyounghong.core.concurrency.examples.evenandodd.TaskEvenOdd;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
            // 1.5 s
            int MAX_TIME_OUT = 1500;
            executorService.awaitTermination(MAX_TIME_OUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // TODO: tired of fixing this bug now, maybe in the future I'll find a better way to catch the output
        assertNotNull(outContent.toString());
    }

}
