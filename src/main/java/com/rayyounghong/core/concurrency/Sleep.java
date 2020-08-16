package com.rayyounghong.core.concurrency;

/**
 * @author ray
 */
public class Sleep {

    public static void main(String[] args) throws InterruptedException {
        String[] messages = {"Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too"};
        for (String message : messages) {
            // sleep 2 s
            Thread.sleep(2000);
            System.out.println(message);
        }
    }
}
