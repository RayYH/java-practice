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
    /** 根节点 */
    Node root;

    /** visited 存储了 DFS 遍历的值，方便对遍历结果进行单元测试 */
    static List<Integer> visited = new ArrayList<>();

    /**
     * 创建一个只有根节点的二叉树。
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
     * 层级遍历二叉树中的所有元素。
     *
     * @return 符合层级遍历顺序的元素构成的列表
     */
    List<Integer> levelOrder() {
        // -------------------------------------------------------------------------------------------------------------
        // 遍历，即按照某种特定的顺序依次访问指定数据结构中的各个元素，解决这种问题的关键点在于如何保证我们的『访问』顺序。
        // 为了使问题形象化，我们将原数据结构称为『来源』，遍历结果的最终存放位置称为『目标』，『来源』中所取元素的暂存位置我们称之为『缓存』。
        // 那么所有的遍历问题都可以描述为两个主要步骤：
        // 1. 从『来源』中逐一取出元素存放于『缓存』
        // 2. 从『缓存』中逐一取出元素输出到『目标』
        // 由于『缓存』的大小一般不是无限大的，因此我们必须要在合适的时机清除掉位于『缓存』中无用的元素，而这才是大多数遍历算法的核心所在。
        // -------------------------------------------------------------------------------------------------------------
        // 在开始介绍二叉树的层级遍历之前，我们先讲解一下一维数组的遍历。
        // 假设有一个数组 A 为 int[]{1, 2, 3, 4, 5}，我们有一个从零开始自增的索引值 i
        // 受限，我们取出第一个元素 1，由于后面的元素都不依赖于 1 这个值，因为它们可以通过数组 A[i] 直接获得。所以这时候我们可以直接释放 A 或者
        // 说我们根本就不建立一个所谓的『缓冲』。
        // -------------------------------------------------------------------------------------------------------------
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
        // 但二叉树的层级遍历则不同，对于上面这棵树，按照『层级』的要求，我们很自然地有如下的选择措施：
        // a. 从『来源』中根据 root 直接取出 1 并输出到『目标』，『缓存』中有 1
        // b. 根据『缓存』中已有的 1 取出 2 并输出到『目标』，『缓存』中有 1、2
        // c. 根据『缓存』中已有的 1 取出 3 并输出到『目标』，『缓存』中有 1、2、3
        // d. 根据『缓存』中已有的 2 取出 4 并输出到『目标』，『缓存』中有 1、2、3、4
        // e. 根据『缓存』中已有的 2 取出 5 并输出到『目标』，『缓存』中有 1、2、3、4、5
        // -------------------------------------------------------------------------------------------------------------
        // 步骤 a 取出了节点 1 - 第 1 层元素输出完毕
        // 步骤 b，c 取出了节点 1 的子节点 - 第 2 层元素输出完毕，此时我们可以从『缓存』中清除掉节点 1，因为后面不再需要节点 1 了
        // 步骤 d，e 取出了节点 2 的子节点 - 第 3 层元素输出完毕，同理我们可以从『缓冲』中清除掉节点 2
        // -------------------------------------------------------------------------------------------------------------
        // 到这里，我们已经可以明确，在一个节点的左右子节点都输出到『目标』之后，我们便可以从『缓存』中清除掉该节点。
        // 但还有一个问题需要解决，我们如何定义『缓存』的数据结构。
        // 解决这个问题的解决办法很简单，『缓存』中先来的元素先释放则使用队列，『缓存』中后来的元素先释放则使用栈。
        // 显然，左边的子节点先加入『缓存』中，也率先从『缓存』中移除，二叉树的层级遍历使用队列即可。
        // -------------------------------------------------------------------------------------------------------------

        // 用列表来存储『目标』
        List<Integer> l = new ArrayList<>();
        // 用队列来作为『缓存』
        Queue<Node> q = new Queue<>();
        // 取出根节点并加入到『缓存』
        q.enqueue(root);
        // 因为『缓存』的大小非 0，因此只要『缓存』中还有节点，说明『来源』中取出来的元素并未全部输出到『目标』
        while (!q.isEmpty()) {
            // 从『缓存』中取出元素
            Node node = q.dequeue();
            // 『缓存』中取出的元素输出到『目标』中
            l.add(node.key);
            // 『来源』中取出的元素添加到『缓存』中
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
