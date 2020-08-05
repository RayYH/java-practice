package com.rayyounghong.core.trykeyword;

/**
 * @author ray
 */
public class InsufficientFundsException extends Exception {
    private static final long serialVersionUID = -1127573053927405905L;

    private final double amount;

    public InsufficientFundsException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String getMessage() {
        return "Sorry, but you are short " + this.amount;
    }
}
