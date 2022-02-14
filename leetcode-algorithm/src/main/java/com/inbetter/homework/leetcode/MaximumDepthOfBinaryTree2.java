package com.inbetter.homework.leetcode;

public class MaximumDepthOfBinaryTree2 {

    private int depth, ans;

    public int maxDepth(TreeNode root) {
        depth = 1;
        ans = 0;
        calculate(root);
        return ans;
    }

    private void calculate(TreeNode root) {
        if (root == null) {
            return;
        }
        ans = Math.max(depth, ans);
        depth++;
        calculate(root.left);
        calculate(root.right);
        depth--;
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
