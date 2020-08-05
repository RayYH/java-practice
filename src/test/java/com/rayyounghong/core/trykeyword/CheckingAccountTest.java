package com.rayyounghong.core.trykeyword;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class CheckingAccountTest {
    @Test
    void testCheckingAccount() {
        CheckingAccount c = new CheckingAccount(100.0);
        c.deposit(500.0);
        assertEquals(c.getBalance(), 600.0);
        try {
            c.withdraw(100.00);
            assertEquals(c.getBalance(), 500.0);
            c.withdraw(600.00);
        } catch (InsufficientFundsException e) {
            assertEquals(e.getMessage(), "Sorry, but you are short 100.0");
        }
    }
}
