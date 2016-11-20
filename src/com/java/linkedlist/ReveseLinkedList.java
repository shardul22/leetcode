package com.java.linkedlist;

public class ReveseLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReveseLinkedList reveseLinkedList = new ReveseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = reveseLinkedList.reverseList(head);
    }

    /*
     * Problem :- https://leetcode.com/problems/reverse-linked-list/
     *
     *
     * */
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
