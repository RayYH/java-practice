package com.rayyounghong.core.oop.basic;

import java.time.Month;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 */
public class ManagerTest {

    @Test
    void testManager() {
        Manager boss = new Manager("Carl Cracker", 75000, 1987, Month.NOVEMBER, 15);
        boss.setBonus(15000);
        assertEquals(90000, boss.getSalary());
    }

    @Test
    void testPolymorphism() {
        Employee[] staff = new Employee[3];
        Manager boss = new Manager("Carl Cracker", 75000, 1987, Month.NOVEMBER, 15);
        boss.setBonus(15000);
        assertEquals(15000, boss.getBonus());
        // cannot use staff[0] = new Manager(...);
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, Month.OCTOBER, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, Month.MARCH, 15);
        assertEquals(90000, staff[0].getSalary());
        assertEquals(50000, staff[1].getSalary());
        assertEquals(40000, staff[2].getSalary());
    }
}
