package com.java.tree;

public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}

		if(root.left == null && root.right == null)
			return root.val == sum;

		int newSum = sum - root.val;
		return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
	}
}
