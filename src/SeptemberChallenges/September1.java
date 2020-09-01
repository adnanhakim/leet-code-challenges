package SeptemberChallenges;

/*
September 1

Question: Largest Time for Given Digits
Given an array of 4 digits, return the largest 24 hour time that can be made.
The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3445/
*/

class September1 {
    private int[] result;

    public String largestTimeFromDigits(int[] nums) {
        permute(nums, 0);
        return format(result);
    }

    private void permute(int[] nums, int offset) {
        if (offset == nums.length - 1) {
            if (isValid(nums) && isBetter(result, nums)) {
                if (result == null)
                    result = new int[4];
                for (int i = 0; i < 4; i++)
                    result[i] = nums[i];
            }
            return;
        }

        for (int i = offset; i < nums.length; i++) {
            int tmp = nums[offset];
            nums[offset] = nums[i];
            nums[i] = tmp;
            permute(nums, offset + 1);
            nums[i] = nums[offset];
            nums[offset] = tmp;
        }
    }

    private boolean isValid(int[] nums) {
        return nums[0] <= 2 && (nums[0] != 2 || nums[1] <= 3) && nums[2] <= 5;
    }

    private boolean isBetter(int[] result, int[] nums) {
        if (result == null)
            return true;

        for (int i = 0; i < 3; i++) {
            if (result[i] == nums[i]) continue;
            return result[i] < nums[i];
        }
        return false;
    }

    private String format(int[] nums) {
        if (nums == null)
            return "";
        else return "" + nums[0] + nums[1] + ':' + nums[2] + nums[3];
    }
}
