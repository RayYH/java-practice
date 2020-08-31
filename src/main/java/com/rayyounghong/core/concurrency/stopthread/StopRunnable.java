package com.rayyounghong.core.concurrency.stopthread;

/**
 * @author ray
 */
public class StopRunnable implements Runnable {

    private boolean doStop = false;

    public synchronized void doStop() {
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        return !this.doStop;
    }

    @Override
    public void run() {
        while (keepRunning()) {
            // keep doing what this thread should do.
            System.out.println("Running");
            try {
                Thread.sleep(3L * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
