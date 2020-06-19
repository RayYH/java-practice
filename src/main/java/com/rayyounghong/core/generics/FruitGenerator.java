package com.rayyounghong.core.generics;

import java.util.Random;

/**
 * @author ray
 */
public class FruitGenerator implements Generator<String> {

    private final String[] fruits = new String[]{"Apple", "Banana", "Orange"};

    @Override
    public String next() {
        Random random = new Random();
        return fruits[random.nextInt(3)];
    }
}
