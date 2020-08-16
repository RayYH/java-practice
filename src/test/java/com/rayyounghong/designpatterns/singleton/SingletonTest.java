/*
 * The MIT License Copyright © 2014-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.rayyounghong.designpatterns.singleton;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTimeout;

/**
 * PLEASE VIEW licenses/java-design-patterns-license.txt file to get more details of copyrights.
 *
 * @param <S>
 *            Supplier method generating singletons
 * @author Jeroen Meulemeester
 * @author Richard Jones
 * @author ray
 */
public abstract class SingletonTest<S> {
    /**
     * The singleton's getInstance method.
     */
    private final Supplier<S> singletonInstanceMethod;

    /**
     * Create a new singleton test instance using the given 'getInstance' method.
     *
     * @param singletonInstanceMethod
     *            The singleton's getInstance method
     */
    public SingletonTest(Supplier<S> singletonInstanceMethod) {
        this.singletonInstanceMethod = singletonInstanceMethod;
    }

    @Test
    public void testMultipleCallsReturnTheSameObjectInSameThread() {
        var instance1 = this.singletonInstanceMethod.get();
        var instance2 = this.singletonInstanceMethod.get();
        var instance3 = this.singletonInstanceMethod.get();
        assertSame(instance1, instance2);
        assertSame(instance1, instance3);
        assertSame(instance2, instance3);
    }

    /**
     * Test singleton instance in a concurrent setting.
     */
    @Test
    public void testMultipleCallsReturnTheSameObjectInDifferentThreads() {
        assertTimeout(ofMillis(10000), () -> {
            // Create 10000 tasks and inside each callable instantiate the singleton class
            final var tasks = IntStream.range(0, 10000).<Callable<S>>mapToObj(i -> this.singletonInstanceMethod::get)
                .collect(Collectors.toCollection(ArrayList::new));

            // Use up to 8 concurrent threads to handle the tasks
            final var executorService = Executors.newFixedThreadPool(8);
            final var results = executorService.invokeAll(tasks);

            // wait for all of the threads to complete
            final var expectedInstance = this.singletonInstanceMethod.get();
            for (var res : results) {
                final var instance = res.get();
                assertNotNull(instance);
                assertSame(expectedInstance, instance);
            }

            // tidy up the executor
            executorService.shutdown();
        });

    }
}
