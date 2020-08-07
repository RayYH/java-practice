package com.rayyounghong.core.concurrency.waitandnotify;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ray
 */
public class Receiver implements Runnable {
    private final Data load;

    Receiver(Data load) {
        this.load = load;
    }

    @Override
    public void run() {
        String endString = "END";
        for (String message = load.receive(); !endString.equals(message); message = load.receive()) {
            System.out.println(message);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                // do some logging
            }
        }
    }
}
