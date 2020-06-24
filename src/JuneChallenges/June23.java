package JuneChallenges;

import java.util.LinkedList;
import java.util.Queue;

/*
June 23

Question: Count Complete Tree Nodes
Given a complete binary tree, count the number of nodes.
Note:
Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3369/
*/

class June23 {
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

    // Solution 1 - Level Order Traversal (4 ms)
    public int countNodesLevel(TreeNode root) {
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();

                if (curr == null) return count;
                count++;

                queue.add(curr.left);
                queue.add(curr.right);
            }
        }

        return count;
    }

    // Solution 2 - DFS Recursion (1 ms)
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        TreeNode left = root, right = root;
        int leftHeight = 0, rightHeight = 0;

        while (left != null) {
            leftHeight++;
            left = left.left;
        }
        while (right != null) {
            rightHeight++;
            right = right.right;
        }

        if (leftHeight == rightHeight)
            return (int) Math.pow(2, leftHeight) - 1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
