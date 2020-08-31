package com.rayyounghong.ds.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.rayyounghong.ds.queue.Queue;

/**
 * <p>
 * Some properties.
 * </p>
 *
 * <ul>
 * <li><strong>Depth</strong>: The depth of a node is the number of generations the node is removed from the root. The
 * root has depth 0. The root's children have depth 1. Depth can be defined recursively: the depth of node n is 0 if n
 * is the root, or 1 plus the depth of n's parent otherwise.</li>
 * <li><strong>Height</strong>: The height of tree {@code T} is the maximum depth of any node of {@code T}.</li>
 * <li><strong>Binary Tree</strong>: A binary tree is a rooted tree such that every node has <i>at most two
 * children</i>. The children (when present) are known as the left child and right child.</li>
 * <li><strong>Full Binary Tree</strong>: A Binary Tree is a full binary tree if every node has 0 or 2 children. We can
 * also say a full binary tree is a binary tree in which all nodes except leaf nodes have two children.</li>
 * <li><strong>Complete Binary Tree</strong>: A Binary Tree is a complete Binary Tree if all the levels are completely
 * filled except possibly the last level and the last level has all keys as left as possible.</li>
 * <li><strong>Perfect Binary Tree</strong>: A Binary tree is a Perfect Binary Tree in which all the internal nodes have
 * two children and all leaf nodes are at the same level.</li>
 * <li><strong>Balanced Binary Tree</strong>: A binary tree is balanced if the height of the tree is {@code O(Log n)}
 * where n is the number of nodes. For Example, the AVL tree maintains {@code O(Log n)} height by making sure that the
 * difference between the heights of the left and right subtrees is almost 1. Red-Black trees maintain {@code O(Log n)}
 * height by making sure that the number of Black nodes on every root to leaf paths is the same and there are no
 * adjacent red nodes. Balanced Binary Search trees are performance-wise good as they provide {@code O(log n)} time for
 * search, insert and delete.</li>
 * </ul>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees">Types of binary trees.</a>
 * @see <a href="https://en.wikipedia.org/wiki/Tree_traversal">Tree traversal.</a>
 * @see <a href="http://faculty.cs.niu.edu/~mcmahon/CS241/Notes/Data_Structures/binary_tree_traversals.html">Binary Tree
 *      Traversals</a>
 * @author ray
 */
public class BinaryTree {
    /**
     * root node.
     */
    Node root;

    /*
     * ----------------------------------------------------------
     * Lists for saving results from tree traversals (DFS).
     * For testing usage.
     * ----------------------------------------------------------
     */

    static List<Integer> inorderList = new ArrayList<>();
    static List<Integer> postorderList = new ArrayList<>();
    static List<Integer> preorderList = new ArrayList<>();

    /*
     * ----------------------------------------------------------
     * Constructors.
     * ----------------------------------------------------------
     */

    /**
     * Generate a tree with root node.
     *
     * @param key
     *            root key
     */
    BinaryTree(int key) {
        root = new Node(key);
    }

    /**
     * Generate a empty tree.
     */
    BinaryTree() {
        root = null;
    }

    /*
     * ----------------------------------------------------------
     * Get lists updated by different traversal strategies.
     * ----------------------------------------------------------
     */

    List<Integer> getInorderLists() {
        inorderList.clear();
        inorder(root);
        return inorderList;
    }

    List<Integer> getPreorderLists() {
        preorderList.clear();
        preorder(root);
        return preorderList;
    }

    List<Integer> getPostorderLists() {
        postorderList.clear();
        postorder(root);
        return postorderList;
    }

    /*
     * ----------------------------------------------------------
     * Recursive traversals.
     * ----------------------------------------------------------
     */

    /**
     * Left, Root, Right.
     *
     * @param node
     *            given node
     */
    static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            inorderList.add(node.key);
            inorder(node.right);
        }
    }

    /**
     * Root, Left, Right.
     *
     * @param node
     *            given node
     */
    static void preorder(Node node) {
        if (node != null) {
            preorderList.add(node.key);
            preorder(node.left);
            preorder(node.right);
        }
    }

    /**
     * Left, Right, Root.
     *
     * @param node
     *            given node
     */
    static void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            postorderList.add(node.key);
        }
    }

    /*
     * ----------------------------------------------------------
     * Non-recursive traversals.
     * ----------------------------------------------------------
     */

    List<Integer> iterativePreorder() {
        List<Integer> l = new ArrayList<>();
        Node node = root;
        if (node == null) {
            return l;
        }

        Stack<Node> s = new Stack<>();
        s.push(node);

        while (!s.isEmpty()) {
            node = s.pop();
            l.add(node.key);
            // right child is pushed first so that left is processed first
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }

        return l;
    }

    List<Integer> iterativeInorder() {
        List<Integer> l = new ArrayList<>();
        Node node = root;
        Stack<Node> s = new Stack<>();
        while (!s.isEmpty() || node != null) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
                l.add(node.key);
                node = node.right;
            }
        }

        return l;
    }

    List<Integer> iterativePostorder() {
        List<Integer> l = new ArrayList<>();
        Node node = root;
        Node peekNode;
        Node lastVisitedNode = null;
        Stack<Node> s = new Stack<>();
        while (!s.isEmpty() || node != null) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                peekNode = s.peek();
                // if right child exists and traversing node
                // from left child, then move right
                if (peekNode.right != null && lastVisitedNode != peekNode.right) {
                    node = peekNode.right;
                } else {
                    l.add(peekNode.key);
                    lastVisitedNode = s.pop();
                }
            }
        }

        return l;
    }

    List<Integer> levelOrder() {
        Queue<Node> q = new Queue<>();
        List<Integer> l = new ArrayList<>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            Node node = q.dequeue();
            l.add(node.key);
            if (node.left != null) {
                q.enqueue(node.left);
            }
            if (node.right != null) {
                q.enqueue(node.right);
            }
        }

        return l;
    }
}
