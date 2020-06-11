package MayChallenges;

import java.util.HashMap;

/*
May 5

Question: First Unique Character in a String
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/
*/

class May5 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(char letter: s.toCharArray())
            hashMap.put(letter, hashMap.getOrDefault(letter, 0) + 1);

        for(char letter: s.toCharArray())
            if (hashMap.get(letter) == 1)
                return s.indexOf(letter);

        return -1;
    }
}
