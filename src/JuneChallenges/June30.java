package JuneChallenges;

import java.util.ArrayList;
import java.util.List;

/*
June 30

Question: Word Search II
Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3376/
*/

class June30 {
    static class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0) return result;

        TrieNode root = new TrieNode();
        buildTrie(root, words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (root.children[c - 'a'] != null) {
                    dfs(board, i, j, root, result);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode curr, List<String> result) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) return;

        if (board[i][j] == '#') return;

        char c = board[i][j];
        if (curr.children[c - 'a'] == null) return;

        curr = curr.children[c - 'a'];
        if (curr.word != null) {
            result.add(curr.word);
            curr.word = null;
        }

        board[i][j] = '#';
        dfs(board, i + 1, j, curr, result);
        dfs(board, i - 1, j, curr, result);
        dfs(board, i, j + 1, curr, result);
        dfs(board, i, j - 1, curr, result);
        board[i][j] = c;
    }

    private void buildTrie(TrieNode root, String[] words) {
        for (String word : words) {
            TrieNode curr = root;

            for (char c : word.toCharArray()) {
                int index = (int) c - 'a';
                if (curr.children[index] == null)
                    curr.children[index] = new TrieNode();
                curr = curr.children[index];
            }

            curr.word = word;
        }
    }
}
