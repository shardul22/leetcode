package com.java.tree;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		if(root ==null) {
			return 0;
		}
		int max[] = new int[1];
		max[0] = Integer.MIN_VALUE;
		maxPathSumHelper(root, max);
		return max[0];
	}
	
	public int maxPathSumHelper(TreeNode root, int[] max) {
		if(root == null) {
			return 0;
		}
		int left = Math.max(0, maxPathSumHelper(root.left, max));
		int right = Math.max(0, maxPathSumHelper(root.right, max));
		max[0] = Math.max(max[0], left + right + root.val);
		return Math.max(left, right) + root.val;
	}
}
