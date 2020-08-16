package com.rayyounghong.core.concurrency.threadmethods;

/**
 * we can see clearly second thread thread2 starts after first thread thread1 has died and thread3 will start its
 * execution after second thread thread2 has died.
 *
 * {@code join()}: It will put the current thread on wait until the thread on which it is called is dead. If thread is
 * interrupted then it will throw InterruptedException.
 *
 * @author ray
 */
public class ThreadJoin {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();

        thread1.start();

        try {
            System.out.println("Current Thread: " + Thread.currentThread().getName());
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();

        try {
            System.out.println("Current Thread: " + Thread.currentThread().getName());
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread3.start();
    }
}
