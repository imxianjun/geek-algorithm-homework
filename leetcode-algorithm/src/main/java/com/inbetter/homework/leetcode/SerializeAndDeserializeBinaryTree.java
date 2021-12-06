package com.inbetter.homework.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {

    private static final String SPLITER = ",";

    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        buildString(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void buildString(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append(NN)
                    .append(SPLITER);
        } else {
            stringBuilder.append(root.val)
                    .append(SPLITER);
            buildString(root.left, stringBuilder);
            buildString(root.right, stringBuilder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<String>();
        nodes.addAll(Arrays.asList(data.split(SPLITER)));
        return buildTreeNodes(nodes);
    }

    private TreeNode buildTreeNodes(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(val));
        treeNode.left = buildTreeNodes(nodes);
        treeNode.right = buildTreeNodes(nodes);
        return treeNode;
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
