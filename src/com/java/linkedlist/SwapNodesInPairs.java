package com.java.linkedlist;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode resultNode = dummyHead;
        //1->2->3->4
        //0->1->2->3->4
        while (head != null && head.next != null) {
            ListNode temp = head.next;
            head.next = temp.next;
            head = head.next;

            ListNode temp2 = dummyHead.next;
            temp.next = dummyHead.next;
            dummyHead.next = temp;
            dummyHead = temp2;
        }
        return resultNode.next;
    }
}
