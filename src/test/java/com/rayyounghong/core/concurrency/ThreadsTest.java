package com.rayyounghong.core.concurrency;

import org.junit.jupiter.api.Test;

/**
 * <a href="http://tutorials.jenkov.com/java-concurrency/creating-and-starting-threads.html">Creating and Starting Java
 * Threads</a>
 *
 * There are no rules about which of the two methods ({@link Runnable} or {@link Thread}) that is the best. Both methods
 * works. Personally though, I prefer implementing {@code Runnable}, and handing an instance of the implementation to a
 * {@code Thread} instance. When having the {@code Runnable}'s executed by a thread pool it is easy to queue up the
 * {@code Runnable} instances until a thread from the pool is idle. This is a little harder to do with {@code Thread}
 * subclasses.
 *
 * @author ray
 */
public class ThreadsTest {
    /**
     * the orders of execution are not certain!
     */
    @Test
    void testCreatingThreads() {
        // Thread Subclass
        GreetThread greetThread = new GreetThread();
        greetThread.start();
        // using anonymous subclass
        Thread anonymousThread = new Thread("Anonymous Thread!") {
            @Override
            public void run() {
                System.out.println(getName());
            }
        };
        anonymousThread.start();
        // Runnable Interface Implementation
        GreetRunnable greetRunnable = new GreetRunnable();
        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Runnable");
            }
        };

        // A Java lambda can only implement a single method. You must use a custom class, or a custom interface that
        // extends Runnable which has the extra methods, and which is implemented by an anonymous class.
        Runnable lambdaRunnable = () -> System.out.println("Lambda Runnable!");

        // get current thread name
        Thread thread = Thread.currentThread();
        try {
            // sleep 3 s
            Thread.sleep(3L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Current thread: " + thread.getName());

        // when using new Thread, you can also pass a parameter as thread name
        Thread greetRunnableThread = new Thread(greetRunnable, "Greet Runnable");
        Thread anonymousRunnableThread = new Thread(anonymousRunnable);
        Thread lambdaRunnableThread = new Thread(lambdaRunnable);
        greetRunnableThread.start();
        anonymousRunnableThread.start();
        lambdaRunnableThread.start();
    }

    @Test
    void testStopThreads() {
        StopRunnable stopRunnable = new StopRunnable();
        Thread thread = new Thread(stopRunnable, "This thread will be stopped");
        thread.start();
        try {
            Thread.sleep(10L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopRunnable.doStop();
    }

}
