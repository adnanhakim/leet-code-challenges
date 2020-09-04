package SeptemberChallenges;

/*
September 3

Question: Repeated Substring Pattern
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3447/
*/

class September3 {
    public boolean repeatedSubstringPattern(String s) {
        int stringLength = s.length();
        int repeatLength = 1;

        for (int i = stringLength / 2; i > 0; i--) {
            if (stringLength % i != 0)
                continue;
            repeatLength = i;
            if (s.substring(0, repeatLength - 1).equals(s.substring(repeatLength, repeatLength + repeatLength - 1)))
                break;
        }

        String repeatedString = s.substring(0, repeatLength);
        for (int i = repeatLength; i <= stringLength - repeatLength; i += repeatLength)
            if (!repeatedString.equals(s.substring(i, i + repeatLength)))
                return false;

        return repeatLength != stringLength;
    }
}
