package com.java.tree;

/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 */
public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		if(root == null) {
			return 0;
		}
		int closestValue = root.val;
		while(root != null) {
			if(Math.abs(root.val - target) < Math.abs(closestValue - target)) {
				closestValue = root.val;
			}
			root = root.val < target ? root.right : root.left;
		}
		return closestValue;
	}
}
