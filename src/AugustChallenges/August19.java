package AugustChallenges;

import java.util.HashSet;

/*
August 19

Question: Goat Latin
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
The rules of Goat Latin are as follows:
1 -> If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
2 -> If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
3 -> Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3429/
*/

class August19 {
    public String toGoatLatin(String S) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        String[] words = S.split(" ");
        StringBuilder builder = new StringBuilder();
        StringBuilder a = new StringBuilder();
        for (String word : words) {
            char start = word.charAt(0);
            if (vowels.contains(start))
                builder.append(word).append("maa");
            else builder.append(word.substring(1)).append(start).append("maa");

            builder.append(a);
            a.append('a');
            builder.append(' ');
        }

        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
