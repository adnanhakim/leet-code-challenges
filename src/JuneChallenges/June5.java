package JuneChallenges;

/*
June 5

Question: Random Pick with Weight
Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3351/
*/

class June5 {
    int[] sumArr;
    int sum;

    public June5(int[] w) {
        sum = 0;
        sumArr = new int[w.length];
        for (int i = 0; i < sumArr.length; i++) {
            sum += w[i];
            sumArr[i] = sum;
        }
    }

    public int pickIndex() {
        int index = (int) (Math.random() * sum);
        return binarySearch(index + 1);
    }

    private int binarySearch(int val) {
        int left = 0, right = sumArr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sumArr[mid] < val) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
