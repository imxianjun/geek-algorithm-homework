package com.inbetter.homework.leetcode;

public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] ans = robHouse(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] robHouse(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = robHouse(root.left);
        int[] right = robHouse(root.right);
        int[] ans = new int[2];
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ans[1] = root.val + left[0] + right[0];
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