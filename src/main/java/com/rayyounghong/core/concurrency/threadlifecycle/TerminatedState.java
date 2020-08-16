package com.rayyounghong.core.concurrency.threadlifecycle;

/**
 * It's in the {@code TERMINATED} state when it has either finished execution or was terminated abnormally.
 *
 * @author ray
 */
public class TerminatedState implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TerminatedState());
        t1.start();
        Thread.sleep(1000);
        System.out.println(t1.getState());
    }

    @Override
    public void run() {
        // No processing in this block
    }
}
