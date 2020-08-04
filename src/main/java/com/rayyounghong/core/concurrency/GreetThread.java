package com.rayyounghong.core.concurrency;

/**
 * @author ray
 */
public class GreetThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello!");
    }
}
