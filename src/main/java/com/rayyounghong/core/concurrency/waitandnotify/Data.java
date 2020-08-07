package com.rayyounghong.core.concurrency.waitandnotify;

/**
 * @author ray
 */
public class Data {
    private String packet;

    /**
     * true if receiver should wait, false if sender should wait.
     */
    private boolean transfer = true;

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        transfer = true;
        notifyAll();
        return packet;
    }

    public synchronized void send(String packet) {
        // wait until the transferring process is done(set to false).
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        transfer = false;
        this.packet = packet;
        notifyAll();
    }
}
