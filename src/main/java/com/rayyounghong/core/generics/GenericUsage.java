package com.rayyounghong.core.generics;

import java.util.ArrayList;

/**
 * @author ray
 */
class GenericUsage {

    private final ArrayList<String> list = new ArrayList<>();

    GenericUsage() {
        this.list.add("Ray");
        this.list.add("Bob");
    }

    String stringList() {
        return list.toString();
    }

    String getSingleItem() {
        return list.get(1);
    }

    String getIteratorAsString() {
        StringBuilder res = new StringBuilder();
        for (String s : this.list) {
            res.append(s);
        }

        return res.toString();
    }
}
