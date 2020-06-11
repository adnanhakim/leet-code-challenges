package MayChallenges;

import java.util.HashSet;

/*
May 2

Question: Jewels and Stones
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/
*/

class May2 {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> hashSet = new HashSet<>();

        for (int i = 0; i < J.length(); i++)
            hashSet.add(J.charAt(i));

        int count = 0;
        for (int i = 0; i < S.length(); i++)
            if (hashSet.contains(S.charAt(i)))
                count++;

        return count;
    }
}
