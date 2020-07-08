package com.rayyounghong.core.oop;

import com.rayyounghong.helper.DisableInspection;
import java.time.Month;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author ray
 */
public class EmployeeTest {
    @Test
    void testEmployInstances() {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, Month.NOVEMBER, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, Month.OCTOBER, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, Month.MARCH, 15);

        for (Employee e : staff) {
            assertEquals(-1, e.getId());
        }

        staff[0].setId();
        assertEquals(1, staff[0].getId());
        staff[1].setId();
        assertEquals(2, staff[1].getId());
        staff[2].setId();
        assertEquals(3, staff[2].getId());
        assertEquals(4, Employee.getNextId());

        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        for (Employee e : staff) {
            assertNotNull(e.getName());
            assertNotNull(e.getHireDay());
            DisableInspection.doWhatEver(e.getSalary());
        }

        Employee e = new Employee("Ray", 100.0);
        assertEquals("2000-01-01", e.getHireDay().toString());
    }
}
