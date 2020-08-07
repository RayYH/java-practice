package com.rayyounghong.core.concurrency.examples;

import com.rayyounghong.StandardIOTest;
import com.rayyounghong.core.concurrency.examples.printsequence.PrintSequenceRunnable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ray
 */
public class PrintSequenceTest extends StandardIOTest {
    @Test
    void test() {
        PrintSequenceRunnable.startThreads();
        assertNotNull(outContent.toString());
    }
}
