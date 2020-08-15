package AugustChallenges;

/*
August 14

Question: Longest Palindrome
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here.
Note:
Assume the length of given string will not exceed 1,010.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3423/
*/


class August14 {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray())
            count[c]++;

        int single = 0;
        for (int n : count)
            if (n % 2 != 0)
                single++;

        return single > 1 ? s.length() - single + 1 : s.length();
    }
}
