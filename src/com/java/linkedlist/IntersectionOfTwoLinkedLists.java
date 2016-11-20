package com.java.linkedlist;

/**
 * Problem :- https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Solution :-
 *
 * 1) find length of both of the list. 2) Calculate the difference of the length. 3) Advance the
 * head pointer of the list till the difference. 4) Now check for the intersecting node and return
 * the node
 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {

        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode head2 = new ListNode(7);
        head2.next = new ListNode(8);
        head2.next.next = head.next.next.next;
        System.out.println(intersectionOfTwoLinkedLists.getIntersectionNode(head, head2).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int headALength = findLengthOfList(headA);
        int headBLength = findLengthOfList(headB);

        if (headALength > headBLength) {
            int difference = headALength - headBLength;
            while (difference != 0) {
                difference--;
                headA = headA.next;
            }
        } else {
            int difference = headBLength - headALength;
            while (difference != 0) {
                difference--;
                headB = headB.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA.val == headB.val) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public int findLengthOfList(ListNode node) {
        ListNode start = node;
        int length = 0;
        while (start != null) {
            length++;
            start = start.next;
        }
        return length;
    }

}
