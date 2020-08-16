package com.rayyounghong.core.concurrency.threadlifecycle;

/**
 * A NEW Thread (or a Born Thread) is a thread that's been created but not yet started.
 *
 * @author ray
 */
public class NewState implements Runnable {
    public static void main(String[] args) {
        Runnable runnable = new NewState();
        Thread t = new Thread(runnable);
        System.out.println(t.getState());
    }

    @Override
    public void run() {

    }
}
