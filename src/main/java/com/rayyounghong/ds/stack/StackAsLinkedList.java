package com.rayyounghong.ds.stack;

/**
 * We also use linked list to implement a stack.
 *
 * @author ray
 * @date 2020/7/6
 */
public class StackAsLinkedList {

    StackNode root;

    static class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
        }
    }

    /**
     * Returns true if current stack contains no elements.
     *
     * @return returns true if current stack is empty, otherwise false.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Using linked list will not thrown an overflow exception.
     *
     * @param data
     *            the element.
     */
    public void push(int data) {
        StackNode newNode = new StackNode(data);

        if (root == null) {
            root = newNode;
        } else {
            StackNode previousRootNode = root;
            root = newNode;
            newNode.next = previousRootNode;
        }
    }

    /**
     * Removes an item from the stack. The items are popped in the reversed order in which they are pushed. If the stack
     * is empty, then it is said to be an Underflow condition.
     *
     * @return the item will be removed.
     */
    public int pop() {
        if (root == null) {
            throw new StackUnderflowException("Stack Underflow");
        }

        int popped = root.data;
        root = root.next;

        return popped;
    }

    /**
     * Returns top element of stack.
     *
     * @return the top element.
     */
    int peek() {
        if (root == null) {
            throw new StackUnderflowException("Stack Underflow");
        }

        return root.data;
    }
}
