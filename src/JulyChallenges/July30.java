package JulyChallenges;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
July 30

Question: Word Break II
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
Note:
1 -> The same word in the dictionary may be reused multiple times in the segmentation.
2 -> You may assume the dictionary does not contain duplicate words.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3406/
*/

class July30 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int max = 0;

        HashSet<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
            max = Math.max(max, word.length());
        }
        List<String> result = new ArrayList<>();

        dfs(s, result, new StringBuilder(), 0, max, dict, new boolean[s.length() + 1]);

        return result;
    }

    private void dfs(String word, List<String> result, StringBuilder builder, int index, int max, HashSet<String> dict, boolean[] invalid) {
        if (index == word.length()) {
            result.add(builder.toString());
            return;
        }

        for (int i = index + 1; i <= index + max && i <= word.length(); i++) {
            if (!invalid[i]) {
                if (dict.contains(word.substring(index, i))) {
                    int oldLength = builder.length();
                    int oldSize = result.size();
                    if (oldLength != 0)
                        builder.append(" ");
                    builder.append(word.substring(index, i));
                    dfs(word, result, builder, i, max, dict, invalid);
                    if (oldSize == result.size())
                        invalid[i] = true;
                    builder.delete(oldLength, builder.length());
                }
            }
        }
    }
}
