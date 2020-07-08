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
        assertEquals("[4, 2, 5, 1, 3]", Arrays.toString(tree.getInorderLists().toArray()));
        assertEquals("[4, 2, 5, 1, 3]", Arrays.toString(tree.iterativeInorder().toArray()));
        assertEquals("[1, 2, 4, 5, 3]", Arrays.toString(tree.getPreorderLists().toArray()));
        assertEquals("[1, 2, 4, 5, 3]", Arrays.toString(tree.iterativePreorder().toArray()));
        assertEquals("[4, 5, 2, 3, 1]", Arrays.toString(tree.getPostorderLists().toArray()));
        assertEquals("[4, 5, 2, 3, 1]", Arrays.toString(tree.iterativePostorder().toArray()));
    }
}
