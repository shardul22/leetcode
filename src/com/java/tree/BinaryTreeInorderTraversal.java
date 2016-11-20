package com.java.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        return inorderTraversalIterative(root, resultList);
    }

    public List<Integer> inorderTraversalIterative(TreeNode root, List<Integer> resultList) {
        if (root == null) {
            return resultList;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        while (root != null || !nodeStack.isEmpty()) {
            if (root != null) {
                nodeStack.push(root);
                root = root.left;
            } else {
                TreeNode temp = nodeStack.pop();
                resultList.add(temp.val);
                if (temp.right != null) {
                    root = temp.right;
                }
            }
        }
        return resultList;
    }

    public void inOrderHelperRecursive(TreeNode root, List<Integer> resultList) {
        if (root != null) {
            inOrderHelperRecursive(root.left, resultList);
            resultList.add(root.val);
            inOrderHelperRecursive(root.right, resultList);
        }
    }

}
