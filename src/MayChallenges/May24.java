package MayChallenges;

import java.util.ArrayList;

/*
May 24

Question: Construct Binary Search Tree from Preorder Traversal
Return the root node of a binary search tree that matches the given preorder traversal.

https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3339/
*/

class May24 {
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

    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        return buildBST(preorder, Integer.MAX_VALUE);
    }

    public TreeNode buildBST(int[] preorder, int max) {
        if (index == preorder.length || preorder[index] > max)
            return null;

        TreeNode node = new TreeNode(preorder[index++]);

        node.left = buildBST(preorder, node.val);
        node.right = buildBST(preorder, max);

        return node;
    }
}