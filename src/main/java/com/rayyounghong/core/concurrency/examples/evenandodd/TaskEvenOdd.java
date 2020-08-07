package com.rayyounghong.core.concurrency.examples.evenandodd;

/**
 * @author ray
 */
public class TaskEvenOdd implements Runnable {
    private final int max;
    private final Printer print;
    private final boolean isEvenNumber;

    public TaskEvenOdd(Printer print, int max, boolean isEvenNumber) {
        this.print = print;
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }
    }
}
