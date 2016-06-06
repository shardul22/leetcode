package com.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> resultList = new ArrayList<>();
		if(root == null) {
			return resultList;
		}
		
		Queue<TreeNode> levelQueue = new LinkedList<>();
		levelQueue.offer(root);
		levelQueue.offer(null);
		while(!levelQueue.isEmpty()) {
			TreeNode temp = levelQueue.poll();
			if(temp == null) {
				if(!levelQueue.isEmpty()) {
					levelQueue.offer(null);
				}
			} else {
				if(levelQueue.peek() == null) {
					resultList.add(temp.val);
				}
				if(temp.left != null) {
					levelQueue.offer(temp.left);
				}
				if(temp.right != null) {
					levelQueue.offer(temp.right);
				}
			}
		}
		return resultList;
	}

}
