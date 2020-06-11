package MayChallenges;

import java.util.HashMap;
import java.util.Map;

/*
May 3

Question: Ransom Note
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
Each letter in the magazine string can only be used once in your ransom note.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/
*/

class May3 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineMap = new HashMap<>();
        HashMap<Character, Integer> noteMap = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++)
            magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i), 0) + 1);

        for (int i = 0; i < ransomNote.length(); i++)
            noteMap.put(ransomNote.charAt(i), noteMap.getOrDefault(ransomNote.charAt(i), 0) + 1);

        for (Map.Entry element: noteMap.entrySet()) {
            Character key = (Character) element.getKey();
            Integer value = (Integer) element.getValue();

            if (value > magazineMap.getOrDefault(key, 0))
                return false;
        }

        return true;
    }
}
