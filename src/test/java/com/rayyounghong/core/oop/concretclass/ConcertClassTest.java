package com.rayyounghong.core.oop.concretclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class ConcertClassTest {

    @Test
    void testFancyCar() {
        FancyCar fancyCar = new FancyCar();
        assertEquals("zoom", fancyCar.drive());
        assertEquals("beep", fancyCar.honk());
    }

}
