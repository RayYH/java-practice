package com.rayyounghong.ds.stack;

/**
 * Stack is a linear data structure which follows a particular order in which the operations are performed. The order
 * may be LIFO(Last In First Out) or FILO(First In Last Out).
 *
 * @author ray
 * @date 2020/7/5
 */
public class Stack {

    /** Maximum size of stack. */
    static final int MAX_SIZE = 1000;

    /** top pointer. */
    int top;

    /** use array to store elements. */
    int[] data = new int[MAX_SIZE];

    /**
     * Stack Constructor.
     */
    Stack() {
        this.top = -1;
    }

    /**
     * Returns true if current stack contains no elements.
     *
     * @return returns true if current stack is empty, otherwise false.
     */
    boolean isEmpty() {
        return top < 0;
    }

    /**
     * Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
     *
     * @param x
     *            given data.
     *
     * @return true when execution is successful, otherwise false.
     *
     */
    boolean push(int x) {
        if (top >= MAX_SIZE - 1) {
            throw new StackOverflowException("Stack Overflow.");
        }

        data[++top] = x;
        return true;
    }

    /**
     * Removes an item from the stack. The items are popped in the reversed order in which they are pushed. If the stack
     * is empty, then it is said to be an Underflow condition.
     *
     * @return the item will be removed.
     */
    int pop() {
        if (top < 0) {
            throw new StackUnderflowException("Stack Underflow");
        }

        return data[top--];
    }

    /**
     * Returns top element of stack.
     *
     * @return the top element.
     */
    int peek() {
        if (top < 0) {
            throw new StackUnderflowException("Stack Underflow");
        }

        return data[top];
    }
}
