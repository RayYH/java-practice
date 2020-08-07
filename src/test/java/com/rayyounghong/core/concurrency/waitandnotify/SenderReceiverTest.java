package com.rayyounghong.core.concurrency.waitandnotify;

import com.rayyounghong.StandardIOTest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class SenderReceiverTest extends StandardIOTest {

    @Test
    void test() {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Data data = new Data();
        Sender sender = new Sender(data);
        Receiver receiver = new Receiver(data);
        service.submit(sender);
        service.submit(receiver);
        try {
            // 7.5 s
            int MAX_TIME_OUT = 7500;
            service.awaitTermination(MAX_TIME_OUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("First packet\n" + "Second packet\n" + "Third packet\n" + "Fourth packet\n" + "End\n",
            outContent.toString());
    }
}
