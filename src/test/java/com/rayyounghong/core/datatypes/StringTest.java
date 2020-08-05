package com.rayyounghong.core.datatypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * {@link String} class is final, so it cannot be extended.
 *
 * <p>
 * In Java 8, {@link String} use char array to store an array, while since java9, {@link String} use byte to store an
 * array and provides a {@code coder} property to determine which encoding used.
 * </p>
 *
 * <p>
 * Advantages of immutable String:
 * </p>
 *
 * <ul>
 * <li>1. Caching Hashcode.</li>
 * <li>2. Requirement of String Pool.</li>
 * <li>3. Security, file name? network connection parameters?</li>
 * <li>4. Immutable objects are naturally thread-safe.</li>
 * </ul>
 *
 * <p>
 * String, StringBuffer, StringBuilder
 * </p>
 *
 * <ul>
 * <li>String is immutable while StringBuilder and StringBuffer is mutable.</li>
 * <li>String is thread-safe due to immutability, StringBuffer is thread-safe via synchronized keyword, while
 * StringBuilder is not thread-safe .</li>
 * </ul>
 *
 * @author ray
 */
public class StringTest {
    /**
     * String Pool Test.
     */
    @Test
    void declareStringViaObjectOrStringLiteral() {
        // `==` checks memory location - assertSame/assertNotSame
        // `equals` checks overridden equals method - assertEquals/assertNotEquals

        // When use new keyword, a String object will be created in heap area
        // (not inside String pooled area)
        String sObjOne = new String("String");
        // Using new String("new string which is NOT cached in string pool");
        // will create two objects.
        // first: "new string which is NOT cached in string pool" ==> create a String Literal in String Pool.
        // second: new("new string which is NOT cached in string pool") statement will create an object in heap.

        String sObjTwo = new String("String");
        // Use string literal
        String sConstantOne = "String";
        String sConstantTwo = "String";
        // but: String s1 = null; String s2 = null; ==> s1 == s2 returns true

        String sObj1 = new String("New String");
        String sObj2 = new String("New String");
        // intern method first add the string to String Pool, then get a ref to this string
        // while using literal will automatically add string to String pool
        String sInternOne = sObj1.intern();
        String sInterTwo = sObj2.intern();

        assertNotSame(sObjOne, sObjTwo); // == returns false
        assertEquals(sObjOne, sObjTwo); // equals returns true

        assertSame(sConstantOne, sConstantTwo); // == returns true
        assertEquals(sConstantOne, sConstantTwo); // equals returns true

        assertSame(sInternOne, sInterTwo); // == returns true
        assertEquals(sInternOne, sInterTwo); // equals returns true
    }

    @Test
    void testConcentrateStrings() {
        assertEquals("Hello World", "Hello" + " " + "World");
        assertEquals("Hello13", "Hello" + 13);
        assertEquals("Hello/World", String.join("/", "Hello", "World"));
    }

    @Test
    void testBuildString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = "B";
        stringBuilder.append(1);
        stringBuilder.append('A');
        stringBuilder.insert(2, str);
        String s = stringBuilder.toString();
        assertEquals(s, "1AB");
    }

    @Test
    void testHashCode() {
        String s = "Ok";
        StringBuilder sb = new StringBuilder(s);
        String t = "Ok";
        StringBuilder tb = new StringBuilder(t);
        // 字符串的散列码是由内容导出的
        assertEquals(s.hashCode(), t.hashCode());
        // StringBuilder 类没有重写 hashCode 方法，散列码是由 Object 类的 hashCode 方法导出的对象存储地址
        assertNotEquals(sb.hashCode(), tb.hashCode());
    }
}
