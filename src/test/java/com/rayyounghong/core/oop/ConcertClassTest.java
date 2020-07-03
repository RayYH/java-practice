package com.rayyounghong.core.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 * @date 2020/7/2
 */
public class ConcertClassTest {

    @Test
    void testFancyCar() {
        FancyCar fancyCar = new FancyCar();
        assertEquals("zoom", fancyCar.drive());
        assertEquals("beep", fancyCar.honk());
    }

}
