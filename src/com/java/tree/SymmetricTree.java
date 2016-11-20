package com.java.tree;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirrorHelper(root.left, root.right);
    }

    public boolean isMirrorHelper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null)
            return true;

        if (leftNode == null || rightNode == null)
            return false;

        return leftNode.val == rightNode.val &&
                isMirrorHelper(leftNode.left, rightNode.right) &&
                isMirrorHelper(leftNode.right, rightNode.left);
    }

}
