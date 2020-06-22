package com.rayyounghong.core.generics;

import com.rayyounghong.helper.Order;
import java.util.Arrays;
import java.util.List;

/**
 * @author ray
 * @date 2020/6/22
 */
public class GenericMethod {
    public static <E> String arrayToString(E[] arr) {
        return Arrays.toString(arr);
    }

    public static <T extends Comparable<T>> T max(T x, T y, T z) {
        T max = x;

        max = y.compareTo(max) > 0 ? y : max;
        max = z.compareTo(max) > 0 ? z : max;

        return max;
    }

    public static <T extends Number & Comparable<T>> T maximum(T x, T y, T z) {
        return GenericMethod.max(x, y, z);
    }

    public static double sum(List<? extends Number> numbers) {
        double sum = 0.0;

        for (Number n : numbers) {
            sum += n.doubleValue();
        }

        return sum;
    }

    public static String listToString(List<?> list) {
        StringBuilder res = new StringBuilder();

        for (Object item : list) {
            res.append(item.toString()).append(" ");
        }

        return res.toString().trim();
    }

    /**
     * in category - Upper bound wildcard.
     *
     * @param catList
     *            cat list
     * @param cat
     *            cat
     */
    public static void deleteCat(List<? extends Cat> catList, Cat cat) {
        catList.remove(cat);
    }

    /**
     * out category - Lower bound wildcard.
     *
     * @param catList
     *            cat list
     */
    public static void addCat(List<? super RedCat> catList) {
        catList.add(new RedCat("Red Cat"));
    }
}
