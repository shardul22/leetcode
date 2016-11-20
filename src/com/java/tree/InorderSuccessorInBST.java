package com.java.tree;

/**
 * https://leetcode.com/problems/inorder-successor-in-bst/
 */
public class InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root;
        }

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            if (left != null) {
                return left;
            }
            return root;
        }
    }

    public TreeNode inorderPredeceessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root;
        }

        if (root.val <= p.val) {
            TreeNode right = inorderPredeceessor(root.right, p);
            if (right != null) {
                return right;
            }
            return root;
        } else {
            return inorderPredeceessor(root.left, p);
        }
    }

}
