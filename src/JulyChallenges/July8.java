package JulyChallenges;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
July 8

Question: 3Sum
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note:
The solution set must not contain duplicate triplets.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3384/
*/

class July8 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = nums.length - 1;
                int target = -nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == target) {
                        output.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > target) high--;
                    else low++;
                }
            }
        }

        return output;
    }
}
