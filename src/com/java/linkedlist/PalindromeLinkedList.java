package com.java.linkedlist;

/**
 * Problem :- https://leetcode.com/problems/palindrome-linked-list/
 *
 * 1) Find Middle of the list. 2) Reverse the later half of the list 3) Check if it is a
 * palindrome.
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(palindromeLinkedList.isPalindrome(head));

    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;


        ListNode middleNode = getMiddleNode(head);
        ListNode reverseHeadList = reverseList(middleNode.next);
        middleNode.next = null;
        while (head != null && reverseHeadList != null) {
            if (head.val != reverseHeadList.val) {
                return false;
            }
            head = head.next;
            reverseHeadList = reverseHeadList.next;
        }
        return true;
    }

    public ListNode getMiddleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = temp;
            temp = head;
            head = nextNode;
        }
        return temp;
    }

}

