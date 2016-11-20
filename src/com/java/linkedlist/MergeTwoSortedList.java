package com.java.linkedlist;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedList {

    public static void main(String[] args) {

        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        mergeTwoSortedList.mergeTwoLists(list1, list2);

    }

    //2-4-6
    //1-3-5
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode resultNode = new ListNode(-1);
        ListNode l3 = resultNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        if (l1 == null)
            l3.next = l2;

        if (l2 == null)
            l3.next = l1;

        return resultNode.next;
    }

}
