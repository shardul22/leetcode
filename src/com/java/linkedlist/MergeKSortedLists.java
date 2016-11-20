package com.java.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(7);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(5);
        list2.next.next = new ListNode(8);

        ListNode list3 = new ListNode(3);
        list3.next = new ListNode(6);
        list3.next.next = new ListNode(9);

        ListNode[] lists = new ListNode[]{list1, list2, list3};
        ListNode resultHead = mergeKSortedLists.mergeKLists(lists);
        while (resultHead != null) {
            System.out.println(resultHead.val);
            resultHead = resultHead.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null)
            return null;

        if (lists.length == 1)
            return lists[0];

        PriorityQueue<ListNode> nodePriorityQueue = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                nodePriorityQueue.offer(lists[i]);
        }
        ListNode resultNode = new ListNode(-111);
        ListNode resultList = resultNode;
        while (!nodePriorityQueue.isEmpty()) {
            ListNode temp = nodePriorityQueue.poll();
            if (temp.next != null)
                nodePriorityQueue.offer(temp.next);
            resultList.next = temp;
            resultList = resultList.next;
            temp.next = null;
        }
        return resultNode.next;

    }

}
