package com.inbetter.homework.leetcode;

public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    private TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) {
            return tail;
        }
        TreeNode ans = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return ans;
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
