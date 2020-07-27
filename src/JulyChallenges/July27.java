package JulyChallenges;

/*
July 27

Question: Construct Binary Tree from Inorder and Postorder Traversal
Given inorder and postorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3403/
*/

class July27 {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int pIndex, int iStart, int iEnd) {
        if (pIndex >= postorder.length || iStart > iEnd) return null;
        TreeNode node = new TreeNode(postorder[pIndex]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++)
            if (inorder[i] == postorder[pIndex]) {
                index = i;
                break;
            }

        node.left = helper(inorder, postorder, pIndex - 1 - iEnd + index, iStart, index - 1);
        node.right = helper(inorder, postorder, pIndex - 1, index + 1, iEnd);
        return node;
    }
}
