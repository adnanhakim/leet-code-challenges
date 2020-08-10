package AugustChallenges;

/*
August 10

Question: Excel Sheet Column Number
Given a column title as appear in an Excel sheet, return its corresponding column number.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3419/
*/


class August10 {
    public int titleToNumber(String s) {
        int col = 0;
        for (char c : s.toCharArray())
            col = col * 26 + ((c - 'A') + 1);
        return col;
    }
}
