package AugustChallenges;

/*
August 1

Question: Detect Capital
Given a word, you need to judge whether the usage of capitals in it is right or not.
We define the usage of capitals in a word to be right when one of the following cases holds:
1 -> All letters in this word are capitals, like "USA".
2 -> All letters in this word are not capitals, like "leetcode".
3 -> Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.

https://leetcode.com/explore/featured/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3409/
*/

class August1 {
    public boolean detectCapitalUse(String word) {
        int lastCap = -1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                if (lastCap + 1 == i)
                    lastCap++;
                else return false;
            }
        }

        return lastCap == -1 || lastCap == word.length() - 1 || lastCap == 0;
    }
}
