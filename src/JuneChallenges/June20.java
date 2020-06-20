package JuneChallenges;

import java.util.ArrayList;
import java.util.List;

/*
June 20

Question: Permutation Sequence
The set [1,2,3,...,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
1 -> "123"
2 -> "132"
3 -> "213"
4 -> "231"
5 -> "312"
6 -> "321"
Given n and k, return the kth permutation sequence.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3366/
*/

class June20 {
    public String getPermutation(int n, int k) {
        if (n == 1) return "1";

        int fact = fact(n - 1);
        k = k - 1;
        StringBuilder builder = new StringBuilder();

        List<Character> list = new ArrayList<>();
        for (int i = 49; i < n + 49; i++)
            list.add((char) i);

        while (list.size() > 1) {
            int index = k / fact;
            builder.append(list.remove(index));
            k %= fact;
            n -= 1;
            fact = fact / n;
        }

        builder.append(list.get(0));

        return builder.toString();
    }

    public int fact(int n) {
        if (n == 1) return 1;
        else return n * fact(n - 1);
    }
}
