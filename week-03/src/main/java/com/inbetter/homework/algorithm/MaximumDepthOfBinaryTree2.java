package com.inbetter.homework.algorithm;

public class MaximumDepthOfBinaryTree2 {

    private int depth, ans;

    public int maxDepth(TreeNode root) {
        depth = 1;
        ans = 0;
        calcu(root);
        return ans;
    }

    private void calcu(TreeNode root) {
        if (root == null) {
            return;
        }
        ans = Math.max(ans, depth);
        depth++;
        calcu(root.left);
        calcu(root.right);
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
