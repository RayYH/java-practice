package com.rayyounghong.ds.trees;

/**
 * @author ray
 */
public class Node {
    /** 节点的 key 值 */
    int key;

    /** 左右节点 */
    Node left, right;

    /**
     * 根据给定的 key 初始化一个节点。
     *
     * @param key
     *            给定的 key 值
     */
    Node(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}
