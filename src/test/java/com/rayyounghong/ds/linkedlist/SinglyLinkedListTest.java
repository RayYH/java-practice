package com.rayyounghong.ds.linkedlist;

import com.rayyounghong.StandardIOTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author ray
 */
public class SinglyLinkedListTest extends StandardIOTest {

    @Test
    public void testPrintList() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = new Node(1);
        singlyLinkedList.head.next = new Node(2);
        singlyLinkedList.head.next.next = new Node(3);

        singlyLinkedList.printList();

        assertEquals("1->2->3", outContent.toString());
    }

    @Test
    public void testPush() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.push(3);
        singlyLinkedList.push(2);
        singlyLinkedList.push(1);

        singlyLinkedList.printList();

        assertEquals("1->2->3", outContent.toString());
    }

    @Test
    public void testInsertAfter() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        assertThrows(IllegalArgumentException.class, () -> {
            singlyLinkedList.head = new Node(1);
            singlyLinkedList.insertAfter(singlyLinkedList.head.next, 1);
        });

        singlyLinkedList.head = new Node(1);
        singlyLinkedList.insertAfter(singlyLinkedList.head, 2);
        singlyLinkedList.insertAfter(singlyLinkedList.head.next, 3);

        singlyLinkedList.printList();

        assertEquals("1->2->3", outContent.toString());
    }

    @Test
    public void testAppend() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);

        singlyLinkedList.printList();

        assertEquals("1->2->3", outContent.toString());
    }

    @Test
    public void testDeleteNode() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(7);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.append(7);

        singlyLinkedList.deleteNode(7);
        singlyLinkedList.deleteNode(4);

        singlyLinkedList.printList();

        assertEquals("1->2->3->7", outContent.toString());
    }

    @Test
    public void testDeleteNodes() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(7);
        singlyLinkedList.append(7);
        singlyLinkedList.append(7);
        singlyLinkedList.append(7);
        singlyLinkedList.append(1);
        singlyLinkedList.append(7);
        singlyLinkedList.append(7);
        singlyLinkedList.append(2);
        singlyLinkedList.append(7);
        singlyLinkedList.append(3);
        singlyLinkedList.append(7);
        singlyLinkedList.append(7);
        singlyLinkedList.append(7);

        singlyLinkedList.deleteNodes(7);

        singlyLinkedList.printList();

        assertEquals("1->2->3", outContent.toString());
    }

    @Test
    public void testDeleteNodeAtGivenPosition() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(0);
        singlyLinkedList.append(1);
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(7);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.append(7);

        singlyLinkedList.deleteNodeAtGivenPosition(0); // 0
        singlyLinkedList.deleteNodeAtGivenPosition(0); // 1
        singlyLinkedList.deleteNodeAtGivenPosition(2); // 7
        singlyLinkedList.deleteNodeAtGivenPosition(3); // 4
        singlyLinkedList.deleteNodeAtGivenPosition(3); // 7

        singlyLinkedList.printList();

        assertEquals("1->2->3", outContent.toString());
    }

    @Test
    public void testGetCount() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);

        assertEquals(3, singlyLinkedList.getCountOfNodes());
    }

    @Test
    public void testDeleteList() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);

        singlyLinkedList.deleteList();

        assertEquals(0, singlyLinkedList.getCountOfNodes());
    }

    @Test
    public void testHas() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);

        assertTrue(singlyLinkedList.has(3));
        assertTrue(SinglyLinkedList.has(singlyLinkedList.head, 3));
        assertTrue(singlyLinkedList.has(2));
        assertTrue(SinglyLinkedList.has(singlyLinkedList.head, 2));
        assertFalse(singlyLinkedList.has(7));
    }

    /**
     * 在我们的实现中，list 中的索引是从 0 开始的，因此 n 的合法值是 0 ~ n-1 而不是 1 ~ n
     */
    @Test
    public void testGetNth() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        assertThrows(NoSuchElementException.class, () -> singlyLinkedList.getNth(1));
        assertThrows(NoSuchElementException.class, () -> singlyLinkedList.getNthFromLast(1));
        assertThrows(NullPointerException.class, () -> SinglyLinkedList.getNth(singlyLinkedList.head, 1));
        assertThrows(NoSuchElementException.class, () -> {
            singlyLinkedList.append(1);
            singlyLinkedList.append(2);
            singlyLinkedList.append(3);
            singlyLinkedList.getNth(-1);
        });

        assertThrows(NoSuchElementException.class, () -> singlyLinkedList.getNth(5));

        assertEquals(1, singlyLinkedList.getNth(1));
        assertEquals(2, singlyLinkedList.getNth(2));
        assertEquals(3, singlyLinkedList.getNth(3));

        assertEquals(1, singlyLinkedList.getNthFromLast(3));
        assertEquals(2, singlyLinkedList.getNthFromLast(2));
        assertEquals(3, singlyLinkedList.getNthFromLast(1));

        assertEquals(1, SinglyLinkedList.getNth(singlyLinkedList.head, 1));
        assertEquals(2, SinglyLinkedList.getNth(singlyLinkedList.head, 2));
        assertEquals(3, SinglyLinkedList.getNth(singlyLinkedList.head, 3));
    }

    @Test
    void testGetMiddle() {
        // 1->2->3->4->5 should be 3
        // 1->2->3->4->5->6 should be 4
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.append(5);
        assertEquals(3, singlyLinkedList.getMiddleViaTwoPointers());
        assertEquals(3, singlyLinkedList.getMiddle());
        singlyLinkedList.append(6);
        assertEquals(4, singlyLinkedList.getMiddleViaTwoPointers());
        assertEquals(4, singlyLinkedList.getMiddle());
    }

    @Test
    void testCount() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(3);
        singlyLinkedList.append(3);
        assertEquals(2, singlyLinkedList.count(2));
        assertEquals(2, SinglyLinkedList.count(singlyLinkedList.head, 2));
        assertEquals(3, singlyLinkedList.count(3));
        assertEquals(3, SinglyLinkedList.count(singlyLinkedList.head, 3));
    }

    @Test
    void testDetectLoop() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.push(20);
        singlyLinkedList.push(4);
        singlyLinkedList.push(15);
        singlyLinkedList.push(10);
        singlyLinkedList.head.next.next.next.next = singlyLinkedList.head;
        assertTrue(singlyLinkedList.detectLoop(singlyLinkedList.head));
        assertTrue(singlyLinkedList.detectLoop());
        assertEquals(4, singlyLinkedList.countNodesInLoop());

        singlyLinkedList.head.next.next.next.next = null;
        assertFalse(singlyLinkedList.detectLoop(singlyLinkedList.head));
        assertFalse(singlyLinkedList.detectLoop());
        assertEquals(0, singlyLinkedList.countNodesInLoop());
    }

    @Test
    void testIsPalindrome() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(2);
        singlyLinkedList.append(1);
        assertTrue(SinglyLinkedList.isPalindrome(singlyLinkedList.head));
        singlyLinkedList.append(4);
        assertFalse(SinglyLinkedList.isPalindrome(singlyLinkedList.head));
        singlyLinkedList.push(4);
        assertTrue(SinglyLinkedList.isPalindrome(singlyLinkedList.head));
    }

    @Test
    void testReverse() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.reverse();
        assertEquals(4, singlyLinkedList.getNth(1));
        assertEquals(3, singlyLinkedList.getNth(2));
        assertEquals(2, singlyLinkedList.getNth(3));
        assertEquals(1, singlyLinkedList.getNth(4));
        singlyLinkedList.head = SinglyLinkedList.reverse(singlyLinkedList.head);
        assertEquals(1, singlyLinkedList.getNth(1));
        assertEquals(2, singlyLinkedList.getNth(2));
        assertEquals(3, singlyLinkedList.getNth(3));
        assertEquals(4, singlyLinkedList.getNth(4));
        singlyLinkedList.head = SinglyLinkedList.reverse(singlyLinkedList.head);
        assertEquals(4, singlyLinkedList.getNth(1));
        assertEquals(3, singlyLinkedList.getNth(2));
        assertEquals(2, singlyLinkedList.getNth(3));
        assertEquals(1, singlyLinkedList.getNth(4));
    }

    @Test
    void testSorted() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        assertTrue(singlyLinkedList.isAscend());
        assertFalse(singlyLinkedList.isDescend());
        singlyLinkedList.reverse();
        assertTrue(singlyLinkedList.isDescend());
        assertFalse(singlyLinkedList.isAscend());
    }

    @Test
    void testRemoveDuplicatesWhenSorted() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(1);
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(3);
        singlyLinkedList.append(3);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.removeDuplicatesWhenSorted();
        assertEquals(1, singlyLinkedList.getNth(1));
        assertEquals(2, singlyLinkedList.getNth(2));
        assertEquals(3, singlyLinkedList.getNth(3));
        assertEquals(4, singlyLinkedList.getNth(4));
        singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(1);
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(3);
        singlyLinkedList.append(3);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.reverse();
        singlyLinkedList.removeDuplicatesWhenSorted();
        assertEquals(4, singlyLinkedList.getNth(1));
        assertEquals(3, singlyLinkedList.getNth(2));
        assertEquals(2, singlyLinkedList.getNth(3));
        assertEquals(1, singlyLinkedList.getNth(4));
    }

    @Test
    void testRemoveDuplicatesWhenUnSorted() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(3);
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(3);
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(4);
        singlyLinkedList.append(1);
        singlyLinkedList.removeDuplicatesWhenNotSorted();
        assertEquals(3, singlyLinkedList.getNth(1));
        assertEquals(1, singlyLinkedList.getNth(2));
        assertEquals(2, singlyLinkedList.getNth(3));
        assertEquals(4, singlyLinkedList.getNth(4));
    }

    @Test
    void testSwapTheNextNodeAndHead() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.swapTheNextNodeAndHead(singlyLinkedList.head);
        assertEquals(2, singlyLinkedList.getNth(1));
        assertEquals(1, singlyLinkedList.getNth(2));
    }

    @Test
    void testSwapNodesViaGivenData() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        assertEquals(1, singlyLinkedList.getNth(1));
        assertEquals(2, singlyLinkedList.getNth(2));
        assertEquals(3, singlyLinkedList.getNth(3));
        assertEquals(4, singlyLinkedList.getNth(4));
        singlyLinkedList.swapNodesViaGivenData(1, 4);
        assertEquals(4, singlyLinkedList.getNth(1));
        assertEquals(2, singlyLinkedList.getNth(2));
        assertEquals(3, singlyLinkedList.getNth(3));
        assertEquals(1, singlyLinkedList.getNth(4));
    }

    @Test
    void testPairWiseSwap() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.append(5);
        singlyLinkedList.append(6);
        singlyLinkedList.append(7);
        singlyLinkedList.pairWiseSwap();
        assertEquals(2, singlyLinkedList.getNth(1));
        assertEquals(1, singlyLinkedList.getNth(2));
        assertEquals(4, singlyLinkedList.getNth(3));
        assertEquals(3, singlyLinkedList.getNth(4));
        assertEquals(6, singlyLinkedList.getNth(5));
        assertEquals(5, singlyLinkedList.getNth(6));
        assertEquals(7, singlyLinkedList.getNth(7));
    }

    @Test
    void testMoveLastToFront() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.append(5);
        singlyLinkedList.append(6);
        singlyLinkedList.append(7);
        singlyLinkedList.moveLastToFront();
        assertEquals(7, singlyLinkedList.getNth(1));
        assertEquals(1, singlyLinkedList.getNth(2));
        assertEquals(5, singlyLinkedList.getNth(6));
        assertEquals(6, singlyLinkedList.getNth(7));
    }

    @Test
    void testSortedIntersect() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.append(4);
        singlyLinkedList.append(4);
        singlyLinkedList.append(4);
        singlyLinkedList.append(5);
        singlyLinkedList.append(6);
        singlyLinkedList.append(7);
        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
        singlyLinkedList2.append(1);
        singlyLinkedList2.append(2);
        singlyLinkedList2.append(2);
        singlyLinkedList2.append(4);
        singlyLinkedList2.append(4);
        singlyLinkedList2.append(4);
        singlyLinkedList2.append(4);
        singlyLinkedList2.append(7);
        Node temp = singlyLinkedList.sortedIntersect(singlyLinkedList.head, singlyLinkedList2.head);
        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();
        singlyLinkedList1.head = temp;
        singlyLinkedList1.printList();
        assertEquals("1->2->2->4->4->4->4->7", outContent.toString());
    }

    @Test
    void testSortedIntersectAndRemoveDuplicates() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.append(4);
        singlyLinkedList.append(4);
        singlyLinkedList.append(4);
        singlyLinkedList.append(5);
        singlyLinkedList.append(6);
        singlyLinkedList.append(7);
        SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
        singlyLinkedList2.append(1);
        singlyLinkedList2.append(2);
        singlyLinkedList2.append(2);
        singlyLinkedList2.append(4);
        singlyLinkedList2.append(4);
        singlyLinkedList2.append(4);
        singlyLinkedList2.append(4);
        singlyLinkedList2.append(7);
        Node temp = singlyLinkedList.sortedIntersectAndRemoveDuplicates(singlyLinkedList.head, singlyLinkedList2.head);
        SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();
        singlyLinkedList1.head = temp;
        singlyLinkedList1.printList();
        assertEquals("1->2->4->7", outContent.toString());
    }

}
