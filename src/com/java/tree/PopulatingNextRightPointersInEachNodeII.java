package com.java.tree;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersInEachNodeII {

    /*
        1
       / \
      2   3
     / \   \
    4   5   7
    */
    public void connect(TreeLinkNode root) {
        if (root != null) {
            TreeLinkNode dummyHead = new TreeLinkNode(0);
            TreeLinkNode previousNode = dummyHead;
            while (root != null) {
                while (root != null) {
                    if (root.left != null) {
                        previousNode.next = root.left;
                        previousNode = previousNode.next;
                    }
                    if (root.right != null) {
                        previousNode.next = root.right;
                        previousNode = previousNode.next;
                    }
                    root = root.next;
                }
                root = dummyHead.next;
                dummyHead.next = null;
                previousNode = dummyHead;
            }
        }
    }

    public void connect_2(TreeLinkNode root) {
        if (root != null) {
            TreeLinkNode previousNode = null;
            TreeLinkNode headNodeForNextLevel = null;
            TreeLinkNode currentRootNode = root;

            while (currentRootNode != null) {
                while (currentRootNode != null) {
                    if (currentRootNode.left != null) {
                        if (previousNode != null) {
                            previousNode.next = currentRootNode.left;
                        } else {
                            headNodeForNextLevel = currentRootNode.left;
                        }
                        previousNode = currentRootNode.left;
                    }

                    if (currentRootNode.right != null) {
                        if (previousNode != null) {
                            previousNode.next = currentRootNode.right;
                        } else {
                            headNodeForNextLevel = currentRootNode.right;
                        }
                        previousNode = currentRootNode.right;
                    }
                    currentRootNode = currentRootNode.next;
                }
                currentRootNode = headNodeForNextLevel;
                headNodeForNextLevel = null;
                previousNode = null;
            }
        }
    }
}
