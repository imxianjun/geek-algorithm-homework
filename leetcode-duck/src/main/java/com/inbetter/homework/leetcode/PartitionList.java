package com.inbetter.homework.leetcode;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0), greaterHead = new ListNode(0);
        ListNode smallerLast = smallerHead, greaterLast = greaterHead;
        while (head != null) {
            if (head.val < x) {
                smallerLast.next = head;
                smallerLast = smallerLast.next;
            } else {
                greaterLast.next = head;
                greaterLast = greaterLast.next;
            }
            head = head.next;
        }
        greaterLast.next = null;
        smallerLast.next = greaterHead.next;
        return smallerHead.next;
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
