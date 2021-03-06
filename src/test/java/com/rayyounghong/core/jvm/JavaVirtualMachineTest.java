package com.rayyounghong.core.jvm;

import com.rayyounghong.core.oop.basic.Student;
import java.util.HashMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ray
 */
public class JavaVirtualMachineTest {

    @Test
    void jvmWillCreateClassObjectWhenLoadingDotClassFile() {
        Student s = new Student("Ray", 24, 96.0f);
        Class<?> c = s.getClass();
        assertEquals(c.getName(), "com.rayyounghong.core.oop.basic.Student");

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
        /*
         * null reflects Bootstrap ClassLoader.
         *
         * When we are trying to load HashMap,
         * our System ClassLoader delegates it to the Extension ClassLoader.
         * The extension class loader delegates it to the Bootstrap ClassLoader.
         * The bootstrap class loader finds the HashMap class and loads it into the JVM memory.
         */
        assertNull(HashMap.class.getClassLoader());
        assertNull(String.class.getClassLoader());

        // If one Class file is in CLASSPATH, then the output will be:
        // xxx.xxx.xxx.$ExtClassLoader@xxxxxx

        // On my local machine: jdk.internal.loader.ClassLoaders$AppClassLoader@3d4eac69
        assertNotNull(Student.class.getClassLoader());
    }

}
