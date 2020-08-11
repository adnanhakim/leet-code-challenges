package AugustChallenges;

/*
August 11

Question: H-Index
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3420/
*/

class August11 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] count = new int[len + 1];

        for (int c : citations)
            if (c > len)
                count[len]++;
            else count[c]++;

        int total = 0;
        for (int i = len; i >= 0; i--) {
            total += count[i];
            if (total >= i)
                return i;
        }

        return 0;
    }
}
