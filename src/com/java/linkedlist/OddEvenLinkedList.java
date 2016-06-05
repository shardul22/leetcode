package com.java.linkedlist;

public class OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {
		if( head == null || head.next == null)
			return head;
		
		ListNode resultNode = head, evenNodeHead = head.next; 
		ListNode oddNode = head, evenNode = head.next;
		//1-2-3-4-5-6-7
		while(oddNode.next != null && evenNode.next != null) {
			oddNode.next = oddNode.next.next;
			evenNode.next = evenNode.next.next;
			oddNode = oddNode.next;
			evenNode = evenNode.next;
		}
		oddNode.next = evenNodeHead;
		return resultNode;

	}
	public static void main(String[] args) {
		OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		oddEvenLinkedList.oddEvenList(head);
	}

}
