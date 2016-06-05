package com.java.linkedlist;

/**
 * Problem :- https://leetcode.com/problems/linked-list-cycle/
 * 
 * Solution :-
 * 
 * 1) fastNode moves two position and slowNode moves one position
 * 2) if linked list contains cycle then fastNode and slowNode will 
 * collide with each other 
 * 3) Take the slowNode back to head node and iterate till fastNode 
 * and slowNode collides with each other 
 * */
public class LinkedListCycleTwo {

	public ListNode detectCycle(ListNode head) {
		ListNode fastNode = head, slowNode = head;
		boolean hasCycle = false;
		while(fastNode != null && fastNode.next != null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
			if(fastNode == slowNode) {
				hasCycle = true;
				break;
			}
		}
		if(hasCycle) {
			slowNode = head;
			while(slowNode != fastNode) {
				fastNode = fastNode.next;
				slowNode = slowNode.next;
			}
			return slowNode;
		} else
		    return null;
	}
	
	public static void main(String[] args) {
		LinkedListCycleTwo linkedListCycleTwo = new LinkedListCycleTwo();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = head.next;
		System.out.println(linkedListCycleTwo.detectCycle(head).val);

	}

}
