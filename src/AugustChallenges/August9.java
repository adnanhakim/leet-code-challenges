package AugustChallenges;

import java.util.LinkedList;
import java.util.Queue;

/*
August 9

Question: Rotting Oranges
In a given grid, each cell can have one of three values:
0 -> the value 0 representing an empty cell;
1 -> the value 1 representing a fresh orange;
2 -> the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3418/
*/

class August9 {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();

        int rows = grid.length, cols = grid[0].length, fresh = 0, time = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2)
                    rotten.offer(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }

        while (!rotten.isEmpty()) {
            int size = rotten.size();
            for (int count = 0; count < size; count++) {
                int[] curr = rotten.poll();
                int i = curr[0], j = curr[1];

                if (i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    fresh--;
                    rotten.offer(new int[]{i - 1, j});
                }
                if (i < rows - 1 && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    fresh--;
                    rotten.offer(new int[]{i + 1, j});
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    fresh--;
                    rotten.offer(new int[]{i, j - 1});
                }
                if (j < cols - 1 && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    fresh--;
                    rotten.offer(new int[]{i, j + 1});
                }
            }
            if (!rotten.isEmpty()) time++;
        }

        return fresh == 0 ? time : -1;
    }
}
