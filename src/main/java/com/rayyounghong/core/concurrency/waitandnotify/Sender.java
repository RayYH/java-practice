package com.rayyounghong.core.concurrency.waitandnotify;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ray
 */
public class Sender implements Runnable {
    private final Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String[] packets = {"First packet", "Second packet", "Third packet", "Fourth packet", "End"};

        for (String packet : packets) {
            data.send(packet);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
