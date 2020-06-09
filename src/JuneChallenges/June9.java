package JuneChallenges;

/*
June 9

Question: Is Subsequence
Given a string s and a string t, check if s is subsequence of t.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3355/
*/

class June9 {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty())
            return true;

        int i, j;
        for (i = 0, j = 0; i < t.length() && j < s.length(); i++)
            if (s.charAt(j) == t.charAt(i))
                j++;

        return j == s.length();
    }
}
