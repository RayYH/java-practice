package com.rayyounghong.core.oop.basic;

import com.rayyounghong.helper.DisableInspection;
import java.time.Month;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ray
 */
public class EmployeeTest {
    @Test
    void testEmployInstances() {
        Employee.setNextId();
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, Month.NOVEMBER, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, Month.OCTOBER, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, Month.MARCH, 15);

        for (Employee e : staff) {
            assertEquals(-1, e.getId());
        }

        assertEquals("com.rayyounghong.core.oop.basic.Employee[name=Carl Cracker,salary=75000.0,hireDay=1987-11-15]",
            staff[0].toString());
        assertEquals("com.rayyounghong.core.oop.basic.Employee[name=Harry Hacker,salary=50000.0,hireDay=1989-10-01]",
            staff[1].toString());
        assertEquals("com.rayyounghong.core.oop.basic.Employee[name=Tony Tester,salary=40000.0,hireDay=1990-03-15]",
            staff[2].toString());

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

        Employee firstStaff = new Employee("Tony Tester", 40000, 1990, Month.MARCH, 15);
        Employee secondStaff = new Employee("Tony Tester", 40000, 1990, Month.MARCH, 15);
        assertEquals(firstStaff, secondStaff);
    }

    @Test
    void testComparator() {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, Month.NOVEMBER, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, Month.OCTOBER, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, Month.MARCH, 15);
        staff[1].setId();
        staff[0].setId();
        staff[2].setId();
        Arrays.sort(staff);
        assertEquals("Harry Hacker", staff[0].getName());
    }

    @Test
    void testClone() throws CloneNotSupportedException {
        Employee.setNextId(1);
        Employee employee = new Employee("Carl Cracker", 75000, 1987, Month.NOVEMBER, 15);
        employee.setId();
        assertEquals(employee.getId(), 1);
        Employee newEmployee = employee.clone();
        assertEquals(newEmployee.getId(), 2);
    }
}
