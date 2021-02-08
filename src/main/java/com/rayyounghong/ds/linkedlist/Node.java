package com.rayyounghong.ds.linkedlist;

/**
 * Node in linked-lists.
 *
 * @author ray
 */
public class Node {

    int data;

    Node prev, next;

    Node() {
        this.data = 0;
        next = null;
        prev = null;
    }

    Node(int d) {
        this.data = d;
        prev = null;
        next = null;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
