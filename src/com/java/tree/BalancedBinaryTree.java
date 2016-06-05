package com.java.tree;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}

		if(isBalancedTreeHelper(root) == -1) {
			return false;
		}
		return true;
	}

	public int isBalancedTreeHelper(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int left = isBalancedTreeHelper(root.left);
		int right = isBalancedTreeHelper(root.right);

		if(left == -1 || right == -1) {
			return -1;
		}

		if(Math.abs(left - right) > 1)
			return -1;

		return Math.max(left, right) + 1;
	}

}
