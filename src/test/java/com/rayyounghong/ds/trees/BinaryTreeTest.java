package com.rayyounghong.ds.trees;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author ray
 */
public class BinaryTreeTest {

    @Test
    void testBinaryTreeBasic() {
        BinaryTree binaryTree = new BinaryTree();
        assertNull(binaryTree.root);
        binaryTree = new BinaryTree(1);
        assertEquals(1, binaryTree.root.key);
    }

    @Test
    void testBinaryTreeTraversals() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        /*
         *****************************************
         *          1
         *        /  \
         *       2    3
         *     /  \
         *    4    5
         *****************************************
         */
        assertEquals("[4, 2, 5, 1, 3]", Arrays.toString(tree.getInorderLists().toArray()));
        assertEquals("[4, 2, 5, 1, 3]", Arrays.toString(tree.iterativeInorder().toArray()));
        assertEquals("[1, 2, 4, 5, 3]", Arrays.toString(tree.getPreorderLists().toArray()));
        assertEquals("[1, 2, 4, 5, 3]", Arrays.toString(tree.iterativePreorder().toArray()));
        assertEquals("[4, 5, 2, 3, 1]", Arrays.toString(tree.getPostorderLists().toArray()));
        assertEquals("[4, 5, 2, 3, 1]", Arrays.toString(tree.iterativePostorder().toArray()));
        assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(tree.levelOrder().toArray()));
        assertEquals("[[1], [2, 3], [4, 5]]", Arrays.toString(tree.levelOrders().toArray()));
        assertEquals("[[4, 5], [2, 3], [1]]", Arrays.toString(tree.levelOrdersBottom().toArray()));
    }

    @Test
    void testInsert() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        /*
         *****************************************
         *          1
         *        /  \
         *       2    3
         *     /       \
         *    4         6
         *****************************************
         */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.right = new Node(6);
        assertEquals("[1, 2, 3, 4, 6]", Arrays.toString(tree.levelOrder().toArray()));
        tree.insert(7);
        assertEquals("[1, 2, 3, 4, 7, 6]", Arrays.toString(tree.levelOrder().toArray()));
        tree.insert(5);
        assertEquals("[1, 2, 3, 4, 7, 5, 6]", Arrays.toString(tree.levelOrder().toArray()));
    }

    @Test
    void testDelete() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        /*
         *****************************************
         *          1
         *        /  \
         *       2    3
         *     /       \
         *    4         6
         *****************************************
         */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.right = new Node(6);
        assertEquals("[1, 2, 3, 4, 6]", Arrays.toString(tree.levelOrder().toArray()));
        tree.delete(2);
        assertEquals("[1, 6, 3, 4]", Arrays.toString(tree.levelOrder().toArray()));
        tree.delete(1);
        assertEquals("[4, 6, 3]", Arrays.toString(tree.levelOrder().toArray()));
    }
}
