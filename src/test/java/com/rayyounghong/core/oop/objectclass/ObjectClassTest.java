package com.rayyounghong.core.oop.objectclass;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class ObjectClassTest {

    @Test
    void testAnyClassExtendsObject() {
        Object obj = new Person("Rayyh", 24); // valid
        assertNotNull(obj);
        obj = new int[10];
        assertNotNull(obj);
    }

    @Test
    void testHashCode() {
        String s = "ok";
        StringBuilder sb = new StringBuilder(s);
        String t = "ok";
        StringBuilder tb = new StringBuilder(t);
        // 字符串的 hashcode 由其内容决定
        assertEquals(s.hashCode(), t.hashCode());
        // StringBuilder 没有定义 hashCode 方法，其 hashcode 由对象存储地址决定
        assertNotEquals(sb.hashCode(), tb.hashCode());
    }

    @Test
    void testToString() {
        Person p = new Person("Rayyh", 24);
        assertEquals("[" + p + "]", "[Person{name='Rayyh', age=24}]");
    }
}
