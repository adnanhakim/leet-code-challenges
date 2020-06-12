package MayChallenges;

import java.util.ArrayList;
import java.util.List;

/*
May 17

Question: Find All Anagrams in a String
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/
*/

class May17 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.isEmpty() || p.length() > s.length()) return result;

        int[] count = new int[26];

        for (char c : p.toCharArray())
            count[c - 'a']++;

        int start = 0;
        for (int i = 0; i < p.length(); i++)
            count[s.charAt(i) - 'a']--;

        int mismatch = 0;
        for (int no : count)
            if (no != 0)
                mismatch++;

        if (mismatch == 0)
            result.add(start);
        start++;

        while (start <= s.length() - p.length()) {
            int index1 = s.charAt(start - 1) - 'a';
            int index2 = s.charAt(start + p.length() - 1) - 'a';

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

            if (mismatch == 0) result.add(start);
            start++;
        }

        return result;
    }
}
