package com.java.linkedlist;

public class SortList {
	
	public ListNode sortList(ListNode head) {
		if( head == null || head.next == null)
			return head;
		
		ListNode left = head;
		ListNode currentHead = head;
		ListNode middleNode = findMiddleNode(currentHead);
		ListNode right = middleNode.next;
		middleNode.next = null;
		
		ListNode leftList = sortList(left);
		ListNode rightList = sortList(right);
		ListNode result = mergeList(leftList, rightList);
		
		return result;
	}
	
	public ListNode mergeList(ListNode leftList, ListNode rightList) {
		ListNode resultHead = new ListNode(-1111);
		ListNode resultList = resultHead;
		while(leftList != null || rightList != null) {
			if(leftList == null) {
				resultList.next = rightList;
				break;
			} else if(rightList == null) {
				resultList.next = leftList;
				break;
			} else {
				if(leftList.val == rightList.val) {
					ListNode newNode = new ListNode(leftList.val);
					resultList.next = newNode;
					resultList = resultList.next;
					leftList = leftList.next;
					ListNode node = new ListNode(rightList.val);
					resultList.next = node;
					rightList = rightList.next;
				} else if(leftList.val < rightList.val) {
					ListNode newNode = new ListNode(leftList.val);
					resultList.next = newNode;
					leftList = leftList.next;
				} else {
					ListNode newNode = new ListNode(rightList.val);
					resultList.next = newNode;
					rightList = rightList.next;
				}
				resultList = resultList.next;
			}
		}
		return resultHead.next;
	}
	
	public ListNode findMiddleNode(ListNode head) {
		ListNode fastNode = head, slowNode = head;
		while(fastNode.next != null && fastNode.next.next != null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}
		return slowNode;
	}

	public static void main(String[] args) {

		SortList sortList = new SortList();
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next = new ListNode(5);
		ListNode result = sortList.sortList(head);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}
