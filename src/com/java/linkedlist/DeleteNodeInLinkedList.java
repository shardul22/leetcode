package com.java.linkedlist;

public class DeleteNodeInLinkedList {

	/**
	 * Problem :- https://leetcode.com/problems/delete-node-in-a-linked-list/
	 * 
	 * Solution :-
	 * 
	 * 1) Copy the value of next node to current node
	 * 2) set the next pointer of current node to next to next node
	 * */
	public void deleteNode(ListNode node) {
		if(node.next != null) {
			node.val = node.next.val;
			node.next = node.next.next;
		}
	}

	public static void main(String[] args) {
		DeleteNodeInLinkedList deleteNodeInLinkedList = new DeleteNodeInLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		deleteNodeInLinkedList.deleteNode(head.next.next);
	}

}
