package com.inbetter.homework.leetcode;

public class MinimumDepthOfBinaryTree2 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);

        return (leftMinDepth == 0 || rightMinDepth == 0) ? leftMinDepth + rightMinDepth + 1 : Math.min(leftMinDepth, rightMinDepth) + 1;
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
