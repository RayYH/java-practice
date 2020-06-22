package com.rayyounghong.core.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ray
 * @date 2020/5/9
 */
class GenericTest {

    @Test
    void testGeneric() {
        Generic<Integer> genericInteger = new Generic<>(1996);
        Generic<String> genericString = new Generic<>("ray");
        assertEquals(genericInteger.getKey(), 1996);
        assertEquals(genericString.getKey(), "ray");
    }

    @Test
    void showGenericTypeErasure() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        list.add("Hi");
        assertEquals("[Hi]", list.toString());
        Class<?> c = List.class;
        Method add = c.getDeclaredMethod("add", Object.class);
        add.invoke(list, 123); // notice here: 123, not "123"
        assertEquals("[Hi, 123]", list.toString());
    }

    @Test
    void boxCanBeDeclaredWithType() {
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();

        integerBox.add(1);
        stringBox.add("Box");

        assertEquals(1, integerBox.get());
        assertEquals("Box", stringBox.get());
    }

    @Test
    void advancedBoxCanAcceptTwoParameters() {
        AdvancedBox<Integer, String> box = new AdvancedBox<>();
        box.add(10, "Hello");

        assertEquals(10, box.getT());
        assertEquals("Hello", box.getS());
    }

    @Test
    void showCustomMapUsage() {
        CustomMap<String, Integer> customMap = new CustomMap<>();
        customMap.addKeyValue("age", 24);
        assertEquals(24, customMap.getValue("age"));
    }

    @Test
    void showCustomListUsage() {
        CustomList<AdvancedBox<Integer, String>> customList = new CustomList<>();
        AdvancedBox<Integer, String> box = new AdvancedBox<>();
        box.add(10, "Hello");
        customList.addItem(box);
        assertEquals(10, customList.getItem(0).getT());

        // we can also do this
        AdvancedBox<Integer, CustomList<String>> aBox = new AdvancedBox<>();
        CustomList<String> cList = new CustomList<>();
        cList.addItem("Hello");
        aBox.add(1, cList);
        assertEquals("Hello", aBox.getS().getItem(0));
    }

    @Test
    void genericMethodCanAcceptParametersWithDifferentType() {
        // cannot use int[]/double[]/char[] here
        Integer[] intArr = {1, 2, 3, 4, 5};
        Double[] doubleArr = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] charArr = {'H', 'E', 'L', 'L', 'O'};

        // arrayToString
        assertEquals("[1, 2, 3, 4, 5]", GenericMethod.arrayToString(intArr));
        assertEquals("[1.1, 2.2, 3.3, 4.4, 5.5]", GenericMethod.arrayToString(doubleArr));
        assertEquals("[H, E, L, L, O]", GenericMethod.arrayToString(charArr));

        // sum
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        assertEquals(6, GenericMethod.sum(integerList));
        assertEquals(6.6, GenericMethod.sum(doubleList));

        // listToString
        assertEquals("1 2 3", GenericMethod.listToString(Arrays.asList(1, 2, 3)));
        assertEquals("1.1 2.2 3.3", GenericMethod.listToString(Arrays.asList(1.1, 2.2, 3.3)));

        List<Animal> animalList = new ArrayList<>();
        List<RedCat> redCatList = new ArrayList<>();
        GenericMethod.addCat(animalList);
        GenericMethod.addCat(redCatList);
        GenericMethod.addCat(redCatList);
        assertEquals("Red Cat", GenericMethod.listToString(animalList));
        assertEquals("Red Cat Red Cat", GenericMethod.listToString(redCatList));
        Cat cat = redCatList.get(0);
        GenericMethod.deleteCat(redCatList, cat);
        assertEquals("Red Cat", GenericMethod.listToString(redCatList));
    }

    @Test
    void genericTypeCanBeRestricted() {
        assertEquals(GenericMethod.max(1, 2, 3), 3);
        assertEquals(GenericMethod.max(1.1, 2.2, 3.3), 3.3);
        assertEquals(GenericMethod.max("pear", "apple", "banana"), "pear");

        assertEquals(GenericMethod.maximum(1, 2, 3), 3);
        assertEquals(GenericMethod.maximum(1.1, 2.2, 3.3), 3.3);
    }
}
