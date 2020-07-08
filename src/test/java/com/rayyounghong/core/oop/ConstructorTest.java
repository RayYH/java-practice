package com.rayyounghong.core.oop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class ConstructorTest {

    /**
     * @link https://beginnersbook.com/2013/03/constructors-in-java/
     */
    @Test
    void testWebsite() {
        // this keyword
        Website websiteDefault = new Website();
        assertEquals(websiteDefault.getName(), "rayyounghong.com");
        assertEquals(websiteDefault.getVisitors(), 1);
        // constructor with assignment via params
        Website website = new Website("google.com", 1234567);
        assertEquals(website.getName(), "google.com");
        assertEquals(website.getVisitors(), 1234567);
        // super keyword
        Student student = new Student("ray", 23, 99.5f);
        assertEquals(student.getGrade(), 99.5f);
        assertEquals(student.getName(), "ray");
        assertEquals(student.getAge(), 23);
        Website websiteCopied = new Website(website);
        assertEquals(websiteCopied.getName(), website.getName());
        assertEquals(websiteCopied.getVisitors(), website.getVisitors());
    }

    @Test
    void testCopyConstructor() {
        Person personOne = new Person("ray", 23);
        personOne.birthDate = new Date(System.currentTimeMillis());
        Person personTwo = new Person(personOne);
        assertEquals(personOne.age, personTwo.age);
        assertEquals(personOne.name, personTwo.name);
        assertEquals(personOne.birthDate.getTime(), personTwo.birthDate.getTime());
    }
}
