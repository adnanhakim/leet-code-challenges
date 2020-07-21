package JulyChallenges;

/*
July 21

Question: Word Search
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3397/
*/

class July21 {
    public boolean search(char[][] board, int row, int col, String word, int index) {
        if (index == word.length() - 1)
            return true;

        board[row][col] -= 65;

        if (row > 0 && board[row - 1][col] == word.charAt(index + 1) && search(board, row - 1, col, word, index + 1))
            return true;

        if (row < board.length - 1 && board[row + 1][col] == word.charAt(index + 1) && search(board, row + 1, col, word, index + 1))
            return true;

        if (col > 0 && board[row][col - 1] == word.charAt(index + 1) && search(board, row, col - 1, word, index + 1))
            return true;

        if (col < board[0].length - 1 && board[row][col + 1] == word.charAt(index + 1) && search(board, row, col + 1, word, index + 1))
            return true;

        board[row][col] += 65;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (board[i][j] == word.charAt(0) && search(board, i, j, word, 0))
                    return true;

        return false;
    }
}
