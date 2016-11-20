package com.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> levelQueue = new LinkedList<>();
            levelQueue.offer(root);
            levelQueue.offer(null);
            List<Integer> tempList = new ArrayList<>();
            Stack<List<Integer>> tempStack = new Stack<>();
            while (!levelQueue.isEmpty()) {
                TreeNode temp = levelQueue.poll();
                if (temp == null) {
                    if (!levelQueue.isEmpty())
                        levelQueue.add(null);
                    tempStack.add(tempList);
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

            while (!tempStack.isEmpty()) {
                resultList.add(tempStack.pop());
            }
        }

        return resultList;
    }

}
