package com.java.linkedlist;

/**
 * Problem :- https://leetcode.com/problems/linked-list-cycle/
 *
 * Solution :-
 *
 * 1) fastNode moves two position and slowNode moves one position 2) if linked list contains cycle
 * then fastNode and slowNode will collide with each other
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next;
        System.out.println(linkedListCycle.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null)
            return false;

        ListNode fastNode = head, slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode)
                return true;
        }
        return false;
    }

}
