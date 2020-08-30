package AugustChallenges;

import java.util.HashMap;
import java.util.HashSet;

/*
August 30

Question: Largest Component Size by Common Factor
Given a non-empty array of unique positive integers A, consider the following graph:
1 -> There are A.length nodes, labelled A[0] to A[A.length - 1];
2 -> There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3442/
*/

class August30 {
    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int num) {
            while (parent[num] != num) {
                parent[num] = parent[parent[num]];
                num = parent[num];
            }
            return num;
        }

        private void union(int p, int q) {
            p = find(p);
            q = find(q);
            if (p == q) return;
            if (rank[p] < rank[q]) {
                parent[q] = p;
                rank[p] += rank[q];
            } else {
                parent[p] = q;
                rank[q] += rank[p];
            }
        }

        private int getRank(int num) {
            return rank[find(num)];
        }
    }

    private HashSet<Integer> getPrimeFactors(int val) {
        HashSet<Integer> set = new HashSet<>();

        while (val % 2 == 0) {
            set.add(2);
            val /= 2;
        }

        for (int i = 3; i * i <= val; i += 2) {
            while (val % i == 0) {
                set.add(i);
                val /= i;
            }
        }

        if (val > 1)
            set.add(val);
        return set;
    }

    public int largestComponentSize(int[] A) {
        HashMap<Integer, Integer> first = new HashMap<>();
        UnionFind unionFind = new UnionFind(A.length);

        for (int i = 0; i < A.length; i++) {
            for (int p : getPrimeFactors(A[i])) {
                if (!first.containsKey(p))
                    first.put(p, i);
                else unionFind.union(first.get(p), i);
            }
        }

        int max = 0;
        for (int i = 0; i < A.length; i++)
            max = Math.max(unionFind.getRank(i), max);

        return max;
    }
}
