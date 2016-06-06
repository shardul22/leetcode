package com.java.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	
	public List<Integer> preorderTraversal(TreeNode root) {
		return preOrderHelper(root);
	}
	
	public List<Integer> preOrderHelper(TreeNode root) {
		List<Integer> resultList = new ArrayList<>();
		if(root == null) {
			return resultList;
		}
		Stack<TreeNode> nodeStack = new Stack<>();
		while(!nodeStack.isEmpty() || root != null) {
			if(root != null) {
				nodeStack.push(root);
				resultList.add(root.val);
				root = root.left;
			} else {
				TreeNode temp = nodeStack.pop();
				if(temp.right !=null) {
					root = temp.right;
				}
			}
		}
		return resultList;
	}
}
