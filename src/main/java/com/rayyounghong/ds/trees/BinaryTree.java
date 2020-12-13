package com.rayyounghong.ds.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.rayyounghong.ds.queue.Queue;

/**
 * Binary Tree.
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

    static List<Integer> list = new ArrayList<>();

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

    /**
     * Given a binary tree and a key, insert the key into the binary tree at the first position available in level
     * order.
     *
     * The idea is to do iterative level order traversal of the given tree using queue. If we find a node whose left
     * child is empty, we make new key as left child of the node. Else if we find a node whose right child is empty, we
     * make the new key as right child. We keep traversing the tree until we find a node whose either left or right is
     * empty.
     *
     * @see <a href= "https://www.geeksforgeeks.org/deletion-binary-tree/">Deletion in a Binary Tree</a>
     */
    void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }

        Node temp = root;

        Queue<Node> q = new Queue<>();
        q.enqueue(temp);

        while (!q.isEmpty()) {
            temp = q.dequeue();
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else {
                q.enqueue(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else {
                q.enqueue(temp.right);
            }
        }
    }

    private void deleteDeepestNode(Node deepestNode) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new Queue<>();
        Node temp = root;
        q.enqueue(temp);
        while (!q.isEmpty()) {
            temp = q.dequeue();
            if (temp.right != null) {
                if (temp.right == deepestNode) {
                    temp.right = null;
                    return;
                } else {
                    q.enqueue(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == deepestNode) {
                    temp.left = null;
                    return;
                } else {
                    q.enqueue(temp.left);
                }
            }
        }
    }

    void delete(int key) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (root.key == key) {
                root = null;
            }
            return;
        }

        // find the keyNode and the deepestNode
        Node temp = root, keyNode = null;
        Queue<Node> q = new Queue<>();
        q.enqueue(temp);
        while (!q.isEmpty()) {
            temp = q.dequeue();
            if (temp.key == key) {
                keyNode = temp;
            }

            if (temp.left != null) {
                q.enqueue(temp.left);
            }

            if (temp.right != null) {
                q.enqueue(temp.right);
            }
        }

        if (keyNode != null) {
            keyNode.key = temp.key;
            deleteDeepestNode(temp);
        }
    }

    /*
     * ----------------------------------------------------------
     * Get list updated by different traversal strategies.
     * ----------------------------------------------------------
     */

    List<Integer> getInorderLists() {
        list.clear();
        inorder(root);
        return list;
    }

    List<Integer> getPreorderLists() {
        list.clear();
        preorder(root);
        return list;
    }

    List<Integer> getPostorderLists() {
        list.clear();
        postorder(root);
        return list;
    }

    /*
     * ----------------------------------------------------------
     * visit method.
     * ----------------------------------------------------------
     */

    /**
     * Visit element.
     *
     * @param node
     *            node will be visited
     */
    static void visit(Node node) {
        list.add(node.key);
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
            visit(node);
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
            visit(node);
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
            visit(node);
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

    /*
     * ----------------------------------------------------------
     * BFS traversal..
     * ----------------------------------------------------------
     */

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
