package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> warpList = new ArrayList<>();
        levelHelper(warpList, root, 0);
        return warpList;
    }

    private void levelHelper(List<List<Integer>> warpList, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == warpList.size()) {
            warpList.add(new LinkedList<>());
        }
        warpList.get(level).add(root.val);
        levelHelper(warpList, root.left, level + 1);
        levelHelper(warpList, root.right, level + 1);
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
