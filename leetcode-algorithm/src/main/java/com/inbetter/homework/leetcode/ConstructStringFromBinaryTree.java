package com.inbetter.homework.leetcode;

public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        String result = root.val + "";
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        if ("".equals(left) && "".equals(right)) {
            return result;
        }
        if ("".equals(left)) {
            return result + "()(" + right + ")";
        }
        if ("".equals(right)) {
            return result + "(" + left + ")";
        }
        return result + "(" + left + ")(" + right + ")";
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
