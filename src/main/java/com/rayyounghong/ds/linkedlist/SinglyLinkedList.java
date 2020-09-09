package com.rayyounghong.ds.linkedlist;

import java.util.HashSet;

/**
 * @author ray
 */
public class SinglyLinkedList {

    /**
     * head node.
     */
    Node head;

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
     * Insert a new Node at front of the list.
     *
     * @param newData
     *            new data
     */
    public void push(int newData) {
        // allocate the Node & Put in the data
        Node newNode = new Node(newData);
        // make next of new Node as head
        newNode.next = head;
        // move the head to point to new Node
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
        // check if the given Node is null
        if (prevNode == null) {
            throw new IllegalArgumentException("prev Node is null");
        }
        // allocate the Node & Put in the data
        Node newNode = new Node(newData);
        // make next of new Node as next of prevNode
        newNode.next = prevNode.next;
        // make next of prevNode as newNode
        prevNode.next = newNode;
    }

    /**
     * Appends a new node at the end.
     *
     * @param newData
     *            new data
     */
    public void append(int newData) {
        // newNode.next is default null
        Node newNode = new Node(newData);
        // if the Linked List is empty, then make the new node as head
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
     * <ol>
     * <li>Find previous node of the node to be deleted.</li>
     * <li>Change the next of previous node.</li>
     * <li>Free memory for the node to be deleted.</li>
     * </ol>
     *
     * @param key
     *            given key
     */
    public void deleteNode(int key) {
        // if head matched, move head to next
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
                // iterate
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
                // if matched, then break the relationship
                if (prevNode.next.data == key) {
                    prevNode.next = prevNode.next.next;
                } else {
                    prevNode = prevNode.next;
                }
            }
        }
    }

    /**
     * Deletes the node at the given position, index starts at 0.
     *
     * @param position
     *            position index
     */
    public void deleteNodeAtGivenPosition(int position) {
        if (head == null) {
            return;
        }

        // current node
        Node currentNode = head;

        // if head needs to be removed
        // just change the head
        if (position == 0) {
            head = currentNode.next;
            return;
        }

        // limitation thinking, if position = 1, we only need to remove currentNode
        // without iteration, so the the loop limitation of i is i < position
        for (int i = 1; i < position && currentNode != null; i++) {
            // Before: when i = 1, currentNode's index is 0, currentNode.next is at index 1
            // so currentNode.next is the actual element which should be removed
            currentNode = currentNode.next;
            // After: currentNode holds i-th(starts from 0) element
        }
        // now currentNode holds element of index (position - 1)
        // so we should remove currentNode.next
        if (currentNode != null && currentNode.next != null) {
            currentNode.next = currentNode.next.next;
        }
    }

    /**
     * Delete current list.
     */
    public void deleteList() {
        head = null;
    }

    /**
     * Get the count of nodes.
     *
     * @return the total count of nodes in current list
     */
    public int getCountOfNodes() {
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
     * @return true if founded, otherwise false
     */
    public static boolean has(Node head, int needle) {
        if (head == null) {
            return false;
        }

        if (head.data == needle) {
            return true;
        }

        return has(head.next, needle);
    }

    /**
     * Checking if given value is exists in given list.
     *
     * @param needle
     *            given value
     * @return returns true when founded, otherwise false
     */
    public boolean has(int needle) {
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
     * Get n-th value, notice the n is from 1 to n.
     *
     * We didn't check whether the index is valid, if it's invalid, we just throw a NoSuchElementException.
     *
     * @param index
     *            given index
     * @return the value
     */
    public int getNth(int index) {
        Node curr = head;
        int count = 1;
        while (curr != null) {
            if (count++ == index) {
                return curr.data;
            }
            curr = curr.next;
        }

        throw new NoSuchElementException("cannot find element of given index: " + index);
    }

    /**
     * Get n-th value but whether index is valid has not been checked.
     *
     * @param head
     *            list
     * @param index
     *            index
     * @return result
     */
    public static int getNth(Node head, int index) {
        int count = 1;
        if (head == null) {
            throw new NullPointerException("list is null");
        }

        if (count == index) {
            return head.data;
        }

        // recursively decrease n and increase
        // head to next pointer
        return getNth(head.next, index - 1);
    }

    /**
     * get n-th value from last, notice the n is from 1 to n.
     *
     * @param n
     *            given index
     * @return the result
     */
    public int getNthFromLast(int n) {
        if (n < 1) {
            throw new NoSuchElementException("provided index is invalid");
        }

        // use two pointers
        Node fast = head;
        Node slow = head;
        int start = 0;

        if (head == null) {
            throw new NoSuchElementException("current list is empty");
        }

        while (start < n) {
            if (fast == null) {
                throw new NoSuchElementException("provided index is invalid");
            }
            fast = fast.next;
            start++;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    /**
     * Get middle item of current list.
     *
     * @return founded value
     */
    public int getMiddle() {
        return getMiddleViaCounter();
    }

    /**
     * Get middle item of current list.
     *
     * Traverse linked list using two pointers. Move one pointer by one and other pointer by two. When the fast pointer
     * reaches end slow pointer will reach middle of the linked list.
     *
     * @return founded value
     */
    public int getMiddleViaTwoPointers() {
        Node slowPtr = head;
        Node fastPtr = head;

        if (head != null) {
            // move the fast pointer by two
            while (fastPtr != null && fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
            }
        } else {
            throw new EmptyListException();
        }

        assert slowPtr != null;
        return slowPtr.data;
    }

    /**
     * Get middle item of current list.
     *
     * Initialize mid element as head and initialize a counter as 0. Traverse the list from head, while traversing
     * increment the counter and change mid to mid->next whenever the counter is odd. So the mid will move only half of
     * the total length of the list.
     *
     * @return founded value
     */
    public int getMiddleViaCounter() {
        Node mid = head;
        Node headNode = head;

        if (head == null) {
            throw new EmptyListException();
        }

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
     * Counts the number of times a given int occurs in a Linked List.
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
     * Counts the number of times a given int occurs in a Linked List.
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
     * Floyd’s Cycle-Finding Algorithm. (Also using two pointers)
     *
     * <ol>
     * <li>Traverse linked list using two pointers.</li>
     * <li>Move one pointer(slowPtr) by one and another pointer(fastPtr) by two.</li>
     * <li>If these pointers meet at the same node then there is a loop. If pointers do not meet then linked list does
     * not have a loop.</li>
     * </ol>
     *
     * @param h
     *            head node
     * @return true when loop occurred otherwise false
     */
    public boolean detectLoop(Node h) {
        Node slowPtr = h, fastPtr = h;
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
     * Detect loop in a linked list.
     *
     * @return true if exists loop, otherwise false
     */
    public boolean detectLoop() {
        return detectLoop(head);
    }

    /**
     * Detect loop in a linked list.
     *
     * <ol>
     * <li>Find the common point in the loop by using the Floyd’s Cycle detection algorithm</li>
     * <li>Store the pointer in a temporary variable and keep a count = 0</li>
     * <li>Traverse the linked list until the same node is reached again and increase the count while moving to next
     * node.</li>
     * <li>Now the holds the length of loop</li>
     * </ol>
     *
     * @return 0 or the counts of nodes in loop
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
     * Find length of loop in linked list.
     *
     * @param n
     *            given node
     * @return the count
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
     * Check whether current list is a palindrome.
     *
     * Palindrome: a word, phrase, or sequence that reads the same backward as forward, e.g., madam or nurses run.
     *
     * <ol>
     * <li>Get the middle of the linked list.</li>
     * <li>Reverse the second half of the linked list.</li>
     * <li>Check if the first half and second half are identical.</li>
     * <li>Construct the original linked list by reversing the second half again and attaching it back to the first
     * half</li>
     * </ol>
     *
     * <p>
     * When number of nodes are even, the first and second half contain exactly half nodes. The challenging thing in
     * this method is to handle the case when number of nodes are odd. We don’t want the middle node as part of any of
     * the lists as we are going to compare them for equality. For odd case, we use a separate variable {@code mid}.
     * </p>
     *
     * @param head
     *            given head node
     * @return when matched returns true, otherwise false
     */
    public static boolean isPalindrome(Node head) {
        boolean isPalindrome = true;

        Node slowPtr = head;
        Node fastPtr = head;
        Node prevOfSlowPtr = head;
        Node secondHalf;
        Node mid = null;

        if (head != null && head.next != null) {
            // Get the middle of the list. Move slowPtr by 1 and fastPtr by 2, slowPtr will have the middle node
            while (fastPtr != null && fastPtr.next != null) {
                fastPtr = fastPtr.next.next;
                // We need previous of the slowPtr for linked lists with odd elements
                prevOfSlowPtr = slowPtr;
                slowPtr = slowPtr.next;
            }

            // fastPtr would become NULL when there are even elements in the list and not NULL for odd elements.
            // We need to skip the middle node for odd case and store it somewhere so that
            // we can restore the original list
            if (fastPtr != null) {
                mid = slowPtr;
                // skip mid node
                slowPtr = slowPtr.next;
            }

            // Now reverse the second half and compare it with first half
            secondHalf = slowPtr;
            prevOfSlowPtr.next = null;
            secondHalf = reverse(secondHalf);
            isPalindrome = compareLists(head, secondHalf);
            secondHalf = reverse(secondHalf);

            if (mid != null) {
                // If there was a mid node (odd size case) which
                // was not part of either first half or second half.
                prevOfSlowPtr.next = mid;
                mid.next = secondHalf;
            } else {
                prevOfSlowPtr.next = secondHalf;
            }
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
     * @return returns true when two lists are same, otherwise false
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

    /**
     * Reverse a linked list.
     *
     * <ol>
     * <li>Initialize three pointers prev as NULL, curr as head and next as NULL.</li>
     * <li>Iterate trough the linked list. In loop, change the relationship between nodes.</li>
     * </ol>
     *
     * @param h
     *            head Node
     * @return new head Node
     */
    public static Node reverse(Node h) {
        Node prev = null, curr = h, next;
        while (curr != null) {
            // Before changing next of current, store next node
            next = curr.next;
            // Now change next of current, this is where actual reversing happens
            curr.next = prev;
            // Move prev and curr one step forward
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void reverse() {
        head = reverse(head);
    }

    /**
     * Check if current list is sorted.
     *
     * @param asc
     *            sort asc
     * @return returns true if current list is sorted, otherwise false
     */
    private boolean isSorted(boolean asc) {
        // no elements
        if (head == null) {
            throw new EmptyListException();
        }
        // only one node
        if (head.next == null) {
            return true;
        }

        Node first = head;
        Node second = head.next;
        while (second.next != null) {
            if (asc) {
                if (first.data > second.data) {
                    return false;
                }
            } else {
                if (first.data < second.data) {
                    return false;
                }
            }
            first = first.next;
            second = second.next;
        }

        return true;
    }

    /**
     * Check if current list is sorted.
     *
     * @return returns true if current list is ascend, otherwise false
     */
    public boolean isAscend() {
        return isSorted(true);
    }

    /**
     * Check if current list is sorted.
     *
     * @return returns true if current list is descend, otherwise false
     */
    public boolean isDescend() {
        return isSorted(false);
    }

    /**
     * Remove duplicates from a sorted linked list.
     *
     * Traverse the list from the head (or start) node. While traversing, compare each node with its next node. If data
     * of next node is same as current node then delete the next node. Before we delete a node, we need to store next
     * pointer of the node
     */
    public void removeDuplicatesWhenSorted() {
        assert (isAscend() || isDescend());

        Node curr = head;
        Node temp;
        while (curr != null) {
            temp = curr;
            // Compare current node with the next node and keep on deleting them until it matches the current node data
            while (temp != null && temp.data == curr.data) {
                temp = temp.next;
            }
            // Set current node next to the next different element denoted by temp
            curr.next = temp;
            curr = curr.next;
        }
    }

    /**
     * Remove duplicates from a unsorted linked list.
     *
     * We traverse the link list from head to end. For every newly encountered element, we check whether it is in the
     * hash table: if yes, we remove it; otherwise we put it in the hash table.
     */
    public void removeDuplicatesWhenNotSorted() {
        HashSet<Integer> h = new HashSet<>();

        Node curr = head;
        Node prev = null;

        while (curr != null) {
            // skip current element
            if (h.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                h.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    /**
     * Swap head node and given node's next node
     *
     * @param n
     *            given node
     */
    public void swapTheNextNodeAndHead(Node n) {
        // head -> section_one -> n -> n.next -> section_two -> null
        // n.next -> section_one -> n -> head -> section_two -> null
        if (n == null || head == null || head.next == null) {
            return;
        }

        Node headNode = head, temp;

        if (n == head) {
            // head -> head.next -> ...
            // head.next -> head -> ...
            temp = head.next.next;
            head = head.next;
            head.next = headNode;
            headNode.next = temp;
            return;
        }

        Node sectionOne, sectionTwo;
        sectionOne = head.next;
        if (n.next == null) {
            sectionTwo = null;
        } else {
            sectionTwo = n.next.next;
        }

        head = n.next;
        head.next = sectionOne;
        n.next = headNode;
        n.next.next = sectionTwo;
    }

    /**
     * Swap nodes in a linked list without swapping data
     *
     * @param x
     *            first value
     * @param y
     *            second value
     */
    public void swapNodesViaGivenData(int x, int y) {
        // Nothing to do if x and y are same
        if (x == y) {
            return;
        }

        // search for x and y in the linked list and store their pointer in a and b
        Node curr = head, temp;
        Node a = null, b = null;
        while (curr.next != null) {
            // a.next.data = x
            // b.next.data = y
            if (curr.next.data == x) {
                a = curr;
            } else if (curr.next.data == y) {
                b = curr;
            }
            curr = curr.next;
        }

        if (head.data == x && b != null) {
            swapTheNextNodeAndHead(b);
        }

        if (head.data == y && a != null) {
            swapTheNextNodeAndHead(a);
        }

        // a -> (x), b -> (y)
        if (a != null && b != null) {
            temp = a.next;
            a.next = b.next;
            b.next = temp;
            temp = a.next.next;
            a.next.next = b.next.next;
            b.next.next = temp;
        }
    }

    /**
     * Pairwise swap elements of a given linked list.
     *
     * Start from the head node and traverse the list. While traversing swap data of each node with its next node’s
     * data.
     */
    public void pairWiseSwap() {
        Node curr = head;
        int temp;
        while (curr != null && curr.next != null) {
            temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            // note here
            curr = curr.next.next;
        }
    }

    /**
     * Move last element to front of a given Linked List.
     */
    public void moveLastToFront() {
        // If linked list is empty or it contains only one node then simply return.
        if (head == null || head.next == null) {
            return;
        }

        // Initialize second last and last pointer
        Node secondLast = null, last = head;

        // After this loop secondLast contains address of second last node and
        // last contains address of last node in Linked List
        while (last.next != null) {
            secondLast = last;
            last = last.next;
        }

        assert secondLast != null;
        secondLast.next = null;
        last.next = head;
        head = last;
    }

    /**
     * Intersection of two Sorted Linked Lists without remove duplicates.
     *
     * @param a
     *            head node of first list
     * @param b
     *            head node of second list
     * @return the intersect list
     */
    public Node sortedIntersect(Node a, Node b) {
        Node dummy = new Node();
        Node tail = dummy;

        // Once one or the other list runs out -- we're done
        while (a != null && b != null) {
            if (a.data == b.data) {
                tail.next = new Node(a.data);
                tail = tail.next;
                a = a.next;
                b = b.next;
            } else if (a.data < b.data) {
                a = a.next;
            } else {
                b = b.next;
            }
        }
        return dummy.next;
    }

    /**
     * Intersection of two Sorted Linked Lists without remove duplicates.
     *
     * @param a
     *            head node of first list
     * @param b
     *            head node of second list
     * @return the intersect list
     */
    public Node sortedIntersectAndRemoveDuplicates(Node a, Node b) {
        Node dummy = new Node();
        Node tail = dummy;

        // Once one or the other list runs out -- we're done
        while (a != null && b != null) {
            if (a.data == b.data) {
                // remove duplicates
                while (a.next != null && a.next.data == a.data) {
                    a = a.next;
                }

                while (b.next != null && b.next.data == b.data) {
                    b = b.next;
                }

                tail.next = new Node(a.data);
                tail = tail.next;
                a = a.next;
                b = b.next;
            } else if (a.data < b.data) {
                a = a.next;
            } else {
                b = b.next;
            }
        }
        return dummy.next;
    }

    /**
     * Get the intersection point of two Linked Lists.
     *
     * @param a
     *            first list
     * @param b
     *            second list
     * @return the intersection point
     */
    public Node getIntersectionPoint(SinglyLinkedList a, SinglyLinkedList b) {
        int c1 = a.getCountOfNodes();
        int c2 = b.getCountOfNodes();
        int d = c1 - c2;

        if (d > 0) {
            return getIntersectionNode(d, a, b);
        }

        return getIntersectionNode(-d, b, a);
    }

    /**
     * Function to get the intersection point of two linked lists {@code larger} and {@code shorter} where
     * {@code larger} has {@code d} more nodes than {@code shorter}.
     *
     * @param d
     *            number of difference
     * @param larger
     *            the larger list
     * @param shorter
     *            the shorter list
     * @return the intersection node
     */
    private Node getIntersectionNode(int d, SinglyLinkedList larger, SinglyLinkedList shorter) {
        Node res;
        Node currentA = larger.head;
        Node currentB = shorter.head;

        for (int i = 0; i < d; i++) {
            if (currentA == null) {
                return null;
            }
            currentA = currentA.next;
        }

        while (currentA != null && currentB != null) {
            if (currentA.data == currentB.data) {
                res = currentA;
                return res;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }

        return null;
    }



    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();
        singlyLinkedList1.append(3);
        singlyLinkedList1.append(5);
        singlyLinkedList1.append(9);
        singlyLinkedList1.append(15);
        singlyLinkedList1.append(30);
        singlyLinkedList1.printList();
    }

}
