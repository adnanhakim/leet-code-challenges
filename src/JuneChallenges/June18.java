package JuneChallenges;

/*
June 18

Question: H-Index II
Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3364/
*/

class June18 {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (citations[mid] == citations.length - mid) return citations.length - mid;
            else if (citations[mid] > citations.length - mid) right = mid - 1;
            else left = mid + 1;
        }

        return citations.length - left;
    }
}
