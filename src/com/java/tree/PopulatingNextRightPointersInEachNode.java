package com.java.tree;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {

	/*
	 *          
	 *   1
       /  \
      2    3
     / \  / \
    4  5  6  7
	 * 
	 * */
	public void connect(TreeLinkNode root) {
		if(root != null) {
			while(root != null) {
				TreeLinkNode tempRootNode = root;
				while(tempRootNode != null && tempRootNode.left != null) {
					tempRootNode.left.next = tempRootNode.right;
					// To understand this look at linking of node 5 & 6
					if(tempRootNode.next != null) {
						tempRootNode.right.next = tempRootNode.next.left;
					}
					tempRootNode = tempRootNode.next;
				}
				root = root.left;
			}
		}
	}
}
