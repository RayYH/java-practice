package com.rayyounghong.core.concurrency.examples.printsequence;

/**
 * @author ray
 */
public class PrintSequenceRunnableMain {

    public static void main(String[] args) {
        PrintSequenceRunnable.base = 4;
        PrintSequenceRunnable.maxNumber = 1000;
        PrintSequenceRunnable.startThreads();
    }
}
