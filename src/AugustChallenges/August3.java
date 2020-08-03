package AugustChallenges;

/*
August 3

Question: Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3411/
*/

class August3 {
    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;

        s = s.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }

        return true;
    }
}
