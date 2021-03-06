package com.rayyounghong.core.trykeyword;

import com.rayyounghong.helper.Order;

/**
 * @author ray
 */
public class MyResourceTwo implements AutoCloseable {

    MyResourceTwo() {
        Order.orders.add("Constructor Two.");
    }

    public void doSomething() {
        Order.orders.add("Do Something Two.");
    }

    @Override
    public void close() {
        Order.orders.add("Closed Two.");
    }
}
