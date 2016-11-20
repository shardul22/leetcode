package com.java.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        while (root != null || !nodeStack.isEmpty()) {
            if (root != null) {
                nodeStack.push(root);
                root = root.left;
            } else {
                if (nodeStack.peek().right != null) {
                    root = nodeStack.peek().right;
                } else {
                    root = nodeStack.pop();
                    resultList.add(root.val);
                    while (!nodeStack.isEmpty() && root == nodeStack.peek().right) {
                        root = nodeStack.pop();
                        resultList.add(root.val);
                    }
                    if (!nodeStack.isEmpty()) {
                        root = nodeStack.peek().right;
                    } else {
                        root = null;
                    }
                }
            }
        }
        return resultList;
    }
}
