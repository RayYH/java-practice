package com.rayyounghong.core.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rayyounghong.StandardIOTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * @author ray
 */
public class MethodReferenceTest extends StandardIOTest {
    public void changeValue(CustomNumber customNumber, ChangeCustomerNumberValue changeCustomerNumberValue) {
        changeCustomerNumberValue.changeValue(customNumber);
    }

    @Test
    void testMethodReference() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.forEach(System.out::print);
        Consumer<Integer> method = n -> System.out.print(n * 2);
        numbers.forEach(method);
        assertEquals("598101816", outContent.toString());
    }

    @Test
    void testNew() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Stream<CustomNumber> customNumbers = numbers.stream().map(CustomNumber::new);
        CustomNumber[] anotherCustomerNumbers = customNumbers.toArray(CustomNumber[]::new);
        assertEquals(Arrays.toString(anotherCustomerNumbers),
            "[CustomNumber{number=1}, CustomNumber{number=2}, CustomNumber{number=3}]");
    }

    @Test
    void testMethods() {
        CustomNumber customNumber = new CustomNumber(1);
        Adder adder = new Adder();
        changeValue(customNumber, Adder::addTwo);
        assertEquals(customNumber.number, 3);
        changeValue(customNumber, adder::addOne);
        assertEquals(customNumber.number, 4);
        changeValue(customNumber, adder::addThree);
        assertEquals(customNumber.number, 7);
    }
}
