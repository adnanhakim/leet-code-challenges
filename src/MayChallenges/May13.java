package MayChallenges;

/*
May 13

Question: Remove K Digits
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/
*/


class May13 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        StringBuilder builder = new StringBuilder(num);
        int i = 0;
        while (k > 0) {
            while (i < builder.length() - 1 && builder.charAt(i + 1) >= builder.charAt(i))
                i++;

            builder.deleteCharAt(i);
            k--;
            i = Math.max(i - 1, 0);
        }

        // Remove leading zeros
        String result = builder.toString().replaceAll("^0+", "");

        return result.length() > 0 ? result : "0";
    }
}
