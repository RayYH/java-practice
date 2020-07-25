package com.rayyounghong.core.synchronization;

/**
 * @author ray
 */
public class SynchronizedDemo {

    private int sum = 0;

    public static int staticSum = 0;

    public int getSum() {
        return sum;
    }

    public void calculate() {
        this.sum += 1;
    }

    public synchronized void synchronizedCalculate() {
        this.sum += 1;
    }

    public synchronized static void staticSynchronizedCalculate() {
        staticSum += 1;
    }

    public void performSynchronizedTask() {
        synchronized (this) {
            this.sum += 1;
        }
    }

    public static void performStaticSynchronizedTask() {
        synchronized (SynchronizedDemo.class) {
            staticSum += 1;
        }
    }
}
