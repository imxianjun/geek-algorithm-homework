package com.inbetter.homework.algorithm;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean check(TreeNode root, long rangeLeft, long rangeRight) {
        if (root == null) {
            return true;
        }

        if (root.val < rangeLeft || root.val > rangeRight) {
            return false;
        }

        return check(root.left, rangeLeft, (long)root.val - 1)
                &
                check(root.right, (long)root.val + 1, rangeRight);
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
