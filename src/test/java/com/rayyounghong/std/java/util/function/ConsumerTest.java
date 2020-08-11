package com.rayyounghong.std.java.util.function;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class ConsumerTest {

    @Test
    void test() {
        String rawStr = "Test String  ";
        Consumer<String> consumer1 = arg -> assertEquals(rawStr, arg);
        consumer1.accept(rawStr);
        Consumer<String> consumer2 = arg -> assertEquals(rawStr.trim(), arg.trim());
        consumer1.andThen(consumer2).accept(rawStr);
    }

    @Test
    void testPrimitiveConsumer() {
        IntConsumer intConsumer = arg -> assertEquals(2, arg + 1);
        intConsumer.accept(1);
        LongConsumer longConsumer1 = arg -> assertEquals(2L, arg + 1);
        LongConsumer longConsumer2 = arg -> assertEquals(3L, arg + 2);
        longConsumer1.andThen(longConsumer2).accept(1L);
    }
}
