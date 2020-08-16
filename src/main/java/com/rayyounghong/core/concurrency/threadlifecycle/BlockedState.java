package com.rayyounghong.core.concurrency.threadlifecycle;

/**
 * A thread is in the {@code BLOCKED} state when it's currently not eligible to run. It enters this state when it is
 * waiting for a monitor lock and is trying to access a section of code that is locked by some other thread.
 *
 * @author ray
 */
public class BlockedState {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoThreadBlockingState());
        Thread t2 = new Thread(new DemoThreadBlockingState());

        t1.start();
        t2.start();

        Thread.sleep(1000);

        System.out.println(t2.getState());
        System.exit(0);
    }
}
