package com.rayyounghong.helper;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.rayyounghong.AppTest;

/**
 * @author ray
 * @date 2020/6/19
 */
public class ColorTest {

    @Test
    void printColors() {
        String s = Color.showAllConstants();
        AppTest.doWhatEver(s);
        try {
            Field[] fields = Color.class.getDeclaredFields();
            for (Field f : fields) {
                if (Modifier.isStatic(f.getModifiers())) {
                    f.setAccessible(true);
                    // Here, you can print the constant, but to be cleaner, I disabled it.
                    AppTest.doWhatEver(f.get(null) + f.getName() + Color.ANSI_RESET);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
