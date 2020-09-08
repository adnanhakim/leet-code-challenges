package SeptemberChallenges;

import java.util.HashMap;

/*
September 7

Question: Word Pattern
Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3451/
*/

class September7 {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if (pattern.length() != s.length) return false;

        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(s1)) return false;
            } else {
                if (map.containsValue(s1)) return false;
            }
            map.put(c, s1);
        }

        return true;
    }
}
