package MayChallenges;

/*
May 10

Question: Find the Town Judge
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
If the town judge exists, then:
1 -> The town judge trusts nobody.
2 -> Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/
*/

class May10 {
    public int findJudge(int N, int[][] trust) {
        int[] trustCount = new int[N + 1];

        for (int[] t: trust) {
            trustCount[t[0]]--;
            trustCount[t[1]]++;
        }

        for (int i = 1; i < trustCount.length; i++)
            if (trustCount[i] == N - 1)
                return i;

        return -1;
    }
}
