package com.java.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	/*
		3
	   / \
	  9  20
	    /  \
	   15   7
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> resultList = new ArrayList<>();
		if(root == null) {
			return resultList;
		}
		
		Stack<TreeNode> leftToRightStack = new Stack<>();
		Stack<TreeNode> rightToLeftStack = new Stack<>();
		
		leftToRightStack.push(root);
		while(!leftToRightStack.isEmpty() || !rightToLeftStack.isEmpty()) {
			List<Integer> leftToRightList = new ArrayList<>();
			List<Integer> rightToLeftList = new ArrayList<>();
			while(!leftToRightStack.isEmpty()) {
				TreeNode temp = leftToRightStack.pop();
				leftToRightList.add(temp.val);
				if(temp.left != null) {
					rightToLeftStack.push(temp.left);
				}
				if(temp.right != null) {
					rightToLeftStack.push(temp.right);
				}
			}
			if(leftToRightList.size() != 0) {
				resultList.add(leftToRightList);
			}
			while(!rightToLeftStack.isEmpty()) {
				TreeNode temp = rightToLeftStack.pop();
				rightToLeftList.add(temp.val);
				if(temp.right != null) {
					leftToRightStack.push(temp.right);
				}
				if(temp.left != null) {
					leftToRightStack.push(temp.left);
				}
				
			}
			if(rightToLeftList.size() != 0) {
				resultList.add(rightToLeftList);
			}
		}
		return resultList;
	}
}
