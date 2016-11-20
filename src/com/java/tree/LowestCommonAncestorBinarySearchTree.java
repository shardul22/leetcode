package com.java.tree;

public class LowestCommonAncestorBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if (root.val <= q.val && p.val <= root.val)
            return root;

        if (root.val <= p.val && q.val <= root.val)
            return root;

        //Traverse left subtree if null then traverse right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if (left == null) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return left;
    }
}
