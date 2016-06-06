package com.java.tree;

import java.util.Stack;

public class KthSmallestElementBST {
//230
	
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallest_iterative(root, k);
    }
    
    public int kthSmallest_recursive(TreeNode root, int k, int counter) {
    	if(root != null) {
    		kthSmallest_recursive(root.left, k, counter);
    		counter++;
    		if(counter == k) {
    			return root.val;
    		}
    		kthSmallest_recursive(root.right, k, counter);
    	}
    	return 0;
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
