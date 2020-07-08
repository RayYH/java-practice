package com.rayyounghong.core.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ray
 */
public class CustomList<E> {
    private final List<E> list = new ArrayList<>();

    public void addItem(E elem) {
        list.add(elem);
    }

    public E getItem(int index) {
        return list.get(index);
    }
}
