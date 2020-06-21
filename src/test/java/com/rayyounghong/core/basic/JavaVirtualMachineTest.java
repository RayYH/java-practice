package com.rayyounghong.core.basic;

import com.rayyounghong.core.oop.Student;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ray
 * @date 2020/6/21
 */
public class JavaVirtualMachineTest {

    @Test
    void jvmWillCreateClassObjectWhenLoadingDotClassFile() {
        Student s = new Student("Ray", 24, 96.0f);
        Class<?> c = s.getClass();
        assertEquals(c.getName(), "com.rayyounghong.core.oop.Student");

        // Although student class extends person
        // when iterate methods or fields, only own methods & own fields can be accessed

        Method[] m = c.getDeclaredMethods();
        for (Method method : m) {
            assertEquals("getGrade", method.getName());
        }

        Field[] f = c.getDeclaredFields();
        for (Field field : f) {
            assertEquals("grade", field.getName());
        }
    }

    @Test
    void onlyOneObjectOfClassWillBeCreatedForEveryLoadedDotClassFile() {
        Student s1 = new Student("Ray", 24, 96.0f);
        Student s2 = new Student("Rayyh", 24, 96.0f);
        assertNotEquals(s1, s2);
        assertEquals(s1.getClass(), s2.getClass());
    }

    @Test
    void classesWithDifferentTypesLoadedByDifferentClassLoaders() {
        assertNull(String.class.getClassLoader());
        // On my local machine: jdk.internal.loader.ClassLoaders$AppClassLoader@3d4eac69
        assertNotNull(Student.class.getClassLoader());
    }

}
