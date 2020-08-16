package com.rayyounghong.core.concurrency.threadlifecycle;

/**
 * A thread is in {@code WAITING} state when it's waiting for some other thread to perform a particular action.
 *
 * <ul>
 * <li>{@code object.wait()}</li>
 * <li>{@code thread.join()}</li>
 * <li>{@code LockSupport.park()}</li>
 * </ul>
 *
 * @author ray
 */
public class WaitingState implements Runnable {
    public static Thread t1;

    public static void main(String[] args) {
        t1 = new Thread(new WaitingState());
        t1.start();
    }

    @Override
    public void run() {
        Thread t2 = new Thread(new DemoThreadWaitingState());
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
