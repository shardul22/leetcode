package com.java.tree;

import java.util.Stack;

public class BSTIterator {

	private Stack<TreeNode> nodeStack;
	public BSTIterator(TreeNode root) {
		if(root != null) {
			nodeStack = new Stack<>();
			while(root != null) {
				nodeStack.push(root);
				root = root.left;
			}
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if(nodeStack != null)
			return !nodeStack.isEmpty();
		return false;
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode temp = nodeStack.pop();
		if(temp.right != null) {
			TreeNode root = temp.right;
			while(root != null) {
				nodeStack.push(root);
				root = root.left;
			}
		}
		return temp.val;
	}

}
