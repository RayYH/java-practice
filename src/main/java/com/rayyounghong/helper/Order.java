package com.rayyounghong.helper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class can be used for scenarios that need to verify the execution order.
 *
 * @author ray
 */
public class Order {

    public static ArrayList<String> orders = new ArrayList<>();

    public static void main(String[] args) {
        Order.orders.add("1");
        Order.orders.add("2");
        Order.orders.add("3");
        System.out.println(Arrays.toString(Order.orders.toArray()));
    }
}
