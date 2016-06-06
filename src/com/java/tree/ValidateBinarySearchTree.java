package com.java.tree;

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	public boolean isValidBSTHelper(TreeNode root, long minValue, long maxValue) {
		if(root == null) {
			return true;
		}
		
		if(minValue >= root.val || root.val >= maxValue)
		    return false;

		return  isValidBSTHelper(root.left, minValue, root.val) && 
				isValidBSTHelper(root.right, root.val, maxValue);
	}

}
