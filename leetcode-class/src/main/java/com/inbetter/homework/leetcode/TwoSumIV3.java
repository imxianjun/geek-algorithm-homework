package com.inbetter.homework.leetcode;

public class TwoSumIV3 {

    private TreeNode node;

    public boolean findTarget(TreeNode root, int k) {
        if (node == null) {
            node = root;
        }
        if (root == null) {
            return false;
        }
        if (search(root, k - root.val)) {
            return true;
        }
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    private boolean search(TreeNode root, int k) {
        TreeNode currentNode = node;
        while (currentNode != null) {
            if (currentNode.val < k) {
                currentNode = currentNode.right;
            } else if (currentNode.val > k) {
                currentNode = currentNode.left;
            } else {
                return currentNode != root;
            }
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
