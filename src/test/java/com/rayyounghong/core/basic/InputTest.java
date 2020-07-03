package com.rayyounghong.core.basic;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 * @date 2020/6/20
 */
public class InputTest {
    @Test
    void testInputInt() {
        InputStream original = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        Scanner input = new Scanner(System.in);
        int anInt = input.nextInt();
        assertEquals(anInt, 1);
        System.setIn(original);
    }

    @Test
    void testInputFloat() {
        InputStream original = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2.1".getBytes());
        System.setIn(in);
        Scanner input = new Scanner(System.in);
        float aFloat = input.nextFloat();
        assertEquals(aFloat, 2.1f);
        System.setIn(original);
    }

    @Test
    void testInputString() {
        InputStream original = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("Hello World".getBytes());
        System.setIn(in);
        Scanner input = new Scanner(System.in);
        String aString = input.next(); // next 遇到空格即停止
        assertEquals(aString, "Hello");
        System.setIn(original);
    }

    @Test
    void testNextLine() {
        InputStream original = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("Hello World".getBytes());
        System.setIn(in);
        Scanner input = new Scanner(System.in);
        String aString = input.nextLine();
        assertEquals(aString, "Hello World");
        System.setIn(original);
    }
}
