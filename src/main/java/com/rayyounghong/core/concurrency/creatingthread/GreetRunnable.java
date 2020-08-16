package com.rayyounghong.core.concurrency.creatingthread;

/**
 * Provide a Runnable object.
 *
 * @author ray
 */
public class GreetRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Greet Runnable!");
    }
}
