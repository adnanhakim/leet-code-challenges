package SeptemberChallenges;

import java.util.ArrayList;
import java.util.List;

/*
September 4

Question: Partition Labels
A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3448/
*/

class September4 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();

        if (S == null || S.length() == 0) return result;

        int[] lastIndex = new int[26];
        char[] arr = S.toCharArray();

        for (int i = 0; i < arr.length; i++)
            lastIndex[arr[i] - 'a'] = i;

        int start = 0, last = 0;
        for (int i = 0; i < arr.length; i++) {
            last = Math.max(lastIndex[arr[i] - 'a'], last);
            if (last == i) {
                result.add(last - start + 1);
                start = last + 1;
            }
        }

        return result;
    }
}
