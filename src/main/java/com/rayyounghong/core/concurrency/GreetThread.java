package com.rayyounghong.core.concurrency;

/**
 * Subclass Thread.
 *
 * @author ray
 */
public class GreetThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello!");
    }
}
