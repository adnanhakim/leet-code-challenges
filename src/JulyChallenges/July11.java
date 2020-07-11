package JulyChallenges;

import java.util.ArrayList;
import java.util.List;

/*
July 11

Question: Subsets
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3387/
*/

class July11 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), subsets);
        return subsets;
    }

    public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(i + 1, nums, current, subsets);
            current.remove(current.size() - 1);
        }
    }
}
