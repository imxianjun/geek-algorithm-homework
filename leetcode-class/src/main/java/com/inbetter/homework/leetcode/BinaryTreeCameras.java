package com.inbetter.homework.leetcode;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreeCameras {

    private int cameras;

    private Set<TreeNode> covered;

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        cameras = 0;
        covered = new HashSet<>();
        covered.add(null);
        dfs(root, null);
        return cameras;
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            dfs(node.left, node);
            dfs(node.right, node);
            if ((parent == null
                    && !covered.contains(node))
                    || !covered.contains(node.left)
                    || !covered.contains(node.right)) {
                cameras++;
                covered.add(node);
                covered.add(parent);
                covered.add(node.left);
                covered.add(node.right);
            }
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
