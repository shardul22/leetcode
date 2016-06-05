package com.java.linkedlist;

/**
 * Problem :- https://leetcode.com/problems/add-two-numbers/
 * 
 * Solution :-
 * 
 * 1) iterate both of the lists and calculate sum with carry (initially assigned to 0).
 * 2) if the lists are unequal then check for non null head pointer and add the
 * remaining digits
 * 3) At the end check if there is carry and if it is then create a node and return 
 * head pointer   
 * 
 * */
public class AddTwoNumbers {

	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		// create a fake head
		ListNode resultList = new ListNode(-1);
		ListNode l3 = resultList;
		int carry = 0;
		while( l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			carry = sum / 10;
			l3.next = new ListNode(sum % 10);
			l3 = l3.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		if(l1 == null && l2 == null && carry == 1) {
			l3.next = new ListNode(1);
			return resultList.next;
		}
		
		if(l1 != null) {
			while(l1 != null) {
				if(carry == 1) {
					int sum = l1.val + carry;
					carry = sum / 10;
					l3.next = new ListNode(sum % 10);
					l3 = l3.next;
					l1 = l1.next;
				} else {
					l3.next = l1;
					return resultList.next;
				}
			} 
		}
			
		if(l2 != null) {
			while(l2 != null) {
				if(carry == 1) {
					int sum = l2.val + carry;
					carry = sum / 10;
					l3.next = new ListNode(sum % 10);
					l2 = l2.next;
					l3 = l3.next;
				} else {
					l3.next = l2;
					return resultList.next;
				}
			}
		}
		return resultList.next;
	}

	public static void main(String[] args) {
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		ListNode list1 = new ListNode(9);
		list1.next = new ListNode(8);
		list1.next.next = new ListNode(9);
		
		ListNode list2 = new ListNode(9);
		list2.next = new ListNode(9);
		list2.next.next = new ListNode(9);

		System.out.println();
		ListNode temp = addTwoNumbers.addTwoNumbers(list1, list2);
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

}
