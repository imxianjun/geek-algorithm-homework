package com.inbetter.homework.leetcode;

public class PopulatingNextRightPointersInEachNodeII {

    public Node connect(Node root) {
        //head of the next level
        Node head = null;
        //the leading node on the next level
        Node previous = null;
        //current node of current level
        Node current = root;

        while (current != null) {
            //iterate on the current level
            while (current != null) {

                //left child
                if (current.left != null) {
                    if (previous != null) {
                        previous.next = current.left;
                    } else {
                        head = current.left;
                    }
                    previous = current.left;
                }

                //right child
                if (current.right != null) {
                    if (previous != null) {
                        previous.next = current.right;
                    } else {
                        head = current.right;
                    }
                    previous = current.right;
                }

                //move to next node
                current = current.next;
            }

            //move to next level
            current = head;
            head = null;
            previous = null;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
