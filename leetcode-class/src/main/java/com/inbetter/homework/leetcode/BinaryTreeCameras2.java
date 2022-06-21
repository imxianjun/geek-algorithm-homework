package com.inbetter.homework.leetcode;

public class BinaryTreeCameras2 {

    private int cameras;

    public int minCameraCover(TreeNode root) {
        return dfs(root) == 0 ? cameras + 1 : cameras;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 1;
        }
        int left = dfs(node.left), right = dfs(node.right);
        if (left == 0 || right == 0) {
            cameras++;
            return 2;
        } else if (left == 2 || right == 2) {
            return 1;
        } else {
            return 0;
        }
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
