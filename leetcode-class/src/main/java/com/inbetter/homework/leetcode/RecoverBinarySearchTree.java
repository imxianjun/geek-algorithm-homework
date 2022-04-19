package com.inbetter.homework.leetcode;

/**
 * find incorrect node
 * swap
 */
public class RecoverBinarySearchTree {

    private TreeNode firstNode = null;
    private TreeNode secondNode = null;
    private TreeNode previousNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (firstNode == null && previousNode.val > root.val) {
            firstNode = previousNode;
        }
        if (firstNode != null && previousNode.val > root.val) {
            secondNode = root;
        }
        previousNode = root;
        traverse(root.right);
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
