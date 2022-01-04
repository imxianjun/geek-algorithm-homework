package com.inbetter.homework.algorithm;

public class BinaryTreeMaximumPathSum {

    private int maxPathSum;

    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        maxSumHelper(root);
        return maxPathSum;
    }

    private int maxSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = maxSumHelper(root.left);
        int rightSum = maxSumHelper(root.right);

        int maxSumInLeftAndRight = Math.max(leftSum, rightSum);
        int maxSumInSinglePart = Math.max(root.val, root.val + maxSumInLeftAndRight);
        int maxSumAll = Math.max(maxSumInSinglePart, leftSum + rightSum + root.val);

        maxPathSum = Math.max(maxPathSum, maxSumAll);

        return maxSumInSinglePart;
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
