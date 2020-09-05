package SeptemberChallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
September 5

Question: All Elements in Two Binary Search Trees
Given two binary search trees root1 and root2.
Return a list containing all the integers from both trees sorted in ascending order.

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3449/
*/

class September5 {
    static class TreeNode {
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

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        traverse(root1, result);
        traverse(root2, result);

        Collections.sort(result);
        return result;
    }

    private void traverse(TreeNode root, List<Integer> result) {
        if (root == null) return;

        if (root.left != null)
            traverse(root.left, result);
        result.add(root.val);
        if (root.right != null)
            traverse(root.right, result);
    }
}