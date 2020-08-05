package com.rayyounghong.core.lambda;

/**
 * @author ray
 */
public class CustomNumber {
    public int number;

    CustomNumber(int n) {
        this.number = n;
    }

    @Override
    public String toString() {
        return "CustomNumber{" + "number=" + number + '}';
    }
}
