package JuneChallenges;

/*
June 26

Question: Sum Root to Leaf Numbers
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
Note: A leaf is a node with no children.

https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3372/
*/

class June26 {
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

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode node, int curr) {
        if (node == null) return 0;

        curr = (curr * 10) + node.val;
        if (node.left == null && node.right == null)
            return curr;

        return helper(node.left, curr) + helper(node.right, curr);
    }
}
