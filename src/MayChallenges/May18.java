package MayChallenges;

/*
May 18

Question: Permutation in String
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
*/

class May18 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s2.isEmpty() || s1.length() > s2.length()) return false;

        int[] count = new int[26];

        for (char c : s1.toCharArray())
            count[c - 'a']++;

        int start = 0;
        for (int i = 0; i < s1.length(); i++)
            count[s2.charAt(i) - 'a']--;

        int mismatch = 0;
        for (int no : count)
            if (no != 0)
                mismatch++;

        if (mismatch == 0)
            return true;
        start++;

        while (start <= s2.length() - s1.length()) {
            int index1 = s2.charAt(start - 1) - 'a';
            int index2 = s2.charAt(start + s1.length() - 1) - 'a';

            count[index1]++;
            if (count[index1] == 1)
                mismatch++;
            else if (count[index1] == 0)
                mismatch--;

            count[index2]--;
            if (count[index2] == -1)
                mismatch++;
            else if (count[index2] == 0)
                mismatch--;

            if (mismatch == 0)
                return true;
            start++;
        }

        return false;
    }
}
