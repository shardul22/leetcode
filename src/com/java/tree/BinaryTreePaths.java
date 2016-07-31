package com.java.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {

		List<String> resultPathList = new ArrayList<>();

		if(root == null) {
			return resultPathList;
		}
		binaryTreePathsHelper(root, resultPathList, new ArrayList<Integer>());

		return resultPathList;
	}

	public void binaryTreePathsHelper(TreeNode root, List<String> resultPathList, List<Integer> pathList) {
		if(root.left == null && root.right == null) {
			StringBuilder stringBuilder = new StringBuilder();
			for(int i=0; i<pathList.size(); i++) {
				stringBuilder.append(pathList.get(i)+"->");
			}
			stringBuilder.append(root.val);
			resultPathList.add(stringBuilder.toString());
		}

		if(root.left != null) {
			pathList.add(root.val);
			binaryTreePathsHelper(root.left, resultPathList, pathList);
			pathList.remove(pathList.size()-1);
		}

		if(root.right != null) {
			pathList.add(root.val);
			binaryTreePathsHelper(root.right, resultPathList, pathList);
			pathList.remove(pathList.size()-1);
		}
	}
}
