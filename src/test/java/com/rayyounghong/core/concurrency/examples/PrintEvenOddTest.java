package com.rayyounghong.core.concurrency.examples;

import com.rayyounghong.StandardIOTest;
import com.rayyounghong.core.concurrency.examples.evenandodd.Printer;
import com.rayyounghong.core.concurrency.examples.evenandodd.TaskEvenOdd;
import com.rayyounghong.helper.OSEnum;
import com.rayyounghong.helper.Os;
import java.io.IOException;
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
    void testWaitNotify() throws IOException {
        outContent.flush();
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
        assertEquals("1 2 3 4 5 6 7 8 9 10 ", outContent.toString());
    }

}
