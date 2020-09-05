package com.rayyounghong.ds.linkedlist;

/**
 * Node in linked-lists.
 *
 * @author ray
 */
public class Node {

    int data;

    Node next;

    Node() {
        this.data = 0;
        next = null;
    }

    Node(int d) {
        this.data = d;
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
