package com.rayyounghong.ds.trees;

/**
 * @author ray
 * @date 2020/7/6
 */
public class Node {

    int key;

    Node left, right;

    Node(int item) {
        this.key = item;
        this.left = this.right = null;
    }
}
