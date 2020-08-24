package AugustChallenges;

/*
August 24

Question: Sum of Left Leaves
Find the sum of all left leaves in a given binary tree.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3435/
*/

class August24 {
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

    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean isLeft) {
        if (root == null) return 0;

        if (isLeft && root.left == null && root.right == null)
            return root.val;

        return helper(root.left, true) + helper(root.right, false);
    }
}
