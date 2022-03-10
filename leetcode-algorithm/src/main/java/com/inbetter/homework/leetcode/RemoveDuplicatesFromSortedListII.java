package com.inbetter.homework.leetcode;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fakeNode = new ListNode(head.val == 0 ? 1 : 0);
        fakeNode.next = head;

        ListNode prev = fakeNode;
        ListNode current = head;

        while (current != null) {
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            if (current == prev.next) {
                prev = prev.next;
            } else {
                prev.next = current.next;
            }
            current = current.next;
        }
        return fakeNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
