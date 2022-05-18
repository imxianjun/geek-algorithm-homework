package com.inbetter.homework.leetcode;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target) {
            return cloned;
        }
        TreeNode ans = getTargetCopy(original.left, cloned.left, target);
        if (ans != null) {
            return ans;
        }
        return getTargetCopy(original.right, cloned.right, target);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
