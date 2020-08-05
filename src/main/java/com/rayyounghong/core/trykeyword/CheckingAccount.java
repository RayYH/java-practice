package com.rayyounghong.core.trykeyword;

/**
 * @author ray
 */
public class CheckingAccount {
    private double balance;

    public CheckingAccount(double number) {
        this.balance = number;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        System.out.println(balance + " " + amount);
        if (amount <= balance) {
            balance -= amount;
        } else {
            double needs = amount - balance;
            throw new InsufficientFundsException(needs);
        }
    }

    public double getBalance() {
        return balance;
    }
}
