package com.inbetter.homework.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, Integer> map = null;
        ArrayDeque<Map<TreeNode, Integer>> queue = new ArrayDeque<>();
        map = new HashMap<>();
        map.put(root, 0);
        queue.add(map);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<TreeNode, Integer> first = queue.getFirst();
            Map<TreeNode, Integer> last = queue.getLast();
            ans = Math.max(ans, (Integer) last.values().toArray()[0] - (Integer) first.values().toArray()[0] + 1);
            Map<TreeNode, Integer> node;
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                TreeNode treeNode = (TreeNode) node.keySet().toArray()[0];
                Integer value = (Integer) node.values().toArray()[0];
                if (treeNode.left != null) {
                    map = new HashMap<>();
                    map.put(treeNode.left, 2 * value + 1);
                    queue.add(map);
                }
                if (treeNode.right != null) {
                    map = new HashMap<>();
                    map.put(treeNode.right, 2 * value + 2);
                    queue.add(map);
                }
            }
        }
        return ans;
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
