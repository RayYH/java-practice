package com.rayyounghong.ds.linkedlist;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author ray
 */
public class SinglyLinkedList {

    /**
     * head node.
     */
    Node head;

    /**
     * attrs for check if given list is palindrome
     */
    Node slowPtrForPalindrome, fastPtrForPalindrome, secondHalfForPalindrome;

    /**
     * Print items of linked list one by one.
     */
    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
            if (n != null) {
                System.out.print("->");
            }
        }
    }

    /**
     * Insert a new Node at front of the lists.
     *
     * @param newData
     *            new data
     */
    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Inserts a new node after the given prevNode.
     *
     * @param prevNode
     *            previous node
     * @param newData
     *            new data
     * @throws IllegalArgumentException
     *             when prevNode is null, throws an exception
     */
    public void insertAfter(Node prevNode, int newData) throws IllegalArgumentException {
        if (prevNode == null) {
            throw new IllegalArgumentException("prev Node is null");
        }

        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    /**
     * Appends a new node at the end.
     *
     * @param newData
     *            new data
     */
    public void append(int newData) {
        Node newNode = new Node(newData);

        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    /**
     * Given a key, deletes the first occurrence of key in linked list.
     *
     * @param key
     *            given key.
     */
    public void deleteNode(int key) {
        // if head matched
        if (head != null && head.data == key) {
            head = head.next;
        } else { // find matched node
            Node prevNode = head;
            // starting iteration
            while (prevNode.next != null) {
                if (prevNode.next.data == key) {
                    // remove prevNode.next: break the relationship between prevNode and prevNode.next
                    prevNode.next = prevNode.next.next;
                    break;
                }

                // keep original relationship - nothing will be removed
                prevNode = prevNode.next;
            }
        }
    }

    /**
     * Delete all nodes whose data matched the given key.
     *
     * @param key
     *            given key
     */
    public void deleteNodes(int key) {
        // delete all the nodes matched the criteria at the front
        while (head != null && head.data == key) {
            head = head.next;
        }

        Node prevNode = head;

        if (prevNode != null) {
            while (prevNode.next != null) {
                if (prevNode.next.data == key) {
                    prevNode.next = prevNode.next.next;
                } else {
                    prevNode = prevNode.next;
                }
            }
        }
    }

    /**
     * deletes the node at the given position.
     *
     * @param position
     *            position index.
     */
    public void deleteNodeAtGivenPosition(int position) {
        if (head.next != null) {
            Node currentNode = head;

            // if head needs to be removed.
            if (position == 0) {
                head = currentNode.next;
            } else {
                for (int i = 0; i < position - 1 && currentNode != null; i++) {
                    currentNode = currentNode.next;
                }

                // now the index of currentNode is position-1
                // we should remove currentNode.next
                if (currentNode != null && currentNode.next != null) {
                    currentNode.next = currentNode.next.next;
                }
            }
        }
    }

    /**
     * Delete current list.
     */
    public void deleteList() {
        head = null;
    }

    /**
     * Get node counts.
     *
     * @return the total count of nodes in current list
     */
    public int getCount() {
        Node curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

    /**
     * Check if given value exists in given linked list.
     *
     * @param head
     *            head node
     * @param needle
     *            given value
     * @return true if founded, otherwise false.
     */
    public static boolean has(Node head, int needle) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == needle) {
                return true;
            }

            curr = curr.next;
        }

        return false;
    }

    /**
     * instance method for checking if given value is exists in given list.
     *
     * @param needle
     *            given value
     * @return returns true when founded, otherwise false.
     */
    public boolean has(int needle) {
        return SinglyLinkedList.has(head, needle);
    }

    /**
     * Get n-th value, notice the n is from 0 to n-1.
     *
     * @param index
     *            given index
     * @return the value
     */
    public int getNth(int index) {
        int listCount = getCount();

        // list is null
        if (listCount == 0) {
            throw new NullPointerException("list is null");
        }

        // index is invalid
        if (index >= getCount() || index < 0) {
            throw new IllegalArgumentException("invalid index given");
        }

        Node curr = head;
        int count = 0;
        while (curr != null) {

            if (count++ == index) {
                return curr.data;
            }

            curr = curr.next;
        }

        throw new RuntimeException("some error happened");
    }

    /**
     * static method for get n-th value but whether index is valid has not been checked.
     *
     * @param head
     *            list
     * @param index
     *            index
     * @return result
     */
    public static int getNth(Node head, int index) {
        int count = 0;
        if (head == null) {
            throw new NullPointerException("list is null");
        }

        // if count equal too n return node.data
        if (count == index) {
            return head.data;
        }

        // recursively decrease n and increase
        // head to next pointer
        return getNth(head.next, index - 1);
    }

    /**
     * get n-th value from last.
     *
     * @param n
     *            given index
     * @return the result
     */
    public int getNthFromLast(int n) {
        // 极限思想，最后一个元素传过来的 n 是 0
        // 此时传给 getNth 的值应该是 n - 1
        return this.getNth(getCount() - n - 1);
    }

    /**
     * Get middle value
     *
     * @return result
     */
    public int getMiddle() {
        return getMiddleSolution3();
    }

    /**
     * Get middle item of current list.
     *
     * @return founded value.
     */
    public int getMiddleSolution1() {
        int count = this.getCount();
        Node curr = head;
        int i = 0;
        int middleIndex = count / 2;
        while (i < middleIndex) {
            curr = curr.next;

            i++;
        }
        return curr.data;
    }

    public int getMiddleSolution2() {
        // 双指针，慢的指针一次依次移动一个节点，快的指针一次移动两个节点
        // 快指针指向 null 的时候，慢指针就是中间那个数
        Node slowPtr = head;
        Node fastPtr = head;

        if (head != null) {
            while (fastPtr != null && fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
            }
        }

        assert slowPtr != null;
        return slowPtr.data;
    }

    public int getMiddleSolution3() {
        // 和方法 2 的原理类似，只是在遍历的时候，两次才移动一次 mid 指针
        Node mid = head;
        Node headNode = head;
        int count = 0;

        while (headNode != null) {
            if ((count & 1) == 1) {
                mid = mid.next;
            }
            ++count;
            headNode = headNode.next;
        }

        assert mid != null;
        return mid.data;
    }

    /**
     * 给定值，查出它出现的次数
     *
     * @param searchFor
     *            searched value
     * @return the count
     */
    public int count(int searchFor) {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            if (curr.data == searchFor) {
                count++;
            }

            curr = curr.next;
        }

        return count;
    }

    /**
     * 查找给定值出现次数的静态方法
     *
     * @param head
     *            head
     * @param searchFor
     *            value will be searched
     * @return the count
     */
    public static int count(Node head, int searchFor) {
        if (head == null) {
            return 0;
        }

        if (head.data == searchFor) {
            return 1 + SinglyLinkedList.count(head.next, searchFor);
        }

        return SinglyLinkedList.count(head.next, searchFor);
    }

    /**
     * Time complexity: O(n). Auxiliary Space: O(n).
     *
     * @param h
     *            node
     * @return true when loop occurred otherwise false
     */
    public boolean detectLoop(Node h) {
        // save node addresses
        HashSet<Node> s = new HashSet<>();
        while (h != null) {
            if (s.contains(h)) {
                return true;
            }
            System.out.println(h.data);

            s.add(h);
            h = h.next;
        }

        return false;
    }

    /**
     * 检查链表中是否存在死循环。
     *
     * @return true if exists loop, otherwise false.
     */
    public boolean detectLoop() {
        Node slowPtr = head, fastPtr = head;
        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                return true;
            }
        }

        return false;
    }

    /**
     * 统计死循环链中的节点总数。
     *
     * @param n
     *            head node
     * @return the count.
     */
    public int countNodes(Node n) {
        int count = 1;
        Node temp = n;
        while (n.next != temp) {
            count++;
            n = n.next;
        }

        return count;
    }

    /**
     * 返回死循环链中的节点数目，不存在则返回 0
     *
     * @return 0 or the counts of nodes in loop.
     */
    public int countNodesInLoop() {
        Node slowPtr = head, fastPtr = head;
        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                return countNodes(slowPtr);
            }
        }

        return 0;
    }

    /**
     * 判断是否是回文，入栈再出栈。
     *
     * @param head
     *            given node head.
     * @return when matched return true otherwise false
     */
    public static boolean isPalindrome(Node head) {
        Node n = head;
        boolean isPalindrome = true;
        Stack<Integer> s = new Stack<>();
        int temp;

        while (n != null) {
            s.push(n.data);

            n = n.next;
        }

        while (head != null) {
            temp = s.pop();

            if (temp != head.data) {
                isPalindrome = false;
                break;
            }

            head = head.next;
        }

        return isPalindrome;
    }

    /**
     * Function to check if two input lists have same data
     *
     * @param head1
     *            head1
     * @param head2
     *            head2
     * @return returns true when two lists are same, otherwise false.
     */
    public static boolean compareLists(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else {
                return false;
            }
        }

        return temp1 == null && temp2 == null;
    }
}
