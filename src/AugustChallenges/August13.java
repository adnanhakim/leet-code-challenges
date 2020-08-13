package AugustChallenges;

/*
August 13

Question: Iterator for Combination
Design an Iterator class, which has:
1 -> A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
2 -> A function next() that returns the next combination of length combinationLength in lexicographical order.
3 -> A function hasNext() that returns True if and only if there exists a next combination.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3422/
*/

class August13 {
    char[] current, dictionary;
    boolean hasNext;
    int n;

    public August13(String characters, int combinationLength) {
        current = characters.substring(0, combinationLength).toCharArray();
        dictionary = characters.toCharArray();
        n = dictionary.length;
        hasNext = true;
    }

    public String next() {
        if (!hasNext) return "";
        String result = new String(current);
        int combinationLength = current.length;
        int i = current.length - 1, j = dictionary.length - 1;
        while (i >= 0 && current[i] == dictionary[j]) {
            i--;
            j--;
        }
        if (i == -1)
            hasNext = false;
        else {
            int index = String.valueOf(dictionary).indexOf(current[i]);
            for (int k = i; k < combinationLength; k++)
                current[k] = dictionary[++index];
        }
        return result;
    }

    public boolean hasNext() {
        return hasNext;
    }
}
