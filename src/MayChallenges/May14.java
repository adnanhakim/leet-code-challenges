package MayChallenges;

/*
May 14

Question: Implement Trie (Prefix Tree)
Implement a trie with insert, search, and startsWith methods.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3329/
*/

class May14 {
    static class TrieNode {
        private TrieNode[] children;
        private boolean endOfWord;

        TrieNode() {
            children = new TrieNode[26];
            endOfWord = false;
        }
    }

    TrieNode root;

    /* Initialize your data structure here. */
    public May14() {
        root = new TrieNode();
    }

    /* Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.endOfWord = true;
    }

    /* Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            curr = curr.children[c - 'a'];
            if (curr == null)
                return false;
        }
        return curr.endOfWord;
    }

    /* Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c: prefix.toCharArray()) {
            curr = curr.children[c - 'a'];
            if (curr == null)
                return false;
        }
        return true;
    }
}

/*
  Your Trie object will be instantiated and called as such:
  Trie obj = new Trie();
  obj.insert(word);
  boolean param_2 = obj.search(word);
  boolean param_3 = obj.startsWith(prefix);
*/
