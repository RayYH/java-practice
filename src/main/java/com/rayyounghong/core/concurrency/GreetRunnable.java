package com.rayyounghong.core.concurrency;

/**
 * @author ray
 */
public class GreetRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Greet Runnable!");
    }
}
