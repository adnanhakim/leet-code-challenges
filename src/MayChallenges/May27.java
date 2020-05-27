package MayChallenges;

/*
May 27

Question: Possible Bipartition
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
Each person may dislike some other people, and they should not go into the same group.
Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
Return true if and only if it is possible to split everyone into two groups in this way.

https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3342/
*/

class May27 {
    public boolean possibleBipartition(int N, int[][] dislikes) {

        int[] team = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            team[i] = i;
        }

        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];

            if (team[a] == a && team[b] == b) {
                team[a] = b;
                team[b] = a;
            } else if (team[a] == a && team[b] != b) {
                team[a] = team[team[b]];
            } else if (team[b] == b && team[a] != a) {
                team[b] = team[team[a]];
            } else if (team[b] == team[a]) {
                return false;
            }
        }

        return true;
    }
}
