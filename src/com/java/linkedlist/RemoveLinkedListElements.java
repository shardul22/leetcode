package com.java.linkedlist;

public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        ListNode resultHead = removeLinkedListElements.removeElements(head, 1);
        while (resultHead != null) {
            System.out.println(resultHead.val);
            resultHead = resultHead.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;

        ListNode resultHead = new ListNode(-1);
        resultHead.next = head;
        ListNode previousNode = resultHead;

        while (head != null) {
            if (head.val == val) {
                previousNode.next = previousNode.next.next;
                head = head.next;
            } else {
                previousNode = head;
                head = head.next;
            }
        }
        return resultHead.next;
    }
}
