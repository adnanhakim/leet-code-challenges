package JulyChallenges;

/*
July 15

Question: Reverse Words in a String
Given an input string, reverse the string word by word.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3391/
*/

class July15 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return "";

        StringBuilder builder = new StringBuilder();
        int right = s.length() - 1, left;

        while (right >= 0) {
            if (s.charAt(right) != ' ') {
                left = s.lastIndexOf(" ", right);
                builder.append(s.substring(left + 1, right + 1)).append(" ");
                right = left;
            } else right--;
        }

        return builder.toString().trim();
    }
}
