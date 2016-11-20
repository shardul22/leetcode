package com.java.linkedlist;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
        ListNode newHead = removeNthNodeFromEnd.removeNthFromEnd(head, 5);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }

    /*
     * Problem :- https://leetcode.com/problems/remove-nth-node-from-end-of-list/
     *
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null)
            return null;

        ListNode currentNode = head, nthFromEndNode = head;
        ListNode previousNode = null;

        while (currentNode != null) {
            n--;
            if (n < 0) {
                previousNode = nthFromEndNode;
                nthFromEndNode = nthFromEndNode.next;
            }
            currentNode = currentNode.next;
        }
        if (previousNode == null)
            head = head.next;
        else
            previousNode.next = previousNode.next.next;
        return head;
    }

}
