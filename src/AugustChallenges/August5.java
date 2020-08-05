package AugustChallenges;

/*
August 5

Question: Power of Four
Design a data structure that supports the following two operations:
1 -> void addWord(word)
2 -> bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3413/
*/

class August5 {
    August5[] children;
    boolean endOfWord;

    /* Initialize your data structure here. */
    public August5() {
        children = new August5[26];
        endOfWord = false;
    }

    /* Adds a word into the data structure. */
    public void addWord(String word) {
        August5 curr = this;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new August5();
            }
            curr = curr.children[c - 'a'];
        }
        curr.endOfWord = true;
    }

    /* Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        August5 curr = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (August5 ch : curr.children) {
                    if (ch != null && ch.search(word.substring(i + 1))) return true;
                }
                return false;
            } else {
                if (curr.children[c - 'a'] == null) return false;
                curr = curr.children[c - 'a'];
            }
        }
        return curr != null && curr.endOfWord;
    }
}
