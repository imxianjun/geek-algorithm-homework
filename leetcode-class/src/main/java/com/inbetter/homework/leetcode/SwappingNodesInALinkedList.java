package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SwappingNodesInALinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        int val = list.get(k - 1).val;
        list.get(k - 1).val = list.get(list.size() - k).val;
        list.get(list.size() - k).val = val;
        return head;
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
