package com.rayyounghong.core.concurrency.volatilekeyword;

import java.util.Random;

/**
 * @author ray
 */
public class VolatileThread extends Thread {
    private final VolatileData data;

    public VolatileThread(VolatileData data) {
        this.data = data;
    }

    @Override
    public void run() {
        int oldValue = data.getCounter();
        System.out.println("[Thread " + Thread.currentThread().getId() + "]: Old value = " + oldValue);
        Random random = new Random();
        data.changeCounter(oldValue + random.nextInt());
        int newValue = data.getCounter();
        System.out.println("[Thread " + Thread.currentThread().getId() + "]: New value = " + newValue);
    }
}
