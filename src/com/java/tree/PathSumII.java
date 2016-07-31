package com.java.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> resultList = new ArrayList<>();
		if(root == null) {
			return resultList;
		}
		pathSumHelper(root, sum, new ArrayList<Integer>(), resultList);
		return resultList;
	}

	public void pathSumHelper(TreeNode root, int sum, List<Integer> currentList, 
			List<List<Integer>> resultList) {

		if(root.val == sum && root.left == null && root.right == null) {
			currentList.add(root.val);
			List<Integer> tempList = new ArrayList<Integer>();
			tempList.addAll(currentList);
			resultList.add(tempList);
			currentList.remove(currentList.size()-1);
		}
		else {
			if(root.left != null) {
				currentList.add(root.val);
				pathSumHelper(root.left, sum-root.val, currentList, resultList);
				currentList.remove(currentList.size()-1);
			}
			if(root.right != null) {
				currentList.add(root.val);
				pathSumHelper(root.right, sum-root.val, currentList, resultList);
				currentList.remove(currentList.size()-1);
			}
		}
	}

}
