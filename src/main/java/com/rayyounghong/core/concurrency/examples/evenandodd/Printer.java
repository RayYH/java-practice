package com.rayyounghong.core.concurrency.examples.evenandodd;

/**
 * @author ray
 */
public class Printer {
    private volatile boolean isOdd;

    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(number + " ");
        isOdd = true;
        notify();
    }

    synchronized void printEven(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.print(number + " ");
        isOdd = false;
        notify();
    }
}
