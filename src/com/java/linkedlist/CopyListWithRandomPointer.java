package com.java.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * */
public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null)
            return head;

        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();
        RandomListNode copyHead = new RandomListNode(head.label);
        nodeMap.put(head, copyHead);
        RandomListNode copyHeadRef = copyHead;
        while (head != null) {
            if (head.next != null) {
                if (!nodeMap.containsKey(head.next)) {
                    RandomListNode copyNextPointerNode = new RandomListNode(head.next.label);
                    nodeMap.put(head.next, copyNextPointerNode);
                    copyHeadRef.next = copyNextPointerNode;
                } else {
                    copyHeadRef.next = nodeMap.get(head.next);
                }
            }
            if (head.random != null) {
                if (!nodeMap.containsKey(head.next)) {
                    RandomListNode coyRandomPointerNode = new RandomListNode(head.random.label);
                    nodeMap.put(head.next, coyRandomPointerNode);
                    copyHeadRef.next = coyRandomPointerNode;
                } else {
                    copyHeadRef.random = nodeMap.get(head.random);
                }
            }
            head = head.next;
            copyHeadRef = copyHeadRef.next;
        }
        return copyHead;
    }

}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}
