package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

     public List<List<Integer>> levelOrder(TreeNode root) {
          List<List<Integer>> ans = new ArrayList<>();
          if (root == null) {
               return ans;
          }
          Queue<TreeNode> queue = new LinkedList<>();
          queue.add(root);

          while (!queue.isEmpty()) {
               int levelSize = queue.size();
               List<Integer> currentLevel = new ArrayList<>();
               for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) {
                         queue.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                         queue.add(currentNode.right);
                    }
               }
               ans.add(currentLevel);
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
