package com.rayyounghong.ds.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.rayyounghong.ds.queue.Queue;

/**
 * 二叉树。
 *
 * @author ray
 */
public class BinaryTree {

    /**
     * 根节点。
     */
    Node root;

    /**
     * visited 存储了 DFS 遍历的值，方便测试用例编写。
     */
    static List<Integer> visited = new ArrayList<>();

    /**
     * 创建一个单节点的二叉树。
     *
     * @param key
     *            root key
     */
    BinaryTree(int key) {
        root = new Node(key);
    }

    /**
     * 创建一个空的二叉树。
     */
    BinaryTree() {
        root = null;
    }

    /**
     * 层级遍历元素。
     *
     * @return 符合层级遍历顺序的元素构成的列表。
     */
    List<Integer> levelOrder() {
        /*
         *****************************************
         *          1
         *        /  \
         *       2    3
         *     /  \
         *    4    5
         *****************************************
         */

        // -------------------------------------------------------------------------------------------------------------
        // 所有的遍历都可以理解为在一个数组中按指定顺序放入原数据结构中的各个元素并且在适当的时候从内存中移除掉该元素。
        // 根据上面的思想，我们需要解决的问题什么时候从内存中移除掉我们访问过的元素。
        // 假设我们逐一遍历数组，显然我们访问就可以移除掉访问的元素，因为我们可以根据下标得到下一个元素的位置。
        // -------------------------------------------------------------------------------------------------------------
        // 但二叉树的层级遍历则不同，按照遍历要求，我们很自然地有如下的选择措施：
        // a. 根据根节点直接取出 1 并放入到数组中，内存中有 1
        // b. 根据内存中已有的 1 取出 2 并放入到数组中，内存中有 1、2
        // c. 根据内存中已有的 1 取出 3 并放入到数组中，内存中有 1、2、3
        // d. 根据内存中已有的 2 取出 4 并放入到数组中，内存中有 1、2、3、4
        // e. 根据内存中已有的 2 取出 5 并放入到数组中，内存中有 1、2、3、4、5
        // -------------------------------------------------------------------------------------------------------------
        // 步骤 a 取出了节点 1 - 第 1 层
        // 步骤 b，c 取出了节点 1 的子节点 - 第 2 层，这一步骤执行完毕，我们可以释放掉节点 1，因为后面不再需要节点 1 了
        // 步骤 d，e 取出了节点 2 的子节点 - 第 3 层，同理节点 2 可以被释放了
        // -------------------------------------------------------------------------------------------------------------
        // 到这里，我们已经基本有了一个方案了，释放节点的时间就是该节点的左右节点都被访问了的时候。
        // 还有一个问题，我们怎么存储这些暂存的节点？这个问题的解决办法很简单，先访问先释放，使用队列，先访问后释放，使用栈
        // 看到这里，想必你已豁然开朗，层级遍历使用队列辅助就完事了
        // -------------------------------------------------------------------------------------------------------------

        // 用列表来存储访问过的元素
        List<Integer> l = new ArrayList<>();
        // 用队列来暂存还不能释放的元素
        Queue<Node> q = new Queue<>();
        // 根节点加如队列
        q.enqueue(root);
        // 只要还有节点未被释放，说明有可能有子节点，则进行访问
        while (!q.isEmpty()) {
            // 这里访问节点和从暂存列表中释放节点的顺序与我们前边的讨论相反，因为是同时执行的，所以无关紧要
            // 从队列中取出节点，并取出其左右节点加入到暂存队列中去
            Node node = q.dequeue();
            // 访问该节点
            l.add(node.key);
            // 左右节点均加入暂存队列中去
            if (node.left != null) {
                q.enqueue(node.left);
            }
            if (node.right != null) {
                q.enqueue(node.right);
            }
        }

        return l;
    }

    /**
     * 在当前二叉树中插入一个新的节点，节点的位置符合层级遍历顺序，即靠左上方的位置。
     *
     * 基本思想就是逐层遍历整棵树，即 BFS 广度优先遍历。如果我们发现一个节点的左节点为空，就将新节点作为该节点的左节点。如果我们发现一个节点的右节点为空，即将新节点作为该节点的右节点。
     */
    void insert(int key) {
        // 空树直接将新节点作为根节点
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
        visited.clear();
        inorder(root);
        return visited;
    }

    List<Integer> getPreorderLists() {
        visited.clear();
        preorder(root);
        return visited;
    }

    List<Integer> getPostorderLists() {
        visited.clear();
        postorder(root);
        return visited;
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
        visited.add(node.key);
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

}
