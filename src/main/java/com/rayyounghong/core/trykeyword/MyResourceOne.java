package com.rayyounghong.core.trykeyword;

import com.rayyounghong.helper.Order;

/**
 * @author ray
 */
public class MyResourceOne implements AutoCloseable {

    MyResourceOne() {
        Order.orders.add("Constructor One.");
    }

    public void doSomething() {
        Order.orders.add("Do Something One.");
    }

    @Override
    public void close() {
        Order.orders.add("Closed One.");
    }
}
