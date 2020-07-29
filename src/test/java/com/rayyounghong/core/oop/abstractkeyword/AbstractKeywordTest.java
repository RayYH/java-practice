package com.rayyounghong.core.oop.abstractkeyword;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class AbstractKeywordTest {
    @Test
    void testAbstractKeyword() {

        AbstractPerson[] person = new AbstractPerson[2];
        person[0] = new Student("Rayyh", "Mathematical");
        person[1] = new Teacher("Taylor", 30);
        assertEquals(person[0].getDescription(), "a student majoring in Mathematical");
        assertEquals(person[1].getDescription(), "a teacher of age 30");
    }
}
