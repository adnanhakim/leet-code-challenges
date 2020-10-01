package SeptemberChallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
September 19

Question: Sequential Digits
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3465/
*/

class September19 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> output = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            int num = 0, j = i;
            while (num <= high && j < 10) {
                num = num * 10 + j;
                if (num >= low && num <= high)
                    output.add(num);
                j++;
            }
        }

        Collections.sort(output);
        return output;
    }
}
