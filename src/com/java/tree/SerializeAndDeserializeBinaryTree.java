package com.java.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null)
            return stringBuilder.toString();

        serializeTreeHelper(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void serializeTreeHelper(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("N,");
            return;
        }
        stringBuilder.append(root.val).append(",");
        serializeTreeHelper(root.left, stringBuilder);
        serializeTreeHelper(root.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;

        Queue<String> nodeQueue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeTreeHelper(nodeQueue);
    }

    private TreeNode deserializeTreeHelper(Queue<String> nodeQueue) {
        String data = nodeQueue.poll();
        if (data.equals("N"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(data));
        root.left = deserializeTreeHelper(nodeQueue);
        root.right = deserializeTreeHelper(nodeQueue);
        return root;

    }
}
