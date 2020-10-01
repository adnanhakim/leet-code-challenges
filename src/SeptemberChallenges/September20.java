package SeptemberChallenges;

/*
September 20

Question: Unique Paths III
On a 2-dimensional grid, there are 4 types of squares:
1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3466/
*/

class September20 {
    int rows, cols;
    int[][] grid;
    int pathCount;
    
    public int uniquePathsIII(int[][] grid) {
        int nonObstacles = 0, startRow = 0, startCol = 0;

        this.rows = grid.length;
        this.cols = grid[0].length;

        // step 1). initialize the conditions for backtracking
        // i.e. initial state and final state
        for (int row = 0; row < rows; ++row)
            for (int col = 0; col < cols; ++col) {
                int cell = grid[row][col];
                if (cell >= 0)
                    nonObstacles += 1;
                if (cell == 1) {
                    startRow = row;
                    startCol = col;
                }
            }

        this.pathCount = 0;
        this.grid = grid;

        // kick-off the backtracking
        backtrack(startRow, startCol, nonObstacles);

        return this.pathCount;
    }

    private void backtrack(int row, int col, int remain) {
        // base case for the termination of backtracking
        if (this.grid[row][col] == 2 && remain == 1) {
            // reach the destination
            this.pathCount += 1;
            return;
        }

        // mark the square as visited. case: 0, 1, 2
        int temp = grid[row][col];
        grid[row][col] = -4;
        remain -= 1; // we now have one less square to visit

        // explore the 4 potential directions around
        int[] rowOffsets = {0, 0, 1, -1};
        int[] colOffsets = {1, -1, 0, 0};
        for (int i = 0; i < 4; ++i) {
            int nextRow = row + rowOffsets[i];
            int nextCol = col + colOffsets[i];

            if (0 > nextRow || nextRow >= this.rows ||
                    0 > nextCol || nextCol >= this.cols)
                // invalid coordinate
                continue;

            if (grid[nextRow][nextCol] < 0)
                // either obstacle or visited square
                continue;

            backtrack(nextRow, nextCol, remain);
        }

        // un-mark the square after the visit
        grid[row][col] = temp;
    }
}
