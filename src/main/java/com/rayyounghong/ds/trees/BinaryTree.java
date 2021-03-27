package com.rayyounghong.ds.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;

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
     * 层序遍历二叉树中的所有元素。
     *
     * @return 符合层序遍历顺序的元素构成的列表
     */
    List<Integer> levelOrder() {
        List<Integer> l = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node node = q.poll();
            l.add(node.key);
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }

        return l;
    }

    /**
     * 层序遍历二叉树中的所有元素，每一层的元素自顶往下存放于不同的列表中。
     *
     * @return 存储了遍历结果的二维列表
     */
    List<List<Integer>> levelOrders() {
        List<List<Integer>> l = new ArrayList<>();
        if (root == null) {
            return l;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> levelList = getCurrentLevelListFromQueue(q);
            l.add(levelList);
        }

        return l;
    }

    /**
     * 层序遍历二叉树中的所有元素，每一层的元素自底向上存放于不同的列表中。
     *
     * @return 存储了遍历结果的二维列表
     */
    List<List<Integer>> levelOrdersBottom() {
        List<List<Integer>> l = new LinkedList<>();
        if (root == null) {
            return l;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> levelList = getCurrentLevelListFromQueue(q);
            l.add(0, levelList);
        }

        return l;
    }

    /**
     * 遍历队列中当前已存在的元素，并按层序遍历的顺序修改队列。
     *
     * @param q
     *            辅助队列
     * @return 存放了当前层级元素的列表
     */
    private List<Integer> getCurrentLevelListFromQueue(Queue<Node> q) {
        int currentLevelSize = q.size();
        List<Integer> levelList = new ArrayList<>();
        for (int i = 0; i < currentLevelSize; i++) {
            Node node = q.poll();
            assert node != null;
            levelList.add(node.key);
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        return levelList;
    }

    /**
     * 在当前二叉树中插入一个新的节点，节点的位置为层序遍历时第一个可用的位置。基本思想就是逐层遍历整棵树，即 BFS 广度优先遍历。
     * 如果我们发现一个节点的左节点为空，就将新节点作为该节点的左节点。如果我们发现一个节点的右节点为空，即将新节点作为该节点的右节点。
     *
     * @param key
     *            插入节点的 key 值
     */
    void insert(int key) {
        // 空树直接将新节点作为根节点
        if (root == null) {
            root = new Node(key);
            return;
        }
        // 否则采用层序遍历的策略
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            // 左子节点为空，直接插入到该位置
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else {
                // 不为空则添加到『缓存』
                q.offer(temp.left);
            }
            // 右子节点为空，直接插入到该位置
            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else {
                // 不为空则添加到『缓存』
                q.offer(temp.right);
            }
        }
    }

    /**
     * 从二叉树中删除位于最深层最右边的对应给定 key 的节点，删除节点替换为最深层最右边的节点，可以理解为该操作就是一个不断缩小层级的过程。
     *
     * @param key
     *            节点对应的 key
     */
    void delete(int key) {
        // -------------------------------------------------------------------------------------------------------------
        // 该问题的核心思想就是先找到位于做深层最右边的元素，然后和要删除的元素进行交换，最后删除掉位于最深层最右边的元素
        // 显然，最深层最右边必然涉及到层序遍历，使用队列辅助即可，值得注意的是我们需要考虑一下边缘条件。
        // 如果该树为空树，直接返回即可。
        // 如果该树只有根节点，直接判断根节点 key 与给定的 key 是否相等，相等则删除，不等则直接返回。
        // -------------------------------------------------------------------------------------------------------------

        // 空树直接返回
        if (root == null) {
            return;
        }

        // 树只有根节点
        if (root.left == null && root.right == null) {
            if (root.key == key) {
                root = null;
            }
            return;
        }

        // 层序遍历
        Node temp = root, keyNode = null;
        Queue<Node> q = new LinkedList<>();
        q.offer(temp);
        while (!q.isEmpty()) {
            temp = q.poll();
            // 这里没有 break，因为我们需要找到位于最深层最右边的节点
            // 如果只需要找到第一个满足条件的的节点，这里 break 即可
            if (temp.key == key) {
                keyNode = temp;
            }
            // 左右非空子节点加入队列
            if (temp.left != null) {
                q.offer(temp.left);
            }
            if (temp.right != null) {
                q.offer(temp.right);
            }
        }

        // 层序遍历中最后一个从队列中取出的元素即为最深层最右边的节点元素
        if (keyNode != null) {
            // 这里直接改 key
            keyNode.key = temp.key;
            // 删除位于最深层最右边的节点，这里的 temp 节点实际上不是一个必需参数
            deleteDeepestNode(temp);
        }
    }

    /**
     * 删除位于最深层最右边的节点。
     *
     * @param deepestNode
     *            位于最深层最右边的待删除的节点
     */
    private void deleteDeepestNode(Node deepestNode) {
        // 空树直接返回
        if (root == null) {
            return;
        }

        // 层序遍历
        Queue<Node> q = new LinkedList<>();
        Node temp = root;
        q.offer(temp);
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.right != null) {
                if (temp.right == deepestNode) {
                    temp.right = null;
                    return;
                } else {
                    q.offer(temp.right);
                }
            }
            if (temp.left != null) {
                if (temp.left == deepestNode) {
                    temp.left = null;
                    return;
                } else {
                    q.offer(temp.left);
                }
            }
        }
    }

    /**
     * 中序遍历。
     *
     * @return 返回中序遍历的结果。
     */
    List<Integer> getInorderLists() {
        visited.clear();
        inorder(root);
        return visited;
    }

    /**
     * 前序遍历。
     *
     * @return 返回前序遍历的结果。
     */
    List<Integer> getPreorderLists() {
        visited.clear();
        preorder(root);
        return visited;
    }

    /**
     * 后序遍历。
     *
     * @return 返回后序遍历的结果。
     */
    List<Integer> getPostorderLists() {
        visited.clear();
        postorder(root);
        return visited;
    }

    /**
     * 访问指定元素，应该输出到终端，这里我们直接添加到声明的队列即可。
     *
     * @param node
     *            待访问的节点
     */
    static void visit(Node node) {
        visited.add(node.key);
    }

    /**
     * 中序遍历，即按左子树、根节点、右子树的顺序遍历。
     *
     * @param node
     *            当前访问的节点
     */
    static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            visit(node);
            inorder(node.right);
        }
    }

    /**
     * 前序遍历，即按根节点、左子树、右子树的顺序遍历。
     *
     * @param node
     *            当前访问的节点
     */
    static void preorder(Node node) {
        if (node != null) {
            visit(node);
            preorder(node.left);
            preorder(node.right);
        }
    }

    /**
     * 后序遍历，即按左子树、右子树、根节点的顺序遍历。
     *
     * @param node
     *            当前访问的节点
     */
    static void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            visit(node);
        }
    }

    /**
     * 前序遍历的非递归解法。
     *
     * @return 存储了遍历结果的列表
     */
    List<Integer> iterativePreorder() {
        /*
         *****************************************
         *          1
         *        /  \
         *       2    3
         *     /  \
         *    4    5
         *****************************************
         * 遍历结果 1 2 4 5 3
         *****************************************
         */
        // -------------------------------------------------------------------------------------------------------------
        // a. 从『来源』中根据 root 直接取出 1 并输出到『目标』，『缓存』中有 1
        // b. 根据『缓存』中已有的 1 取出 2 并输出到『目标』，『缓存』中有 1、2
        // c. 根据『缓存』中已有的 2 取出 4 并输出到『目标』，『缓存』中有 1、2、4
        // d. 根据『缓存』中已有的 2 取出 5 并输出到『目标』，『缓存』中有 1、2、4、5
        // e. 根据『缓存』中已有的 1 取出 3 并输出到『目标』，『缓存』中有 1、2、3、4、5
        // -------------------------------------------------------------------------------------------------------------
        // 在步骤 b 和步骤 e 中，这两步的元素目标依赖于『缓存』中的同一个值，因此我们可以率先取出 3 存放于『缓存』，步骤调整为
        // -------------------------------------------------------------------------------------------------------------
        // a. 从『来源』中根据 root 直接取出 1 并输出到『目标』，『缓存』中有 1
        // b. 根据『缓存』中已有的 1 取出 2 并输出到『目标』，『缓存』中有 1、2
        // c. 根据『缓存』中已有的 1 取出 3，『缓存』中有 1、2、3
        // d. 根据『缓存』中已有的 2 取出 4 并输出到『目标』，『缓存』中有 1、2、3、4
        // e. 根据『缓存』中已有的 2 取出 5 并输出到『目标』，『缓存』中有 1、2、3、4、5
        // f. 根据『缓存』中已有的 3 直接输出到『目标』，缓存中有 1、2、3、4、5
        // -------------------------------------------------------------------------------------------------------------
        // 首先我们明确节点从『缓存』中移除的时机。
        // 显然，节点 1 在左右节点 2、3 存放到『缓存』后就可从『缓存』中移除，因为此时节点 1 已到达『目标』且后面的节点访问不依赖它。
        // 然后我们明确释放的顺序，节点 4 和 5 比节点 3 后加入『缓存』但率先从『缓存』中移除，因为得先访问完左子树才能访问右子树。
        // 从这一点看，『缓存』应当遵从后进先出的顺序，所以我们可以使用栈来实现『缓存』。
        // -------------------------------------------------------------------------------------------------------------

        // 使用列表『目标』
        List<Integer> l = new ArrayList<>();
        Node node = root;

        // 空树直接返回
        if (node == null) {
            return l;
        }

        // 栈作为辅助空间
        Stack<Node> s = new Stack<>();
        // 根节点加入『缓存』
        s.push(node);

        while (!s.isEmpty()) {
            // 从『缓存』中取出元素输出到『目标』
            node = s.pop();
            l.add(node.key);
            // 从『来源』中取出元素存放到『缓存』，由于我们采用了栈，后访问左子树意味着先把右节点加入『栈』
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }

        return l;
    }

    /**
     * 中序遍历的非递归解法。
     *
     * @return 存储了遍历结果的列表
     */
    List<Integer> iterativeInorder() {
        /*
         *****************************************
         *          1
         *        /  \
         *       2    3
         *     /  \
         *    4    5
         *****************************************
         * 遍历结果 4 2 5 1 3
         *****************************************
         */
        // 中序遍历意味着按左子树、根节点、右子树的顺序访问元素。
        // 由于我们需要通过根节点来访问右子树，因此访问右子树之前我们不能从『缓存』中移除根节点。
        // 在左子树访问完全之前我们不能访问根节点，也不能访问右子树。
        // 因此我们得先不考虑右子树的问题，我们尽可能地先将左节点加入『缓存』，并且这些节点的遍历顺序符合后进先出的特性。
        // 于是我们可以采用栈，先尽可能地将左节点入栈，在出栈的时候访问该节点，然后对节点的右子树重复类似的步骤。

        List<Integer> l = new ArrayList<>();
        Node node = root;
        // 『缓存』
        Stack<Node> s = new Stack<>();
        while (!s.isEmpty() || node != null) {
            // 尽可能地将左节点入栈
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                // 左节点全部入栈后，访问该节点，并对右节点重复类似的步骤
                node = s.pop();
                l.add(node.key);
                node = node.right;
            }
        }

        return l;
    }

    /**
     * 后序遍历的非递归解法。
     *
     * @return 存储了遍历结果的列表
     */
    List<Integer> iterativePostorder() {
        /*
         *****************************************
         *          1
         *        /  \
         *       2    3
         *     /  \
         *    4    5
         *****************************************
         * 遍历结果 4 5 2 3 1
         *****************************************
         */
        // 后序遍历与中序类似，由于第一个访问的节点，仍然是左子节点，因此我们仍然需要尽可能地先把左边的节点先加入『缓存』。
        // 显然这些节点也符合后进先出的特性，所以我们依然可以采用栈这个存储结构。因此三种 DFS 遍历全部采用了栈这种辅助结构。
        // 后序遍历与中序遍历的不同之处在于，当左节点全部入栈，由于该节点可能存在右子节点，因此我们不能直接从栈顶弹出。
        // 我们得先取出栈顶的节点但并不弹出，然后判断该节点是否存在右子节点，如果存在右子节点则将该节点作为新的父节点重复之前的步骤。
        // 值得注意的是，这里的栈顶元素在右子树访问完成后会被再次访问，因此我们的标记一下最近访问的节点。
        // 如果节点来自左子树，则说明是第一次访问该节点，因此我们需要取出右子树。
        // 如果节点来自右子树，说明右子树访问完全，直接对该节点出栈即可。
        List<Integer> l = new ArrayList<>();
        Node node = root;
        Node peekNode;
        Node lastVisitedNode = null;
        Stack<Node> s = new Stack<>();
        while (!s.isEmpty() || node != null) {
            // 如果节点不为空，直接将该节点入栈，并且调整下一个操作的节点为子节点
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                // 如果节点为空，代表左子节点已经全部入栈，我们需要判断该节点的右子树是否为空，注意不对该节点执行出栈操作
                peekNode = s.peek();
                // 如果该节点的右节点存在，并且最后依次访问的节点不是来自于右子树，我们遍历右子树
                if (peekNode.right != null && lastVisitedNode != peekNode.right) {
                    node = peekNode.right;
                } else {
                    // 如果最近一次访问的节点等于该节点的右节点，说明右子树遍历完毕，这时我们可以对栈执行出栈操作
                    lastVisitedNode = s.pop();
                    l.add(lastVisitedNode.key);
                }
            }
        }

        return l;
    }
}
