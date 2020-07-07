package com.rayyounghong.core.advanced;

/**
 * @author ray
 * @date 2020/7/7
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
        data.changeCounter(oldValue + 1);
        int newValue = data.getCounter();
        System.out.println("[Thread " + Thread.currentThread().getId() + "]: New value = " + newValue);
    }
}
