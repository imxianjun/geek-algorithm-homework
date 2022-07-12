package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView2 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideList = new ArrayList<>();
        rightSide(root, rightSideList, 0);
        return rightSideList;
    }

    private void rightSide(TreeNode current, List<Integer> rightSideList, int currentDepth) {
        if (current == null) {
            return;
        }
        if (currentDepth == rightSideList.size()) {
            rightSideList.add(current.val);
        }
        rightSide(current.right, rightSideList, currentDepth + 1);
        rightSide(current.left, rightSideList, currentDepth + 1);
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
