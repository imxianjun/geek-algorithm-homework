package com.inbetter.homework.leetcode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode newNode = prev;

        while (prev.next != null && prev.next.next != null) {
            ListNode node1 = prev.next;
            ListNode node2 = node1.next;
            ListNode nextNode = node2.next;

            prev.next = node2;
            node2.next = node1;
            node1.next = nextNode;

            prev = node1;
        }

        return newNode.next;
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
