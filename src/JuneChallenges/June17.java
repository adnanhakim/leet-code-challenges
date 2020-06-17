package JuneChallenges;

/*
June 17

Question: Surrounded Regions
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3363/
*/

class June17 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') checkBoundary(board, i, 0);
            if (board[i][cols - 1] == 'O') checkBoundary(board, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') checkBoundary(board, 0, j);
            if (board[rows - 1][j] == 'O') checkBoundary(board, rows - 1, j);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    public void checkBoundary(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length)
            return;

        if (board[row][col] == 'O') board[row][col] = '*';

        if (row > 0 && board[row - 1][col] == 'O')
            checkBoundary(board, row - 1, col);

        if (row < board.length - 1 && board[row + 1][col] == 'O')
            checkBoundary(board, row + 1, col);

        if (col > 0 && board[row][col - 1] == 'O')
            checkBoundary(board, row, col - 1);

        if (col < board[row].length - 1 && board[row][col + 1] == 'O')
            checkBoundary(board, row, col + 1);
    }
}
