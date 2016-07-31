package com.java.tree;

public class SumRootToLeafNumbers {

	public int sumNumbers(TreeNode root) {
		return sumNumbersHelper(root, 0);
	}
	
	public int sumNumbersHelper(TreeNode root, int sum) {
		if(root == null)
			return 0;
		
		sum = sum * 10 + root.val;
		
		if(root.left == null && root.right == null)
			return sum;
		
		int left = sumNumbersHelper(root.left, sum);
		int right = sumNumbersHelper(root.right, sum);
		return left+right;
	}

}
