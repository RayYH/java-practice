package com.rayyounghong.core.concurrency.threadlifecycle;

/**
 * A thread is in {@code TIMED_WAITING} state when it's waiting for another thread to perform a particular action within
 * a stipulated amount of time.
 *
 * <ul>
 * <li>{@code thread.sleep(long millis)}</li>
 * <li>{@code wait(int timeout) or wait(int timeout, int nanos)}</li>
 * <li>{@code thread.join(long millis)}</li>
 * <li>{@code LockSupport.parkNanos}</li>
 * <li>{@code LockSupport.parkUntil}</li>
 * </ul>
 *
 * @author ray
 */
public class TimedWaitingState {
    public static void main(String[] args) throws InterruptedException {
        DemoThread demoThread = new DemoThread();
        Thread t1 = new Thread(demoThread);
        t1.start();
        // The following sleep will give enough time for ThreadScheduler
        // to start processing of thread t1
        Thread.sleep(1000);
        System.out.println(t1.getState());
    }
}
