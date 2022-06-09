package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIV2 {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        if (list.size() == 0) {
            return false;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int value = list.get(i) + list.get(j);
            if (value == k) {
                return true;
            } else if (value > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
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
