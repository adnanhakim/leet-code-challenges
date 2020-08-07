package AugustChallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
August 7

Question: Vertical Order Traversal of a Binary Tree
Given a binary tree, return the vertical order traversal of its nodes values.
For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3415/
*/

class August7 {
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

    static class Point {
        int x, y, val;

        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        PriorityQueue<Point> heap = new PriorityQueue<>((p1, p2) -> {
            if (p1.x != p2.x)
                return p1.x - p2.x;
            else if (p1.y != p2.y)
                return p2.y - p1.y;
            else
                return p1.val - p2.val;

        });

        dfs(root, 0, 0, heap);
        int prevX = Integer.MIN_VALUE;
        while (!heap.isEmpty()) {
            Point p = heap.poll();
            if (p.x > prevX) {
                List<Integer> list = new ArrayList<>();
                list.add(p.val);
                res.add(list);
            } else {
                List<Integer> list = res.get(res.size() - 1);
                list.add(p.val);
            }
            prevX = p.x;
        }
        return res;
    }

    private void dfs(TreeNode root, int x, int y, PriorityQueue<Point> heap) {
        if (root == null) return;
        heap.offer(new Point(x, y, root.val));
        dfs(root.left, x - 1, y - 1, heap);
        dfs(root.right, x + 1, y - 1, heap);
    }
}
