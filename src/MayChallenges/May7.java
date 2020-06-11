package MayChallenges;

import java.util.LinkedList;
import java.util.Queue;

/*
May 7

Question: Cousins in Binary Tree
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/
*/

class May7 {
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

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> parents = new LinkedList<>();
        boolean foundX = false, foundY = false;
        TreeNode parentX = null, parentY = null;

        queue.add(root);
        parents.add(new TreeNode(0, null, null));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                TreeNode parent = parents.remove();

                if (curr.val == x) {
                    foundX = true;
                    parentX = parent;
                }

                if (curr.val == y) {
                    foundY = true;
                    parentY = parent;
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                    parents.add(curr);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                    parents.add(curr);
                }
            }

            if (foundX && foundY)
                return parentX != parentY;
            else if (foundX || foundY)
                return false;
        }

        return false;
    }
}
