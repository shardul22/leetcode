package com.java.tree;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 && right == 0)
            return 1;

        if (left == 0)
            return right + 1;
        if (right == 0)
            return left + 1;

        if (left < right)
            return left + 1;
        return right + 1;
    }
}
