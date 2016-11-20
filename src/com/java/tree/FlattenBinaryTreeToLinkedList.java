package com.java.tree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root != null) {
            while (root != null) {
                if (root.left == null) {
                    root = root.right;
                    continue;
                }
                TreeNode left = root.left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }

    /*
     * O(n) space solution;
     * */
    public void flatten_2(TreeNode root) {

        Stack<TreeNode> nodeStack = new Stack<>();

        if (root != null) {
            while (root != null || !nodeStack.isEmpty()) {
                if (root.right != null) {
                    nodeStack.push(root.right);
                }

                if (root.left != null) {
                    root.right = root.left;
                    root.left = null;
                } else if (!nodeStack.isEmpty()) {
                    root.right = nodeStack.pop();
                }
                root = root.right;
            }
        }
    }
}
