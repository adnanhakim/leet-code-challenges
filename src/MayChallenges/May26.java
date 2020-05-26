package MayChallenges;

import java.util.HashMap;

/*
May 26

Question: Contiguous Array
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3341/
*/

class May26 {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);

        int sum = 0, maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;

            if (hashMap.containsKey(sum))
                maxLength = Math.max(maxLength, i - hashMap.get(sum));
            else hashMap.put(sum, i);
        }

        return maxLength;
    }
}
