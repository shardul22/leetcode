package com.java.tree;

import java.util.Stack;

public class KthSmallestElementBST {

	public int kthSmallest(TreeNode root, int k) {
		return kthSmallest_iterative(root, k);
	}

	public int kthSmallest_iterative(TreeNode root, int k) {
		Stack<TreeNode> nodeStack = new Stack<>();
		int result = 0;
		while(root != null || !nodeStack.isEmpty()) {
			if(root != null) {
				nodeStack.push(root);
				root = root.left;
			} else {
				TreeNode temp = nodeStack.pop();
				result++;
				if(result == k) {
					return temp.val;
				}
				if(temp.right != null) {
					root = temp.right;
				}
			}
		}
		return result;
	}
}
