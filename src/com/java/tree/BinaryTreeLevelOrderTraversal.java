package com.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> levelQueue = new LinkedList<>();
            levelQueue.offer(root);
            levelQueue.offer(null);
            List<Integer> tempList = new ArrayList<>();
            while (!levelQueue.isEmpty()) {
                TreeNode temp = levelQueue.poll();
                if (temp == null) {
                    if (!levelQueue.isEmpty())
                        levelQueue.add(null);
                    resultList.add(tempList);
                    tempList = new ArrayList<Integer>();
                } else {
                    tempList.add(temp.val);
                    if (temp.left != null) {
                        levelQueue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        levelQueue.offer(temp.right);
                    }
                }
            }
        }

        return resultList;

    }
}
