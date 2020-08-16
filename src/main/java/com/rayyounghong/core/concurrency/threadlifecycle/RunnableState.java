package com.rayyounghong.core.concurrency.threadlifecycle;

/**
 * When we've created a new thread and called the {@code start()} method on that, it's moved from {@code NEW} to
 * {@code RUNNABLE} state. Threads in this state are either running or ready to run, but they're waiting for resource
 * allocation from the system.
 *
 * @author ray
 */
public class RunnableState implements Runnable {
    public static void main(String[] args) {
        Runnable runnable = new NewState();
        Thread t = new Thread(runnable);
        t.start();
        System.out.println(t.getState());
    }

    @Override
    public void run() {

    }
}
